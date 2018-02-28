

<%@page import="BusinessObject.ProjectDetail"%>
<%@page import="java.util.List"%>
<%

    List<BusinessObject.ProjectAllocation> projectAllocations = BusinessLogic.ProjectAllocationBL.GetAll();
    String AllUser = "";
    BusinessObject.ProjectDetail projectdetail = new ProjectDetail();
    for (BusinessObject.ProjectAllocation projectAllocation : projectAllocations) {

        projectdetail = BusinessLogic.ProjectDetailBL.GetSingle(projectAllocation.getProjectDetailId());

        List<BusinessObject.ProjectAllocation> getProjectDetail = BusinessLogic.ProjectAllocationBL.GetAllByProjectDetailId(projectAllocation.getProjectDetailId());

        AllUser = "";
        for (int i = 0; i < getProjectDetail.size(); i++) {

            List<BusinessObject.User> users = BusinessLogic.UserBL.GetAllByUserId(getProjectDetail.get(i).getUserId());

            for (int j = 0; j < users.size(); j++) {

                AllUser += users.get(j).getName() + ",";
            }

        }

       String Name = String.format("<tr class='gradeA'><td>%s</td><td>%s</td><td>%s</td><td> <a class='btn btn-primary' href='?Id=%s&Show=View'><i class='glyphicon glyphicon-eye-open'></i>View</a> <a class='btn btn-info' href='?Id=%s&Show=Update'><i class='glyphicon glyphicon-refresh'></i>Edit</a> <a class='btn btn-danger' href='?Id=%s&Show=Delete'><i class='glyphicon glyphicon-remove'></i>Delete</a> </td></tr>", projectAllocation.getName(), projectdetail.getName(), AllUser, projectAllocation.getId(), projectAllocation.getId(), projectAllocation.getId());

        out.println(Name);

    }
     

%>


