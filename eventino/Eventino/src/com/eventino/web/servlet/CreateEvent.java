package com.eventino.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eventino.db.connection.DBConnection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class CreateEvent
 */
@WebServlet("/CreateEvent")
public class CreateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateEvent() {
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
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id")==null) {
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String eventTitle = request.getParameter("event_title");
		String eventTime = request.getParameter("event_time");
		String eventDesc = request.getParameter("event_desc");
		String eventAddress = request.getParameter("event_address");
		String eventType = request.getParameter("event_type");
		String eventPublishDate = request.getParameter("event_publish_date");
		String eventExpireDate = request.getParameter("event_expire_date");
		String eventPhoto = request.getParameter("event_photo");

		System.out.println(eventTitle);
		System.out.println(eventTime);

		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("id")==null) {
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp");
				reqDispatcher.forward(request, response);
			}

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DBConnection.createConnection();

			String sql = "UPDATE event SET event_address=?, event_title=?, event_desc=?, event_expire_date=?, event_publish_date=?, event_time=?, event_type=?, event_photo=? WHERE event.event_id=?";

			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

				preparedStatement.setString(1, eventAddress);
				preparedStatement.setString(2, eventTitle);
				preparedStatement.setString(3, eventDesc);
				preparedStatement.setString(4, eventExpireDate);
				preparedStatement.setString(5, eventPublishDate);
				preparedStatement.setString(6, eventTime);
				preparedStatement.setString(7, eventType);
				preparedStatement.setString(8, eventPhoto);
				preparedStatement.setLong(9, 1);
				preparedStatement.addBatch();

				int[] affectedRecords = preparedStatement.executeBatch();
			} finally {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			}

			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		}

	}

}
