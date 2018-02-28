package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"Css/Neural.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"JS/NeuralNet.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"Container\">\n");
      out.write("\n");
      out.write("            <div style=\"height: 100px;\"></div>\n");
      out.write("            <div id=\"arrowOne\">\n");
      out.write("                <img src=\"arrow.png\" />\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"FirstNeuronOutput\" id=\"FirstNeuronOutputArrowOne\">\n");
      out.write("                <span class=\"Weight\" id=\"FirstNeuronWeightOne\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\"  width=\"130\"  />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"FirstNeuronOutput\" id=\"FirstNeuronOutputArrowTwo\">\n");
      out.write("                <span class=\"Weight\" id=\"FirstNeuronWeightTwo\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\" width=\"230\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"FirstNeuronOutput\" id=\"FirstNeuronOutputArrowThree\">\n");
      out.write("                <span class=\"Weight\" id=\"FirstNeuronWeightThree\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\" width=\"130\" />\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"InputOne\">\n");
      out.write("                <select onchange=\"InputValueOne(this.value)\">\n");
      out.write("                    <option value=\"\"> Sel </option>\n");
      out.write("                    <option value=\"0.0\"> 0 </option>\n");
      out.write("                    <option value=\"1.0\"> 1 </option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"circle\">\n");
      out.write("                <span id=\"InputOnePushValue\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div style=\"height: 100px;\"></div>\n");
      out.write("\n");
      out.write("            <div class=\"circle\">\n");
      out.write("                <span id=\"InputTwoPushValue\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"InputTwo\">\n");
      out.write("                <select onchange=\"InputValueTwo(this.value)\">\n");
      out.write("                    <option value=\"\"> Sel </option>\n");
      out.write("                    <option value=\"0.0\"> 0 </option>\n");
      out.write("                    <option value=\"1.0\"> 1 </option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div Id=\"arrowTwo\">\n");
      out.write("                <img src=\"arrow.png\" />\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"SecondNeuronOutput\" id=\"SecondNeuronOutputArrowOne\">\n");
      out.write("                <span class=\"Weight\" id=\"SecondNeuronWeightOne\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\"  width=\"150\"  />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"SecondNeuronOutput\" id=\"SecondNeuronOutputArrowTwo\">\n");
      out.write("                <span class=\"Weight\" id=\"SecondNeuronWeightTwo\"> \n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\" width=\"230\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"SecondNeuronOutput\" id=\"SecondNeuronOutputArrowThree\">\n");
      out.write("                <span class=\"Weight\" id=\"SecondNeuronWeightThree\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\" width=\"140\" />\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"circle\" id=\"ThirdNeuron\">\n");
      out.write("                <span id=\"ExpThirdNeuron\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("            </div> \n");
      out.write("            <div class=\"HiddenLayer\" id=\"ThirdNeuronOutputArrow\">\n");
      out.write("                <span class=\"Weight\" id=\"ThirdNeuronWeight\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\" width=\"170\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"circle\" id=\"FourthNeuron\">\n");
      out.write("                <span id=\"ExpFourthNeuron\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"HiddenLayer\" id=\"FourthNeuronOutputArrow\">\n");
      out.write("                <span class=\"Weight\" id=\"FourthNeuronWeight\"  >\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\" width=\"120\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"circle\" id=\"FifthNeuron\">\n");
      out.write("                <span id=\"ExpFifthNeuron\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"HiddenLayer\" id=\"FifthNeuronOutputArrow\">\n");
      out.write("                <span class=\"Weight\" id=\"FifthNeuronWeight\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\" width=\"180\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"circle\" id=\"SixthNeuron\">\n");
      out.write("                <span>\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"SixthNeuronOutputArrow\">\n");
      out.write("                <span class=\"Weight\" id=\"SixthNeuronWeight\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <img src=\"arrow.png\" />\n");
      out.write("            </div>\n");
      out.write("            <div id=\"OutPut\">\n");
      out.write("                <select onchange=\"OutputValueTwo(this.value)\">\n");
      out.write("                    <option value=\"\"> Sel </option>\n");
      out.write("                    <option value=\"0.0\"> 0 </option>\n");
      out.write("                    <option value=\"1.0\"> 1 </option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"button\">\n");
      out.write("            <button type=\"button\" onclick=\"calculateMatrix()\" >Iteration</button>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
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
