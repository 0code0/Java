
<%@page import="java.util.List"%>

<% BusinessObject.User user = BusinessLogic.UserBL.GetSingle(Integer.parseInt(request.getParameter("Id")));
    BusinessObject.ProjectCategory userinprojectCategory = BusinessLogic.ProjectCategoryBL.GetSingle(user.getProjectCategoryId());
%>


<form action="/PIMDSWEB/EditUser" method="post" enctype="multipart/form-data" >

    <input type="hidden" name="Id" value="<%= user.getId()%>" /> 

    <h2>Update User</h2>
    <table width="100%" class="table table-striped table-bordered">
        <tbody>

            <tr>
                <td>Name</td>
                <td><input type="text" name="Name" value="<%= user.getName()%>" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="Email" value="<%= user.getEmail()%>" /></td>
            </tr>
            <tr>
                <td>Extn No</td>
                <td><input type="text" name="ExtnNo" value="<%= user.getExtn()%>" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="Address" value="<%= user.getAddress()%>" /></td>
            </tr>
            <tr>
                <td>Url</td>
                <td>
                    <image src='<%= user.getUrl()%>' alt='No data Found' height='50' width='50' />
                    <input type="file" name="Url" />
                    <input type="hidden" name="OldUrl" value="<%= user.getUrl()%>" />
                </td>
            </tr>
            <tr>
                <td>Seat No</td>
                <td><input type="text" name="SeatNo" value="<%= user.getSeatNo()%>" /></td>
            </tr>
            <tr>
                <td>Mobile No</td>
                <td><input type="text" name="MobileNo" value="<%= user.getMobileNo()%>" /></td>
            </tr>
            <tr>
                <td>Emergency No</td>
                <td><input type="text" name="EmergencyNo" value="<%= user.getEmergencyNo()%>" /></td>
            </tr>
            <tr>
                <td>Employee Category</td>
                <td>
                    <select style="width: 150px;" name="EmployeeCategory">
                        <option value="null" >------------Select------------</option>
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
                <td>Date Of Birth</td>
                <td><input type="text" name="DateOfBirth" value="<%= user.getDateOfBirth()%>" /></td>
            </tr>
            <tr>
                <td>Date of Joining</td>
                <td><input type="text" name="DateofJoining" value="<%= user.getDateofJoining()%>" /></td>
            </tr>
            <tr>
                <td>Celebrated Date Of Birth</td>
                <td><input type="text" name="CelebratedDateOfBirth" value="<%= user.getCelebratedDateOfBirth()%>" /></td>
            </tr>
            <tr>
                <td> User Name </td>
                <td><input type="text" name="UserName" value="<%= user.getUserName() %>" /></td>
            </tr>
            <tr>
                <td>Admin of Project Department</td>
                <td>
                    <select style="width: 150px;" name="ProjectCategory">
                        <option value="null" >------------Select------------</option>
                        <%  List<BusinessObject.ProjectCategory> projectCategory = BusinessLogic.ProjectCategoryBL.GetAllnull();

                            for (int i = 0; i < projectCategory.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", projectCategory.get(i).getId(), projectCategory.get(i).getName());

                                out.write(Name);
                            }

                        %>

                    </select><%= userinprojectCategory.getName() %>   
                    
                </td>
            </tr>

        </tbody>

    </table>
                    
    <input type="hidden" name="OldProjectCategory" value="<%= user.getProjectCategoryId()%>" />
    <input type="hidden" name="OldEmployeeCategory" value="<%= user.getEmployeeId()%>"  />
    
    <input type="submit" value="Update" name="op"  class="btn btn-primary"/>

</form>