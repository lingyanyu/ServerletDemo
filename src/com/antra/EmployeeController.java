package com.antra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeController extends HttpServlet{
	
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("employeeName");
		String sal=req.getParameter("sal");
		System.out.println(id);
		System.out.println(name);
		System.out.println(sal);


		String url1 = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
		String user = "xxxxx";
		String password = "xxxxxxxx";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url1, user, password);
			System.out.println("success");

			String insertSQuery = "insert into employee values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQuery);
			preparedStatement.setString(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setString(3,sal);
			preparedStatement.execute();

		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();
		}


		PrintWriter out=res.getWriter();
		out.println(id);
		out.println(name);
		out.println(sal);
	}

}
