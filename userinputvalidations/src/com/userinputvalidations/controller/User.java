package com.userinputvalidations.controller;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Getting the data from the user page */

		String string = request.getParameter("data");
		/*
		 * setContentType. Sets the content type of the response being sent to the
		 * client, if the response has not been committed yet. The given content type
		 * may include a character encoding specification, for example,
		 * text/html;charset=UTF-8 .
		 */
		response.setContentType("text/html");

		try {
			if ((string != null) && !string.equals("") && string.matches("[a-zA-Z].+[a-zA-Z]")) {

				/*
				 * The RequestDispatcher interface provides the facility of dispatching the
				 * request to another resource it may be html, servlet or jsp. This interface
				 * can also be used to include the content of another resource also. It is one
				 * of the way of servlet collaboration.
				 */
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDatabase");
				/*
				 * The include() method is used to include the contents of the calling resource
				 * into the called one.
				 */
				dispatcher.include(request, response);

			} else {
				/*
				 * To pass the value from servlet to html/jsp files, setAttribute() method is
				 * called by the request object. setAttribute() method takes an input as an
				 * object which sends the data from servlet to the requesting website
				 */
				request.setAttribute("msg", " Enter Valid Data!!: Data is not starting and ending with any special character ");
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
