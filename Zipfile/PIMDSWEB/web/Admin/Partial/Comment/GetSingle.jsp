

<%@page import="java.util.List"%>
<% BusinessObject.Comment comment = BusinessLogic.CommentBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); 
    BusinessObject.ProjectDocument projectDocument = BusinessLogic.ProjectDocumentBL.GetSingle(comment.getProjectDocumentId());
    BusinessObject.Comment ParentComment = BusinessLogic.CommentBL.GetSingle(comment.getId());
%>                

<h2>Selected Comment</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>
            <tr>
                <td>Comment</td>
                <td><%= comment.getComment() %></td>
            </tr>
           
            <tr>
                <td>Project Document</td>
                <td>
                    <%= projectDocument.getName()  %>
                </td>
            </tr>
      
        </tbody>
    </table>