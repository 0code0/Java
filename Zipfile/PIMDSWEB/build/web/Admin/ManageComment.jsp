


<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.Date"%>
<%@page import="BusinessObject.Base"%>
<%@page import="BusinessObject.Comment"%>

<% Date date = new Date();
    String Operation = null;
    String Delete = null;
    Operation = request.getParameter("op");
    Delete = request.getParameter("delete_yes");

    BusinessObject.Comment comment = null;
    comment = new Comment();

    if (Delete != null) {

        if (Delete.equals("Yes")) {

            comment.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.CommentBL.Delete(comment);
        }

    }

    if (Operation != null) {
        comment = new Comment();

        if (Operation.equals("Add")) {

            comment = new Comment();
            comment.setComment(request.getParameter("Comment"));
            comment.setProjectDocumentId(Integer.parseInt(request.getParameter("ProjectDocumentName")));
           
            if(request.getParameter("ParentName").equals("null")){
                comment.setParentId(null);
            }else{
                comment.setParentId(Integer.parseInt(request.getParameter("ParentName")));
            }
            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            
            base.setCreatedBy("${UserName}");

            comment.setBase(base);
            BusinessLogic.CommentBL.Add(comment);
        }

        if (Operation.equals("Update")) {

            comment = new Comment();
            comment.setComment(request.getParameter("Comment"));
            
            if(request.getParameter("ProjectDocumentName").equals("null")){
            comment.setProjectDocumentId(Integer.parseInt(request.getParameter("OldProjectDocumentName")));
            
            }else{
            comment.setProjectDocumentId(Integer.parseInt(request.getParameter("ProjectDocumentName")));
            
            }
            
            
            if(request.getParameter("ParentName").equals("null")){
            
                comment.setParentId(null);
            }else{
            
                comment.setParentId(Integer.parseInt(request.getParameter("ParentName")));
            }
            
            
            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("Admin");

            comment.setBase(base);
            comment.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.CommentBL.Update(comment);

        }

    }
%>
<!DOCTYPE html>
<html>
    <head>

        <jsp:include page="Partial/Shared/CSSJS.jsp" />
    </head>
    <body>
        <%@include file="Partial/Shared/Header.jsp"  %>

        <div class="row">
            <jsp:include page="Partial/Shared/Menu.jsp" />

            <div class="col-md-10">

                <div class="row">
                    <div class="col-md-12 panel-warning">
                        <div class="content-box-header panel-heading">
                            <div class="panel-title ">Manage Comment</div>

                            <div class="panel-options">
                                <a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
                                <a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
                            </div>
                        </div>
                        <div class="content-box-large box-with-header">
                            <div class="content-box-large">
                                <div class="panel-heading">
                                    <div class="panel-title">
                                        <a class="btn btn-primary" href="?Show=Add" onclick="">Add Comment</a>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                        <thead>
                                            <tr>
                                                <th>Document Name</th>
                                                <th>Comment</th>
                                                <th>Parent Comment</th>
                                                
                                                <th>Action</th>

                                            </tr>
                                        </thead>
                                        <tbody>

                                            <jsp:include page="Partial/Comment/GetAll.jsp"/>


                                        </tbody>
                                    </table>

                                    <% if (request.getParameter("Show") != null) {%>

                                    <% if (request.getParameter("Show").equals("Add")) {%>

                                    <jsp:include page="Partial/Comment/Add.jsp"/>
                                    <%}%>


                                    <% if (request.getParameter("Show").equals("Update")) {%>

                                    <jsp:include page="Partial/Comment/Update.jsp"/>
                                    <%}%>

                                    <% if (request.getParameter("Show").equals("Delete")) {%>

                                    <jsp:include page="Partial/Comment/Delete.jsp"/>
                                    <%}%>
                                    <% if (request.getParameter("Show").equals("View")) {%>

                                    <jsp:include page="Partial/Comment/GetSingle.jsp"/>
                                    <%}%>

                                    <%}%> 

                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>

    <footer>
        <jsp:include page="Partial/Shared/Footer.jsp" />
    </footer>


</body>
</html>