

<%@page import="java.util.List"%>
<%

    List<BusinessObject.ProjectDocument> projectDocuments = BusinessLogic.ProjectDocumentBL.GetAll();

    for (BusinessObject.ProjectDocument projectDocument : projectDocuments) {
        
        BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(projectDocument.getProjectId());
        String Name = String.format("<tr class='gradeA'><td><a href='%s' target='_black'>%s</a></td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>",projectDocument.getURL(),projectDocument.getName(),projectDetail.getName(),projectDocument.getId(),projectDocument.getId(),projectDocument.getId());
        out.println(Name);
   
    }

%>


    