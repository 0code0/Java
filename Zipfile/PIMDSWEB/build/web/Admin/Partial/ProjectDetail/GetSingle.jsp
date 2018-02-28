

<% BusinessObject.ProjectDetail projectDetails = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                

<h2>Selected Project Detail</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><%= projectDetails.getName() %></td>
            </tr>
            <tr>
                <td>Project Category</td>
                <td><%
            BusinessObject.ProjectCategory projectCategory = BusinessLogic.ProjectCategoryBL.GetSingle(projectDetails.getProjectCategoryId());
            out.println(projectCategory.getName());
                    %></td>
            </tr>
            <tr>
                <td>Project Class</td>
                <td><%
            BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(projectDetails.getProjectClassId());
            out.println(projectClass.getName());
                    %></td>
            </tr>
            <tr>
                <td>Approved</td>
                <td><%= projectDetails.getBase().getIsApproved() %></td>
            </tr>
            
            <tr>
                <td>Deleted</td>
                <td><%= projectDetails.getBase().getIsDeleted() %></td>
            </tr>
            
            <tr>
                <td>Created On</td>
                <td><%= projectDetails.getBase().getCreatedOn() %></td>
            </tr>
            
            <tr>
                <td>User</td>
                <td><%= projectDetails.getBase().getCreatedBy() %></td>
            </tr>
            <tr>
                <td>Document</td>
                <td><a href="<%= projectDetails.getURL()  %>" target="_blank" >Click to Download</a></td>
            </tr>
        </tbody>
    </table>