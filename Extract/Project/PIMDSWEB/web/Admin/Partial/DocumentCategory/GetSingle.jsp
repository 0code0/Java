

<% BusinessObject.DocumentCategory documentCategory = BusinessLogic.DocumentCategoryBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                

<h2>Selected Document Category</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><%= documentCategory.getName() %></td>
            </tr>
            <tr>
                <td>Parent Name</td>
                <td><%
                    
        if(documentCategory.getParentId() == null){
        out.println(documentCategory.getParentId());
        }else{
        
            BusinessObject.DocumentCategory parentName = BusinessLogic.DocumentCategoryBL.GetSingle(documentCategory.getParentId());
            out.println(parentName.getName());
            
        }


                    %></td>
            </tr>
            <tr>
                <td>Approved</td>
                <td><%= documentCategory.getBase().getIsApproved() %></td>
            </tr>
            
            <tr>
                <td>Deleted</td>
                <td><%= documentCategory.getBase().getIsDeleted() %></td>
            </tr>
            
            <tr>
                <td>Created On</td>
                <td><%= documentCategory.getBase().getCreatedOn() %></td>
            </tr>
            
            <tr>
                <td>User</td>
                <td><%= documentCategory.getBase().getCreatedBy() %></td>
            </tr>
        </tbody>
    </table>