package com.cts.customTag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHandler extends TagSupport{
	@Override
	public int doStartTag() throws JspException {
		System.out.println("From doStartTag()");
		JspWriter out=pageContext.getOut();
		try {
			out.write("<h1>"+new Date()+"</h1>");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//return EVAL_BODY_INCLUDE;
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		System.out.println("From doEndTag()");
		//return SKIP_PAGE;
		return EVAL_PAGE;
	}
	
}
