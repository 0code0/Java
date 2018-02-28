<%@page import="java.util.List"%>



<form action="" method="post" >
    <h2>Add New Project Group</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Group Name</td>
                <td><input type="text" name="GroupName" width="100px" /></td>
            </tr>
            
            <tr>
                <td>Project Name</td>
                <td>
                    <select style="width: 150px;" name="ProjectName">
                        <option value="null">------------Select------------</option>
                        <%
                            List<BusinessObject.ProjectDetail> projectDetail = BusinessLogic.ProjectDetailBL.GetAll();

                            for (int i = 0; i < projectDetail.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", projectDetail.get(i).getId(), projectDetail.get(i).getName());

                                out.write(Name);
                            }

                        %>

                    </select>

                </td>
            </tr>
         
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

        </tbody>
    </table>
    <br>

    <input class="btn btn-primary" type="submit" value="Add" name="op" />
</form>
