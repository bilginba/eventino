package com.eventino.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.eventino.web.model.TicketModel;
import com.eventino.web.model.EventModel;

/**
 * Servlet implementation class Mylist
 */
@WebServlet("/Mylist")
public class Mylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mylist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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

			rs = stmt.executeQuery("SELECT SUM(account_transaction.amount) AS user_balance FROM account_transaction WHERE account_transaction.user_id = '" + userID +"'");
			if(rs.next()) {
				String balance = rs.getString("user_balance");
				request.setAttribute("balance", balance);
			}
			rs.close();
			
			
			if(userType.equals("Advertiser")) {
				
				
				
				rs = stmt.executeQuery("SELECT COUNT(event_id) AS number_of_event FROM event WHERE advertiser_id='"+userID+"'");
				if(rs.next()) {
					String numberOfEvent = rs.getString("number_of_event");
					request.setAttribute("numberOfEvent", numberOfEvent);
				}
				rs.close();
				
				
				rs = stmt.executeQuery("SELECT event_id,event_title,event_publish_date,event_expire_date FROM event WHERE event.advertiser_id='"+userID+"'");
				List<EventModel> events = new ArrayList<EventModel>();
				while(rs.next()) {
					
					EventModel eventModel = new EventModel();
					eventModel.setEvent_id(rs.getInt("event_id"));
					eventModel.setEvent_title("event_title");
					eventModel.setEvent_publish_date(rs.getDate("event_publish_date"));
					eventModel.setEvent_expire_date(rs.getDate("event_expire_date"));
					
					events.add(eventModel);
					
					
				}
				request.setAttribute("myevents", events);
				rs.close();
				
				

			}
			else if(userType.equals("Participant")) {
				rs = stmt.executeQuery("SELECT event.event_title AS title,ticket.ticket_type AS type,ticket.price AS price,event.event_time AS time FROM event,ticket WHERE ticket.participant_id='"+userID+"' AND ticket.event_id=event.event_id");
				
				List<EventModel> events = new ArrayList<EventModel>();
				List<TicketModel> tickets = new ArrayList<TicketModel>();
				while(rs.next()) {
					EventModel eventModel = new EventModel();
					TicketModel ticketModel = new TicketModel();
					
					eventModel.setEvent_title(rs.getString("title"));
					try {
						eventModel.setEvent_time(format.parse(rs.getString("time")));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ticketModel.setTicket_type(rs.getString("type"));
					ticketModel.setPrice(Double.valueOf(rs.getString("price")));
					
					events.add(eventModel);
					tickets.add(ticketModel);
					
					request.setAttribute("events", events);
					request.setAttribute("tickets", tickets);
					
				}
				
				rs.close();
				
				rs = stmt.executeQuery("SELECT COUNT(ticket_id) AS number_of_ticket FROM ticket WHERE participant_id='"+userID+"'");
				if(rs.next()) {
					String numberOfTicket = rs.getString("number_of_ticket");
					request.setAttribute("numberOfTicket", numberOfTicket);
				}
				rs.close();

			}
			
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/my_list.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
