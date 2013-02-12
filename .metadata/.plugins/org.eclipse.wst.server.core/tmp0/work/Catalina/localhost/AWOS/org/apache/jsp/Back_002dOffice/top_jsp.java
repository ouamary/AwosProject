package org.apache.jsp.Back_002dOffice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>AWOS Music Admin</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"AWOS Music Admin\">\r\n");
      out.write("    <meta name=\"author\" content=\"awos\">\r\n");
      out.write("\r\n");
      out.write("    <!-- styles -->\r\n");
      out.write("    <link href=\"http://utopiaadmin.themio.net/css/utopia-white.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"http://utopiaadmin.themio.net/css/utopia-responsive.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"http://utopiaadmin.themio.net/css/validationEngine.jquery.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\" src=\"./assets/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"./assets/jquery.cookie.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        if($.cookie(\"css\")) {\r\n");
      out.write("            $('link[href*=\"utopia-white.css\"]').attr(\"href\",$.cookie(\"css\"));\r\n");
      out.write("            $('link[href*=\"utopia-dark.css\"]').attr(\"href\",$.cookie(\"css\"));\r\n");
      out.write("            $('link[href*=\"utopia-wooden.css\"]').attr(\"href\",$.cookie(\"css\"));\r\n");
      out.write("        }\r\n");
      out.write("        $(document).ready(function() {\r\n");
      out.write("            $(\".theme-changer a\").live('click', function() {\r\n");
      out.write("                $('link[href*=\"utopia-white.css\"]').attr(\"href\",$(this).attr('rel'));\r\n");
      out.write("                $('link[href*=\"utopia-dark.css\"]').attr(\"href\",$(this).attr('rel'));\r\n");
      out.write("                $('link[href*=\"utopia-wooden.css\"]').attr(\"href\",$(this).attr('rel'));\r\n");
      out.write("                $.cookie(\"css\",$(this).attr('rel'), {expires: 365, path: '/'});\r\n");
      out.write("                $('.user-info').removeClass('user-active');\r\n");
      out.write("                $('.user-dropbox').hide();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>");
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
