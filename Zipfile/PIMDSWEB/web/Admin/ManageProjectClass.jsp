


<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.Date"%>
<%@page import="BusinessObject.Base"%>
<%@page import="BusinessObject.ProjectClass"%>

<% Date date = new Date();
    String Operation = null;
    String Delete = null;
    Operation = request.getParameter("op");
    Delete = request.getParameter("delete_yes");
    
    BusinessObject.ProjectClass projectClass = null;
    projectClass = new ProjectClass();
    
    if (Delete != null) {
        
        if (Delete.equals("Yes")) {
            
            projectClass.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.ProjectClassBL.Delete(projectClass);
        }
        
    }
    
    if (Operation != null) {
        projectClass = new ProjectClass();
        
        if (Operation.equals("Add")) {
            
            projectClass = new ProjectClass();
            
            projectClass.setName(request.getParameter("Name"));
            
            if (!request.getParameter("ParentId").equals("null")) {
                
                projectClass.setParentId(Integer.parseInt(request.getParameter("ParentId")));
            } else {
                
                projectClass.setParentId(null);
            }
            
            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("Admin");
            
            projectClass.setBase(base);
            BusinessLogic.ProjectClassBL.Add(projectClass);
        }
        
        if (Operation.equals("Update")) {
            
            projectClass = new ProjectClass();
            projectClass.setName(request.getParameter("Name"));
            if (!request.getParameter("ParentId").equals("null")) {
                
                projectClass.setParentId(Integer.parseInt(request.getParameter("ParentId")));
            } else {
                
                projectClass.setParentId(null);
            }
            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("Admin");
            
            projectClass.setBase(base);
            projectClass.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.ProjectClassBL.Update(projectClass);
            
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
                            <div class="panel-title ">Manage Project Class</div>

                            <div class="panel-options">
                                <a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
                                <a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
                            </div>
                        </div>
                        <div class="content-box-large box-with-header">
                            <div class="content-box-large">
                                <div class="panel-heading">
                                    <div class="panel-title">
                                        <a class="btn btn-primary" href="?Show=Add" onclick="">Add Project Class</a>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                        <thead>
                                            <tr>
                                                <th>Class</th>
                                                <th>Parent Class</th>
                                                <th>Action</th>

                                            </tr>
                                        </thead>
                                        <tbody>

                                            <jsp:include page="Partial/ProjectClass/GetAll.jsp"/>


                                        </tbody>
                                    </table>

                                    <% if (request.getParameter("Show") != null) {%>

                                    <% if (request.getParameter("Show").equals("Add")) {%>

                                    <jsp:include page="Partial/ProjectClass/Add.jsp"/>
                                    <%}%>


                                    <% if (request.getParameter("Show").equals("Update")) {%>

                                    <jsp:include page="Partial/ProjectClass/Update.jsp"/>
                                    <%}%>

                                    <% if (request.getParameter("Show").equals("Delete")) {%>

                                    <jsp:include page="Partial/ProjectClass/Delete.jsp"/>
                                    <%}%>
                                    <% if (request.getParameter("Show").equals("View")) {%>

                                    <jsp:include page="Partial/ProjectClass/GetSingle.jsp"/>
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