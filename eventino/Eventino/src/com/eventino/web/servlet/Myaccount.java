package com.eventino.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eventino.db.connection.DBConnection;

/**
 * Servlet implementation class Myaccount
 */
@WebServlet("/Myaccount")
public class Myaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Myaccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());


		request.setAttribute("success", "Account transaction completed successfully");
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
				.getRequestDispatcher("/account_transaction.jsp");
		reqDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String transactionType = request.getParameter("transactionType");
		String amount = request.getParameter("amount");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DBConnection.createConnection();
			Statement stmt = conn.createStatement();
			HttpSession session = request.getSession();

			if(session.getAttribute("id")==null) {
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp");
				reqDispatcher.forward(request, response);
			}

			int userID = (int)session.getAttribute("id");
			String userType = (String)session.getAttribute("user-type");


			if(transactionType.equals("withdraw")) {
				amount = "-" + amount;
			}

			int ks = stmt.executeUpdate("INSERT INTO account_transaction VALUES(null,null,'"+userID+"','"+amount+"',NOW(),'"+transactionType+"')");

			request.setAttribute("success", "Account transaction completed successfully");
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "You dont have any activity");
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "You dont have any activity");
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		}


	}

}
