

<%@page import="BusinessObject.Base"%>
<%@page import="BusinessObject.Randd"%>
<%@page import="java.util.Date"%>

<% Date date = new Date();
    String Operation = null;
    String Delete = null;
    Operation = request.getParameter("op");
    Delete = request.getParameter("delete_yes");

    BusinessObject.Randd randd = null;
    randd = new Randd();

    if (Delete != null) {

        if (Delete.equals("Yes")) {

            randd.setId(Integer.parseInt(request.getParameter("Id")));
            BusinessLogic.RandDBL.Delete(randd);
        }

    }

    if (Operation != null) {

        if (Operation.equals("Add")) {

            randd = new Randd();

            randd.setTitle(request.getParameter("Title"));
            randd.setDetail(request.getParameter("Detail"));
            randd.setUrl(request.getParameter("Url"));
            randd.setLegendsDetailId(Integer.parseInt(request.getParameter("LegendName")));

            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("Admin");

            randd.setBase(base);
            BusinessLogic.RandDBL.Add(randd);
        }

        if (Operation.equals("Update")) {

            randd = new Randd();

            randd.setTitle(request.getParameter("Title"));
            randd.setDetail(request.getParameter("Detail"));
            randd.setUrl(request.getParameter("Url"));
            randd.setLegendsDetailId(Integer.parseInt(request.getParameter("LegendName")));

            Base base = new Base();
            base.setIsApproved("true");
            base.setIsDeleted("false");
            base.setCreatedOn(date.toString());
            base.setCreatedBy("Admin");

            randd.setBase(base);
            randd.setId(Integer.parseInt(request.getParameter("Id")));
      
            BusinessLogic.RandDBL.Update(randd);

        }

    }
%>


<!DOCTYPE html>
<html>
    <head>
        <title> Manage RandD </title>
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
                                <a class="btn btn-primary" href="?Show=Add" onclick=""> Add RandD </a>
                            </div>
                        </div>
                        <div class="panel-body">
                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                <thead>
                                    <tr>
                                        <th> Legend Name </th>
                                        <th> Title </th>
                                        <th>Action</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <jsp:include page="Partials/RandD/GetAll.jsp" />
                                </tbody>


                            </table>

                            <% if (request.getParameter("Show") != null) {%>

                            <% if (request.getParameter("Show").equals("Add")) {%>

                            <jsp:include page="Partials/RandD/Add.jsp"/>
                            <%}%>


                            <% if (request.getParameter("Show").equals("Update")) {%>

                            <jsp:include page="Partials/RandD/Update.jsp"/>
                            <%}%>

                            <% if (request.getParameter("Show").equals("Delete")) {%>

                            <jsp:include page="Partials/RandD/Delete.jsp"/>
                            <%}%>
                            <% if (request.getParameter("Show").equals("View")) {%>

                            <jsp:include page="Partials/RandD/GetSingle.jsp"/>
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