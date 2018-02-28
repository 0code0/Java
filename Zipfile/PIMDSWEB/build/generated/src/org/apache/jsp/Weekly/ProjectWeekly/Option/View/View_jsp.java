package org.apache.jsp.Weekly.ProjectWeekly.Option.View;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.BufferedReader;

public final class View_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    List<String> Milestones = new ArrayList<String>();
    List<String> InitialPropisedPlanes = new ArrayList<String>();
    List<String> LastAgreedPlanes = new ArrayList<String>();
    List<String> PresentForeCasts = new ArrayList<String>();
    List<String> Achieveds = new ArrayList<String>();
    List<String> Delays = new ArrayList<String>();
    private boolean flag = false;
    private String Achievements;
    private String Issues;
    private String Details;
    private String Plan;
    private String UserName;
    private String Header;
    private String storeDate;
    String Milestoneroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Milestone";
    String Reportingroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Reporting";



  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Weekly/ProjectWeekly/Option/View/../../../../Partials/Shared/PageTopSection.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    
    HttpSession httpsession = request.getSession();
    if(httpsession.getAttribute("UserName")==null){
    
    response.sendRedirect("/PIMDSWEB/index.jsp");
    return;
    }
    

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <title> View New </title>\n");
      out.write("\n");
      out.write("        <meta name=\"description\" content=\"Static &amp; Dynamic Tables\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../../../Partials/Shared/CSSANDJS.jsp", out, false);
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"no-skin\" >\n");
      out.write("        <div id=\"navbar\" class=\"navbar navbar-default          ace-save-state\">\n");
      out.write("            <div class=\"navbar-container ace-save-state\" id=\"navbar-container\">\n");
      out.write("                <div class=\"navbar-header pull-left\">\n");
      out.write("                    <a href=\"#\" class=\"navbar-brand\">\n");
      out.write("                        <small>\n");
      out.write("                            <span style=\"color: yellowgreen;\">Project Weekly</span>\n");
      out.write("\n");
      out.write("                        </small>\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"navbar-header pull-right\">\n");
      out.write("                    <a href=\"#\" class=\"navbar-brand\">\n");
      out.write("                        <small>\n");
      out.write("                            <span style=\"color: red;\"> Year: </span>\n");
      out.write("                            ");
      out.print( request.getParameter("Year"));
      out.write("\n");
      out.write("                        </small>\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"navbar-header pull-right\">\n");
      out.write("                    <a href=\"#\" class=\"navbar-brand\">\n");
      out.write("                        <small>\n");
      out.write("                            <span style=\"color: red;\"> Week: </span>\n");
      out.write("                            ");
      out.print( request.getParameter("WeekNumber"));
      out.write("\n");
      out.write("                        </small>\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"main-container ace-save-state\" id=\"main-container\">\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    try {\n");
      out.write("                        ace.settings.loadState('main-container');\n");
      out.write("                    } catch (e) {\n");
      out.write("                    }\n");
      out.write("                </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"main-content\">\n");
      out.write("                    <div class=\"main-content-inner\">\n");
      out.write("\n");
      out.write("                        <div class=\"page-content\">\n");
      out.write("\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-12\">\n");
      out.write("                                    <!-- PAGE CONTENT BEGINS -->\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-xs-12\">\n");
      out.write("                                            <table id=\"simple-table\" class=\"table  table-bordered table-hover\">\n");
      out.write("                                                ");
 BusinessObject.ProjectDetail projectName = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(request.getParameter("Id")));
      out.write("\n");
      out.write("\n");
      out.write("                                                <thead>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <th> Project Name </th>\n");
      out.write("                                                        <th> IP need </th>\n");
      out.write("                                                        <th> Technology </th>\n");
      out.write("                                                        <th> Version </th>\n");
      out.write("                                                        <th> Product </th>\n");
      out.write("                                                        <th> Division </th>\n");
      out.write("                                                        <th> Status </th>\n");
      out.write("\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </thead>\n");
      out.write("                                                <tbody id=\"ShowProjectDetail\" >\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td> ");
      out.print( projectName.getName());
      out.write(" </td>\n");
      out.write("                                                        <td> ");
      out.print( projectName.getIPNeed());
      out.write(" </td>\n");
      out.write("                                                        <td> ");
      out.print( projectName.getTechnology());
      out.write(" </td>\n");
      out.write("                                                        <td> ");
      out.print( projectName.getVersion());
      out.write(" </td>\n");
      out.write("                                                        <td> ");
      out.print( projectName.getProduct());
      out.write(" </td>\n");
      out.write("                                                        <td> ");
      out.print( projectName.getDivision());
      out.write(" </td>\n");
      out.write("                                                        <td> ");
      out.print( projectName.getStatus());
      out.write(" </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            </table>\n");
      out.write("                                        </div><!-- /.span -->\n");
      out.write("\n");
      out.write("                                        <div id=\"sidebar\" class=\"sidebar h-sidebar navbar-collapse collapse ace-save-state \" style=\"position: absolute;margin: auto;top: 150px;bottom: 0;left: 415px;right: 1;\" >\n");
      out.write("                                            <script type=\"text/javascript\">\n");
      out.write("                                                try {\n");
      out.write("                                                    ace.settings.loadState('sidebar');\n");
      out.write("                                                } catch (e) {\n");
      out.write("                                                }\n");
      out.write("                                            </script>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div style=\"height: 130px;\"></div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-xs-12\">\n");
      out.write("                                            <table id=\"myTable\" class=\"table  table-bordered table-hover\">\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th> Milestone </th>\n");
      out.write("                                                    <th> Initial Proposed Plan </th>\n");
      out.write("                                                    <th> Last Agreed Plan </th>\n");
      out.write("                                                    <th> Present Forecast  </th>\n");
      out.write("                                                    <th> Achieved </th>\n");
      out.write("                                                    <th> Delay </th>\n");
      out.write("\n");
      out.write("                                                </tr>\n");
      out.write("\n");
      out.write("                                                ");
  File Milestone_file = new File(Milestoneroot + "/Milestone_" + request.getParameter("Id") + "_" + request.getParameter("WeekNumber") + "_" + request.getParameter("Year") + ".txt");

                                                    if (Milestone_file.exists()) {
                                                        Scanner Milestonefilescan = new Scanner(Milestone_file);

                                                        Milestonefilescan.useDelimiter(",");
                                                        while (Milestonefilescan.hasNext()) {

                                                            try {

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

                                                        for (int i = 0; i < Milestones.size(); i++) {

                                                            out.println("<tr><td>" + Milestones.get(i) + "</td><td>" + InitialPropisedPlanes.get(i) + "</td><td>" + LastAgreedPlanes.get(i) + "</td><td>" + PresentForeCasts.get(i) + "</td><td>" + Achieveds.get(i) + "</td><td>" + Delays.get(i) + "</td></tr>");

                                                        }
                                                        Milestones.clear();
                                                        InitialPropisedPlanes.clear();
                                                        LastAgreedPlanes.clear();
                                                        PresentForeCasts.clear();
                                                        Achieveds.clear();
                                                        Delays.clear();
                                                    } else {
                                                       
                                                        flag = true;
                                                  
                                                    }


                                                
      out.write("\n");
      out.write("\n");
      out.write("                                            </table>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div style=\"width: 137px;margin: 0 auto;font-size: large;color: red;font-weight: bold;\" >\n");
      out.write("                                            Reporting\n");
      out.write("                                        </div>\n");
      out.write("                                        </br>\n");
      out.write("                                        <div class=\"col-xs-12\">\n");
      out.write("\n");
      out.write("                                            ");
   
                                                File Reporting_file = new File(Reportingroot + "/Reporting_" + request.getParameter("Id") + "_" + request.getParameter("WeekNumber") + "_" + request.getParameter("Year") + ".txt");
                                                if (Reporting_file.exists()) {
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

                                                } else {
                                                    
                                                   if(flag){
                                                         response.sendRedirect("/PIMDSWEB/Weekly/ProjectWeekly/Option/View/SelectWeekforView.jsp?Id="+projectName.getId()+"&WeekNumber="+request.getParameter("WeekNumber")+"&Year="+request.getParameter("Year"));
                                                   
                                                   }
                                                }


                                            
      out.write("\n");
      out.write("                                            <table id=\"myTable\" class=\"table  table-bordered table-hover\" width>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th> Header </th>\n");
      out.write("                                                    <th> ");
      out.print( Header);
      out.write(" </th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th> Achievements </th>\n");
      out.write("                                                    <th> ");
      out.print( Achievements);
      out.write(" </th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th> Issues </th>\n");
      out.write("                                                    <th> ");
      out.print( Issues);
      out.write(" </th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th> Details </th>\n");
      out.write("                                                    <th> ");
      out.print( Details);
      out.write(" </th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th> Plan </th>\n");
      out.write("                                                    <th> ");
      out.print( Plan);
      out.write(" </th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </table>\n");
      out.write("\n");
      out.write("                                        </div><!-- /.main-content -->\n");
      out.write("\n");
      out.write("                                        <a href=\"#\" id=\"btn-scroll-up\" class=\"btn-scroll-up btn btn-sm btn-inverse\">\n");
      out.write("                                            <i class=\"ace-icon fa fa-angle-double-up icon-only bigger-110\"></i>\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("                                    <script type=\"text/javascript\">\n");
      out.write("                                        jQuery(function ($) {\n");
      out.write("                                            //initiate dataTables plugin\n");
      out.write("                                            var myTable =\n");
      out.write("                                                    $('#dynamic-table')\n");
      out.write("                                                    //.wrap(\"<div class='dataTables_borderWrap' />\")   //if you are applying horizontal scrolling (sScrollX)\n");
      out.write("                                                    .DataTable({\n");
      out.write("                                                        bAutoWidth: false,\n");
      out.write("                                                        \"aoColumns\": [\n");
      out.write("                                                            {\"bSortable\": false},\n");
      out.write("                                                            null, null, null, null, null,\n");
      out.write("                                                            {\"bSortable\": false}\n");
      out.write("                                                        ],\n");
      out.write("                                                        \"aaSorting\": [],\n");
      out.write("                                                        //\"bProcessing\": true,\n");
      out.write("                                                        //\"bServerSide\": true,\n");
      out.write("                                                        //\"sAjaxSource\": \"http://127.0.0.1/table.php\"\t,\n");
      out.write("\n");
      out.write("                                                        //,\n");
      out.write("                                                        //\"sScrollY\": \"200px\",\n");
      out.write("                                                        //\"bPaginate\": false,\n");
      out.write("\n");
      out.write("                                                        //\"sScrollX\": \"100%\",\n");
      out.write("                                                        //\"sScrollXInner\": \"120%\",\n");
      out.write("                                                        //\"bScrollCollapse\": true,\n");
      out.write("                                                        //Note: if you are applying horizontal scrolling (sScrollX) on a \".table-bordered\"\n");
      out.write("                                                        //you may want to wrap the table inside a \"div.dataTables_borderWrap\" element\n");
      out.write("\n");
      out.write("                                                        //\"iDisplayLength\": 50\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                        select: {\n");
      out.write("                                                            style: 'multi'\n");
      out.write("                                                        }\n");
      out.write("                                                    });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            $.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';\n");
      out.write("\n");
      out.write("                                            new $.fn.dataTable.Buttons(myTable, {\n");
      out.write("                                                buttons: [\n");
      out.write("                                                    {\n");
      out.write("                                                        \"extend\": \"colvis\",\n");
      out.write("                                                        \"text\": \"<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>\",\n");
      out.write("                                                        \"className\": \"btn btn-white btn-primary btn-bold\",\n");
      out.write("                                                        columns: ':not(:first):not(:last)'\n");
      out.write("                                                    },\n");
      out.write("                                                    {\n");
      out.write("                                                        \"extend\": \"copy\",\n");
      out.write("                                                        \"text\": \"<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>\",\n");
      out.write("                                                        \"className\": \"btn btn-white btn-primary btn-bold\"\n");
      out.write("                                                    },\n");
      out.write("                                                    {\n");
      out.write("                                                        \"extend\": \"csv\",\n");
      out.write("                                                        \"text\": \"<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>\",\n");
      out.write("                                                        \"className\": \"btn btn-white btn-primary btn-bold\"\n");
      out.write("                                                    },\n");
      out.write("                                                    {\n");
      out.write("                                                        \"extend\": \"excel\",\n");
      out.write("                                                        \"text\": \"<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>\",\n");
      out.write("                                                        \"className\": \"btn btn-white btn-primary btn-bold\"\n");
      out.write("                                                    },\n");
      out.write("                                                    {\n");
      out.write("                                                        \"extend\": \"pdf\",\n");
      out.write("                                                        \"text\": \"<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>\",\n");
      out.write("                                                        \"className\": \"btn btn-white btn-primary btn-bold\"\n");
      out.write("                                                    },\n");
      out.write("                                                    {\n");
      out.write("                                                        \"extend\": \"print\",\n");
      out.write("                                                        \"text\": \"<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>\",\n");
      out.write("                                                        \"className\": \"btn btn-white btn-primary btn-bold\",\n");
      out.write("                                                        autoPrint: false,\n");
      out.write("                                                        message: 'This print was produced using the Print button for DataTables'\n");
      out.write("                                                    }\n");
      out.write("                                                ]\n");
      out.write("                                            });\n");
      out.write("                                            myTable.buttons().container().appendTo($('.tableTools-container'));\n");
      out.write("\n");
      out.write("                                            //style the message box\n");
      out.write("                                            var defaultCopyAction = myTable.button(1).action();\n");
      out.write("                                            myTable.button(1).action(function (e, dt, button, config) {\n");
      out.write("                                                defaultCopyAction(e, dt, button, config);\n");
      out.write("                                                $('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');\n");
      out.write("                                            });\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            var defaultColvisAction = myTable.button(0).action();\n");
      out.write("                                            myTable.button(0).action(function (e, dt, button, config) {\n");
      out.write("\n");
      out.write("                                                defaultColvisAction(e, dt, button, config);\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                if ($('.dt-button-collection > .dropdown-menu').length == 0) {\n");
      out.write("                                                $('.dt-button-collection');\n");
      out.write("                                                        .wrapInner('<ul class=\"dropdown-menu dropdown-light dropdown-caret dropdown-caret\" />')\n");
      out.write("                                                        .find('a').attr('href', '#').wrap(\"<li />\")\n");
      out.write("                                                }\n");
      out.write("                                                $('.dt-button-collection').appendTo('.tableTools-container .dt-buttons');\n");
      out.write("                                            });\n");
      out.write("\n");
      out.write("                                            ////\n");
      out.write("\n");
      out.write("                                            setTimeout(function () {\n");
      out.write("                                                $($('.tableTools-container')).find('a.dt-button').each(function () {\n");
      out.write("                                                    var div = $(this).find(' > div').first();\n");
      out.write("                                                    if (div.length == 1)\n");
      out.write("                                                        ;\n");
      out.write("                                                    div.tooltip({container: 'body', title: div.parent().text()});\n");
      out.write("                                                            else\n");
      out.write("                                                            $(this).tooltip({container: 'body', title: $(this).text()});\n");
      out.write("                                                });\n");
      out.write("                                            }, 500);\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            myTable.on('select', function (e, dt, type, index) {\n");
      out.write("                                                if (type === 'row') {\n");
      out.write("                                                    $(myTable.row(index).node()).find('input:checkbox').prop('checked', true);\n");
      out.write("                                                }\n");
      out.write("                                            });\n");
      out.write("                                            myTable.on('deselect', function (e, dt, type, index) {\n");
      out.write("                                                if (type === 'row') {\n");
      out.write("                                                    $(myTable.row(index).node()).find('input:checkbox').prop('checked', false);\n");
      out.write("                                                }\n");
      out.write("                                            });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            /////////////////////////////////\n");
      out.write("                                            //table checkboxes\n");
      out.write("                                            $('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);\n");
      out.write("\n");
      out.write("                                            //select/deselect all rows according to table header checkbox\n");
      out.write("                                            $('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function () {\n");
      out.write("                                                var th_checked = this.checked;//checkbox inside \"TH\" table header\n");
      out.write("\n");
      out.write("                                                $('#dynamic-table').find('tbody > tr').each(function () {\n");
      out.write("                                                    var row = this;\n");
      out.write("                                                    if (th_checked)\n");
      out.write("                                                        myTable.row(row).select();\n");
      out.write("                                                    else\n");
      out.write("                                                        myTable.row(row).deselect();\n");
      out.write("                                                });\n");
      out.write("                                            });\n");
      out.write("\n");
      out.write("                                            //select/deselect a row when the checkbox is checked/unchecked\n");
      out.write("                                            $('#dynamic-table').on('click', 'td input[type=checkbox]', function () {\n");
      out.write("                                                var row = $(this).closest('tr').get(0);\n");
      out.write("                                                if (this.checked)\n");
      out.write("                                                    myTable.row(row).deselect();\n");
      out.write("                                                else\n");
      out.write("                                                    myTable.row(row).select();\n");
      out.write("                                            });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            $(document).on('click', '#dynamic-table .dropdown-toggle', function (e) {\n");
      out.write("                                                e.stopImmediatePropagation();\n");
      out.write("                                                e.stopPropagation();\n");
      out.write("                                                e.preventDefault();\n");
      out.write("                                            });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            //And for the first simple table, which doesn't have TableTools or dataTables\n");
      out.write("                                            //select/deselect all rows according to table header checkbox\n");
      out.write("                                            var active_class = 'active';\n");
      out.write("                                            $('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function () {\n");
      out.write("                                                var th_checked = this.checked;//checkbox inside \"TH\" table header\n");
      out.write("\n");
      out.write("                                                $(this).closest('table').find('tbody > tr').each(function () {\n");
      out.write("                                                    var row = this;\n");
      out.write("                                                    if (th_checked)\n");
      out.write("                                                        $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);\n");
      out.write("                                                    else\n");
      out.write("                                                        $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);\n");
      out.write("                                                });\n");
      out.write("                                            });\n");
      out.write("\n");
      out.write("                                            //select/deselect a row when the checkbox is checked/unchecked\n");
      out.write("                                            $('#simple-table').on('click', 'td input[type=checkbox]', function () {\n");
      out.write("                                                var $row = $(this).closest('tr');\n");
      out.write("                                                if ($row.is('.detail-row '))\n");
      out.write("                                                    return;\n");
      out.write("                                                if (this.checked)\n");
      out.write("                                                    $row.addClass(active_class);\n");
      out.write("                                                else\n");
      out.write("                                                    $row.removeClass(active_class);\n");
      out.write("                                            });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            /********************************/\n");
      out.write("                                            //add tooltip for small view action buttons in dropdown menu\n");
      out.write("                                            $('[data-rel=\"tooltip\"]').tooltip({placement: tooltip_placement});\n");
      out.write("\n");
      out.write("                                            //tooltip placement on right or left\n");
      out.write("                                            function tooltip_placement(context, source) {\n");
      out.write("                                                var $source = $(source);\n");
      out.write("                                                var $parent = $source.closest('table');\n");
      out.write("                                                var off1 = $parent.offset();\n");
      out.write("                                                var w1 = $parent.width();\n");
      out.write("\n");
      out.write("                                                var off2 = $source.offset();\n");
      out.write("                                                //var w2 = $source.width();\n");
      out.write("\n");
      out.write("                                                if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))\n");
      out.write("                                                    return 'right';\n");
      out.write("                                                return 'left';\n");
      out.write("                                            }\n");
      out.write("\n");
      out.write("                                        });\n");
      out.write("                                    </script>\n");
      out.write("                                    <script>\n");
      out.write("\n");
      out.write("                                        $('#showdata').on('click', function (e) {\n");
      out.write("                                            alert(\"hello\");\n");
      out.write("                                            e.preventDefault();\n");
      out.write("                                            $(this).closest('tr').next().toggleClass('open');\n");
      out.write("                                            $(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');\n");
      out.write("                                        });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </script>\n");
      out.write("\n");
      out.write("                                    </body>\n");
      out.write("                                    </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
