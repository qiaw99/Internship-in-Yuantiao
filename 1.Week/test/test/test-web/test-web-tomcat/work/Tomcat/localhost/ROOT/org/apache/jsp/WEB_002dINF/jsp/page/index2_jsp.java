/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
 * Generated at: 2020-08-10 07:22:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/pf.tld", Long.valueOf(1596463248000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fpf_005fhead_0026_005ftitle;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fpf_005fbody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fpf_005fscript;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fpf_005fhead_0026_005ftitle = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fpf_005fbody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fpf_005fscript = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fpf_005fhead_0026_005ftitle.release();
    _005fjspx_005ftagPool_005fpf_005fbody.release();
    _005fjspx_005ftagPool_005fpf_005fscript.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_pf_005fhead_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_pf_005fbody_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_pf_005fhead_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  pf:head
    com.yuantiao.webplatform.ui.base.HeadTag _jspx_th_pf_005fhead_005f0 = (com.yuantiao.webplatform.ui.base.HeadTag) _005fjspx_005ftagPool_005fpf_005fhead_0026_005ftitle.get(com.yuantiao.webplatform.ui.base.HeadTag.class);
    boolean _jspx_th_pf_005fhead_005f0_reused = false;
    try {
      _jspx_th_pf_005fhead_005f0.setPageContext(_jspx_page_context);
      _jspx_th_pf_005fhead_005f0.setParent(null);
      // /WEB-INF/jsp/page/index2.jsp(6,0) name = title type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_pf_005fhead_005f0.setTitle((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_pf_005fhead_005f0 = _jspx_th_pf_005fhead_005f0.doStartTag();
      if (_jspx_eval_pf_005fhead_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_pf_005fhead_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_pf_005fhead_005f0);
        }
        do {
          out.write("\r\n");
          out.write("\t<link rel=\"shortcut icon\" href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${smallIcon}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t<link href=\"/page/css/layout.css\" rel=\"stylesheet\">\r\n");
          int evalDoAfterBody = _jspx_th_pf_005fhead_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_pf_005fhead_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_pf_005fhead_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fpf_005fhead_0026_005ftitle.reuse(_jspx_th_pf_005fhead_005f0);
      _jspx_th_pf_005fhead_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_pf_005fhead_005f0, _jsp_getInstanceManager(), _jspx_th_pf_005fhead_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_pf_005fbody_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  pf:body
    com.yuantiao.webplatform.ui.base.BodyTag _jspx_th_pf_005fbody_005f0 = (com.yuantiao.webplatform.ui.base.BodyTag) _005fjspx_005ftagPool_005fpf_005fbody.get(com.yuantiao.webplatform.ui.base.BodyTag.class);
    boolean _jspx_th_pf_005fbody_005f0_reused = false;
    try {
      _jspx_th_pf_005fbody_005f0.setPageContext(_jspx_page_context);
      _jspx_th_pf_005fbody_005f0.setParent(null);
      int _jspx_eval_pf_005fbody_005f0 = _jspx_th_pf_005fbody_005f0.doStartTag();
      if (_jspx_eval_pf_005fbody_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_pf_005fbody_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_pf_005fbody_005f0);
        }
        do {
          out.write("\r\n");
          out.write("<div style=\"height: 100%; width: 100%\" id=\"pageMenu\">\r\n");
          out.write("\t<header class='main-menubar pf-header-nav'>\r\n");
          out.write("\t\t<div class='pf-header-nav-logo-area'>\r\n");
          out.write("\t\t\t<div class='pf-header-nav-logo-icon'>\r\n");
          out.write("\t\t\t<img src='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bigIcon}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("' style='width: 26px'></div>\r\n");
          out.write("\t\t\t<div class='pf-header-nav-logo-title'>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("\t\t</div>\r\n");
          out.write("   \t\t<a class='pf-header-nav-logout-content' href='/logout'>\r\n");
          out.write("   \t\t\t<i class='fa fa-power-off'></i>\r\n");
          out.write("   \t\t</a>\r\n");
          out.write(" \t\t<div class='pf-header-nav-user-content'><span class='pf-header-nav-user-text-name'>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${webpfUserName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</span>\r\n");
          out.write(" \t\t<span id='msgCount' style=' background-color: red;padding: 2px 5px;border-radius: 10px;cursor: pointer;'>0</span></div>\r\n");
          out.write("\t\t<ul id=\"menu\" class=\"mini-menubar mymenu\">\r\n");
          out.write("\t\t</ul>\r\n");
          out.write(" \t</header>\r\n");
          out.write("\t<div class='content'>\r\n");
          out.write(" \t\t<div class='main-content'><iframe id='iframeWindow' style='width: 100%; height: 100%; border: 0' src=''></iframe>\r\n");
          out.write(" \t\t</div>\r\n");
          out.write(" \t</div>\r\n");
          out.write("</div>\r\n");
          out.write("<script src=\"/page/js/index.js\"></script>\r\n");
          if (_jspx_meth_pf_005fscript_005f0(_jspx_th_pf_005fbody_005f0, _jspx_page_context))
            return true;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_pf_005fbody_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_pf_005fbody_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_pf_005fbody_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fpf_005fbody.reuse(_jspx_th_pf_005fbody_005f0);
      _jspx_th_pf_005fbody_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_pf_005fbody_005f0, _jsp_getInstanceManager(), _jspx_th_pf_005fbody_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_pf_005fscript_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_pf_005fbody_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  pf:script
    com.yuantiao.webplatform.ui.base.ScriptTag _jspx_th_pf_005fscript_005f0 = (com.yuantiao.webplatform.ui.base.ScriptTag) _005fjspx_005ftagPool_005fpf_005fscript.get(com.yuantiao.webplatform.ui.base.ScriptTag.class);
    boolean _jspx_th_pf_005fscript_005f0_reused = false;
    try {
      _jspx_th_pf_005fscript_005f0.setPageContext(_jspx_page_context);
      _jspx_th_pf_005fscript_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_pf_005fbody_005f0);
      int _jspx_eval_pf_005fscript_005f0 = _jspx_th_pf_005fscript_005f0.doStartTag();
      if (_jspx_eval_pf_005fscript_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_pf_005fscript_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_pf_005fscript_005f0);
        }
        do {
          out.write("\r\n");
          out.write("\r\n");
          out.write("\tdataRender(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${menu}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(',');
          out.write(' ');
          out.write('"');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nav}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\", \"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write(',');
          out.write('"');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${webpfBaseImplAddress}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          out.write("\t$(\".main-content iframe\").attr(\"src\",\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          out.write("\tif(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${antd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" == \"antd\"){\r\n");
          out.write("\t\t$(\".main-menubar\").addClass(\"main-antd\");\r\n");
          out.write("\t\t$(\".content\").addClass(\"main-sidebar-antd\");\r\n");
          out.write("\t}\r\n");
          out.write("\t$(\"#msgCount\").bind(\"click\",function(){\r\n");
          out.write("\t\tpf.open({\r\n");
          out.write("\t\t\turl:bundleUrl+\"msgLog/showMsg.html\",\r\n");
          out.write("\t\t\twidth:500,\r\n");
          out.write("\t\t\theight:400,\r\n");
          out.write("\t\t\ttitle:\"\",\r\n");
          out.write("\t\t\tonload:function(){\r\n");
          out.write("\t\t\t\tvar data = YTMsg.getMsgData();\r\n");
          out.write("\t\t\t\tfor(var key in data){\r\n");
          out.write("\t\t\t\t\tvar count = parseInt($(\"#msgCount\").html());\r\n");
          out.write("\t\t\t\t\t$(\"#msgCount\").html(count-1);\r\n");
          out.write("\t\t\t\t\tif(data[key].log.sendtime==null||data[key].log.sendtime==\"\"){\r\n");
          out.write("\t\t\t\t\t\tdata[key].log.sendtime = pf.formatDate(Date(),'yyyy-MM-dd HH:mm:ss');\r\n");
          out.write("\t\t\t\t\t}\r\n");
          out.write("\t\t\t\t\t$(\"#showMsgContent\").append(\r\n");
          out.write("\t\t\t\t\t\t'<div class=\"showMsgBox\">'\r\n");
          out.write("\t\t\t\t\t\t\t+'<div class=\"showMsgRow\">'\r\n");
          out.write("\t\t\t\t\t\t\t\t+'<div class=\"showMsg-title\">'+data[key].log.title+'</div>'\r\n");
          out.write("\t\t\t\t\t\t\t\t+'<div class=\"showMsg-time\">'+data[key].log.sendtime+'</div>'\r\n");
          out.write("\t\t\t\t\t\t\t+'</div>'\r\n");
          out.write("\t\t\t\t\t\t\t+'<div class=\"showMsgRow\">'\r\n");
          out.write("\t\t\t\t\t\t\t\t+'<div class=\"showMsg-content\">'+data[key].log.content+'</div>'\r\n");
          out.write("\t\t\t\t\t\t\t+'</div>'\r\n");
          out.write("\t\t\t\t\t\t+'</div>'\r\n");
          out.write("\t\t\t\t\t);\r\n");
          out.write("\t\t\t\t\tYTMsg.read(key);\r\n");
          out.write("\t\t\t\t}\r\n");
          out.write("\t\t\t}\r\n");
          out.write("\t\t})\r\n");
          out.write("\t})\r\n");
          out.write("\tYTMsg.onMessage=function(data){\r\n");
          out.write("\t\tvar count = parseInt($(\"#msgCount\").html());\r\n");
          out.write("\t\t$(\"#msgCount\").html(count+1)\r\n");
          out.write("\t}\r\n");
          out.write("\tYTMsg.open(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msgSocket}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write(',');
          out.write('"');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${webpfUserId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\",\"platform\",\"null\");\r\n");
          out.write("\r\n");
          int evalDoAfterBody = _jspx_th_pf_005fscript_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_pf_005fscript_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_pf_005fscript_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fpf_005fscript.reuse(_jspx_th_pf_005fscript_005f0);
      _jspx_th_pf_005fscript_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_pf_005fscript_005f0, _jsp_getInstanceManager(), _jspx_th_pf_005fscript_005f0_reused);
    }
    return false;
  }
}
