/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BusinessObject.Base;
import BusinessObject.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author singhj1
 */
public class UserUploadComment extends HttpServlet {

    BusinessObject.Comment comment = new Comment();
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

        comment.setProjectDocumentId(Integer.parseInt(request.getParameter("ProjectDocument")));

        if (!request.getParameter("ParentComment").equals("null")) {

            comment.setParentId(Integer.parseInt(request.getParameter("ParentComment")));
        } else {

            comment.setParentId(null);
        }

        comment.setComment(request.getParameter("Comment"));

        base.setIsApproved("true");
        base.setIsDeleted("false");
        base.setCreatedOn(date.toString());
        base.setCreatedBy(request.getSession().getAttribute("UserName").toString());

        comment.setBase(base);
        comment.setUserId(Integer.parseInt(request.getSession().getAttribute("Id").toString()));

        BusinessLogic.CommentBL.Add(comment);

        response.sendRedirect("/PIMDSWEB/Comment.jsp");

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

        List<BusinessObject.Comment> comments = BusinessLogic.CommentBL.GetAllByProjectDocumentAndParentId(Integer.parseInt(request.getParameter("Id")));

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            for (BusinessObject.Comment comment : comments) {

                BusinessObject.User user = BusinessLogic.UserBL.GetSingle(comment.getUserId());

                out.print("<div class=\"widget-main no-padding\">\n"
                        + "                                    <div class=\"dialogs\">");

                String PrintComment = String.format("<div class=\"itemdiv \">\n"
                        + "                                    <div class=\"user\">\n"
                        + "                                        <img alt=\"no data load\" src=\"%s\" />\n"
                        + "                                    </div>\n"
                        + "\n"
                        + "                                    <div class=\"body\">\n"
                        + "                                        <div class=\"time\">\n"
                        + "                                            <i class=\"ace-icon fa fa-clock-o\"></i>\n"
                        + "                                            <span class=\"green\">%s</span>\n"
                        + "                                        </div>\n"
                        + "\n"
                        + "                                        <div class=\"name\">\n"
                        + "                                            <a target=\"_blank\" href=\"%s/ProfileById.jsp?Id=%s\">%s</a>\n"
                        + "                                        </div>\n"
                        + "                                        <div class=\"text\">%s</div>\n"
                        + "\n"
                        + "                                    </div>\n"
                        + "                                </div>", user.getUrl(), comment.getBase().getCreatedOn(),request.getContextPath(),user.getId(), user.getName(), comment.getComment());

                out.println(PrintComment);
                out.println("<div class=\"space-10\"></div>");
                

                    List<Comment> subComments = BusinessLogic.CommentBL.GetAllByParentId(comment.getId());

                    for (Comment subcomment : subComments) {
                        BusinessObject.User subuser = BusinessLogic.UserBL.GetSingle(subcomment.getUserId());

                        String PrintSubComment = String.format("<div class=\"itemdiv \" style=\"margin-left: 50px;\">\n"
                                + "                                    <div class=\"user\">\n"
                                + "                                        <img alt=\"no data load\" src=\"%s\" />\n"
                                + "                                    </div>\n"
                                + "\n"
                                + "                                    <div class=\"body\">\n"
                                + "                                        <div class=\"time\">\n"
                                + "                                            <i class=\"ace-icon fa fa-clock-o\"></i>\n"
                                + "                                            <span class=\"blue\">%s</span>\n"
                                + "                                        </div>\n"
                                + "\n"
                                + "                                        <div class=\"name\">\n"
                                + "                                            <a target=\"_blank\" href=\"%s/ProfileById.jsp?Id=%s\">%s</a>\n"
                                + "                                        </div>\n"
                                + "                                        <div class=\"text\">%s</div>\n"
                                + "\n"
                                + "\n"
                                + "                                    </div>\n"
                                + "\n"
                                + "                                </div>\n"
                                + "", subuser.getUrl(),subcomment.getBase().getCreatedOn(),request.getContextPath(),subuser.getId(),subuser.getName(),subcomment.getComment());

                        out.println(PrintSubComment);
                    }

                

                out.print("    <div class=\"space-10\"></div>\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "                                    </div>\n"
                        + "\n"
                        + "                                </div>\n"
                        + "                                \n"
                        + "                                ");
            }
        }

    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
