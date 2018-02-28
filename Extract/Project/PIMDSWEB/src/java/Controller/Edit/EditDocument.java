/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Edit;

import BusinessObject.Base;
import BusinessObject.Document;
import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author singhj1
 */
public class EditDocument extends HttpServlet {

    private Document document;
    private Date date = new Date();
    private boolean flag = false;

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        document = new Document();

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);

                Iterator iterator = items.iterator();

                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (item.getFieldName().equals("Id")) {
                        document.setId(Integer.parseInt(item.getString()));

                    } else if (item.getFieldName().equals("name")) {
                        document.setName(item.getString());

                    } else if (item.getFieldName().equals("Parent")) {

                        if ((!item.getString().equals("null"))) {
                            document.setParentId(Integer.parseInt(item.getString()));
                        } else {
                            document.setParentId(null);
                        }

                    }
                    String fileName = item.getName();
                    if ((!item.isFormField()) && (!fileName.isEmpty())) {

                        String root = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Uploads";
                        File path = new File(root + "/Document");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);

                        item.write(uploadedFile);
                        document.setURL(request.getContextPath() + "/Uploads/Document/" + fileName);
                        flag = true;

                    } else if (item.getFieldName().equals("DirectUpload") && (item.getSize() > 10) && (flag == false)) {

                        document.setURL(item.getString());
                        flag = true;
                    }

                    if (flag == false && (item.getFieldName().equals("OldUrl"))) {

                        document.setURL(item.getString());
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
        base.setCreatedBy(request.getSession().getAttribute("UserName").toString());

        document.setBase(base);

        BusinessLogic.DocumentBL.Update(document);
        response.sendRedirect("/PIMDSWEB/Admin/ManageDocument.jsp");
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
