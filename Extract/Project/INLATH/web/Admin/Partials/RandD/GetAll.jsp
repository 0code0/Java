<%@page import="java.util.List"%>
<%

    List<BusinessObject.Randd> randds = BusinessLogic.RandDBL.GetAll();
    
    for (BusinessObject.Randd randd : randds) {
            
        BusinessObject.LegendsDetail legendsDetail = BusinessLogic.LegendsDetailBL.GetSingle(randd.getLegendsDetailId());
        
        String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",legendsDetail.getName(), randd.getTitle() ,randd.getId(), randd.getId(), randd.getId());
        out.println(Name);

    }

%>