

<% BusinessObject.EmployeeType employeeType = BusinessLogic.EmployeeTypeBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                

<h2>Selected Employee Category</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><%= employeeType.getName() %></td>
            </tr>
           
            <tr>
                <td>Approved</td>
                <td><%= employeeType.getBase().getIsApproved() %></td>
            </tr>
            
            <tr>
                <td>Deleted</td>
                <td><%= employeeType.getBase().getIsDeleted() %></td>
            </tr>
            
            <tr>
                <td>Created On</td>
                <td><%= employeeType.getBase().getCreatedOn() %></td>
            </tr>
            
            <tr>
                <td>User</td>
                <td><%= employeeType.getBase().getCreatedBy() %></td>
            </tr>
        </tbody>
    </table>