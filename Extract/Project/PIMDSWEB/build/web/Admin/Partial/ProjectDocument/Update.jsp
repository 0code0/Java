
<%@page import="java.util.List"%>
<% BusinessObject.ProjectDocument projectDocument = BusinessLogic.ProjectDocumentBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>
<form action="/PIMDSWEB/EditProjectDocument" method="post" enctype="multipart/form-data" >

    <input type="hidden" name="Id" value="<%= projectDocument.getId()%>" /> 

    <h2>Update Project Document</h2>
    <table width="100%" class="table table-striped table-bordered">
        <tbody>
            <tr>
                <td>Title</td>
                <td><input type="text" name="Title" value="<%= projectDocument.getTitle()%>" width="100px" /></td>

            </tr>
            <tr>
                <td>Version</td>
                <td><input type="text" name="Version" value="<%= projectDocument.getVersion()%>" width="100px" /></td>

            </tr>
            <tr>
                <td>Description</td>
                <td><textarea class="form-control" name="Description" rows="3"><%= projectDocument.getDescription()%></textarea></td>

            </tr>
            <tr>
                <td>Source</td>
                <td><input type="text" name="Source" value="<%= projectDocument.getSource()%>" width="100px" /></td>

            </tr>
            <tr>
                <td>Author</td>
                <td><input type="text" name="Author" value="<%= projectDocument.getAuthor()%>" width="100px" /></td>

            </tr>







            <tr>
                <td>Url</td>

                <td><a href="<%= projectDocument.getURL()%>" target="_black"><%= projectDocument.getName()%></a> 
                    <input type="file" name="Url"  width="100px" />
                    --OR--</br>
                    <input type="text" name="DirectFileUrl" value="<%= projectDocument.getURL()%>"  width="100px" />
                </td>
            </tr><input type="hidden" name="OldUrl" value="<%= projectDocument.getURL()%>" />
        <input type="hidden" name="OldName" value="<%= projectDocument.getName()%>" />
        <tr>
            <td>Project Name</td>
            <td>
                <select style="width: 150px;" name="ProjectName">
                    <option value="null" >------------Select------------</option>
                    <%List<BusinessObject.ProjectDetail> projectDetail = BusinessLogic.ProjectDetailBL.GetAll();

                        for (int i = 0; i < projectDetail.size(); i++) {

                            String Name = String.format("<option value='%s'>%s</option>", projectDetail.get(i).getId(), projectDetail.get(i).getName());

                            out.write(Name);
                        }

                    %>

                </select>
            </td>
        </tr>
        <input type="hidden" name="OldProjectName" value="<%= projectDocument.getProjectId()%>" />
        <tr>
            <td>Document Category</td>
            <td>
                <select style="width: 150px;" name="DocumentCategory">
                    <option value="null" >------------Select------------</option>
                    <%List<BusinessObject.DocumentCategory> documentCategory = BusinessLogic.DocumentCategoryBL.GetAll();

                        for (int i = 0; i < documentCategory.size(); i++) {

                            String Name = String.format("<option value='%s'>%s</option>", documentCategory.get(i).getId(), documentCategory.get(i).getName());

                            out.write(Name);
                        }

                    %>

                </select>
            </td>
        </tr>
        <input type="hidden" name="OldDocumentCategory" value="<%= projectDocument.getDocumentCategoryId()%>" />
        </tbody>

    </table>

    <input type="submit" value="Update" name="op"  class="btn btn-primary"/>

</form>