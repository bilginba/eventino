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
 * Servlet implementation class Profile
 */
@WebServlet("/SetParticipantProfile")
public class SetParticipantProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetParticipantProfile() {
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

		String profilePicture = request.getParameter("profile_picture");
		String nationality = request.getParameter("nationality");
		String birthdate = request.getParameter("date_of_birth");
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String jobTitle = request.getParameter("job_title");
		String languages = request.getParameter("foreign_languages");
		String certificates = request.getParameter("certificates");
		String type = request.getParameter("student_type");
		
		System.out.println(type);

		try {
			
			HttpSession session = request.getSession();
			if(session.getAttribute("id")==null) {
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp");
				reqDispatcher.forward(request, response);
			}
			
			
			int userID = (int)session.getAttribute("id");
			String userType = (String)session.getAttribute("user-type");
			
			if(userType==null || userID==0) {
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp");
				reqDispatcher.forward(request, response);
			}

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DBConnection.createConnection();

			String sql = "UPDATE Participant SET profile_picture=?, nationality=?, birthdate=?, surname=?, participant_name=?, gender=?, job_title=?, foreign_languages=?, certificates=?, participant_type=? WHERE participant.participant_id=?";

			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

				preparedStatement.setString(1, profilePicture);
				preparedStatement.setString(2, nationality);
				preparedStatement.setString(3, birthdate);
				preparedStatement.setString(4, surname);
				preparedStatement.setString(5, name);
				preparedStatement.setString(6, gender);
				preparedStatement.setString(7, jobTitle);
				preparedStatement.setString(8, languages);
				preparedStatement.setString(9, certificates);
				preparedStatement.setString(10, type);
				preparedStatement.setLong(11, userID);
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
