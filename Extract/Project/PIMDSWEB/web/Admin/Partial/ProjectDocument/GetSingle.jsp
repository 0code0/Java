

<% BusinessObject.ProjectDocument projectDocument = BusinessLogic.ProjectDocumentBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                

<h2>Selected Project Document</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Project Name</td>
                <td><%
            BusinessObject.ProjectDetail parentName = BusinessLogic.ProjectDetailBL.GetSingle(projectDocument.getProjectId());
            out.println(parentName.getName());
                    %></td>
            </tr>
            <tr>
                <td>Document Category</td>
                <td><%
            BusinessObject.DocumentCategory documentCategory = BusinessLogic.DocumentCategoryBL.GetSingle(projectDocument.getDocumentCategoryId());
            out.println(documentCategory.getName());
                    %></td>
            </tr>
            <tr>
                <td>Url</td>
                <td><a href="<%= projectDocument.getURL() %>" target="_blank" ><%= projectDocument.getName() %></a></td>
            </tr>
             <tr>
                <td>Description</td>
                <td><%= projectDocument.getDescription() %></td>
            </tr>
            <tr>
                <td>Author</td>
                <td><%= projectDocument.getAuthor() %></td>
            </tr>
            
            <tr>
                <td>Created On</td>
                <td><%= projectDocument.getBase().getCreatedOn() %></td>
            </tr>
            
            <tr>
                <td>User</td>
                <td><%= projectDocument.getBase().getCreatedBy() %></td>
            </tr>
        </tbody>
    </table>