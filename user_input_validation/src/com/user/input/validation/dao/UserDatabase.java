package com.user.input.validation.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	public UserDatabase() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = null;
		PreparedStatement statement = null;
		String string = request.getParameter("data");
		String quer = "insert into user values (?)";

		try {
			/*
			 * Establish a connection using the Connection class object
			 */
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebixcash?user=root&password=root");

			/* Creating a statement */
			statement = connection.prepareStatement(quer);

			statement.setString(1, string);

			/* Executing query */
			statement.executeUpdate();

			request.setAttribute("msg", "Data Added !!: ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_ui_form.jsp");
			dispatcher.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null && statement !=null) {
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
