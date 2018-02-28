

<% BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                

<h2>Selected Project Class</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><%= projectClass.getName() %></td>
            </tr>
            <tr>
                <td>Parent Name</td>
                <td><%
                    
        if(projectClass.getParentId() == null){
        out.println(projectClass.getParentId());
        }else{
        
            BusinessObject.ProjectClass parentName = BusinessLogic.ProjectClassBL.GetSingle(projectClass.getParentId());
            out.println(parentName.getName());
            
        }


                    %></td>
            </tr>
            <tr>
                <td>Approved</td>
                <td><%= projectClass.getBase().getIsApproved() %></td>
            </tr>
            
            <tr>
                <td>Deleted</td>
                <td><%= projectClass.getBase().getIsDeleted() %></td>
            </tr>
            
            <tr>
                <td>Created On</td>
                <td><%= projectClass.getBase().getCreatedOn() %></td>
            </tr>
            
            <tr>
                <td>User</td>
                <td><%= projectClass.getBase().getCreatedBy() %></td>
            </tr>
        </tbody>
    </table>