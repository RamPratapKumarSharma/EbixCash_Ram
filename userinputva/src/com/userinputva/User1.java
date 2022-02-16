package com.userinputva;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User1() {
		super();
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String string = request.getParameter("data");
//
//		response.setContentType("text/html");
//
//		PrintWriter printWriter = response.getWriter();
//
//		if ((string != null) && !string.equals("") && string.matches("^[a-zA-Z\s]*$")) {
//			printWriter.println(string);
//		} else {
//			printWriter.print("Not valid");
//		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher("userinput.html");
//		dispatcher.include(request, response);
//	}
//
//}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,  IOException {
		
		String string = request.getParameter("data");
		
				response.setContentType("text/html");
		
				PrintWriter printWriter = response.getWriter();
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("userinput.html");
				if ((string != null) && !string.equals("") && string.matches("^[a-zA-Z\s]*$")) {
					Connection connection = null;
					PreparedStatement statement = null;
					String quer = "insert into userinput values (?)";
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						OracleDriver driver=new OracleDriver();
						DriverManager.registerDriver(driver);
						connection = DriverManager
								.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
						printWriter.println("Query inserted sucessfully");
						statement = connection.prepareStatement(quer);
						statement.setString(1, string);
						statement.executeUpdate();
						
						printWriter.println("Query inserted sucessfully");
						dispatcher.include(request, response);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (connection != null) {
						try {
							connection.close();
							statement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				} else {
					printWriter.println("Not valid");
					dispatcher.include(request, response);
				}

	}

}
