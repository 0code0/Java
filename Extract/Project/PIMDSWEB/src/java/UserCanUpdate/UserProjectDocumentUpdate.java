/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserCanUpdate;

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
public class UserProjectDocumentUpdate extends HttpServlet {

    ProjectDocument projectDocument;
    Base base = new Base();
    Date date = new Date();
    private boolean DocumentCategorybool = false;
    private boolean ProjectCategorybool = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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

                    if (item.getFieldName().equals("DocumentCategory") && (!item.getString().equals("null"))) {
                        projectDocument.setDocumentCategoryId(Integer.parseInt(item.getString()));
                        DocumentCategorybool = true;
                    } else if (item.getFieldName().equals("OldDocumentCategory") && (DocumentCategorybool != true)) {
                        projectDocument.setDocumentCategoryId(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("Title")) {
                        projectDocument.setTitle(item.getString());

                    } else if (item.getFieldName().equals("Name")) {
                        projectDocument.setName(item.getString());
                    } else if (item.getFieldName().equals("ProjectCategory") && (!item.getString().equals("null"))) {
                        projectDocument.setProjectId(Integer.parseInt(item.getString()));
                        ProjectCategorybool = true;
                    } else if (item.getFieldName().equals("OldProjectDetail") && (ProjectCategorybool != true)) {
                        projectDocument.setProjectId(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("Version")) {
                        projectDocument.setVersion(item.getString());
                    } else if (item.getFieldName().equals("Source")) {
                        projectDocument.setSource(item.getString());
                    } else if (item.getFieldName().equals("Description")) {
                        projectDocument.setDescription(item.getString());
                    } else if (item.getFieldName().equals("Author")) {
                        projectDocument.setAuthor(item.getString());
                    } else if (item.getFieldName().equals("OldUrl")) {
                        projectDocument.setURL(item.getString());
                    } else if (item.getFieldName().equals("OldName")) {
                        projectDocument.setName(item.getString());
                    } else if (item.getFieldName().equals("Id")) {
                        projectDocument.setId(Integer.parseInt(item.getString()));
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

        BusinessLogic.ProjectDocumentBL.Update(projectDocument);
        response.sendRedirect("/PIMDSWEB/MyUploads.jsp");
    }

}
