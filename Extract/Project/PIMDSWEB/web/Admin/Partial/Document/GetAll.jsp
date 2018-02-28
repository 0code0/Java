

<%@page import="java.util.List"%>
<%

    List<BusinessObject.Document> documents = BusinessLogic.DocumentBL.GetAll();

   for (BusinessObject.Document document : documents) {
        BusinessObject.Document ParentName = null;
        
        if ((document.getParentId() != null) && (document.getURL() != null)) {

            ParentName = BusinessLogic.DocumentBL.GetSingle(document.getParentId());
            String one = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td><a href='%s' target='_blank'>%s</a></td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>", document.getName(), ParentName.getName(), document.getURL(), "Click to see Document", document.getId(), document.getId(), document.getId());
            out.println(one);
        } else if ((document.getParentId() == null) && (document.getURL() != null)) {

            String two = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td><a href='%s' target='_blank'>%s</a></td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>", document.getName(), "null", document.getURL(), "Click to see Document", document.getId(), document.getId(), document.getId());
            out.println(two);
        } else if ((document.getParentId() != null) && (document.getURL() == null)) {
            ParentName = BusinessLogic.DocumentBL.GetSingle(document.getParentId());
            String two = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td style='color:red;'>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>", document.getName(), ParentName.getName(), "No data found", document.getId(), document.getId(), document.getId());
            out.println(two);
        } else if ((document.getParentId() == null) && (document.getURL() == null)) {

            String two = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td style='color:red;'>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>", document.getName(), "null", "No data found", document.getId(), document.getId(), document.getId());
            out.println(two);
        }

    } 

%>


