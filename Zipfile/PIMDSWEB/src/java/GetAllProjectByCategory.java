
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
public class GetAllProjectByCategory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        List<BusinessObject.ProjectDetail> projectDetails = BusinessLogic.ProjectDetailBL.GetAllProjectDetailByProjectClass(Integer.parseInt(request.getParameter("Id")));
        try (PrintWriter out = response.getWriter()) {

            if (!projectDetails.isEmpty()) {

                for (BusinessObject.ProjectDetail projectDetail : projectDetails) {
                    BusinessObject.ProjectCategory projectCategory = BusinessLogic.ProjectCategoryBL.GetSingle(projectDetail.getProjectCategoryId());
                    BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(projectDetail.getProjectClassId());

                    String GroupName = " ";
                    String buttonAbleDis = " ";
                    List<BusinessObject.ProjectAllocation> projectAllocation = BusinessLogic.ProjectAllocationBL.GetAllByProjectDetailId(projectDetail.getId());

                    if (!projectAllocation.isEmpty()) {
                        GroupName = projectAllocation.get(0).getName();

                    } else {
                        GroupName = "Not Allocate Group";
                    }

                    if (projectDetail.getBase().getCreatedBy().equals(request.getSession().getAttribute("UserName"))) {

                        buttonAbleDis = "<tr><td style='width:100px;' ><a href=UserProjectDetailManage.jsp?Id=" + projectDetail.getId() + " ><button class='btn btn-xs btn-info'><i class='ace-icon fa fa-pencil bigger-120'></i></button></a> <button onclick='DeleteProject(" + projectDetail.getId() + ")' class='btn btn-round btn-danger btn-sm'><i class='ace-icon fa fa-trash-o bigger-110'></i></button></td>";

                    } else {
                        buttonAbleDis = "<tr><td style='width:100px;' ><button class='btn btn-xs disabled btn-info'><i class='ace-icon fa fa-pencil bigger-120'></i></button> <button class='btn disabled btn-round btn-sm'><i class='ace-icon fa fa-trash-o bigger-110'></i></button></td>";

                    }

                    String PrintProjectDetail = String.format(buttonAbleDis + "<td>"
                            + "                                                    <a href=\"%s/GetDocumentByProject.jsp?Id=%s\"> %s </a>\n"
                            + "                                                    <td>%s</td>\n"
                            + "                                                    <td class=\"hidden-480\">%s</td>\n"
                            + "                                                    <td>%s</td>\n"
                            + "                                                    <td>%s</td>\n"
                            + "                                                    <td>%s</td>\n"
                            + "                                                    <td>%s</td>\n"
                            + "                                                    <td>%s</td>\n"
                            + "                                                    <td>%s</td>\n"
                            + "<td class=\"hidden-480\">\n"
                            + "                                                        <span class=\"label label-sm label-warning\">%s</span>\n"
                            + "</td></tr><tr >\n"
                            + "                                                    <td colspan=\"11\" id=\"\" style=\"display: none ;\" >\n"
                            + "\n"
                            + "                                                    </td>    \n"
                            + "                                                </tr>\n", request.getContextPath(), projectDetail.getId(), projectDetail.getName(), projectDetail.getIPNeed(), projectDetail.getTechnology(), projectDetail.getVersion(), projectDetail.getProduct(), projectDetail.getDivision(), projectCategory.getName(), projectClass.getName(), GroupName, projectDetail.getStatus(), projectDetail.getId());

                    out.println(PrintProjectDetail);

                }

            } else {

                out.print("<td colspan=\"11\" style=\"color: red;text-align: center;\" >No data found</td>");

            }

        }

    }

}
