
<%@include  file="../../Partials/Shared/PageTopSection.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title> Compile Weekly Option </title>

        <meta name="description" content="Static &amp; Dynamic Tables" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <jsp:include page="../../Partials/Shared/CSSANDJS.jsp" />
    </head>
    <% BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>
    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <div class="navbar-container ace-save-state" id="navbar-container">
                <div class="navbar-header pull-left">
                    <a href="#" class="navbar-brand">
                        <small>
                            <span style="color: yellowgreen;">Compile Weekly</span>

                        </small>
                    </a>


                </div>
                <div class="navbar-header pull-right">
                    <a href="#" class="navbar-brand">
                        <small>
                            <span style="color: red;"> Year: </span>
                            <%= request.getParameter("Year")%>
                        </small>
                    </a>


                </div>
                <div class="navbar-header pull-right">
                    <a href="#" class="navbar-brand">
                        <small>
                            <span style="color: red;"> Week: </span>
                            <%= request.getParameter("WeekNumber")%>
                        </small>
                    </a>


                </div>
            </div><!-- /.navbar-container -->

        </div>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('main-container');
                } catch (e) {
                }
            </script>


            <div class="main-content">
                <div class="main-content-inner">

                    <div class="page-content">

                        <div class="row">
                            
                            <h1 style="position: absolute;margin: auto;top: 0;bottom: 0;left: 0;right: 0;text-align:center;" > 
                                Weekly compilation of <span style="color: red;"> <%= projectClass.getName() %> </span> By ${UserName}

                            </h1>
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-xs-12">

                                    </div><!-- /.span -->

                                    <div id="sidebar" class="sidebar h-sidebar navbar-collapse collapse ace-save-state " style="position: absolute;margin: auto;top: 150px;bottom: 0;left: 415px;right: 1;" >
                                        <script type="text/javascript">
                                            try {
                                                ace.settings.loadState('sidebar');
                                            } catch (e) {
                                            }
                                        </script>
                                        <ul class="nav-list" >

                                            <li class="hover" >
                                                <a href="Create/Create.jsp?Id=<%= projectClass.getId()%>&WeekNumber=<%= request.getParameter("WeekNumber")%>&Year=<%= request.getParameter("Year")%>">
                                                    <span class="menu-text green bigger-140"> Create </span>
                                                </a>
                                                <b class="arrow"></b>
                                            </li>
                                          
                                            <li class="hover">
                                                <a href="#">
                                                    <span class=" menu-text green bigger-140 "> View </span>
                                                </a>
                                                <b class="arrow"></b>

                                            </li>
                                            <li class="hover">
                                                <a href="#">
                                                    <span class=" menu-text green bigger-140 "> Update </span>
                                                </a>
                                                <b class="arrow"></b>

                                            </li>
                                            <li class="hover">
                                                <a href="#">
                                                    <span class=" menu-text green bigger-140 "> Generate Mail </span>
                                                </a>
                                                <b class="arrow"></b>

                                            </li>

                                        </ul><!-- /.nav-list -->

                                    </div>


                                </div><!-- /.main-content -->


                                <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                                    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
                                </a>
                            </div><!-- /.main-container -->


                            </body>
                            </html>
