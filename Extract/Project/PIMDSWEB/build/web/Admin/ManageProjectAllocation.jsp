


<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.Date"%>
<%@page import="BusinessObject.Base"%>
<%@page import="BusinessObject.ProjectAllocation"%>

<% Date date = new Date();
    String Operation = null;
    String Delete = null;
    Operation = request.getParameter("op");
    Delete = request.getParameter("delete_yes");

    BusinessObject.ProjectAllocation projectAllocation = null;
    projectAllocation = new ProjectAllocation();

    if (Delete != null) {

        if (Delete.equals("Yes")) {

            projectAllocation.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.ProjectAllocationBL.Delete(projectAllocation);
        }

    }

    if (Operation != null) {
        projectAllocation = new ProjectAllocation();

        if (Operation.equals("Add")) {

            projectAllocation = new ProjectAllocation();

            projectAllocation.setName(request.getParameter("GroupName"));
            projectAllocation.setProjectDetailId(Integer.parseInt(request.getParameter("ProjectName")));
            projectAllocation.setUserId(Integer.parseInt(request.getParameter("UserName")));

            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("Admin");

            projectAllocation.setBase(base);
            BusinessLogic.ProjectAllocationBL.Add(projectAllocation);
        }

        if (Operation.equals("Update")) {

            projectAllocation = new ProjectAllocation();
            projectAllocation.setName(request.getParameter("GroupName"));

            if (request.getParameter("ProjectName").equals("null")) {
                projectAllocation.setProjectDetailId(Integer.parseInt(request.getParameter("OldProjectName")));

            } else {

                projectAllocation.setProjectDetailId(Integer.parseInt(request.getParameter("ProjectName")));

            }
            
            if(request.getParameter("UserName").equals("null")){
            projectAllocation.setUserId(Integer.parseInt(request.getParameter("OldUserName")));

            }else{
            projectAllocation.setUserId(Integer.parseInt(request.getParameter("UserName")));

            }
            
            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("Admin");

            projectAllocation.setBase(base);
            projectAllocation.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.ProjectAllocationBL.Update(projectAllocation);

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
                            <div class="panel-title ">Manage Project Group</div>

                            <div class="panel-options">
                                <a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
                                <a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
                            </div>
                        </div>
                        <div class="content-box-large box-with-header">
                            <div class="content-box-large">
                                <div class="panel-heading">
                                    <div class="panel-title">
                                        <a class="btn btn-primary" href="?Show=Add" onclick="">Add Project Allocation</a>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Project Name</th>
                                                <th>User Name</th>
                                                <th>Action</th>

                                            </tr>
                                        </thead>
                                        <tbody>

                                            <jsp:include page="Partial/ProjectAllocation/GetAll.jsp"/>


                                        </tbody>
                                    </table>

                                    <% if (request.getParameter("Show") != null) {%>

                                    <% if (request.getParameter("Show").equals("Add")) {%>

                                    <jsp:include page="Partial/ProjectAllocation/Add.jsp"/>
                                    <%}%>


                                    <% if (request.getParameter("Show").equals("Update")) {%>

                                    <jsp:include page="Partial/ProjectAllocation/Update.jsp"/>
                                    <%}%>

                                    <% if (request.getParameter("Show").equals("Delete")) {%>

                                    <jsp:include page="Partial/ProjectAllocation/Delete.jsp"/>
                                    <%}%>
                                    <% if (request.getParameter("Show").equals("View")) {%>

                                    <jsp:include page="Partial/ProjectAllocation/GetSingle.jsp"/>
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