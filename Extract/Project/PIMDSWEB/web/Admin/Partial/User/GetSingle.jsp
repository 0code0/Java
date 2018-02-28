

<% BusinessObject.User user = BusinessLogic.UserBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                

<h2>Selected User</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><%= user.getName() %></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><%= user.getEmail()%></td>
            </tr>
            <tr>
                <td>Extn NO</td>
                <td><%= user.getExtn() %></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><%= user.getAddress()%></td>
            </tr>
            <tr>
                <td>Photo</td>
                <td><image src='<%= user.getUrl()%>' alt='no data found' height='50' width='50' /></td>
            </tr>
            <tr>
                <td>Seat No</td>
                <td><%= user.getSeatNo()%></td>
            </tr>
            <tr>
                <td>Mobile No</td>
                <td><%= user.getMobileNo()%></td>
            </tr>
            <tr>
                <td>Emergency No</td>
                <td><%= user.getEmergencyNo()%></td>
            </tr>
            <tr>
                <td>Employee Category</td>
                <td>
                    <% BusinessObject.EmployeeType employeetype = BusinessLogic.EmployeeTypeBL.GetSingle(user.getEmployeeId());
                                            
                        out.println(employeetype.getName());
                    %>
                
                    
                </td>
            </tr>
            <tr>
                <td>Date Of Birth</td>
                <td><%= user.getDateOfBirth()%></td>
            </tr>
            <tr>
                <td>Date of Joining</td>
                <td><%= user.getDateofJoining()%></td>
            </tr>
            <tr>
                <td>Celebrated Date Of Birth</td>
                <td><%= user.getCelebratedDateOfBirth()%></td>
            </tr>
            <tr>
                <td>Admin of Project Department</td>
                <td>
                <% BusinessObject.ProjectCategory projectcategory = BusinessLogic.ProjectCategoryBL.GetSingle(user.getProjectCategoryId()); 
                
                    out.println(projectcategory.getName());
                %>    
                </td>
            </tr>
            
            <tr>
                <td>Approved</td>
                <td><%= user.getBase().getIsApproved() %></td>
            </tr>
            
            <tr>
                <td>Deleted</td>
                <td><%= user.getBase().getIsDeleted() %></td>
            </tr>
            
            <tr>
                <td>Created On</td>
                <td><%= user.getBase().getCreatedOn() %></td>
            </tr>
            
            <tr>
                <td>User</td>
                <td><%= user.getBase().getCreatedBy() %></td>
            </tr>
        </tbody>
    </table>