
<%@page import="java.util.List"%>
<% BusinessObject.EmployeeType employeeType = BusinessLogic.EmployeeTypeBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>
<form action="">

    <input type="hidden" name="Id" value="<%= employeeType.getId()%>" /> 

    <h2>Update Employee Category</h2>
    <table width="100%" class="table table-striped table-bordered">

        <tr>
            <td>Name</td>
            <td><input type="text" name="Name" value="<%= employeeType.getName()%>" /></td>
        </tr>
     
      
    </table>

    <input type="submit" value="Update" name="op"  class="btn btn-primary"/>

</form>