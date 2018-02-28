
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@include  file="../Partials/Shared/PageTopSection.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>Project Weekly</title>

        <meta name="description" content="Static &amp; Dynamic Tables" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <jsp:include page="../Partials/Shared/CSSANDJS.jsp" />
    </head>

    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <div class="navbar-container ace-save-state" id="navbar-container">
                <div class="navbar-header pull-left">
                    <a href="<%=request.getContextPath()%>/DeshBoard.jsp" class="navbar-brand">
                        <small>
                            <span style="color: yellowgreen;"> ERROR </span>

                        </small>
                    </a>


                </div>
            </div><!-- /.navbar-container -->
        </div>

        <div class="main-container ace-save-state" id="main-container">
            <div class="main-content">
                <div class="main-content-inner">

                    <div class="page-content">

                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <%
                                        BusinessObject.ProjectClass projectclass = BusinessLogic.ProjectClassBL.GetSingle(Integer.parseInt(request.getParameter("Id")));

                                    %>
                                    
                                </div><!-- /.row -->

                                <!-- PAGE CONTENT ENDS -->
                            </div><!-- /.col -->
                            <h1 style="color: red;margin-left: 50px;" >
                                        ${UserName} you are not the admin of <%=  projectclass.getName()%> Please Close the Window.
                                    </h1>
                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.main-content -->
            

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div><!-- /.main-container -->

    </body>
</html>
