/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Upload;

import BusinessObject.Base;
import BusinessObject.ProjectDetail;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author singhj1
 */
public class UploadProjectDetail extends HttpServlet {
    private ProjectDetail projectDetail;
    Date date = new Date();
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
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
            projectDetail = new ProjectDetail();

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);

                Iterator iterator = items.iterator();

                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (item.getFieldName().equals("IPNeed")) {

                        projectDetail.setIPNeed(item.getString());
                    } else if (item.getFieldName().equals("Name")) {
                        projectDetail.setName(item.getString());
                    }else if (item.getFieldName().equals("Technology")) {
                        projectDetail.setTechnology(item.getString());
                    }else if (item.getFieldName().equals("Version")) {
                        projectDetail.setVersion(item.getString());
                    }else if (item.getFieldName().equals("Product")) {
                        projectDetail.setProduct(item.getString());
                    }else if (item.getFieldName().equals("Division")) {
                        projectDetail.setDivision(item.getString());
                    }
                    else if (item.getFieldName().equals("ProjectCategory")) {
                        projectDetail.setProjectCategoryId(Integer.parseInt(item.getString()));
                    }                    
                    else if (item.getFieldName().equals("ProjectClass")) {
                        projectDetail.setProjectClassId(Integer.parseInt(item.getString()));
                    }
                    
                    
                    if (!item.isFormField()) {
                        String fileName = item.getName();

                        String root = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Uploads";
                        File path = new File(root + "/ProjectDocument");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);

                        item.write(uploadedFile);
                        projectDetail.setURL(request.getContextPath() + "/Uploads/ProjectDocument/" + fileName);
                        
                    }
                }

            } catch (FileUploadException e) {
                System.err.println(e.getStackTrace());
            } catch (Exception e) {
                System.err.println(e.getStackTrace());
            }
        }

        Base base = new Base();
        base.setIsApproved("true");
        base.setIsDeleted("false");
        base.setCreatedOn(date.toString());
        HttpSession httpsession = request.getSession();
        base.setCreatedBy(httpsession.getAttribute("UserName").toString());

        projectDetail.setBase(base);
        projectDetail.setStatus("running");
        BusinessLogic.ProjectDetailBL.Add(projectDetail);
        response.sendRedirect("/PIMDSWEB/Admin/ManageProjectDetail.jsp");
        
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
