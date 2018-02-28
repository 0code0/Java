

<% BusinessObject.ProjectCategory projectCategory = BusinessLogic.ProjectCategoryBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                

<h2>Selected Project Category</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><%= projectCategory.getName() %></td>
            </tr>
            <tr>
                <td>Parent Name</td>
                <td><%
                    
        if(projectCategory.getParentId() == null){
        out.println(projectCategory.getParentId());
        }else{
        
            BusinessObject.ProjectCategory parentName = BusinessLogic.ProjectCategoryBL.GetSingle(projectCategory.getParentId());
            out.println(parentName.getName());
            
        }


                    %></td>
            </tr>
            <tr>
                <td>Approved</td>
                <td><%= projectCategory.getBase().getIsApproved() %></td>
            </tr>
            
            <tr>
                <td>Deleted</td>
                <td><%= projectCategory.getBase().getIsDeleted() %></td>
            </tr>
            
            <tr>
                <td>Created On</td>
                <td><%= projectCategory.getBase().getCreatedOn() %></td>
            </tr>
            
            <tr>
                <td>User</td>
                <td><%= projectCategory.getBase().getCreatedBy() %></td>
            </tr>
        </tbody>
    </table>