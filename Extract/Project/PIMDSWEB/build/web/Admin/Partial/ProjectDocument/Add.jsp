<%@page import="java.util.List"%>



<form action="/PIMDSWEB/UploadProjectDocument" method="post" enctype="multipart/form-data">
    <h2>Add New Project Document</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>
            <tr>
                <td>Title</td>
                <td><input type="text" name="Title" width="100px" /></td>
            </tr>
            
            <tr>
                <td>Version</td>
                <td><input type="text" name="version" width="100px" /></td>
            </tr>
            
            <tr>
                <td>Source</td>
                <td><input type="text" name="Source" width="100px" /></td>
            </tr>
            

            <tr>
                <td>Url</td>
                <td><input type="file" name="Url" width="100px" />
                    --OR--</br>
                    <input type="text" name="DirectFilePath" width="100px" />
                </td>
            </tr>

            <tr>
                <td>Project Name</td>
                <td>
                    <select style="width: 150px;" name="ProjectCategory">
                        <option >------------Select------------</option>
                        <%List<BusinessObject.ProjectDetail> projectDetail = BusinessLogic.ProjectDetailBL.GetAll();

                            for (int i = 0; i < projectDetail.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", projectDetail.get(i).getId(), projectDetail.get(i).getName());

                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>
            <tr>
                <td>Document Category</td>
                <td>
                    <select style="width: 150px;" name="DocumentCategory">
                        <option >------------Select------------</option>
                        <%List<BusinessObject.DocumentCategory> documentCategory = BusinessLogic.DocumentCategoryBL.GetAll();

                            for (int i = 0; i < documentCategory.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", documentCategory.get(i).getId(), documentCategory.get(i).getName());

                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>
            
              <tr>
                <td>Description</td>
                <td><textarea class="form-control" name="Description" placeholder="Description" rows="3"></textarea></td>
            </tr>
        </tbody>
    </table>
    <br>

    <input class="btn btn-primary" type="submit" value="Add" name="op" />
</form>
