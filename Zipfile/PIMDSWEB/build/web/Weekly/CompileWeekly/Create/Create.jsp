
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@include  file="../../../Partials/Shared/PageTopSection.jsp" %>
<%! String Milestoneroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Milestone";
    String Reportingroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Reporting";
    File[] Reportingfiles;

%>
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
    <% BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(Integer.parseInt(request.getParameter("Id")));
        List<BusinessObject.ProjectDetail> projectDetails = BusinessLogic.ProjectDetailBL.GetAllProjectDetailByProjectClass(Integer.parseInt(request.getParameter("Id")));
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
                                Weekly compilation of <span style="color: red;"> <%= projectClass.getName()%> </span> By ${UserName}

                            </h1>

                        </div>

                    </div>
                    <div style="height: 20px;">

                    </div>
                    <div class="col-xs-12">

                        <table id="simple-table" class="table  table-bordered table-hover" style="width: 300px;" >
                            <thead>
                                <tr>
                                    <th> Select </th>
                                    <th> Week </th>
                                </tr>
                            </thead>
                            <tbody id="ShowProjectDetail" >
                                <%
                                    for (BusinessObject.ProjectDetail projectDetail : projectDetails) {

                                        Reportingfiles = new File(Reportingroot).listFiles(new DataAccess.FileStartFilterDA("Reporting_" + projectDetail.getId(), request.getParameter("Year") + ".txt"));

                                        for (File file : Reportingfiles) {%>

                                <tr>
                                    <td>
                                        <div class='col-xs-12 col-sm-6'>
                                            <div class='control-group'>
                                                <div class='radio'>
                                                    <label class="inline">
                                                        <input type="checkbox" id="<%= file.getName()%>" name="CompileName" value="<%= file.getName().split("_")[1]+"_"+file.getName().split("_")[2]+"_"+file.getName().split("_")[3] %>" class="ace" va />
                                                        <span class="lbl"></span>
                                                    </label>
                                                    <label>
                                                        <input  type='radio' onclick="ViewFile('<%= file.getName().split("_")[1]%>', '<%= file.getName().split("_")[2]%>')" class='ace' name='Select' /><span class='lbl'> </span>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <%= file.getName().split("_")[2]%>
                                    </td>
                                </tr>

                                <%}
                                    }%>
                                <tr id="CompileWeeklyButtonId" ><td colspan="2" ><button class="btn btn-danger btn-block" onclick="CompileWeekly()">Compile</button></td></tr>
                            </tbody>


                        </table>

                    </div>

                    <iframe id="iFrame1" style="margin-top:-275px;margin-bottom:15px ;margin-left: 350px;background:#EAEBED;" name="iFrame1" frameborder=1 scrolling="yes" align="top" width='70%' height='450px' marginwidth=0 marginheight=0  class = "iFrame1">
                        [Your browser does not support frames.]
                    </iframe>
                </div>
            </div>
            <script>
                document.getElementById("iFrame1").style.visibility = "hidden";
               
                var IdforClone;
                var WeekforClone;

                function ViewFile(Id, Week) {
                    document.getElementById("iFrame1").style.visibility = "visible";
               
                    document.getElementById("iFrame1").src = "/PIMDSWEB/Weekly/ProjectWeekly/Option/Create/CloneView.jsp?Id=" + Id + "&WeekNumber=" + Week + "&Year=" +<%= request.getParameter("Year")%>;
                    IdforClone = Id;
                    WeekforClone = Week;
                }

                function CompileWeekly() {

                    var CheckBoxes = document.getElementsByName("CompileName");
                    var CheckBoxesChecked = [];
                    for (var i = 0; i < CheckBoxes.length; i++) {

                        if (CheckBoxes[i].checked) {
                            CheckBoxesChecked.push("File="+CheckBoxes[i].value);
                        }

                    }
                    var url = CheckBoxesChecked.join('&');
                
                    location.href = "/PIMDSWEB/Weekly/CompileWeekly/Create/Compile.jsp?WeekNumber="+ <%= request.getParameter("WeekNumber")%>+"&Year="+<%= request.getParameter("Year")%>+"&"+url+"&classId="+<%= request.getParameter("Id") %>;

                }

            </script>
    </body>
</html>
