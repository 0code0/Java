/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author singhj1
 */
public class UserUploadProjectDocument extends HttpServlet {

    private BusinessObject.ProjectDocument projectDocument;
    private int ProjectDetailId = 0;
    private int DocumentCategory = 0;
    private String Title = null;
    private String Version = null;
    private String Source = null;
    private String Description = null;
    private String Author = null;

    Base base = new Base();
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

        List<BusinessObject.ProjectDocument> projectDocuments = BusinessLogic.ProjectDocumentBL.GetAllByProject(Integer.parseInt(request.getParameter("Id")));

        try (PrintWriter out = response.getWriter()) {
            if (!projectDocuments.isEmpty()) {
                for (BusinessObject.ProjectDocument projectDocument : projectDocuments) {

                    BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(projectDocument.getProjectId());
                    BusinessObject.DocumentCategory docCategory = BusinessLogic.DocumentCategoryBL.GetSingle(projectDocument.getDocumentCategoryId());

                    String RowData = String.format("<tr>"
                            + "<td>%s</td>"
                            + "<td><a href='%s' target='_blank'>%s<a/></td>"
                            + "<td>%s</td>"
                            + "<td>%s</td>"
                            + "<td>%s</td>"
                            + "<td>%s</td>"
                            + "<td>%s</td>"
                            + "<td>%s</td>"
                            + "</tr>", projectDetail.getName(), projectDocument.getURL(), projectDocument.getName(), docCategory.getName(), projectDocument.getTitle(), projectDocument.getSource(), projectDocument.getVersion(), projectDocument.getAuthor(), projectDocument.getBase().getCreatedBy());
                    out.println(RowData);

                }

            } else {

                out.print("<td colspan=\"8\" style=\"color: red;text-align: center;\" >No data found</td>");
            }

        }
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
        HttpSession httpsession = request.getSession();
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);

                Iterator iterator = items.iterator();

                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (item.getFieldName().equals("ProjectDetail")) {

                        ProjectDetailId = Integer.parseInt(item.getString());
                    } else if (item.getFieldName().equals("Title")) {
                        Title = item.getString();
                    } else if (item.getFieldName().equals("Version")) {
                        Version = item.getString();
                    } else if (item.getFieldName().equals("Source")) {
                        Source = item.getString();
                    } else if (item.getFieldName().equals("Description")) {
                        Description = item.getString();
                    } else if (item.getFieldName().equals("Author")) {
                        Author = item.getString();
                    } else if (item.getFieldName().equals("DocumentCategory")) {
                        DocumentCategory = Integer.parseInt(item.getString());
                    }

                    if (!item.isFormField() && (item.getSize() > 0)) {
                        String fileName = item.getName();

                        String root = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Uploads";
                        File path = new File(root + "/ProjectDocument");

                        File uploadedFile = new File(path + "/" + fileName);

                        item.write(uploadedFile);
                        projectDocument.setURL(request.getContextPath() + "/Uploads/ProjectDocument/" + fileName);
                        projectDocument.setName(fileName);
                        projectDocument.setTitle(Title);
                        projectDocument.setProjectId(ProjectDetailId);
                        projectDocument.setDocumentCategoryId(DocumentCategory);
                        projectDocument.setVersion(Version);
                        projectDocument.setSource(Source);
                        projectDocument.setDescription(Description);
                        projectDocument.setAuthor(Author);

                        base.setIsApproved("true");
                        base.setIsDeleted("false");
                        base.setCreatedBy(httpsession.getAttribute("UserName").toString());
                        base.setCreatedOn(date.toString());

                        projectDocument.setBase(base);

                        BusinessLogic.ProjectDocumentBL.Add(projectDocument);
                    } else if (item.getFieldName().equals("DirectUserFileUpload")) {

                        if ((item.getSize() > 10)) {
                            projectDocument.setURL(item.getString());
                            projectDocument.setName(Title);
                            projectDocument.setTitle(Title);
                            projectDocument.setProjectId(ProjectDetailId);
                            projectDocument.setDocumentCategoryId(DocumentCategory);
                            projectDocument.setVersion(Version);
                            projectDocument.setSource(Source);
                            projectDocument.setDescription(Description);
                            projectDocument.setAuthor(Author);

                            base.setIsApproved("true");
                            base.setIsDeleted("false");
                            base.setCreatedBy(httpsession.getAttribute("UserName").toString());
                            base.setCreatedOn(date.toString());

                            projectDocument.setBase(base);

                            BusinessLogic.ProjectDocumentBL.Add(projectDocument);
                        }

                    }
                }
                response.sendRedirect("/PIMDSWEB/Document.jsp");
            } catch (Exception ex) {
                response.sendRedirect("/PIMDSWEB/Document.jsp");
            }
        }

    }

}
