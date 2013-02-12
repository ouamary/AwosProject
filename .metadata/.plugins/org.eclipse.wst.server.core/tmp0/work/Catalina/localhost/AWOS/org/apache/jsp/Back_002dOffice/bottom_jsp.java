package org.apache.jsp.Back_002dOffice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bottom_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!-- javascript placed at the end of the document so the pages load faster -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/utopia.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/jquery.hoverIntent.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/jquery.easing.1.3.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/jquery.datatable.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/tables.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/jquery.sparkline.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/jquery.vticker-min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/datepicker.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/load-image.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/image-gallery.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/jquery.simpleWeather.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/jquery.validationEngine.js\" ></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/jquery.validationEngine-en.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/maskedinput.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/chosen.jquery.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/main.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/header.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"./assets/sidebar.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t    jQuery(function(){\r\n");
      out.write("\t\t        jQuery(\".utopia\").validationEngine('attach', {promptPosition : \"topLeft\", scroll: false});\r\n");
      out.write("\t\t    })\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
