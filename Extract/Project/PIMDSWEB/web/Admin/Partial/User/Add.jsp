<%@page import="java.util.List"%>



<form action="/PIMDSWEB/UploadUser" method="post" enctype="multipart/form-data" >
    <h2>Add New User</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><input type="text" name="Name" width="100px" /></td>
            </tr>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="UserName" width="100px" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="Email" width="100px" /></td>
            </tr>
            <tr>
                <td>Extention No</td>
                <td><input type="text" name="ExtnNo" width="100px" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="Address" width="100px" /></td>
            </tr>
            <tr>
                <td>Image</td>
                <td><input type="file" name="Url"  /></td>
            </tr>
            <tr>
                <td>Seat No</td>
                <td><input type="text" name="SeatNo" width="100px" /></td>
            </tr>
            <tr>
                <td>Mobile No</td>
                <td><input type="text" name="MobileNo" width="100px" /></td>
            </tr>
            <tr>
                <td>Emergency No</td>
                <td><input type="text" name="EmergencyNo" width="100px" /></td>
            </tr>
            <tr>
                <td>Employee Category</td>
                <td>
                    <select style="width: 150px;" name="EmployeeCategory">
                        <option >------------Select------------</option>
                        <%
                            List<BusinessObject.EmployeeType> employeeType = BusinessLogic.EmployeeTypeBL.GetAll();

                            for (int i = 0; i < employeeType.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", employeeType.get(i).getId(), employeeType.get(i).getName());

                                out.write(Name);
                            }

                        %>

                    </select>

                </td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td><input type="text" name="DateofBirth" width="100px" /></td>
            </tr>
            <tr>
                <td>Celebrated Birthday</td>
                <td><input type="text" name="CelebratedBirthday" width="100px" /></td>
            </tr>


            <tr>
                <td>Date of Joining</td>
                <td><input type="text" name="DateofJoining" width="100px"</td>
            </tr>


            <tr>
                <td>Admin of Project Department</td>
                <td>
                    <select style="width: 150px;" name="ProjectCategory">
                        <option >------------Select------------</option>
                        <%                            List<BusinessObject.ProjectCategory> projectCategory = BusinessLogic.ProjectCategoryBL.GetAllnull();

                            for (int i = 0; i < projectCategory.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", projectCategory.get(i).getId(), projectCategory.get(i).getName());

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
