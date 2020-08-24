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
import com.eventino.web.model.ParticipantModel;
import com.eventino.web.model.AdvertiserModel;

/**
 * Servlet implementation class ProfileSettings
 */
@WebServlet("/ProfileSettings")
public class ProfileSettings extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileSettings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

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




			if(userType.equals("Advertiser")) {

				ResultSet rs = stmt.executeQuery("SELECT * FROM advertiser WHERE advertiser_id='"+ userID + "'");
				if(rs.next()) {
					AdvertiserModel model = new AdvertiserModel();
					model.setAdvertiser_name(rs.getString("advertiser_name"));
					model.setLogo(rs.getString("logo"));
					model.setAdvertiser_description(rs.getString("advertiser_description"));
					model.setAdvertiser_type(rs.getString("advertiser_type"));
					request.setAttribute("advertiserModel", model);
					request.setAttribute("participantModel", "");
				}

			}
			else if(userType.equals("Participant")) {

				ResultSet rs = stmt.executeQuery("SELECT * FROM Participant WHERE participant_id='"+ userID + "'");
				if(rs.next()) {
					ParticipantModel model = new ParticipantModel();
					model.setProfile_picture(rs.getString("profile_picture"));
					model.setNationality(rs.getString("nationality"));
					model.setBirthdate(rs.getDate("birthdate"));
					model.setSurname(rs.getString("surname"));
					model.setParticipant_name(rs.getString("participant_name"));
					model.setGender(rs.getString("gender"));
					model.setJob_title(rs.getString("job_title"));
					model.setForeign_languages(rs.getString("foreign_languages"));
					model.setCertificates(rs.getString("certificates"));
					model.setParticipant_type(rs.getString("participant_type"));
					request.setAttribute("advertiserModel", "");
					request.setAttribute("participantModel", model);
				}

			}




			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/profile_settings.jsp");
			reqDispatcher.forward(request, response);



		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

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

			if(userType==null || userID==0) {
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp");
				reqDispatcher.forward(request, response);
			}



			if(userType.equals("Advertiser")) {
				ResultSet rs = stmt.executeQuery("SELECT * FROM Advertiser WHERE advertiser_id='"+ userID + "'");
				request.setAttribute("advertiserModel", "");
				request.setAttribute("participantModel", "");
			}else if(userType.equals("Participant")) {
				ResultSet rs = stmt.executeQuery("SELECT * FROM Participant WHERE participant_id='"+ userID + "'");
				ParticipantModel model = new ParticipantModel();
				model.setParticipant_name(rs.getString("participant_name"));
				request.setAttribute("advertiserModel", "");
				request.setAttribute("participantModel", model);
			}



			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/profile_settings.jsp");
			reqDispatcher.forward(request, response);



		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
