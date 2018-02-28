

<% BusinessObject.ProjectAllocation projectAllocation = BusinessLogic.ProjectAllocationBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>                

<h2>Selected Project Allocation</h2>
<table border="1" width="100%" class="table table-striped table-bordered">

    <tbody>

        <tr>
            <td>Group Name</td>
            <td><%= projectAllocation.getName()%></td>
        </tr>

        <tr>
            <td>Project Name</td>
            <td>
                <% BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(projectAllocation.getProjectDetailId());

                    out.println(projectDetail.getName());
                %>


            </td>
        </tr>
        <tr>
            <td>User Name</td>
            <td>
                <% BusinessObject.User user = BusinessLogic.UserBL.GetSingle(projectAllocation.getUserId());

                    out.println(user.getName());
                %>    
            </td>
        </tr>

        <tr>
            <td>Approved</td>
            <td><%= projectAllocation.getBase().getIsApproved()%></td>
        </tr>

        <tr>
            <td>Deleted</td>
            <td><%= projectAllocation.getBase().getIsDeleted()%></td>
        </tr>

        <tr>
            <td>Created On</td>
            <td><%= projectAllocation.getBase().getCreatedOn()%></td>
        </tr>

        <tr>
            <td>Created By</td>
            <td><%= projectAllocation.getBase().getCreatedBy()%></td>
        </tr>
    </tbody>
</table>