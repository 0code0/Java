
<%@page import="java.util.List"%>
<% BusinessObject.Comment comment = BusinessLogic.CommentBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>
<form action="" method="post" >
    <h2>Update Comment</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>
            <tr>
                <td>Comment</td>
                <td><input type="text" name="Comment" value="<%= comment.getComment() %>" width="100px" /></td>
            </tr>
           
            <tr>
                <td>Project Document Name</td>
                <td>
                    <select style="width: 150px;" name="ProjectDocumentName">
                        <option value="null" >------------Select------------</option>
                        <%List<BusinessObject.ProjectDocument> projectDocument = BusinessLogic.ProjectDocumentBL.GetAll();

                            for (int i = 0; i < projectDocument.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", projectDocument.get(i).getId(), projectDocument.get(i).getTitle());

                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>
        <input type="hidden" value="<%= comment.getProjectDocumentId() %>" name="OldProjectDocumentName" />
            <tr>
                <td>Parent Name</td>
                <td>
                    <select style="width: 150px;" name="ParentName">
                        <option value="null">------------Select------------</option>
                        <%List<BusinessObject.Comment> comments = BusinessLogic.CommentBL.GetAllnull();

                            for (int i = 0; i < comments.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", comments.get(i).getId(), comments.get(i).getComment());

                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>
            <input type="hidden" name="OldParentName" value="<%= comment.getParentId() %>" />
        </tbody>
    </table>
    <br>

    <input class="btn btn-primary" type="submit" value="Update" name="op" />
</form>