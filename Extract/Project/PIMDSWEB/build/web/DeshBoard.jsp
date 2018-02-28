
<%@include file="Partials/Shared/PageTopSection.jsp" %>

<%@page import="BusinessObject.User"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>Dashboard - PIMDS Admin</title>

        <meta name="description" content="overview &amp; stats" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <jsp:include page="Partials/Shared/CSSANDJS.jsp" />
    </head>

    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <jsp:include page="Partials/Shared/Header.jsp" />
        </div>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('main-container')
                } catch (e) {
                }
            </script>

            <div id="sidebar" class="sidebar responsive ace-save-state">
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
                                <a href="#" >Home</a>
                            </li>
                            <li class="active">Dashboard</li>
                        </ul><!-- /.breadcrumb -->

                    </div>

                    <div class="page-content">

                        <div class="page-header">
                            <h1>
                                Dashboard
                                <small>
                                    <i class="ace-icon fa fa-angle-double-right"></i>
                                    overview &amp; stats
                                </small>
                            </h1>
                        </div><!-- /.page-header -->

                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <div class="alert alert-block alert-success">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <i class="ace-icon fa fa-times"></i>
                                    </button>

                                    <i class="ace-icon fa fa-check green"></i>

                                    Welcome to
                                    <strong class="green">
                                        PIMDS
                                        <small>(v1.0)</small>
                                    </strong>,
                                    Dashboard.
                                </div>

                                <div class="row">
                                    <div class="space-6"></div>

                                    <div class="col-sm-7 infobox-container">
                                        <div class="infobox infobox-green">
                                            <div class="infobox-icon">
                                                <i class="ace-icon fa fa-thumbs-up"></i>
                                            </div>

                                            <div class="infobox-data">
                                                <span class="infobox-data-number">
                                                    <%                                                    List<BusinessObject.ProjectDetail> completeProject = BusinessLogic.ProjectDetailBL.Complete();
                                                        out.println(completeProject.size());

                                                    %>    

                                                </span>
                                                <div class="infobox-content">Complete Project</div>
                                            </div>

                                            <div class="stat stat-success">8%</div>
                                        </div>

                                        <div class="infobox infobox-blue">
                                            <div class="infobox-icon">
                                                <i class="ace-icon fa fa-fast-forward"></i>
                                            </div>

                                            <div class="infobox-data">
                                                <span class="infobox-data-number">
                                                    <%                                                        List<BusinessObject.ProjectDetail> runningProject = BusinessLogic.ProjectDetailBL.Running();

                                                        out.println(runningProject.size());
                                                    %>


                                                </span>
                                                <div class="infobox-content">Running Project</div>
                                            </div>


                                        </div>

                                        <div class="infobox infobox-pink">
                                            <div class="infobox-icon">
                                                <i class="ace-icon fa fa-line-chart"></i>
                                            </div>

                                            <div class="infobox-data">
                                                <span class="infobox-data-number">
                                                    <%
                                                        List<BusinessObject.ProjectDetail> totalProject = BusinessLogic.ProjectDetailBL.GetAll();
                                                        out.println(totalProject.size());
                                                    %>
                                                </span>
                                                <div class="infobox-content">Total Project</div>
                                            </div>

                                        </div>

                                        <div class="space-6"></div>

                                        <div class="infobox infobox-green infobox-small infobox-dark">
                                            <div class="infobox-progress">
                                                <div class="easy-pie-chart percentage" data-percent="61" data-size="39">
                                                    <span class="percent">61</span>%
                                                </div>
                                            </div>

                                            <div class="infobox-data">
                                                <div class="infobox-content">Task</div>
                                                <div class="infobox-content">Completion</div>
                                            </div>
                                        </div>

                                        <div class="infobox infobox-blue infobox-small infobox-dark">

                                            <div class="infobox-icon">
                                                <i class="ace-icon fa fa-user"></i>
                                            </div>
                                            <div class="infobox-data">
                                                <div class="infobox-content">Users</div>
                                                <div class="infobox-content">
                                                    <%
                                                        List<BusinessObject.User> allUserCount = BusinessLogic.UserBL.GetAll();
                                                        out.println(allUserCount.size());
                                                    %>    

                                                </div>
                                            </div>
                                        </div>

                                        <div class="infobox infobox-grey infobox-small infobox-dark">
                                            <div class="infobox-icon">
                                                <i class="ace-icon fa fa-group"></i>
                                            </div>

                                            <div class="infobox-data">
                                                <div class="infobox-content">Group</div>
                                                <div class="infobox-content">
                                                    <%
                                                        List<BusinessObject.ProjectAllocation> Group = BusinessLogic.ProjectAllocationBL.GetAll();

                                                        out.println(Group.size());

                                                    %>



                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="vspace-12-sm"></div>

                                    <div class="col-sm-5">
                                        <div class="widget-box">
                                            <div class="widget-header widget-header-flat widget-header-small">
                                                <h5 class="widget-title">
                                                    <i class="ace-icon fa fa-signal"></i>
                                                    Traffic Sources
                                                </h5>

                                                <div class="widget-toolbar no-border">
                                                    <div class="inline dropdown-hover">
                                                        <button class="btn btn-minier btn-primary">
                                                            This Week
                                                            <i class="ace-icon fa fa-angle-down icon-on-right bigger-110"></i>
                                                        </button>

                                                        <ul class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret">
                                                            <li class="active">
                                                                <a href="#" class="blue">
                                                                    <i class="ace-icon fa fa-caret-right bigger-110">&nbsp;</i>
                                                                    This Week
                                                                </a>
                                                            </li>

                                                            <li>
                                                                <a href="#">
                                                                    <i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
                                                                    Last Week
                                                                </a>
                                                            </li>

                                                            <li>
                                                                <a href="#">
                                                                    <i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
                                                                    This Month
                                                                </a>
                                                            </li>

                                                            <li>
                                                                <a href="#">
                                                                    <i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
                                                                    Last Month
                                                                </a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="widget-body">
                                                <div class="widget-main">
                                                    <div id="piechart-placeholder"></div>

                                                    <div class="hr hr8 hr-double"></div>

                                                    <div class="clearfix">
                                                        <div class="grid3">
                                                            <span class="grey">
                                                                <i class="ace-icon fa fa-product-hunt fa-3x blue"></i>
                                                                &nbsp; Project
                                                            </span>
                                                            <h4 class="bigger pull-right">50</h4>
                                                        </div>

                                                        <div class="grid3">
                                                            <span class="grey">
                                                                <i class="ace-icon fa fa-thumbs-up fa-2x purple"></i>
                                                                &nbsp; Done
                                                            </span>
                                                            <h4 class="bigger pull-right">40</h4>
                                                        </div>

                                                        <div class="grid3">
                                                            <span class="grey">
                                                                <i class="ace-icon fa fa-stack-overflow fa-2x red"></i>
                                                                &nbsp; Queue
                                                            </span>
                                                            <h4 class="bigger pull-right">10</h4>
                                                        </div>
                                                    </div>
                                                </div><!-- /.widget-main -->
                                            </div><!-- /.widget-body -->
                                        </div><!-- /.widget-box -->
                                    </div><!-- /.col -->
                                </div><!-- /.row -->

                                <div class="hr hr32 hr-dotted"></div>



                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="widget-box transparent" id="recent-box">
                                            <div class="widget-header">
                                                <h4 class="widget-title lighter smaller">
                                                    <i class="ace-icon fa fa-rss orange"></i>RECENT
                                                </h4>

                                                <div class="widget-toolbar no-border">
                                                    <ul class="nav nav-tabs" id="recent-tab">
                                                        <li class="active">
                                                            <a data-toggle="tab" href="#task-tab">Tasks</a>
                                                        </li>

                                                        <li>
                                                            <a data-toggle="tab" href="#member-tab">Members</a>
                                                        </li>

                                                        <li>
                                                            <a data-toggle="tab" href="#comment-tab">Comments</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>

                                            <div class="widget-body">
                                                <div class="widget-main padding-4">
                                                    <div class="tab-content padding-8">
                                                        <div id="task-tab" class="tab-pane active">
                                                            <h4 class="smaller lighter green">
                                                                <i class="ace-icon fa fa-list"></i>
                                                                Latest Task
                                                            </h4>

                                                            <ul id="tasks" class="item-list">
                                                                <li class="item-orange clearfix">
                                                                    <label class="inline">

                                                                        <span class="lbl"> You are add to a Project Name</span>
                                                                    </label>


                                                                </li>

                                                                <li class="item-red clearfix">
                                                                    <label class="inline">

                                                                        <span class="lbl"> User Inserted Doc to Project Name</span>
                                                                    </label>


                                                                </li>

                                                                <li class="item-green clearfix">
                                                                    <label class="inline">

                                                                        <span class="lbl"> You are add to a Project Name</span>
                                                                    </label>
                                                                </li>

                                                                <li class="item-pink clearfix">
                                                                    <label class="inline">

                                                                        <span class="lbl"> User Inserted Doc to Project Name</span>
                                                                    </label>
                                                                </li>
                                                            </ul>
                                                        </div>

                                                        <div id="member-tab" class="tab-pane">



                                                            <%  List<BusinessObject.ProjectDetail> runningProjectsForGroup = BusinessLogic.ProjectDetailBL.Running();

                                                                for (BusinessObject.ProjectDetail runningProjectForGroup : runningProjectsForGroup) {

                                                            %>

                                                            <div class="clearfix" >

                                                                <% List<BusinessObject.ProjectAllocation> runningGroupMembers = BusinessLogic.ProjectAllocationBL.GetAllByProjectDetailId(runningProjectForGroup.getId());
                                                                    
                                                                    boolean flag = false;
                                                                    String GroupName = null;
                                                                    for (BusinessObject.ProjectAllocation runningGroupMember : runningGroupMembers) {

                                                                        List<BusinessObject.User> userGroups = BusinessLogic.UserBL.GetAllByUserId(runningGroupMember.getUserId());

                                                                        for (BusinessObject.User userGroup : userGroups) {
                                                                            
                                                                        flag =true;
                                                                        GroupName = runningGroupMember.getName();
                                                                %>

                                                                    

                                                                <div class="itemdiv memberdiv" style="border-bottom: 0px;">
                                                                    <div class="user">
                                                                        <img alt="no data load" src="<%= userGroup.getUrl()%>" />
                                                                    </div>

                                                                    <div class="body">
                                                                        <div class="name">
                                                                            <a target="_blank" href="<%= request.getContextPath() %>/ProfileById.jsp?Id=<%= userGroup.getId() %>"><%= userGroup.getUserName()%></a>
                                                                        </div>


                                                                    </div>



                                                                </div>


                                                                <%
                                                                    }

                                                                }%>


                                                            </div>


                                                            <%
                                                                if(flag){%>
                                                                     <ul class="breadcrumb">
                                                                        <li>

                                                                            <%= runningProjectForGroup.getName() %>
                                                                        </li>
                                                                        <li class="active"><%= GroupName %></li>
                                                                    </ul><!-- /.breadcrumb -->
    
                                                              <%
                                                                }
                                                                }
                                                            %>
                                                            <div class="hr hr-24 hr-dotted"></div>
                                                            <div class="space-4"></div>

                                                            <div class="center">
                                                                <i class="ace-icon fa fa-users fa-2x green middle"></i>

                                                                &nbsp;
                                                                <a href="GroupMember.jsp" class="btn btn-sm btn-white btn-info">
                                                                    See all members &nbsp;
                                                                    <i class="ace-icon fa fa-arrow-right"></i>
                                                                </a>
                                                            </div>

                                                            <div class="hr hr-double hr8"></div>
                                                        </div><!-- /.#member-tab -->

                                                        <div id="comment-tab" class="tab-pane">

                                                            <%  List<BusinessObject.Comment> comments = BusinessLogic.CommentBL.GetAllTop3();

                                                                for (BusinessObject.Comment comment : comments) {

                                                                    List<BusinessObject.ProjectDocument> projectDocuments = BusinessLogic.ProjectDocumentBL.GetAllByProjectDocumentId(comment.getProjectDocumentId());

                                                                    for (BusinessObject.ProjectDocument projectDocument : projectDocuments) {

                                                                        List<BusinessObject.ProjectDetail> projectDetails = BusinessLogic.ProjectDetailBL.GetAllByProjectDetailId(projectDocument.getProjectId());

                                                                        for (BusinessObject.ProjectDetail projectDetail : projectDetails) {
                                                            %>

                                                            <div class="comments">
                                                                <div style="margin-left: 20%;">
                                                                    <ul class="breadcrumb">
                                                                        <li>

                                                                            <%= projectDetail.getName()%>
                                                                        </li>
                                                                        <li class="active"><a href="<%= projectDocument.getURL()%>" target="_blank"><%= projectDocument.getName()%></a></li>
                                                                    </ul><!-- /.breadcrumb -->

                                                                </div>

                                                                <div class="itemdiv commentdiv">
                                                                    <div class="user">

                                                                        <% BusinessObject.User user = BusinessLogic.UserBL.GetSingle(comment.getUserId());%>
                                                                        <img alt="no data load" src="<%= user.getUrl()%>" />
                                                                    </div>

                                                                    <div class="body">
                                                                        <div class="name">
                                                                            <a target="_blank" href="<%= request.getContextPath() %>/ProfileById.jsp?Id=<%= user.getId() %>"><%= user.getUserName()%></a>
                                                                        </div>

                                                                        <div class="time">
                                                                            <i class="ace-icon fa fa-clock-o"></i>
                                                                            <span class="green">
                                                                                <%= comment.getBase().getCreatedOn()%>    

                                                                            </span>
                                                                        </div>

                                                                        <div class="text">
                                                                            <i class="ace-icon fa fa-quote-left"></i>
                                                                            <%= comment.getComment()%> &hellip;
                                                                        </div>
                                                                    </div>


                                                                </div>

                                                            </div>  

                                                            <%
                                                                        }
                                                                    }

                                                                }

                                                            %>


                                                            <div class="hr hr8"></div>

                                                            <div class="center">
                                                                <i class="ace-icon fa fa-comments-o fa-2x green middle"></i>

                                                                &nbsp;
                                                                <a href="Comment.jsp" class="btn btn-sm btn-white btn-info">
                                                                    See all comments &nbsp;
                                                                    <i class="ace-icon fa fa-arrow-right"></i>
                                                                </a>
                                                            </div>

                                                            <div class="hr hr-double hr8"></div>
                                                        </div>
                                                    </div>
                                                </div><!-- /.widget-main -->
                                            </div><!-- /.widget-body -->
                                        </div><!-- /.widget-box -->
                                    </div><!-- /.col -->

                                    <div class="col-sm-5">
                                        <div class="widget-box transparent">
                                            <div class="widget-header widget-header-flat">
                                                <h4 class="widget-title lighter">
                                                    <i class="ace-icon fa fa-user-plus orange"></i>
                                                    User Request
                                                </h4>

                                                <div class="widget-toolbar">
                                                    <a href="#" data-action="collapse">
                                                        <i class="ace-icon fa fa-chevron-up"></i>
                                                    </a>
                                                </div>
                                            </div>

                                            <div class="widget-body">
                                                <div class="widget-main no-padding">
                                                    <table class="table table-bordered table-striped">
                                                        <thead class="thin-border-bottom">
                                                            <tr>
                                                                <th>
                                                                    <i class="ace-icon fa fa-caret-right blue"></i>Email
                                                                </th>

                                                                <th>
                                                                    <i class="ace-icon fa fa-caret-right blue"></i>Name
                                                                </th>

                                                                <th class="hidden-480">
                                                                    <i class="ace-icon fa fa-caret-right blue"></i>Request
                                                                </th>
                                                            </tr>
                                                        </thead>

                                                        <tbody>
                                                            <tr>
                                                                <td>internet.com</td>

                                                                <td>

                                                                    <b class="blue">UserName</b>
                                                                </td>

                                                                <td class="hidden-480">
                                                                    <span class="label label-info arrowed-right arrowed-in">on sale</span>
                                                                </td>
                                                            </tr>

                                                            <tr>
                                                                <td>online.com</td>

                                                                <td>
                                                                    <b class="blue">UserName</b>
                                                                </td>

                                                                <td class="hidden-480">
                                                                    <span class="label label-success arrowed-in arrowed-in-right">approved</span>
                                                                </td>
                                                            </tr>

                                                            <tr>
                                                                <td>newnet.com</td>

                                                                <td>
                                                                    <b class="blue">UserName</b>
                                                                </td>

                                                                <td class="hidden-480">
                                                                    <span class="label label-danger arrowed">pending</span>
                                                                </td>
                                                            </tr>

                                                            <tr>
                                                                <td>web.com</td>

                                                                <td>

                                                                    <b class="blue">UserName</b>
                                                                </td>

                                                                <td class="hidden-480">
                                                                    <span class="label arrowed">
                                                                        <s>out of stock</s>
                                                                    </span>
                                                                </td>
                                                            </tr>

                                                            <tr>
                                                                <td>domain.com</td>

                                                                <td>
                                                                    <b class="blue">UserName</b>
                                                                </td>

                                                                <td class="hidden-480">
                                                                    <span class="label label-warning arrowed arrowed-right">SOLD</span>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div><!-- /.widget-main -->
                                            </div><!-- /.widget-body -->
                                        </div><!-- /.widget-box -->
                                    </div><!-- /.col -->
                                </div><!-- /.row -->

                                <div class="hr hr32 hr-dotted"></div>

                                <!-- PAGE CONTENT ENDS -->
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.main-content -->

            <div class="footer">
                <div class="footer-inner">
                    <div class="footer-content">
                        <span class="bigger-120">
                            <span class="blue bolder">PIMDS</span>
                            Application &copy; 2013-2016
                        </span>

                        &nbsp; &nbsp;
                        <span class="action-buttons">
                            <a href="#">
                                <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                            </a>

                            <a href="#">
                                <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                            </a>

                            <a href="#">
                                <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                            </a>
                        </span>
                    </div>
                </div>
            </div>

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div><!-- /.main-container -->


        <!-- inline scripts related to this page -->
        <script type="text/javascript">
            jQuery(function ($) {
                $('.easy-pie-chart.percentage').each(function () {
                    var $box = $(this).closest('.infobox');
                    var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
                    var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
                    var size = parseInt($(this).data('size')) || 50;
                    $(this).easyPieChart({
                        barColor: barColor,
                        trackColor: trackColor,
                        scaleColor: false,
                        lineCap: 'butt',
                        lineWidth: parseInt(size / 10),
                        animate: ace.vars['old_ie'] ? false : 1000,
                        size: size
                    });
                })

                $('.sparkline').each(function () {
                    var $box = $(this).closest('.infobox');
                    var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
                    $(this).sparkline('html',
                            {
                                tagValuesAttribute: 'data-values',
                                type: 'bar',
                                barColor: barColor,
                                chartRangeMin: $(this).data('min') || 0
                            });
                });


                //flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
                //but sometimes it brings up errors with normal resize event handlers
                $.resize.throttleWindow = false;

                var placeholder = $('#piechart-placeholder').css({'width': '90%', 'min-height': '150px'});
                var data = [
                    {label: "social networks", data: 38.7, color: "#68BC31"},
                    {label: "search engines", data: 24.5, color: "#2091CF"},
                    {label: "ad campaigns", data: 8.2, color: "#AF4E96"},
                    {label: "direct traffic", data: 18.6, color: "#DA5430"},
                    {label: "other", data: 10, color: "#FEE074"}
                ]
                function drawPieChart(placeholder, data, position) {
                    $.plot(placeholder, data, {
                        series: {
                            pie: {
                                show: true,
                                tilt: 0.8,
                                highlight: {
                                    opacity: 0.25
                                },
                                stroke: {
                                    color: '#fff',
                                    width: 2
                                },
                                startAngle: 2
                            }
                        },
                        legend: {
                            show: true,
                            position: position || "ne",
                            labelBoxBorderColor: null,
                            margin: [-30, 15]
                        }
                        ,
                        grid: {
                            hoverable: true,
                            clickable: true
                        }
                    })
                }
                drawPieChart(placeholder, data);

                /**
                 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
                 so that's not needed actually.
                 */
                placeholder.data('chart', data);
                placeholder.data('draw', drawPieChart);


                //pie chart tooltip example
                var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
                var previousPoint = null;

                placeholder.on('plothover', function (event, pos, item) {
                    if (item) {
                        if (previousPoint != item.seriesIndex) {
                            previousPoint = item.seriesIndex;
                            var tip = item.series['label'] + " : " + item.series['percent'] + '%';
                            $tooltip.show().children(0).text(tip);
                        }
                        $tooltip.css({top: pos.pageY + 10, left: pos.pageX + 10});
                    } else {
                        $tooltip.hide();
                        previousPoint = null;
                    }

                });

                /////////////////////////////////////
                $(document).one('ajaxloadstart.page', function (e) {
                    $tooltip.remove();
                });




                var d1 = [];
                for (var i = 0; i < Math.PI * 2; i += 0.5) {
                    d1.push([i, Math.sin(i)]);
                }

                var d2 = [];
                for (var i = 0; i < Math.PI * 2; i += 0.5) {
                    d2.push([i, Math.cos(i)]);
                }

                var d3 = [];
                for (var i = 0; i < Math.PI * 2; i += 0.2) {
                    d3.push([i, Math.tan(i)]);
                }


                var sales_charts = $('#sales-charts').css({'width': '100%', 'height': '220px'});
                $.plot("#sales-charts", [
                    {label: "Domains", data: d1},
                    {label: "Hosting", data: d2},
                    {label: "Services", data: d3}
                ], {
                    hoverable: true,
                    shadowSize: 0,
                    series: {
                        lines: {show: true},
                        points: {show: true}
                    },
                    xaxis: {
                        tickLength: 0
                    },
                    yaxis: {
                        ticks: 10,
                        min: -2,
                        max: 2,
                        tickDecimals: 3
                    },
                    grid: {
                        backgroundColor: {colors: ["#fff", "#fff"]},
                        borderWidth: 1,
                        borderColor: '#555'
                    }
                });


                $('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
                function tooltip_placement(context, source) {
                    var $source = $(source);
                    var $parent = $source.closest('.tab-content')
                    var off1 = $parent.offset();
                    var w1 = $parent.width();

                    var off2 = $source.offset();
                    //var w2 = $source.width();

                    if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
                        return 'right';
                    return 'left';
                }


                $('.dialogs,.comments').ace_scroll({
                    size: 300
                });


                //Android's default browser somehow is confused when tapping on label which will lead to dragging the task
                //so disable dragging when clicking on label
                var agent = navigator.userAgent.toLowerCase();
                if (ace.vars['touch'] && ace.vars['android']) {
                    $('#tasks').on('touchstart', function (e) {
                        var li = $(e.target).closest('#tasks li');
                        if (li.length == 0)
                            return;
                        var label = li.find('label.inline').get(0);
                        if (label == e.target || $.contains(label, e.target))
                            e.stopImmediatePropagation();
                    });
                }

                $('#tasks').sortable({
                    opacity: 0.8,
                    revert: true,
                    forceHelperSize: true,
                    placeholder: 'draggable-placeholder',
                    forcePlaceholderSize: true,
                    tolerance: 'pointer',
                    stop: function (event, ui) {
                        //just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
                        $(ui.item).css('z-index', 'auto');
                    }
                }
                );
                $('#tasks').disableSelection();
                $('#tasks input:checkbox').removeAttr('checked').on('click', function () {
                    if (this.checked)
                        $(this).closest('li').addClass('selected');
                    else
                        $(this).closest('li').removeClass('selected');
                });


                //show the dropdowns on top or bottom depending on window height and menu position
                $('#task-tab .dropdown-hover').on('mouseenter', function (e) {
                    var offset = $(this).offset();

                    var $w = $(window)
                    if (offset.top > $w.scrollTop() + $w.innerHeight() - 100)
                        $(this).addClass('dropup');
                    else
                        $(this).removeClass('dropup');
                });

            })
        </script>
    </body>
</html>
