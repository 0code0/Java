

<%@page import="BusinessObject.Base"%>
<%@page import="BusinessObject.LegendsCategory"%>
<%@page import="java.util.Date"%>

<% Date date = new Date();
    String Operation = null;
    String Delete = null;
    Operation = request.getParameter("op");
    Delete = request.getParameter("delete_yes");

    BusinessObject.LegendsCategory legendsCategory = null;
    legendsCategory = new LegendsCategory();

    if (Delete != null) {

        if (Delete.equals("Yes")) {

            legendsCategory.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.LegendsCategoryBL.Delete(legendsCategory);
        }

    }

    if (Operation != null) {

        if (Operation.equals("Add")) {

            legendsCategory = new LegendsCategory();

            legendsCategory.setName(request.getParameter("Name"));

            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("Admin");

            legendsCategory.setBase(base);
            BusinessLogic.LegendsCategoryBL.Add(legendsCategory);
        }

        if (Operation.equals("Update")) {

            legendsCategory = new LegendsCategory();
            legendsCategory.setName(request.getParameter("Name"));
            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("Admin");

            legendsCategory.setBase(base);
            BusinessLogic.LegendsCategoryBL.Add(legendsCategory);
            legendsCategory.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.LegendsCategoryBL.Update(legendsCategory);
            
        }

    }
%>


<!DOCTYPE html>
<html>
    <head>
        <title> M Legends Category </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page="Partials/Shared/CSSandJS.jsp" />
    </head>
    <body>

        <jsp:include page="Partials/Shared/Header.jsp" />

        <div class="page-content">
            <div class="row">

                <jsp:include page="Partials/Shared/Menu.jsp" />

                <div class="col-md-10">

                    <div class="content-box-large">
                        <div class="panel-heading">
                            <div class="panel-title">
                                <a class="btn btn-primary" href="?Show=Add" > Add Legends Category </a>
                            </div>
                        </div>
                        <div class="panel-body">
                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                <thead>
                                    <tr>
                                        <th> Name </th>

                                        <th> Action </th>

                                    </tr>
                                </thead>

                                <tbody>

                                    <jsp:include page="Partials/LegendsCategory/GetAll.jsp" />
                                </tbody>


                            </table>

                            <% if (request.getParameter("Show") != null) {%>

                            <% if (request.getParameter("Show").equals("Add")) {%>

                            <jsp:include page="Partials/LegendsCategory/Add.jsp"/>
                            <%}%>


                            <% if (request.getParameter("Show").equals("Update")) {%>

                            <jsp:include page="Partials/LegendsCategory/Update.jsp"/>
                            <%}%>

                            <% if (request.getParameter("Show").equals("Delete")) {%>

                            <jsp:include page="Partials/LegendsCategory/Delete.jsp"/>
                            <%}%>
                            <% if (request.getParameter("Show").equals("View")) {%>

                            <jsp:include page="Partials/LegendsCategory/GetSingle.jsp"/>
                            <%}%>

                            <%}%> 

                        </div>

                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="Partials/Shared/Footer.jsp" /> 
    </body>
</html>