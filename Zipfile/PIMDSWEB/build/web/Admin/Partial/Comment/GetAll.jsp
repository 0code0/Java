

<%@page import="java.util.List"%>
<%

    List<BusinessObject.Comment> comments = BusinessLogic.CommentBL.GetAll();

  for (BusinessObject.Comment comment : comments) {
        BusinessObject.ProjectDocument projectDocument = BusinessLogic.ProjectDocumentBL.GetSingle(comment.getProjectDocumentId());

        if(comment.getParentId() == null){
            
        String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",projectDocument.getName(),comment.getComment(),comment.getParentId(),comment.getId(),comment.getId(),comment.getId());
        out.println(Name);
        }else{
        
            BusinessObject.Comment commentName = BusinessLogic.CommentBL.GetSingle(comment.getParentId());
            
        String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",projectDocument.getName(),comment.getComment(),commentName.getComment(),comment.getId(),comment.getId(),comment.getId());
        out.println(Name);    
        }
        
        
   
    }

%>


    