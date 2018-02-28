
<%@page import="java.util.List"%>
<% BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>
<form action="">

    <input type="hidden" name="Id" value="<%= projectClass.getId()%>" /> 

    <h2>Update Project Class</h2>
    <table width="100%" class="table table-striped table-bordered">

        <tr>
            <td>Name</td>
            <td><input type="text" name="Name" value="<%= projectClass.getName()%>" /></td>
        </tr>
        <tr>
            <td>Parent Id</td>
            <td>
                <select style="width: 150px;" name="ParentId">
                    <%
                        List<BusinessObject.ProjectClass> projectclass = BusinessLogic.ProjectClassBL.GetAll();

                        for (int i = 0; i < projectclass.size(); i++) {

                            String Name = String.format("<option value='%s'>%s</option>", projectclass.get(i).getId(), projectclass.get(i).getName());

                            out.write(Name);
                        }

                    %>

                </select>

            </td>
        </tr>
      
    </table>

    <input type="submit" value="Update" name="op"  class="btn btn-primary"/>

</form>