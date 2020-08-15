package com.qiaw99;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	
	private StringWriter stringWriter = new StringWriter();
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void doTag() throws JspException, IOException {
		if(message != null) {
			JspWriter outJspWriter = getJspContext().getOut();
			outJspWriter.println(message);
		}else {
			getJspBody().invoke(stringWriter);
			getJspContext().getOut().println(stringWriter.toString());
		}
	}
}
