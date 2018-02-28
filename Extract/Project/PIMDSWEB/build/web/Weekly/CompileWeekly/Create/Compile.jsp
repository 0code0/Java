
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@include  file="../../../Partials/Shared/PageTopSection.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title> Compile Weekly Option </title>

        <meta name="description" content="Static &amp; Dynamic Tables" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <jsp:include page="../../../Partials/Shared/CSSANDJS.jsp" />
    </head>
    <%!
        private List<String> Milestones = new ArrayList<String>();
        private List<String> InitialPropisedPlanes = new ArrayList<String>();
        private List<String> LastAgreedPlanes = new ArrayList<String>();
        private List<String> PresentForeCasts = new ArrayList<String>();
        private List<String> Achieveds = new ArrayList<String>();
        private List<String> Delays = new ArrayList<String>();
        private String Id;
        private String Achievements;
        private String Issues;
        private String Details;
        private String Plan;
        private String UserName;
        private String Header;
        private String storeDate;

        String Milestoneroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Milestone";
        String Reportingroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Reporting";
        StringBuffer Url = new StringBuffer();

    %>
    <%
        Url.delete(0, Url.length());
        for (int i = 0; i < request.getParameterValues("File").length; i++) {
            Url.append("File=");
            Url.append(request.getParameterValues("File")[i]);
            Url.append("&");
        }
    %>
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

            <%BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(Integer.parseInt(request.getParameter("classId")));%>

            <h1 style="position: absolute;margin: auto;top: 0;bottom: 0;left: 0;right: 0;text-align:center;" > 
                Weekly compilation of <span style="color: red;"> <%= projectClass.getName()%>  </span> By ${UserName}

            </h1>
            <div class="main-content">
                <div class="main-content-inner">

                    <div class="page-content">

                        <div class="row">


                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-xs-12">
                                        <%
                                            for (int i = 0; i < request.getParameterValues("File").length; i++) {

                                                BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(request.getParameterValues("File")[i].split("_")[0]));
                                        %> 

                                        <div class="row">
                                            <div class="col-xs-12">
                                                <table id="simple-table" class="table  table-bordered table-hover">

                                                    <thead>
                                                        <tr>
                                                            <th> Project Name </th>
                                                            <th> IP need </th>
                                                            <th> Technology </th>
                                                            <th> Version </th>
                                                            <th> Product </th>
                                                            <th> Division </th>
                                                            <th> Status </th>

                                                        </tr>
                                                    </thead>
                                                    <tbody id="ShowProjectDetail" >
                                                        <tr>
                                                            <td> <%= projectDetail.getName()%> </td>
                                                            <td> <%= projectDetail.getIPNeed()%> </td>
                                                            <td> <%= projectDetail.getTechnology()%> </td>
                                                            <td> <%= projectDetail.getVersion()%> </td>
                                                            <td> <%= projectDetail.getProduct()%> </td>
                                                            <td> <%= projectDetail.getDivision()%> </td>
                                                            <td> <%= projectDetail.getStatus()%> </td>
                                                        </tr>
                                                    </tbody>

                                                </table>
                                            </div><!-- /.span -->

                                            <div id="sidebar" class="sidebar h-sidebar navbar-collapse collapse ace-save-state " style="position: absolute;margin: auto;top: 150px;bottom: 0;left: 415px;right: 1;" >
                                                <script type="text/javascript">
                                                    try {
                                                        ace.settings.loadState('sidebar');
                                                    } catch (e) {
                                                    }
                                                </script>

                                            </div>
                                            <%

                                                File Reporting_file = new File(Reportingroot + "/" + "Reporting_" + request.getParameterValues("File")[i]);
                                                Scanner Reportingfilescan = new Scanner(Reporting_file);
                                                Reportingfilescan.useDelimiter(",");
                                                while (Reportingfilescan.hasNext()) {

                                                    try {
                                                        UserName = Reportingfilescan.next();
                                                        storeDate = Reportingfilescan.next();
                                                        Header = Reportingfilescan.next();
                                                        Achievements = Reportingfilescan.next();
                                                        Issues = Reportingfilescan.next();
                                                        Details = Reportingfilescan.next();
                                                        Plan = Reportingfilescan.next();

                                                    } catch (Exception ex) {

                                                    }
                                                }


                                            %>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1" style="width: 43%;"></label>

                                                <div class="col-sm-9" style="font-size: large;color: blueviolet;width: 20%">
                                                    <a href="#" id="<%= request.getParameterValues("File")[i]%>"  onclick="hideShow(this.id)" > <%= Header%> </a>&nbsp;&nbsp;<span id="<%= request.getParameterValues("File")[i]%>++" style="color: red;font-size: large;">( HIDE )</span>
                                                </div>

                                            </div>
                                            <div style="height: 10px;"></div>

                                            <div id="<%= request.getParameterValues("File")[i]%>+" style="display: none;">
                                                <div class="col-xs-12">
                                                    <table id="myTable" class="table  table-bordered table-hover">
                                                        <tr>
                                                            <th> Milestone </th>
                                                            <th> Initial Proposed Plan </th>
                                                            <th> Last Agreed Plan </th>
                                                            <th> Present Forecast  </th>
                                                            <th> Achieved </th>
                                                            <th> Delay </th>

                                                        </tr>
                                                        <%

                                                            Scanner Milestonefilescan = new Scanner(new File(Milestoneroot + "/" + "Milestone_" + request.getParameterValues("File")[i]));

                                                            Milestonefilescan.useDelimiter(",");
                                                            while (Milestonefilescan.hasNext()) {

                                                                try {
                                                                    Milestones.clear();
                                                                    InitialPropisedPlanes.clear();
                                                                    LastAgreedPlanes.clear();
                                                                    PresentForeCasts.clear();
                                                                    Achieveds.clear();
                                                                    Delays.clear();

                                                                    Milestones.add(Milestonefilescan.next());
                                                                    InitialPropisedPlanes.add(Milestonefilescan.next());
                                                                    LastAgreedPlanes.add(Milestonefilescan.next());
                                                                    PresentForeCasts.add(Milestonefilescan.next());
                                                                    Achieveds.add(Milestonefilescan.next());
                                                                    Delays.add(Milestonefilescan.next());

                                                                } catch (Exception ex) {
                                                                    out.println("<script>alert(" + ex.getMessage() + ");</script>");

                                                                }
                                                            }
                                                            for (int j = 0; j < Milestones.size(); j++) {

                                                                out.println("<tr><td>" + Milestones.get(j) + "</td><td>" + InitialPropisedPlanes.get(j) + "</td><td>" + LastAgreedPlanes.get(j) + "</td><td>" + PresentForeCasts.get(j) + "</td><td>" + Achieveds.get(j) + "</td><td>" + Delays.get(j) + "</td></tr>");

                                                            }


                                                        %>

                                                    </table>

                                                </div>
                                                <div style="width: 137px;margin: 0 auto;font-size: large;color: red;font-weight: bold;" >
                                                    Reporting
                                                </div>
                                                </br>
                                                <div class="col-xs-12">
                                                    <table id="myTable" class="table  table-bordered table-hover">
                                                        <tr>
                                                            <th> Achievements </th>
                                                            <th> <%= Achievements%> </th>
                                                        </tr>
                                                        <tr>
                                                            <th> Issues </th>
                                                            <th> <%= Issues%> </th>
                                                        </tr>
                                                        <tr>
                                                            <th> Details </th>
                                                            <th> <%= Details%> </th>
                                                        </tr>
                                                        <tr>
                                                            <th> Plan </th>
                                                            <th> <%= Plan%> </th>
                                                        </tr>
                                                    </table>

                                                </div><!-- /.main-content -->

                                            </div>

                                        </div>
                                        <hr style="background-color: #fff;border-top: 2px dashed #8c8b8b;">
                                        <% }%>        
                                    </div><!-- /.span -->



                                </div><!-- /.main-content -->


                                <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                                    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
                                </a>
                                <form action="/PIMDSWEB/Weekly/CompileWeekly/Create/SendMail.jsp?<%= Url.toString()%>WeekNumber=<%= request.getParameter("WeekNumber") %>&Year=<%= request.getParameter("Year")%>" method="post" >
                                    <button class="btn btn-danger btn-block" onclick="SubmitCompileWeekly()"> Compile Weekly </button>
                                </form>
                            </div><!-- /.main-container -->

                            <script>
                                function hideShow(val) {
                                    var hshow = document.getElementById(val + "+");
                                    var Value = document.getElementById(val + "++");

                                    if (hshow.style.display === 'none') {

                                        hshow.style.display = 'block';
                                        Value.innerHTML = "( SHOW )";

                                    } else {

                                        hshow.style.display = 'none';
                                        Value.innerHTML = "( HIDE )";
                                    }

                                }
                                function SubmitCompileWeekly() {

                                }
                            </script>
                            </body>

                            </html>
