

<%@page import="java.util.List"%>
<%

    List<BusinessObject.EmployeeType> employeeTypes = BusinessLogic.EmployeeTypeBL.GetAll();

    for (BusinessObject.EmployeeType employeeType : employeeTypes) {
        
        String Name = String.format("<tr class='gradeA'><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",employeeType.getName(),employeeType.getId(),employeeType.getId(),employeeType.getId());
        out.println(Name);
        
    }

%>


    