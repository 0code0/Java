/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.Control;

import BusinessObject.Base;
import BusinessObject.LegendsDetail;
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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author singhj1
 */
public class UpdateLegendsDetail extends HttpServlet {

     private BusinessObject.LegendsDetail legendsDetail;

    Base base = new Base();
    Date date = new Date();
    
    
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
        
           legendsDetail = new LegendsDetail();

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);

                Iterator iterator = items.iterator();

                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (item.getFieldName().equals("Name")) {
                        legendsDetail.setName(item.getString());
                    } else if (item.getFieldName().equals("Born")) {
                        legendsDetail.setBorn(item.getString());
                    } else if (item.getFieldName().equals("Detail")) {
                        legendsDetail.setDetail(item.getString());
                    } else if (item.getFieldName().equals("FamilyDetail")) {
                        legendsDetail.setFamilyDetail(item.getString());
                    } else if (item.getFieldName().equals("MoreDetailUrl")) {
                        legendsDetail.setMoreDetailUrl(item.getString());
                    } else if (item.getFieldName().equals("LegendsCategory")) {
                        legendsDetail.setCategoryId(item.getString());
                    } else if (item.getFieldName().equals("Id")) {
                        legendsDetail.setId(Integer.parseInt(item.getString()));
                    }

                    if (!item.isFormField() && (item.getSize() > 0)) {
                        String fileName = item.getName();

                        String root = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\INLATH\\web\\Admin\\Uploads";

                        File uploadedFile = new File(root + "/" + fileName);

                        item.write(uploadedFile);

                        legendsDetail.setImageUrl(request.getContextPath() + "/Admin/Uploads/" + fileName);

                    }
                }
                base.setIsApproved("true");
                base.setIsDeleted("false");
                base.setCreatedBy("Admin");
                base.setCreatedOn(date.toString());
                legendsDetail.setBase(base);

                BusinessLogic.LegendsDetailBL.Update(legendsDetail);
                response.sendRedirect("/INLATH/Admin/ManageLegendsDetail.jsp");
            } catch (Exception ex) {

            }
        }
        
    }


}
