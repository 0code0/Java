

<%@page import="java.util.List"%>
<%

    List<BusinessObject.ProjectDetail> projectDetails = BusinessLogic.ProjectDetailBL.GetAll();

    for (BusinessObject.ProjectDetail projectDetail : projectDetails) {

        BusinessObject.ProjectCategory projectCategory = BusinessLogic.ProjectCategoryBL.GetSingle(projectDetail.getProjectCategoryId());
        BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(projectDetail.getProjectClassId());

        String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>", projectDetail.getName(),projectCategory.getName(), projectClass.getName(), projectDetail.getTechnology(), projectDetail.getDivision(), projectDetail.getId(), projectDetail.getId(), projectDetail.getId());
        out.println(Name);

    }

%>


