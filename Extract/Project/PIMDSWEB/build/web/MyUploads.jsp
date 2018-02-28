

<%@page import="BusinessObject.ProjectDocument"%>
<%@page import="java.util.List"%>
<%@include  file="Partials/Shared/PageTopSection.jsp" %>
<%
    String Delete = null;
    Delete = request.getParameter("delete_yes");

    if (Delete != null) {

        BusinessObject.ProjectDocument DeleteProjectDocument = new ProjectDocument();
        
        
        DeleteProjectDocument.setId(Integer.parseInt(request.getParameter("Id").trim()));
        
        BusinessLogic.ProjectDocumentBL.Delete(DeleteProjectDocument);

    }


%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>Show ${UserName} Uploads</title>

        <meta name="description" content="Static &amp; Dynamic Tables" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <jsp:include page="Partials/Shared/CSSANDJS.jsp" />
    </head>

    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <div class="navbar-container ace-save-state" id="navbar-container">
                <jsp:include page="Partials/Shared/Header.jsp" />       
            </div><!-- /.navbar-container -->
        </div>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('main-container');
                } catch (e) {
                }
            </script>

            <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
                <script type="text/javascript">
                    try {
                        ace.settings.loadState('sidebar');
                    } catch (e) {
                    }
                </script>


                <jsp:include page="Partials/Shared/SideMenu.jsp" />
                <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                    <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
                </div>
            </div>

            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Home</a>
                            </li>

                            <li class="active">
                                <a href="#">Show  ${UserName} Uploads</a>
                            </li>

                        </ul><!-- /.breadcrumb -->

                        <div class="nav-search" id="nav-search">
                            <form class="form-search">
                                <span class="input-icon">
                                    <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </form>
                        </div><!-- /.nav-search -->
                    </div>

                    <div class="page-content">


                        <div class="page-header">
                            <h1>
                                Show <span style=" color: black ">${UserName}</span> Uploads
                                <small>
                                    <i class="ace-icon fa fa-angle-double-right"></i>

                                </small>
                            </h1>
                        </div><!-- /.page-header -->
                        <div class="form-group">


                            <div class="col-sm-9">

                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <div class="row">
                                    <div class="col-xs-12">
                                        <table id="simple-table" class="table  table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th class="hidden-480">Action</th>
                                                    <th>Document Name</th>
                                                    <th>Title</th>
                                                    <th>Source</th>
                                                    <th>Version</th>
                                                    <th>Author</th>
                                                    <th>Project Name</th>
                                                    <th>Document Category</th>



                                                </tr>
                                            </thead>


                                            <tbody >
                                                <% List<BusinessObject.ProjectDocument> UserProjectDocuments = BusinessLogic.ProjectDocumentBL.GetAllProjectDocumentByUser(request.getSession().getAttribute("UserName").toString());

                                                    for (BusinessObject.ProjectDocument UserProjectDocument : UserProjectDocuments) {

                                                        BusinessObject.ProjectDetail uproject = BusinessLogic.ProjectDetailBL.GetSingle(UserProjectDocument.getProjectId());
                                                        BusinessObject.DocumentCategory uDocCategory = BusinessLogic.DocumentCategoryBL.GetSingle(UserProjectDocument.getDocumentCategoryId());
                                                %>

                                                <tr>
                                                    <td style="width: 110px;">
                                                        <a href="<%= request.getContextPath() %>/UserDocumentManage.jsp?Id=<%= UserProjectDocument.getId() %>" >
                                                            <button class="btn btn-xs btn-info">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                        
                                                        </a>
                                                        <a href="#" onclick="showDeleteBox('<%= UserProjectDocument.getId() %>', '<%= UserProjectDocument.getName()%>')">
                                                            
                                                        <button class=" btn btn-danger btn-round btn-sm ">
                                                            <i class=" ace-icon fa fa-trash-o bigger-110 "></i>
                                                        </button>
                                                        </a>


                                                    </td>
                                                    <td> <a href="<%= UserProjectDocument.getURL()%>" target="_blank" > <%= UserProjectDocument.getName()%> </a> </td>
                                                    <td> <%= UserProjectDocument.getTitle()%> </td>
                                                    <td> <%= UserProjectDocument.getSource()%> </td>
                                                    <td> <%= UserProjectDocument.getVersion()%> </td>
                                                    <td> <%= UserProjectDocument.getAuthor()%> </td>
                                                    <td> <%= uproject.getName()%> </td>
                                                    <td> <%= uDocCategory.getName()%> </td>



                                                </tr>
                                                <tr >
                                                    <td colspan="10" id="<%= UserProjectDocument.getId() %>" style="display: none;" >

                                                    </td>    
                                                </tr>
                                                <%}%>




                                            </tbody>


                                        </table>
                                        <img src="<%=request.getContextPath()%>/Admin/Themes/ajax-loader.gif" id="loading" style="display: none;" />
                                    </div><!-- /.span -->
                                </div><!-- /.row -->

                                <div class="row" style="display: none;">
                                    <div class="col-xs-12">

                                        <div>
                                            <table id="dynamic-table" class="table table-striped table-bordered table-hover">



                                            </table>
                                        </div>
                                    </div>
                                </div>



                                <!-- PAGE CONTENT ENDS -->
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.main-content -->

            <div class="footer">

                <jsp:include page="Partials/Shared/Footer.jsp" />
            </div>

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



        </script>

        <script>

            function showDeleteBox(Id, Name) {
               
                document.getElementById(Id).style.display = "";
                document.getElementById(Id).innerHTML = "<form action=''><input type='hidden' name='Id' value=" + Id + " /><pre><b>Are you sure you want to delete </b><span style='color:red; font-size: 20px;' >" + Name + "</span> <b>All data will be lost and cannot be recovered.</b></pre><input type = 'submit' name='delete_yes' value='Delete' class='btn btn-white btn-warning btn-bold' /><input type='submit' value='Cancel' class='btn btn-white btn-default btn-round'/></form>";
            }

            function refreshPage() {
                window.location.reload();
            }
        </script>

    </body>
</html>
