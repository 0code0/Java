package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class St_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <title> Lab - Pimds Admin </title>\n");
      out.write("\n");
      out.write("        <meta name=\"description\" content=\"top menu &amp; navigation\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\n");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Partials/Shared/CSSANDJS.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"no-skin\">\n");
      out.write("        <div id=\"navbar\" class=\"navbar navbar-default    navbar-collapse       h-navbar ace-save-state\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Partials/Shared/Header.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"main-container ace-save-state\" id=\"main-container\">\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                try {\n");
      out.write("                    ace.settings.loadState('main-container')\n");
      out.write("                } catch (e) {\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("            <div id=\"sidebar\" class=\"sidebar      h-sidebar                navbar-collapse collapse          ace-save-state\">\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    try {\n");
      out.write("                        ace.settings.loadState('sidebar')} catch (e) {\n");
      out.write("                    }\n");
      out.write("                </script>\n");
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Partials/StMenu/menu.jsp", out, false);
      out.write(" \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("           \n");
      out.write("            <div class=\"footer\">\n");
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Partials/Shared/Footer.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <a href=\"#\" id=\"btn-scroll-up\" class=\"btn-scroll-up btn btn-sm btn-inverse\">\n");
      out.write("                <i class=\"ace-icon fa fa-angle-double-up icon-only bigger-110\"></i>\n");
      out.write("            </a>\n");
      out.write("        </div><!-- /.main-container -->\n");
      out.write("\n");
      out.write("        <!-- basic scripts -->\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                            if ('ontouchstart' in document.documentElement)\n");
      out.write("                                document.write(\"<script src='assets/js/jquery.mobile.custom.min.js'>\" + \"<\" + \"/script>\");\n");
      out.write("        </script>\n");
      out.write("    \n");
      out.write("        <!-- inline scripts related to this page -->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                            jQuery(function ($) {\n");
      out.write("                                var $sidebar = $('.sidebar').eq(0);\n");
      out.write("                                if (!$sidebar.hasClass('h-sidebar'))\n");
      out.write("                                    return;\n");
      out.write("\n");
      out.write("                                $(document).on('settings.ace.top_menu', function (ev, event_name, fixed) {\n");
      out.write("                                    if (event_name !== 'sidebar_fixed')\n");
      out.write("                                        return;\n");
      out.write("\n");
      out.write("                                    var sidebar = $sidebar.get(0);\n");
      out.write("                                    var $window = $(window);\n");
      out.write("\n");
      out.write("                                    //return if sidebar is not fixed or in mobile view mode\n");
      out.write("                                    var sidebar_vars = $sidebar.ace_sidebar('vars');\n");
      out.write("                                    if (!fixed || (sidebar_vars['mobile_view'] || sidebar_vars['collapsible'])) {\n");
      out.write("                                        $sidebar.removeClass('lower-highlight');\n");
      out.write("                                        //restore original, default marginTop\n");
      out.write("                                        sidebar.style.marginTop = '';\n");
      out.write("\n");
      out.write("                                        $window.off('scroll.ace.top_menu')\n");
      out.write("                                        return;\n");
      out.write("                                    }\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    var done = false;\n");
      out.write("                                    $window.on('scroll.ace.top_menu', function (e) {\n");
      out.write("\n");
      out.write("                                        var scroll = $window.scrollTop();\n");
      out.write("                                        scroll = parseInt(scroll / 4);//move the menu up 1px for every 4px of document scrolling\n");
      out.write("                                        if (scroll > 17)\n");
      out.write("                                            scroll = 17;\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        if (scroll > 16) {\n");
      out.write("                                            if (!done) {\n");
      out.write("                                                $sidebar.addClass('lower-highlight');\n");
      out.write("                                                done = true;\n");
      out.write("                                            }\n");
      out.write("                                        } else {\n");
      out.write("                                            if (done) {\n");
      out.write("                                                $sidebar.removeClass('lower-highlight');\n");
      out.write("                                                done = false;\n");
      out.write("                                            }\n");
      out.write("                                        }\n");
      out.write("\n");
      out.write("                                        sidebar.style['marginTop'] = (17 - scroll) + 'px';\n");
      out.write("                                    }).triggerHandler('scroll.ace.top_menu');\n");
      out.write("\n");
      out.write("                                }).triggerHandler('settings.ace.top_menu', ['sidebar_fixed', $sidebar.hasClass('sidebar-fixed')]);\n");
      out.write("\n");
      out.write("                                $(window).on('resize.ace.top_menu', function () {\n");
      out.write("                                    $(document).triggerHandler('settings.ace.top_menu', ['sidebar_fixed', $sidebar.hasClass('sidebar-fixed')]);\n");
      out.write("                                });\n");
      out.write("\n");
      out.write("\n");
      out.write("                            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
