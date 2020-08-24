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
import com.eventino.web.model.AdvertiserModel;
import com.eventino.web.model.ParticipantModel;

/**
 * Servlet implementation class Myprofile
 */
@WebServlet("/Myprofile")
public class Myprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myprofile() {
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


			ResultSet rs = null;

			
			
			
			if(userType.equals("Advertiser")) {

				rs = stmt.executeQuery("SELECT * FROM advertiser WHERE advertiser_id='"+ userID + "'");
				if(rs.next()) {
					AdvertiserModel model = new AdvertiserModel();
					model.setAdvertiser_name(rs.getString("advertiser_name"));
					model.setLogo(rs.getString("logo"));
					model.setAdvertiser_description(rs.getString("advertiser_description"));
					model.setAdvertiser_type(rs.getString("advertiser_type"));
					request.setAttribute("advertiserModel", model);
					request.setAttribute("participantModel", "");
				}
				rs.close();

				rs = stmt.executeQuery("SELECT COUNT(event_id) AS number_of_event FROM event WHERE advertiser_id='"+userID+"'");
				if(rs.next()) {
					String numberOfEvent = rs.getString("number_of_event");
					request.setAttribute("numberOfEvent", numberOfEvent);
				}
				rs.close();
				
				rs = stmt.executeQuery("SELECT SUM(account_transaction.amount) AS user_balance FROM account_transaction WHERE account_transaction.user_id = '" + userID +"'");
				if(rs.next()) {
					String balance = rs.getString("user_balance");
					request.setAttribute("balance", balance);
				}
				rs.close();

			}
			else if(userType.equals("Participant")) {

				rs = stmt.executeQuery("SELECT * FROM Participant WHERE participant_id='"+ userID + "'");
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
				rs.close();
				
				rs = stmt.executeQuery("SELECT COUNT(ticket_id) AS number_of_ticket FROM ticket WHERE participant_id='"+userID+"'");
				if(rs.next()) {
					String numberOfTicket = rs.getString("number_of_ticket");
					request.setAttribute("numberOfTicket", numberOfTicket);
				}
				rs.close();
				
				rs = stmt.executeQuery("SELECT SUM(account_transaction.amount) AS user_balance FROM account_transaction WHERE account_transaction.user_id = '" + userID +"'");
				if(rs.next()) {
					String balance = rs.getString("user_balance");
					request.setAttribute("balance", balance);
				}
				rs.close();
				
				
			}
			
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/my_profile.jsp");
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

	}

}
