<%@page import="java.util.List"%>



<form action="" method="post" >
    <h2>Add New Comment</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>
            <tr>
                <td>Comment</td>
                <td><input type="text" name="Comment" width="100px" /></td>
            </tr>
           
            <tr>
                <td>Project Document Name</td>
                <td>
                    <select style="width: 150px;" name="ProjectDocumentName">
                        <option >------------Select------------</option>
                        <%List<BusinessObject.ProjectDocument> projectDocument = BusinessLogic.ProjectDocumentBL.GetAll();

                            for (int i = 0; i < projectDocument.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", projectDocument.get(i).getId(), projectDocument.get(i).getTitle());

                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>
            <tr>
                <td>Parent Name</td>
                <td>
                    <select style="width: 150px;" name="ParentName">
                        <option value="null">------------Select------------</option>
                        <%List<BusinessObject.Comment> comment = BusinessLogic.CommentBL.GetAllnull();

                            for (int i = 0; i < comment.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", comment.get(i).getId(), comment.get(i).getComment());

                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>
        </tbody>
    </table>
    <br>

    <input class="btn btn-primary" type="submit" value="Add" name="op" />
</form>
