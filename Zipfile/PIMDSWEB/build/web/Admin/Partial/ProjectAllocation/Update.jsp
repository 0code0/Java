
<%@page import="java.util.List"%>
<% BusinessObject.ProjectAllocation projectAllocation = BusinessLogic.ProjectAllocationBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>
<form action="">

    <input type="hidden" name="Id" value="<%= projectAllocation.getId()%>" /> 

    <h2>Update Project Allocation</h2>
    <table width="100%" class="table table-striped table-bordered">
        <tbody>

            <tr>
                <td>Group Name</td>
                <td><input type="text" name="GroupName" value="<%= projectAllocation.getName()%>" /></td>
            </tr>
            
            <tr>
                <td>Project Name</td>
                <td>
                    <select style="width: 150px;" name="ProjectName">
                        <option value="null" >------------Select------------</option>
                        <%
                            List<BusinessObject.ProjectDetail> projectName = BusinessLogic.ProjectDetailBL.GetAll();

                            for (int i = 0; i < projectName.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", projectName.get(i).getId(), projectName.get(i).getName());

                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>
            <input type="hidden" name="OldProjectName" value="<%= projectAllocation.getProjectDetailId() %>" />
            <tr>
                <td>User Name</td>
                <td>
                    <select style="width: 150px;" name="UserName">
                        <option value="null" >------------Select------------</option>
                        <%  List<BusinessObject.User> user = BusinessLogic.UserBL.GetAll();

                            for (int i = 0; i < user.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", user.get(i).getId(), user.get(i).getName());

                                out.write(Name);
                            }

                        %>

                    </select>   
                </td>
            </tr>
            <input type="hidden" name="OldUserName" value="<%= projectAllocation.getUserId() %>" />
        </tbody>

    </table>

    <input type="submit" value="Update" name="op"  class="btn btn-primary"/>

</form>