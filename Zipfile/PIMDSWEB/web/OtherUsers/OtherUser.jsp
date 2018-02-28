<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title> Other User </title>

        <meta name="description" content="top menu &amp; navigation" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />


        <jsp:include page="../Partials/Shared/CSSANDJS.jsp" />

    </head>

    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default    navbar-collapse       h-navbar ace-save-state">




            <div class="navbar-container ace-save-state" id="navbar-container">
                <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                    <span class="sr-only">Toggle sidebar</span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>
                </button>

                <div class="navbar-header pull-left">
                    <a href="#" class="navbar-brand">
                        <small>

                            PIMDS 
                        </small>
                    </a>
                </div>



                <div class="navbar-buttons navbar-header pull-right" role="navigation">
                    <ul class="nav ace-nav">


                        <li class="light-blue dropdown-modal">
                            <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                                
                                <span class="user-info">
                                    <small>Welcome,</small>
                                    ${UserName}

                                </span>

                                <i class="ace-icon fa fa-caret-down"></i>
                            </a>

                            <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

                                <li>
                                    <a href="/PIMDSWEB/Logout">
                                        <i class="ace-icon fa fa-power-off"></i>
                                        Logout
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>

                <div class="navbar-brand pull-right">
                    <small style="color: #ffe7b4">
                        ${Email}
                    </small>
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

            <div id="sidebar" class="sidebar      h-sidebar                navbar-collapse collapse          ace-save-state">
                <script type="text/javascript">
                    try {
                        ace.settings.loadState('sidebar');
                    } catch (e) {
                    }
                </script>

                <ul class="nav nav-list" style="margin-left: 300px;">

                    <li class="hover">
                        <a href="#">
                            <span class="menu-text"> Mission </span>
                        </a>

                        <ul class="submenu">

                            <li class="active open hover">
                                <a href="../Uploads/HSLink_Mission.ppt" >
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    PIMDS
                                </a>

                            </li>
                        </ul>
                    </li>
                    <li class="hover">
                        <a href="#">
                            <span class="menu-text"> Organization </span>
                        </a>

                        <ul class="submenu">

                            <li class="active open hover">
                                <a href="#" class="dropdown-toggle">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    PIMDS
                                    <b class='arrow fa fa-angle-right'></b>
                                </a>
                                <ul class="submenu">

                                    <li class="active open hover">
                                        <a href="../Uploads/OrganizationChart_Dconv_Nov2015.pptx">
                                            <i class="menu-icon fa fa-caret-right"></i>
                                            Date Convertor
                                        </a>

                                    </li>
                                    <li class="active open hover">
                                        <a href="../Uploads/HSLINK_Organization_intl_2014.ppt" >
                                            <i class="menu-icon fa fa-caret-right"></i>
                                            HSL
                                        </a>

                                    </li>
                                    <li class="active open hover">
                                        <a href="../Uploads/OrganizationChart_LAB_Jan2014.ppt">
                                            <i class="menu-icon fa fa-caret-right"></i>
                                            LAB
                                        </a>

                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
                <div class="center">
                    <h1 style="color: red;">
                        You have not the permission to access the web site. Please connect Mr vigyan jain TR&D Department 
                    </h1>
                </div>
            </div>


            <div class="footer">

                <jsp:include page="../Partials/Shared/Footer.jsp" />
            </div>

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div><!-- /.main-container -->

        <!-- basic scripts -->

        <script type="text/javascript">
            if ('ontouchstart' in document.documentElement)
                document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
        </script>

        <!-- inline scripts related to this page -->
        <script type="text/javascript">
            jQuery(function ($) {
                var $sidebar = $('.sidebar').eq(0);
                if (!$sidebar.hasClass('h-sidebar'))
                    return;

                $(document).on('settings.ace.top_menu', function (ev, event_name, fixed) {
                    if (event_name !== 'sidebar_fixed')
                        return;

                    var sidebar = $sidebar.get(0);
                    var $window = $(window);

                    //return if sidebar is not fixed or in mobile view mode
                    var sidebar_vars = $sidebar.ace_sidebar('vars');
                    if (!fixed || (sidebar_vars['mobile_view'] || sidebar_vars['collapsible'])) {
                        $sidebar.removeClass('lower-highlight');
                        //restore original, default marginTop
                        sidebar.style.marginTop = '';

                        $window.off('scroll.ace.top_menu')
                        return;
                    }


                    var done = false;
                    $window.on('scroll.ace.top_menu', function (e) {

                        var scroll = $window.scrollTop();
                        scroll = parseInt(scroll / 4);//move the menu up 1px for every 4px of document scrolling
                        if (scroll > 17)
                            scroll = 17;


                        if (scroll > 16) {
                            if (!done) {
                                $sidebar.addClass('lower-highlight');
                                done = true;
                            }
                        } else {
                            if (done) {
                                $sidebar.removeClass('lower-highlight');
                                done = false;
                            }
                        }

                        sidebar.style['marginTop'] = (17 - scroll) + 'px';
                    }).triggerHandler('scroll.ace.top_menu');

                }).triggerHandler('settings.ace.top_menu', ['sidebar_fixed', $sidebar.hasClass('sidebar-fixed')]);

                $(window).on('resize.ace.top_menu', function () {
                    $(document).triggerHandler('settings.ace.top_menu', ['sidebar_fixed', $sidebar.hasClass('sidebar-fixed')]);
                });


            });
        </script>
    </body>
</html>
