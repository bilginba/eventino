package com.eventino.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eventino.db.connection.DBConnection;
import com.eventino.web.model.EventModel;

/**
 * Servlet implementation class Events
 */
@WebServlet(urlPatterns = {"/Events","/AllEvents"})
public class Events extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Events() {
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
			

			ResultSet rs = stmt.executeQuery("SELECT * FROM event");


				
			List<EventModel> events = new ArrayList<EventModel>();
			
			//ResultSet studentTicket = stmt.executeQuery("SELECT ticket.price FROM ticket,event WHERE event.event_id = " + rs.getInt("event_id") + " AND event.event_id = ticket.event_id AND ticket.ticket_type = 'Student' ORDER BY ticket.ticket_id LIMIT 1");
			//ResultSet nonStudentTicket = stmt.executeQuery("SELECT ticket.price FROM ticket,event WHERE event.event_id = " + rs.getInt("event_id") + " AND event.event_id = ticket.event_id AND ticket.ticket_type = 'Non-Student' ORDER BY ticket.ticket_id LIMIT 1");
			
			
			while(rs.next()){
				EventModel event = new EventModel(rs.getInt("event_id"),
						rs.getInt("advertiser_id"),
						rs.getInt("system_account_transaction_id"),
						rs.getInt("account_transaction_id"),
						rs.getString("event_address"),
						rs.getString("event_title"),
						rs.getString("event_desc"),
						rs.getDate("event_expire_date"),
						rs.getDate("event_publish_date"),
						rs.getDate("event_time"),
						rs.getString("event_type"),
						rs.getString("event_photo"));
				events.add(event);

			}

			request.setAttribute("events", events);

			
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/events.jsp");
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
