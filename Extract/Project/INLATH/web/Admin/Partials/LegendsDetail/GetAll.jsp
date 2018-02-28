<%@page import="java.util.List"%>
<%

    List<BusinessObject.LegendsDetail> legendsDetails = BusinessLogic.LegendsDetailBL.GetAll();

    for (BusinessObject.LegendsDetail legendsDetail : legendsDetails) {

        String Name = String.format("<tr class='gradeA'><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>", legendsDetail.getName(),legendsDetail.getId(), legendsDetail.getId(), legendsDetail.getId());
        out.println(Name);

    }

%>