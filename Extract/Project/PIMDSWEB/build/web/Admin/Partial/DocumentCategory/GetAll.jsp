

<%@page import="java.util.List"%>
<%

    List<BusinessObject.DocumentCategory> documentCategorys = BusinessLogic.DocumentCategoryBL.GetAll();

    for (BusinessObject.DocumentCategory documentCategory : documentCategorys) {
        
        if(documentCategory.getParentId() == null){
        String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",documentCategory.getName(),documentCategory.getParentId(),documentCategory.getId(),documentCategory.getId(),documentCategory.getId());
        out.println(Name);
        }else{
        
            BusinessObject.DocumentCategory parentName = BusinessLogic.DocumentCategoryBL.GetSingle(documentCategory.getParentId());
            
            String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",documentCategory.getName(),parentName.getName(),documentCategory.getId(),documentCategory.getId(),documentCategory.getId());
            out.println(Name);
            
        }
        
        
   
    }

%>


    