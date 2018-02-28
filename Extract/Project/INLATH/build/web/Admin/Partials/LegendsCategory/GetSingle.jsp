

<% BusinessObject.LegendsCategory legendsCategory = BusinessLogic.LegendsCategoryBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                

<h2>Selected Project Category</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><%= legendsCategory.getName() %></td>
            </tr>
        
            <tr>
                <td>Approved</td>
                <td><%= legendsCategory.getBase().getIsApproved() %></td>
            </tr>
            
            <tr>
                <td>Deleted</td>
                <td><%= legendsCategory.getBase().getIsDeleted() %></td>
            </tr>
            
            <tr>
                <td>Created On</td>
                <td><%= legendsCategory.getBase().getCreatedOn() %></td>
            </tr>
            
            <tr>
                <td>User</td>
                <td><%= legendsCategory.getBase().getCreatedBy() %></td>
            </tr>
        </tbody>
    </table>