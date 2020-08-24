package com.eventino.web.servlet;

import java.io.IOException;
import java.sql.Connection;
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
import com.eventino.web.model.TicketRequestModel;

/**
 * Servlet implementation class AdminPanel
 */
@WebServlet("/AdminPanel")
public class AdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPanel() {
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
			
			rs = stmt.executeQuery("SELECT request_financial_aid.student_id AS studentID,event.event_title AS eventTitle,request_financial_aid.ticket_id AS ticketID FROM request_financial_aid,ticket,event WHERE is_accepted is null AND request_financial_aid.ticket_id = ticket.ticket_id AND ticket.event_id = event.event_id");
			List<TicketRequestModel> ticketRS = new ArrayList<TicketRequestModel>();
			List<EventModel> ticketES = new ArrayList<EventModel>();
			while(rs.next()) {
				TicketRequestModel ticketR = new TicketRequestModel();
				EventModel ticketE = new EventModel();
				ticketR.setStudent_id(rs.getInt("studentID"));
				ticketR.setTicket_id(rs.getInt("ticketID"));
				ticketE.setEvent_title(rs.getString("eventTitle"));
				ticketRS.add(ticketR);
				ticketES.add(ticketE);
			}
			
			request.setAttribute("ticketRS", ticketRS);
			request.setAttribute("ticketES", ticketES);
			
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/admin_panel.jsp");
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
