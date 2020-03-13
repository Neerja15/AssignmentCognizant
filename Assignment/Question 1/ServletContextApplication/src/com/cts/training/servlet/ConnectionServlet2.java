package com.cts.training.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnectionServlet2 extends HttpServlet {
	String user, password, url, driver;
	Connection con;
	ServletContext context;
	@Override
	public void init(ServletConfig config) throws ServletException {
		context=config.getServletContext();
		user = context.getInitParameter("userName");
		password = context.getInitParameter("password");
		url = context.getInitParameter("url");
		driver = context.getInitParameter("driver");
		try {
			Class.forName(driver);
con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
			System.out.println(config +"From cs2");
			System.out.println(context +"From cs2");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello from service");
	}
}
