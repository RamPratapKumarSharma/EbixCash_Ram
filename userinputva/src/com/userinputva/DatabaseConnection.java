package com.userinputva;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DatabaseConnection
 */
@WebServlet("/DatabaseConnection")
public class DatabaseConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatabaseConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		Statement statement = null;
		String quer = "insert into employee values (?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDrive");

			connection = DriverManager
					.getConnection("jdbc:oracle://localhost:1521/ebixcash?user=scott&password=tiger");
			statement = connection.createStatement();

			statement.executeUpdate(quer);

			System.out.println("Query inserted sucessfully");
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

	}

}
