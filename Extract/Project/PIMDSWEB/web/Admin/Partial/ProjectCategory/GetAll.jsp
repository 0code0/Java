

<%@page import="java.util.List"%>
<%

    List<BusinessObject.ProjectCategory> projectcategorys = BusinessLogic.ProjectCategoryBL.GetAll();

    for (BusinessObject.ProjectCategory projectcategory : projectcategorys) {
        
        if(projectcategory.getParentId() == null){
        String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",projectcategory.getName(),projectcategory.getParentId(),projectcategory.getId(),projectcategory.getId(),projectcategory.getId());
        out.println(Name);
        }else{
        
            BusinessObject.ProjectCategory parentName = BusinessLogic.ProjectCategoryBL.GetSingle(projectcategory.getParentId());
            
            String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",projectcategory.getName(),parentName.getName(),projectcategory.getId(),projectcategory.getId(),projectcategory.getId());
            out.println(Name);
            
        }
        
        
   
    }

%>


    