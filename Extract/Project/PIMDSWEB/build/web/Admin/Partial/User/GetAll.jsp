

<%@page import="java.util.List"%>
<%

    List<BusinessObject.User> users = BusinessLogic.UserBL.GetAll();

    for (BusinessObject.User user : users) {

        String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td><image src='%s' alt='no data found' height='50' width='50' /></td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>", user.getName(), user.getEmail(),user.getExtn(),user.getSeatNo(),user.getUrl(),user.getId(), user.getId(), user.getId());
        out.println(Name);

    }

%>


