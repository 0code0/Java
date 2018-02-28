
<%@page import="java.util.Arrays"%>
<%@page import="DataAccess.FileDA"%>
<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.File"%>
<%@include  file="../../../../Partials/Shared/PageTopSection.jsp" %>
<%! String Milestoneroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Milestone";
    String Reportingroot = "C:\\Users\\singhj1\\Downloads\\NetBeansProjects\\PIMDSWEB\\web\\Weekly\\ProjectWeekly\\Option\\Create\\Data\\Reporting";


%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title> Project Weekly Create New </title>

        <meta name="description" content="Static &amp; Dynamic Tables" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <jsp:include page="../../../../Partials/Shared/CSSANDJS.jsp" />
    </head>

    <body class="no-skin" >
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
                    <a href="" class="navbar-brand">
                        <small>
                            <span style="color: red;"> Clone </span>

                        </small>
                    </a>
                    <a href="" class="navbar-brand">
                        <small>
                            <span style="color: red;"> Year: </span>
                            <%= request.getParameter("Year")%>
                        </small>
                    </a>


                </div>

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

                                    <table id="simple-table" class="table  table-bordered table-hover" style="width: 300px;" >
                                        <thead>
                                            <tr>
                                                <th> Select </th>
                                                <th> Week </th>
                                            </tr>
                                        </thead>
                                        <tbody id="ShowProjectDetail" >
                                            <%

                                                File[] Reportingfiles = new File(Reportingroot).listFiles(new DataAccess.FileDA(request.getParameter("Year") + ".txt"));
                                               // File[] Milestonefiles = new File(Milestoneroot).listFiles(new DataAccess.FileDA(request.getParameter("Year") + ".txt"));

                                                for (File file : Reportingfiles) {%>

                                            <tr>
                                                <td>
                                                    <div class='col-xs-12 col-sm-6'>
                                                        <div class='control-group'>
                                                            <div class='radio'><label>
                                                                    <input  type='radio' onclick="ViewFile('<%= file.getName().split("_")[1] %>','<%= file.getName().split("_")[2] %>')" class='ace' name='Select' /><span class='lbl'> </span>
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <%= file.getName().split("_")[2]%>
                                                </td>
                                            </tr>

                                            <%}%>
                                            <tr id="GenerateClone" ><td colspan="2" ><button class="btn btn-danger btn-block" onclick="GenerateClone()">Generate Clone</button></td></tr>
                                        </tbody>


                                    </table>
                                           
                                </div>
                                
                                <iframe id="iFrame1" style="margin-top:-230px;margin-left: 350px;background:#EAEBED;" name="iFrame1" frameborder=1 scrolling="yes" align="top" width='70%' height='450px' marginwidth=0 marginheight=0  class = "iFrame1">
                                    [Your browser does not support frames.]
                                </iframe>
                                            
                            </div>
                                            
                        </div>

                    </div>
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



                    function ShowProjectDetail(str) {
                        var xhttp;
                        var loading = document.getElementById("loading");
                        loading.style.display = "block";
                        if (str == "null") {
                            return;
                        }
                        xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function () {
                            if (this.readyState == 4 && this.status == 200) {
                                loading.style.display = "none";

                                document.getElementById("ShowProjectDetail").innerHTML = this.responseText;
                            }
                        };

                        xhttp.open("GET", "/PIMDSWEB/GetAllProjectByCategory?Id=" + str, true);
                        xhttp.send();
                    }
                    
                </script>

                <script>
                    document.getElementById("iFrame1").style.visibility = "hidden";
                    document.getElementById("GenerateClone").style.visibility = "hidden";
                    var IdforClone;
                    var WeekforClone;
    
                    function ViewFile(Id,Week) {
                    document.getElementById("iFrame1").style.visibility = "visible";
                    document.getElementById("GenerateClone").style.visibility = "visible";
                    document.getElementById("iFrame1").src = "CloneView.jsp?Id="+Id+"&WeekNumber="+Week+"&Year="+<%= request.getParameter("Year") %>;
                    IdforClone = Id;
                    WeekforClone = Week;
                }
                    function GenerateClone(){
                        
                        location.href = "/PIMDSWEB/Weekly/ProjectWeekly/Option/Create/Clone.jsp?Id="+IdforClone+"&WeekNumber="+WeekforClone+"&Year=<%= request.getParameter("Year") %>&NewWeekNumber=<%= request.getParameter("WeekNumber") %>";
                        
                    }
                </script>
                </body>
                </html>
