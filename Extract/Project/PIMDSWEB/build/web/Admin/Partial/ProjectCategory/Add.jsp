<%@page import="java.util.List"%>
<form action="" method="post" >
    <h2>Add New Project Detail</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><input type="text" name="Name" width="100px" /></td>
            </tr>
            <tr>
                <td>Parent Name</td>
                <td>
                    <select style="width: 150px;" name="ParentId">
                        <option value="null">--Select--</option>
                        <%
                            List<BusinessObject.ProjectCategory> projectcategory = BusinessLogic.ProjectCategoryBL.GetAll();

                            for (int i = 0; i < projectcategory.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", projectcategory.get(i).getId(), projectcategory.get(i).getName());

                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>

        </tbody>
    </table>
                        <br>
    <input class="btn btn-primary" type="submit" value="Add" name="op" />
</form>