/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Upload;

import BusinessObject.Base;
import BusinessObject.User;
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
public class UploadUser extends HttpServlet {
    private User user;
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
        
        user = new User();

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);

                Iterator iterator = items.iterator();

                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (item.getFieldName().equals("EmployeeCategory")) {

                        user.setEmployeeId(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("Name")) {
                        user.setName(item.getString());
                    }else if (item.getFieldName().equals("Email")) {
                        user.setEmail(item.getString());
                    }else if (item.getFieldName().equals("ExtnNo")) {
                        user.setExtn(item.getString());
                    }else if (item.getFieldName().equals("Address")) {
                        user.setAddress(item.getString());
                    }else if (item.getFieldName().equals("SeatNo")) {
                        user.setSeatNo(item.getString());
                    }else if (item.getFieldName().equals("MobileNo")) {
                        user.setMobileNo(item.getString());
                    }else if (item.getFieldName().equals("EmergencyNo")) {
                        user.setEmergencyNo(item.getString());
                    }else if (item.getFieldName().equals("DateofBirth")) {
                        user.setDateOfBirth(item.getString());
                    }else if (item.getFieldName().equals("CelebratedBirthday")) {
                        user.setCelebratedDateOfBirth(item.getString());
                    }else if (item.getFieldName().equals("DateofJoining")) {
                        user.setDateofJoining(item.getString());
                    }else if (item.getFieldName().equals("ProjectCategory")) {
                        user.setProjectCategoryId(Integer.parseInt(item.getString()));
                    }else if (item.getFieldName().equals("UserName")) {
                        user.setUserName(item.getString());
                    }
                    
                    if (!item.isFormField() && (item.getSize() > 0)) {
                        String fileName = item.getName();

                        String root = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Uploads";
                        File path = new File(root + "/User");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);

                        item.write(uploadedFile);
                        user.setUrl(request.getContextPath() + "/Uploads/User/" + fileName);
                        
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
        base.setCreatedBy("Admin");

        user.setBase(base);
        user.setRole("user");
        user.setUserName("userName");
        BusinessLogic.UserBL.Add(user);
        response.sendRedirect("/PIMDSWEB/Admin/ManageUser.jsp");
    }


}
