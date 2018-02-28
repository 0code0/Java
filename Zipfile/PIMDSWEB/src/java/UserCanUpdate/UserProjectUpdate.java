/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserCanUpdate;

import BusinessObject.Base;
import BusinessObject.ProjectDetail;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
public class UserProjectUpdate extends HttpServlet {

    private ProjectDetail projectDetail;
    Date date = new Date();
    private boolean ProjectCategorybool = false;
    private boolean ProjectClassbool = false;

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
                    } else if (item.getFieldName().equals("Technology")) {
                        projectDetail.setTechnology(item.getString());
                    } else if (item.getFieldName().equals("Version")) {
                        projectDetail.setVersion(item.getString());
                    } else if (item.getFieldName().equals("Product")) {
                        projectDetail.setProduct(item.getString());
                    } else if (item.getFieldName().equals("Division")) {
                        projectDetail.setDivision(item.getString());
                    } else if (item.getFieldName().equals("ProjectCategory") && (!item.getString().equals("null"))) {
                        projectDetail.setProjectCategoryId(Integer.parseInt(item.getString().trim()));
                        ProjectCategorybool = true;
                    } else if (item.getFieldName().equals("OldProjectCategory") && (ProjectCategorybool != true)) {
                        projectDetail.setProjectCategoryId(Integer.parseInt(item.getString()));

                    } else if (item.getFieldName().equals("ProjectClass") && (!item.getString().equals("null"))) {
                        projectDetail.setProjectClassId(Integer.parseInt(item.getString()));
                        ProjectClassbool = true;
                    } else if (item.getFieldName().equals("OldProjectClass") && (ProjectClassbool != true)) {
                        projectDetail.setProjectClassId(Integer.parseInt(item.getString()));

                    } else if (item.getFieldName().equals("OldUrl")) {
                        projectDetail.setURL(item.getString());

                    }else if (item.getFieldName().equals("Id")) {
                        projectDetail.setId(Integer.parseInt(item.getString()));

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
        BusinessLogic.ProjectDetailBL.Update(projectDetail);

        response.sendRedirect("/PIMDSWEB/GroupMember.jsp");

    }

}
