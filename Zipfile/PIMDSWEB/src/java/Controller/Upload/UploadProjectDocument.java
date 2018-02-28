/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Upload;

import BusinessObject.Base;
import BusinessObject.ProjectDocument;
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
public class UploadProjectDocument extends HttpServlet {

    private ProjectDocument projectDocument;
    Date date = new Date();
    Base base = new Base();

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

        projectDocument = new ProjectDocument();

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);

                Iterator iterator = items.iterator();

                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (item.getFieldName().equals("DocumentCategory")) {
                        System.out.print(item.getString());
                        projectDocument.setDocumentCategoryId(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("Title")) {
                        projectDocument.setTitle(item.getString());

                    } else if (item.getFieldName().equals("Name")) {
                        projectDocument.setName(item.getString());
                    } else if (item.getFieldName().equals("ProjectCategory")) {
                        projectDocument.setProjectId(Integer.parseInt(item.getString()));
                    }else if (item.getFieldName().equals("version")) {
                        projectDocument.setVersion(item.getString());
                    }else if (item.getFieldName().equals("Source")) {
                        projectDocument.setSource(item.getString());
                    }else if (item.getFieldName().equals("Description")) {
                        projectDocument.setDescription(item.getString());
                    }
                    if (!item.isFormField() && (item.getSize() > 0)) {
                        System.out.println(item.getSize());
                        String fileName = item.getName();

                        String root = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Uploads";
                        File path = new File(root + "/ProjectDocument");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);

                        item.write(uploadedFile);
                        projectDocument.setURL(request.getContextPath() + "/Uploads/ProjectDocument/" + fileName);
                        projectDocument.setName(fileName);
                    }else if (item.getFieldName().equals("DirectFilePath")) {
                        
                        if((item.getSize() > 15)){
                        projectDocument.setURL(item.getString());
                        projectDocument.setName(projectDocument.getTitle());
                        
                        }
                        
                        
                    }
                }

            } catch (FileUploadException e) {
                System.err.println(e.getStackTrace());
            } catch (Exception e) {
                System.err.println(e.getStackTrace());
            }
        }

        base.setIsApproved("true");
        base.setIsDeleted("false");
        base.setCreatedOn(date.toString());
        HttpSession httpsession = request.getSession();
        
        base.setCreatedBy(httpsession.getAttribute("UserName").toString());

        projectDocument.setBase(base);

        BusinessLogic.ProjectDocumentBL.Add(projectDocument);
        response.sendRedirect("/PIMDSWEB/Admin/ManageProjectDocument.jsp");

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
