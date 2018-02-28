/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author singhj1
 */
public class GetSubValue extends HttpServlet {

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
        List<BusinessObject.ProjectCategory> SubprojectCategory = BusinessLogic.ProjectCategoryBL.GetAllByParentId(Integer.parseInt(request.getParameter("Id").trim()));

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<select style=\"width: 150px;\" name=\"ProjectSubCategory\">");
            out.println("<option value=\"null\">-----Select-----</option>");
            for (int i = 0; i < SubprojectCategory.size(); i++) {
                String OptionString = String.format("<option value='%s'>%s</option>", SubprojectCategory.get(i).getId(), SubprojectCategory.get(i).getName());
                out.println(OptionString);

            }
            out.println("</select>");
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

        List<BusinessObject.ProjectClass> projectSubClass = BusinessLogic.ProjectClassBL.GetAllByParentId(Integer.parseInt(request.getParameter("Id").trim()));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<select style=\"width: 150px;\" name=\"ProjectSubClass\">");
            out.println("<option value=\"null\">-----Select-----</option>");
            for (int i = 0; i < projectSubClass.size(); i++) {
                String OptionString = String.format("<option value='%s'>%s</option>", projectSubClass.get(i).getId(), projectSubClass.get(i).getName());
                out.println(OptionString);

            }

            out.println("</select>");
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
