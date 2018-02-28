
<%@page import="BusinessObject.LegendsDetail"%>
<%@page import="java.util.Date"%>
<% Date date = new Date();
    String Delete = null;
    Delete = request.getParameter("delete_yes");

    BusinessObject.LegendsDetail legendsDetail = null;
    legendsDetail = new LegendsDetail();

    if (Delete != null) {

        if (Delete.equals("Yes")) {

            legendsDetail.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.LegendsDetailBL.Delete(legendsDetail);
        }

    }
    
%>

<!DOCTYPE html>
<html>
    <head>
        <title> Manage Legends Detail </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page="Partials/Shared/CSSandJS.jsp" />
    </head>
    <body>

        <jsp:include page="Partials/Shared/Header.jsp" />

        <div class="page-content">
            <div class="row">

                <jsp:include page="Partials/Shared/Menu.jsp" />
                <div class="col-md-10">

                    <div class="col-md-10">

                        <div class="content-box-large">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <a class="btn btn-primary" href="?Show=Add" onclick=""> Add Legends Detail </a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                    <thead>
                                        <tr>
                                            <th> Name </th>

                                            <th> Action </th>

                                        </tr>
                                    <tbody>

                                        <jsp:include page="Partials/LegendsDetail/GetAll.jsp" />
                                    </tbody>


                                </table>

                                <% if (request.getParameter("Show") != null) {%>

                                <% if (request.getParameter("Show").equals("Add")) {%>

                                <jsp:include page="Partials/LegendsDetail/Add.jsp"/>
                                <%}%>


                                <% if (request.getParameter("Show").equals("Update")) {%>

                                <jsp:include page="Partials/LegendsDetail/Update.jsp"/>
                                <%}%>

                                <% if (request.getParameter("Show").equals("Delete")) {%>

                                <jsp:include page="Partials/LegendsDetail/Delete.jsp"/>
                                <%}%>
                                <% if (request.getParameter("Show").equals("View")) {%>

                                <jsp:include page="Partials/LegendsDetail/GetSingle.jsp"/>
                                <%}%>

                                <%}%> 
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="Partials/Shared/Footer.jsp" /> 
    </body>
</html>