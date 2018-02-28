
<%@page import="java.util.List"%>
<% BusinessObject.DocumentCategory documentCategory = BusinessLogic.DocumentCategoryBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>
<form action="">

    <input type="hidden" name="Id" value="<%= documentCategory.getId()%>" /> 

    <h2>Update Document Category</h2>
    <table width="100%" class="table table-striped table-bordered">

        <tr>
            <td>Name</td>
            <td><input type="text" name="Name" value="<%= documentCategory.getName()%>" /></td>
        </tr>
        <tr>
            <td>Parent Id</td>
            <td>
                <select style="width: 150px;" name="ParentId">
                      <option value="null">--Select--</option>
                    <%
                        List<BusinessObject.DocumentCategory> projectcategory = BusinessLogic.DocumentCategoryBL.GetAll();

                        for (int i = 0; i < projectcategory.size(); i++) {

                            String Name = String.format("<option value='%s'>%s</option>", projectcategory.get(i).getId(), projectcategory.get(i).getName());

                            out.write(Name);
                        }

                    %>

                </select>

            </td>
        </tr>
      
    </table>

    <input type="submit" value="Update" name="op"  class="btn btn-primary"/>

</form>