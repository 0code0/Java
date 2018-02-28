
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>

<%!
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


%>




<%@include  file="../../../../Partials/Shared/PageTopSection.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title> View New </title>

        <meta name="description" content="Static &amp; Dynamic Tables" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <jsp:include page="../../../../Partials/Shared/CSSANDJS.jsp" />
    </head>

    <body class="no-skin" >
        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <div class="navbar-container ace-save-state" id="navbar-container">

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
                                <div class="col-xs-12">
                                    <!-- PAGE CONTENT BEGINS -->
                                    <div class="row">
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

                                            <% BusinessObject.ProjectDetail projectName = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>

                                            <tbody id="ShowProjectDetail" >
                                                <tr>
                                                    <td> <%= projectName.getName()%> </td>
                                                    <td> <%= projectName.getIPNeed()%> </td>
                                                    <td> <%= projectName.getTechnology()%> </td>
                                                    <td> <%= projectName.getVersion()%> </td>
                                                    <td> <%= projectName.getProduct()%> </td>
                                                    <td> <%= projectName.getDivision()%> </td>
                                                    <td> <%= projectName.getStatus()%> </td>
                                                </tr>

                                            </tbody>


                                        </table>


                                        <div class="col-xs-12">

                                            <%
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

                                                    flag = true;
                                                }


                                            %>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1" style="width: 43%;"></label>

                                                <div class="col-sm-9" style="font-size: large;color: blueviolet;width: 20%">
                                                    <%= Header%>
                                                </div>

                                            </div>
                                            <div style="height: 10px;"></div>

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

                                                    <%  File Milestone_file = new File(Milestoneroot + "/Milestone_" + request.getParameter("Id") + "_" + request.getParameter("WeekNumber") + "_" + request.getParameter("Year") + ".txt");

                                                        if (Milestone_file.exists()) {
                                                            Scanner Milestonefilescan = new Scanner(Milestone_file);

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

                                                            for (int i = 0; i < Milestones.size(); i++) {

                                                                out.println("<tr><td>" + Milestones.get(i) + "</td><td>" + InitialPropisedPlanes.get(i) + "</td><td>" + LastAgreedPlanes.get(i) + "</td><td>" + PresentForeCasts.get(i) + "</td><td>" + Achieveds.get(i) + "</td><td>" + Delays.get(i) + "</td></tr>");

                                                            }
                                                            Milestones.clear();
                                                            InitialPropisedPlanes.clear();
                                                            LastAgreedPlanes.clear();
                                                            PresentForeCasts.clear();
                                                            Achieveds.clear();
                                                            Delays.clear();
                                                        } else if (flag) {
                                                            response.sendRedirect("/PIMDSWEB/Weekly/ProjectWeekly/Option/View/SelectWeekforView.jsp?Id=" + request.getParameter("Id") + "&WeekNumber=" + request.getParameter("WeekNumber") + "&Year=" + request.getParameter("Year"));
                                                        }


                                                    %>

                                                </table>

                                            </div>
                                            <div style="width: 137px;margin: 0 auto;font-size: large;color: red;font-weight: bold;" >
                                                Reporting
                                            </div>
                                            </br>
                                            <div class="col-xs-12">


                                                <table id="myTable" class="table  table-bordered table-hover" style="width: 50%;margin-left: 300px;">

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

                                            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                                                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
                                            </a>
                                        </div>
                                        <script type="text/javascript">
                                            jQuery(function ($) {
                                                //initiate dataTables plugin
                                                var myTable =
                                                        $('#dynamic-table')
                                                        //.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
                                                        .DataTable({
                                                            bAutoWidth: false,
                                                            "aoColumns": [
                                                                {"bSortable": false},
                                                                null, null, null, null, null,
                                                                {"bSortable": false}
                                                            ],
                                                            "aaSorting": [],
                                                            //"bProcessing": true,
                                                            //"bServerSide": true,
                                                            //"sAjaxSource": "http://127.0.0.1/table.php"	,

                                                            //,
                                                            //"sScrollY": "200px",
                                                            //"bPaginate": false,

                                                            //"sScrollX": "100%",
                                                            //"sScrollXInner": "120%",
                                                            //"bScrollCollapse": true,
                                                            //Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
                                                            //you may want to wrap the table inside a "div.dataTables_borderWrap" element

                                                            //"iDisplayLength": 50


                                                            select: {
                                                                style: 'multi'
                                                            }
                                                        });



                                                $.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';

                                                new $.fn.dataTable.Buttons(myTable, {
                                                    buttons: [
                                                        {
                                                            "extend": "colvis",
                                                            "text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
                                                            "className": "btn btn-white btn-primary btn-bold",
                                                            columns: ':not(:first):not(:last)'
                                                        },
                                                        {
                                                            "extend": "copy",
                                                            "text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
                                                            "className": "btn btn-white btn-primary btn-bold"
                                                        },
                                                        {
                                                            "extend": "csv",
                                                            "text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
                                                            "className": "btn btn-white btn-primary btn-bold"
                                                        },
                                                        {
                                                            "extend": "excel",
                                                            "text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
                                                            "className": "btn btn-white btn-primary btn-bold"
                                                        },
                                                        {
                                                            "extend": "pdf",
                                                            "text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
                                                            "className": "btn btn-white btn-primary btn-bold"
                                                        },
                                                        {
                                                            "extend": "print",
                                                            "text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
                                                            "className": "btn btn-white btn-primary btn-bold",
                                                            autoPrint: false,
                                                            message: 'This print was produced using the Print button for DataTables'
                                                        }
                                                    ]
                                                });
                                                myTable.buttons().container().appendTo($('.tableTools-container'));

                                                //style the message box
                                                var defaultCopyAction = myTable.button(1).action();
                                                myTable.button(1).action(function (e, dt, button, config) {
                                                    defaultCopyAction(e, dt, button, config);
                                                    $('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
                                                });


                                                var defaultColvisAction = myTable.button(0).action();
                                                myTable.button(0).action(function (e, dt, button, config) {

                                                    defaultColvisAction(e, dt, button, config);


                                                    if ($('.dt-button-collection > .dropdown-menu').length == 0) {
                                                    $('.dt-button-collection');
                                                            .wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
                                                            .find('a').attr('href', '#').wrap("<li />")
                                                    }
                                                    $('.dt-button-collection').appendTo('.tableTools-container .dt-buttons');
                                                });

                                                ////

                                                setTimeout(function () {
                                                    $($('.tableTools-container')).find('a.dt-button').each(function () {
                                                        var div = $(this).find(' > div').first();
                                                        if (div.length == 1)
                                                            ;
                                                        div.tooltip({container: 'body', title: div.parent().text()});
                                                                else
                                                                $(this).tooltip({container: 'body', title: $(this).text()});
                                                    });
                                                }, 500);





                                                myTable.on('select', function (e, dt, type, index) {
                                                    if (type === 'row') {
                                                        $(myTable.row(index).node()).find('input:checkbox').prop('checked', true);
                                                    }
                                                });
                                                myTable.on('deselect', function (e, dt, type, index) {
                                                    if (type === 'row') {
                                                        $(myTable.row(index).node()).find('input:checkbox').prop('checked', false);
                                                    }
                                                });




                                                /////////////////////////////////
                                                //table checkboxes
                                                $('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);

                                                //select/deselect all rows according to table header checkbox
                                                $('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function () {
                                                    var th_checked = this.checked;//checkbox inside "TH" table header

                                                    $('#dynamic-table').find('tbody > tr').each(function () {
                                                        var row = this;
                                                        if (th_checked)
                                                            myTable.row(row).select();
                                                        else
                                                            myTable.row(row).deselect();
                                                    });
                                                });

                                                //select/deselect a row when the checkbox is checked/unchecked
                                                $('#dynamic-table').on('click', 'td input[type=checkbox]', function () {
                                                    var row = $(this).closest('tr').get(0);
                                                    if (this.checked)
                                                        myTable.row(row).deselect();
                                                    else
                                                        myTable.row(row).select();
                                                });



                                                $(document).on('click', '#dynamic-table .dropdown-toggle', function (e) {
                                                    e.stopImmediatePropagation();
                                                    e.stopPropagation();
                                                    e.preventDefault();
                                                });



                                                //And for the first simple table, which doesn't have TableTools or dataTables
                                                //select/deselect all rows according to table header checkbox
                                                var active_class = 'active';
                                                $('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function () {
                                                    var th_checked = this.checked;//checkbox inside "TH" table header

                                                    $(this).closest('table').find('tbody > tr').each(function () {
                                                        var row = this;
                                                        if (th_checked)
                                                            $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
                                                        else
                                                            $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
                                                    });
                                                });

                                                //select/deselect a row when the checkbox is checked/unchecked
                                                $('#simple-table').on('click', 'td input[type=checkbox]', function () {
                                                    var $row = $(this).closest('tr');
                                                    if ($row.is('.detail-row '))
                                                        return;
                                                    if (this.checked)
                                                        $row.addClass(active_class);
                                                    else
                                                        $row.removeClass(active_class);
                                                });



                                                /********************************/
                                                //add tooltip for small view action buttons in dropdown menu
                                                $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

                                                //tooltip placement on right or left
                                                function tooltip_placement(context, source) {
                                                    var $source = $(source);
                                                    var $parent = $source.closest('table');
                                                    var off1 = $parent.offset();
                                                    var w1 = $parent.width();

                                                    var off2 = $source.offset();
                                                    //var w2 = $source.width();

                                                    if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
                                                        return 'right';
                                                    return 'left';
                                                }

                                            });
                                        </script>
                                        <script>

                                            $('#showdata').on('click', function (e) {
                                                alert("hello");
                                                e.preventDefault();
                                                $(this).closest('tr').next().toggleClass('open');
                                                $(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');
                                            });



                                        </script>

                                        </body>
                                        </html>
