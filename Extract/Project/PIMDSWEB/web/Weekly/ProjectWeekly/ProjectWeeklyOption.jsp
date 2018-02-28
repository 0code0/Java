
<%@page import="java.util.List"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@include  file="../../Partials/Shared/PageTopSection.jsp" %>
<%!
    String Milestoneroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Milestone";
    String Reportingroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Reporting";
    boolean checkFileFlag = true;
    boolean FlagChecklockfile = false;
    boolean FlagProjectWeekly = false;
    String LockData = " ";
    StringBuilder sb = new StringBuilder();
%>
<%    String Lockfileroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Lock";

    File Checklockfile = new File(Lockfileroot + "/Locked_" + request.getParameter("Id") + "_" + request.getParameter("WeekNumber") + "_" + request.getParameter("Year") + ".txt");

    FlagChecklockfile = Checklockfile.exists();
    if (FlagChecklockfile) {

        BufferedReader reader = new BufferedReader(new FileReader(Checklockfile));

        while ((LockData = reader.readLine()) != null) {
            sb.append(LockData);
        }

    }

%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title> Project Weekly Option </title>

        <meta name="description" content="Static &amp; Dynamic Tables" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <jsp:include page="../../Partials/Shared/CSSANDJS.jsp" />
    </head>

    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <div class="navbar-container ace-save-state" id="navbar-container">
                <div class="navbar-header pull-left">
                    <a href="#" class="navbar-brand">
                        <small>
                            <span style="color: yellowgreen;">Project Weekly</span>

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
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
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


                                    </div><!-- /.span -->
                                    <%  File Milestone_file = new File(Milestoneroot + "/Milestone_" + request.getParameter("Id") + "_" + request.getParameter("WeekNumber") + "_" + request.getParameter("Year") + ".txt");
                                        File Reporting_file = new File(Reportingroot + "/Reporting_" + request.getParameter("Id") + "_" + request.getParameter("WeekNumber") + "_" + request.getParameter("Year") + ".txt");

                                        if ((Milestone_file.exists()) && (Reporting_file.exists())) {
                                            checkFileFlag = true;
                                        } else {
                                            checkFileFlag = false;
                                        }


                                    %>
                                    <div id="sidebar" class="sidebar h-sidebar navbar-collapse collapse ace-save-state " style="position: absolute;margin: auto;top: 150px;bottom: 0;left: 415px;right: 1;" >
                                        <script type="text/javascript">
                                            try {
                                                ace.settings.loadState('sidebar');
                                            } catch (e) {
                                            }
                                        </script>
                                        <ul class="nav-list" >
                                            <%                                                
                                                List<BusinessObject.ProjectAllocation> projectAllocations = BusinessLogic.ProjectAllocationBL.GetAllByProjectDetailId(Integer.parseInt(request.getParameter("Id")));

                                                for (BusinessObject.ProjectAllocation projectAllocation : projectAllocations) {

                                                    if ((Integer.parseInt(request.getSession().getAttribute("Id").toString()) == projectAllocation.getUserId())) {
                                                        FlagProjectWeekly = true;
                                                    }

                                                }

                                                if ((request.getSession().getAttribute("Role").toString().equals("admin")) || FlagProjectWeekly) {%>


                                            <li class="hover" >
                                                <a href="#">
                                                    <span class="menu-text green bigger-140"> Create </span>
                                                </a>
                                                <b class="arrow"></b>
                                                <ul class="submenu">
                                                    <li class="active open hover">
                                                        <a href="" onclick="CreateNew(<%= FlagChecklockfile%>, '<%= sb.toString()%>')" >
                                                            <i class="menu-icon fa fa-caret-right"></i>
                                                            Create New

                                                        </a>
                                                    </li>
                                                    <li class="active open hover">
                                                        <a href="Option/Create/SelectYearForClone.jsp?Id=<%= projectName.getId()%>&WeekNumber=<%= request.getParameter("WeekNumber")%>&Year=<%= request.getParameter("Year")%>";
                                                           <i class="menu-icon fa fa-caret-right"></i>
                                                            Clone

                                                        </a>
                                                    </li>
                                                </ul>     


                                            </li>
                                            <li class="hover">
                                                <a href="#">
                                                    <span class="menu-text green bigger-140 "> Create From SDB </span>
                                                </a>
                                                <b class="arrow"></b>
                                                <ul class="submenu">
                                                    <li class="active open hover">
                                                        <a href="Option/CreateFromSDB/ImportDates.jsp" >
                                                            <i class="menu-icon fa fa-caret-right"></i>

                                                            Import Dates

                                                        </a>
                                                    </li>
                                                    <li class="active open hover">
                                                        <a href="Option/CreateFromSDB/ImportsWeek.jsp" >
                                                            <i class="menu-icon fa fa-caret-right"></i>
                                                            Import Weeks

                                                        </a>

                                                    </li>
                                                </ul>     


                                            </li>
                                            <li class="hover">
                                                <a href="Option/Update.jsp?Id=<%= projectName.getId()%>&WeekNumber=<%= request.getParameter("WeekNumber")%>&Year=<%= request.getParameter("Year")%>">
                                                    <span class=" menu-text green bigger-140 "> Update </span>
                                                </a>
                                                <b class="arrow"></b>

                                            </li><%}
                                            %>

                                            <li class="hover">
                                                <a href="#" onclick="CheckFile(<%= checkFileFlag%>)">
                                                    <span class=" menu-text green bigger-140 "> View </span>
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

                            <!-- basic scripts -->

                            <!-- inline scripts related to this page -->
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


                                function CreateNew(Flag, data) {

                                    if (Flag) {
                                        alert(data);

                                    } else {
                                        window.open('/PIMDSWEB/Weekly/ProjectWeekly/Option/Create/CreateNew.jsp?Id=<%= projectName.getId()%>&WeekNumber=<%= request.getParameter("WeekNumber")%>&Year=<%= request.getParameter("Year")%>', 'CreateNew', 'width=1250,height=750');

                                    }

                                }

                                function CheckFile(flag) {

                                    if (flag) {

                                        window.location.href = "/PIMDSWEB/Weekly/ProjectWeekly/Option/View/View.jsp?Id=" +<%= projectName.getId()%> + "&WeekNumber=" + <%=request.getParameter("WeekNumber")%> + "&Year=" +<%= request.getParameter("Year")%>;

                                    } else {


                                    }

                                }

                            </script>

                            </body>
                            </html>
