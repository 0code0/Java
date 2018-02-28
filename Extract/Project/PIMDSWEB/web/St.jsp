<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title> Lab - Pimds Admin </title>

        <meta name="description" content="top menu &amp; navigation" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        
        <jsp:include page="Partials/Shared/CSSANDJS.jsp" />

    </head>

    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default    navbar-collapse       h-navbar ace-save-state">
            <jsp:include page="Partials/Shared/Header.jsp" />
        </div>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('main-container')
                } catch (e) {
                }
            </script>

            <div id="sidebar" class="sidebar      h-sidebar                navbar-collapse collapse          ace-save-state">
                <script type="text/javascript">
                    try {
                        ace.settings.loadState('sidebar')} catch (e) {
                    }
                </script>

                <jsp:include page="Partials/StMenu/menu.jsp" /> 
                
            </div>

           
            <div class="footer">

                <jsp:include page="Partials/Shared/Footer.jsp" />
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
