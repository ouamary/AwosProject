package org.apache.jsp.Front_002dOffice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<link rel=\"stylesheet\" href=\"./Front-Office/style.css\" type=\"text/css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"scripts/jquery.js\"></script>\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\n");
      out.write("function viderChampRecherche(){\n");
      out.write("\tvar champRecherche = document.getElementById(\"champRecherche\");\n");
      out.write("\tchampRecherche.value = \"\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("function ecrireChampRecherche(){\n");
      out.write("\tvar champRecherche = document.getElementById(\"champRecherche\");\n");
      out.write("\tif(champRecherche.value == \"\")\n");
      out.write("\t\tchampRecherche.value = \"Saisie ici...\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("function doAjax() {\n");
      out.write("  $.ajax({\n");
      out.write("    url: '../indexController.action'\n");
      out.write("    }\n");
      out.write("  );\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<title>Bienvenue chez AWOS Foods !</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top.jsp", out, false);
      out.write("</div>\n");
      out.write("\t<div>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "left.jsp", out, false);
      out.write("</div>\n");
      out.write("\t<div id=\"container\">\t\t    \n");
      out.write("     \t<div id=\"mainContent\">\n");
      out.write("     \t\t<h2>Bienvenue sur le site officiel de AWOS Foods !</h2>\n");
      out.write("\t\t\t<br><h4>En ce moment, en exclusivité web </h4>\n");
      out.write("\t\t\t<br><h4>Les bons plans à saisir </h4>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("   \t<div>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "right.jsp", out, false);
      out.write("</div>\n");
      out.write("\t<div>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
