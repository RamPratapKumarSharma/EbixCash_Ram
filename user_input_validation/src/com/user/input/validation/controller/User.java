package com.user.input.validation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* grtting the data from the user page */

		String string = request.getParameter("data");

		response.setContentType("text/html");

		if ((string != null) && !string.equals("") && string.matches("[a-zA-Z].+[a-zA-Z]")) {

			/*
			 * It is use to chain from one Servlet to another resources of the same
			 * application.
			 */
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDatabase");
			/*
			 * The include() method is used to include the contents of the calling resource
			 * into the called one.
			 */
			dispatcher.include(request, response);

		} else {
			request.setAttribute("msg", " Enter Valid Data!!: ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_ui_form.jsp");
			dispatcher.include(request, response);
		}

	}

}
