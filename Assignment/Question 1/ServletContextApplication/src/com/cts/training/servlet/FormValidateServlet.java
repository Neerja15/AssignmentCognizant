package com.cts.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FormValidateServlet extends HttpServlet {
	String user, password, url, driver;
	Connection conn;

	@Override
	public void init(ServletConfig config) throws ServletException {
		user = config.getInitParameter("userName");
		password = config.getInitParameter("password");
		url = config.getInitParameter("url");
		driver = config.getInitParameter("driver");
	
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("From service");
		if (req.getMethod().equals("GET")) {
			doGet(req, resp);
		} else {
			doPost(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		{

			PrintWriter pw = resp.getWriter();

			String eId = req.getParameter("empid");
			String name = req.getParameter("un");
			String pass = req.getParameter("pwd");
			String salary = req.getParameter("salary");

			try {
				PreparedStatement ps;
				String sql = "insert into emp_details values (?,?,?,?)";

				ps = conn.prepareStatement(sql);
				ps.setString(1, eId);
				ps.setString(2, name);
				ps.setString(3, pass);
				ps.setString(4, salary);
				int result = ps.executeUpdate();
				if (result > 0) {
					System.out.println("Data Inserted Successfully!");

				} else {
					System.out.println("Something went wrong..");

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
