package com.userinputvalidations.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDatabase
 */
@WebServlet("/UserDatabase")
public class UserDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDatabase() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = null;
		PreparedStatement statement = null;
		/*
		 * The UI/Form Data can be fetched by using getParameter( ).
		 */
		String string = request.getParameter("data");
		String quer = "insert into user values (?)";

		try {

			/*
			 * get the Class instance using forName method
			 */
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 * Establish a connection using the Connection class object
			 */
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebixcash?user=root&password=root");

			/* Creating a statement */
			statement = connection.prepareStatement(quer);
			/*
			 * Sets the designated parameter to the given Java String value. The driver
			 * converts this to an SQL VARCHAR or LONGVARCHAR value when it sends it to the
			 * database.
			 */
			statement.setString(1, string);

			/* Executing query */
			statement.executeUpdate();
			/*
			 * To pass the value from servlet to html/jsp files, setAttribute() method is
			 * called by the request object. setAttribute() method takes an input as an
			 * object which sends the data from servlet to the requesting website
			 */
			request.setAttribute("msg", "Data Added !!: ");
			/*
			 * The RequestDispatcher interface provides the facility of dispatching the
			 * request to another resource it may be html, servlet or jsp. This interface
			 * can also be used to include the content of another resource also. It is one
			 * of the way of servlet collaboration.
			 */
			RequestDispatcher dispatcher = request.getRequestDispatcher("useruiform.jsp");
			/*
			 * Includes the content of a resource (servlet, JSP page, or HTML file) in the
			 * response.
			 */
			dispatcher.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null && statement != null) {
				try {
					connection.close();
					statement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
