

<%@page session="true" %>
<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.Date"%>
<%@page import="BusinessObject.Base"%>
<%@page import="BusinessObject.ProjectCategory" %>

<% Date date = new Date();
    String Operation = null;
    String Delete = null;
    Operation = request.getParameter("op");
    Delete = request.getParameter("delete_yes");

    BusinessObject.ProjectCategory projectCategory = null;
    projectCategory = new ProjectCategory();

    if (Delete != null) {

        if (Delete.equals("Yes")) {

            projectCategory.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.ProjectCategoryBL.Delete(projectCategory);
        }

    }

    if (Operation != null) {
        projectCategory = new ProjectCategory();

        if (Operation.equals("Add")) {

            projectCategory = new ProjectCategory();

            projectCategory.setName(request.getParameter("Name"));
            String Name = request.getParameter("ParentId");

            if (request.getParameter("ParentId").equals(null) || request.getParameter("ParentId").equals("null")) {
                projectCategory.setParentId(null);

            } else {
                projectCategory.setParentId(Integer.parseInt(request.getParameter("ParentId")));

            }

            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("${UserName}");

            projectCategory.setBase(base);
            BusinessLogic.ProjectCategoryBL.Add(projectCategory);
        }

        if (Operation.equals("Update")) {

            projectCategory = new ProjectCategory();
            projectCategory.setName(request.getParameter("Name"));
            if (!request.getParameter("ParentId").equals("null")) {

                projectCategory.setParentId(Integer.parseInt(request.getParameter("ParentId")));
            } else {

                projectCategory.setParentId(null);
            }
            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());

            base.setCreatedBy(request.getSession().getAttribute("UserName").toString());

            projectCategory.setBase(base);
            projectCategory.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.ProjectCategoryBL.Update(projectCategory);

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
                            <div class="panel-title ">Manage Project Category</div>

                            <div class="panel-options">
                                <a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
                                <a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
                            </div>
                        </div>
                        <div class="content-box-large box-with-header">
                            <div class="content-box-large">
                                <div class="panel-heading">
                                    <div class="panel-title">
                                        <a class="btn btn-primary" href="?Show=Add" onclick="">Add Project Category</a>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Parent Name</th>
                                                <th>Action</th>

                                            </tr>
                                        </thead>
                                        <tbody>

                                            <jsp:include page="Partial/ProjectCategory/GetAll.jsp"/>


                                        </tbody>
                                    </table>

                                    <% if (request.getParameter("Show") != null) {%>

                                    <% if (request.getParameter("Show").equals("Add")) {%>

                                    <jsp:include page="Partial/ProjectCategory/Add.jsp"/>
                                    <%}%>


                                    <% if (request.getParameter("Show").equals("Update")) {%>

                                    <jsp:include page="Partial/ProjectCategory/Update.jsp"/>
                                    <%}%>

                                    <% if (request.getParameter("Show").equals("Delete")) {%>

                                    <jsp:include page="Partial/ProjectCategory/Delete.jsp"/>
                                    <%}%>
                                    <% if (request.getParameter("Show").equals("View")) {%>

                                    <jsp:include page="Partial/ProjectCategory/GetSingle.jsp"/>
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