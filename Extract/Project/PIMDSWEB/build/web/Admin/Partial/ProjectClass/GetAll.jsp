

<%@page import="java.util.List"%>
<%

    List<BusinessObject.ProjectClass> projectClasss = BusinessLogic.ProjectClassBL.GetAll();

    for (BusinessObject.ProjectClass projectClass : projectClasss) {
        
        if(projectClass.getParentId() == null){
        String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",projectClass.getName(),projectClass.getParentId(),projectClass.getId(),projectClass.getId(),projectClass.getId());
        out.println(Name);
        }else{
        
            BusinessObject.ProjectClass parentName = BusinessLogic.ProjectClassBL.GetSingle(projectClass.getParentId());
            
            String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",projectClass.getName(),parentName.getName(),projectClass.getId(),projectClass.getId(),projectClass.getId());
            out.println(Name);
            
        }
        
        
   
    }

%>


    