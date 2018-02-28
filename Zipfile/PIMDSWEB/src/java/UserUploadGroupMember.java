/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BusinessObject.Base;
import BusinessObject.Email;
import BusinessObject.ProjectAllocation;
import BusinessObject.ProjectDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author singhj1
 */
public class UserUploadGroupMember extends HttpServlet {

    ProjectAllocation projectAllocation;
    Date date = new Date();
    ArrayList<Integer> StoreUserId = new ArrayList<>();
    int ProjectId;
    String GroupName;
    Base base = new Base();
    String AllUser = "";
    Email email = new Email();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        List<BusinessObject.ProjectAllocation> projectAllocations = BusinessLogic.ProjectAllocationBL.GetAllByProjectDetailId(Integer.parseInt(request.getParameter("Id")));

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            BusinessObject.ProjectDetail projectdetail = new ProjectDetail();
            for (BusinessObject.ProjectAllocation projectAllocation : projectAllocations) {

                projectdetail = BusinessLogic.ProjectDetailBL.GetSingle(projectAllocation.getProjectDetailId());
                List<BusinessObject.ProjectAllocation> getProjectDetail = BusinessLogic.ProjectAllocationBL.GetAllByProjectDetailId(projectAllocation.getProjectDetailId());
                AllUser = "";
                for (int i = 0; i < getProjectDetail.size(); i++) {

                    List<BusinessObject.User> users = BusinessLogic.UserBL.GetAllByUserId(getProjectDetail.get(i).getUserId());

                    for (int j = 0; j < users.size(); j++) {

                        AllUser += users.get(j).getName() + ",";
                    }

                }

            }

            String RowData = String.format("<tr>"
                    + "<td>%s</td>"
                    + "<td>%s</td>"
                    + "<td>%s</td>"
                    + "</tr>", projectdetail.getName(), AllUser, projectdetail.getStatus());
            out.println(RowData);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        projectAllocation = new ProjectAllocation();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);

                Iterator iterator = items.iterator();

                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (item.getFieldName().equals("ProjecId")) {

                        ProjectId = Integer.parseInt(item.getString());

                    } else if (item.getFieldName().equals("UserIds")) {
                        StoreUserId.add(Integer.parseInt(item.getString()));

                    } else if (item.getFieldName().equals("GroupName")) {
                        GroupName = item.getString();

                    }

                }
                if (StoreUserId.size() > 0) {

                    for (int i = 0; i < StoreUserId.size(); i++) {

                        projectAllocation.setUserId(StoreUserId.get(i));
                        projectAllocation.setProjectDetailId(ProjectId);
                        projectAllocation.setName(GroupName);

                        base.setCreatedBy(request.getSession().getAttribute("UserName").toString());
                        base.setCreatedOn(date.toString());
                        base.setIsApproved("true");
                        base.setIsDeleted("false");

                        projectAllocation.setBase(base);

                        BusinessLogic.ProjectAllocationBL.Add(projectAllocation);

                        BusinessObject.User user = BusinessLogic.UserBL.GetSingle(StoreUserId.get(i));
                        BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(ProjectId);
                        BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(projectDetail.getProjectClassId());

                        email.setTo(user.getEmail());
                        email.setFrom(request.getSession().getAttribute("FromEmail").toString());
                        email.setPassword(request.getSession().getAttribute("Password").toString());
                        email.setSubject("Project Created " + projectDetail.getName() + " By " + request.getSession().getAttribute("UserName") + " at " + date);
                        email.setBody("Hello, </br>" + request.getSession().getAttribute("UserName") + " has created the project - " + projectDetail.getName() + "</br> You are the Member of this project</br> Here are the Detail: </br><table width=\"50%\" border=\"2\" align=\"center\" cellpadding=\"5\" cellspacing=\"0\" style=\"font-family:arial,helvetica,sans-serif;\"><tbody><tr><td>IpNeed</td><td>" + projectDetail.getIPNeed() + "</td></tr><tr><td>Technology</td><td>" + projectDetail.getTechnology() + "</td></tr><tr><td>Version</td><td>" + projectDetail.getVersion() + "</td></tr><tr><td>Product</td><td>" + projectDetail.getProduct() + "</td></tr><tr><td>Division</td><td>" + projectDetail.getDivision() + "</td></tr><tr><td>Class</td><td>" + projectClass.getName() + "</td></tr></tbody></table></br> Thanks & Regards");
                        BusinessLogic.EmailBL.sendMail(email);

                    }

                }

            } catch (Exception ex) {

                System.err.println(ex);
            } finally {

                response.sendRedirect("/PIMDSWEB/ViewProject.jsp");
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
