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
 * Servlet implementation class BuyTicket
 */
@WebServlet("/BuyTicket")
public class BuyTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String ticketType = request.getParameter("ticket-type");
		String eventID = request.getParameter("event-id");

		try {
			HttpSession session = request.getSession();

			if(session.getAttribute("id")==null) {
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp");
				reqDispatcher.forward(request, response);
			}

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DBConnection.createConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = null;

			int userID = (int) session.getAttribute("id");


			if(!ticketType.equals("Free Request")) {
				rs = stmt.executeQuery("SELECT SUM(account_transaction.amount) AS user_balance FROM account_transaction WHERE account_transaction.user_id = '" + userID +"'");
				Double userBalance = null;
				if(rs.next()) {
					userBalance = rs.getDouble("user_balance");
				}
				rs.close();

				System.out.println("e id" + eventID);
				System.out.println("t t" + ticketType);

				rs = stmt.executeQuery("SELECT ticket_id,price FROM ticket WHERE ticket.event_id='"+eventID+"' AND ticket.ticket_type='"+ticketType+"' AND ticket.participant_id is null");
				if(rs.next()) {
					Double seatPrice = rs.getDouble("price");
					int ticketID = rs.getInt("ticket_id");
					if(seatPrice<userBalance) {
						int ks = stmt.executeUpdate("UPDATE ticket SET ticket.participant_id = '"+ userID +"', ticket.acquisition_date = NOW() WHERE ticket.ticket_id='"+ticketID+"'");

						request.setAttribute("success", "Ticket successfully received");
						System.out.println("Ticket successfully received");
						RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
								.getRequestDispatcher("/index.jsp");
						reqDispatcher.forward(request, response);

					}else {
						request.setAttribute("error", "Not enough money");
						System.out.println("Not enough money");
						RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
								.getRequestDispatcher("/index.jsp");
						reqDispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("error", "No empty seats");
					System.out.println("No empty seats");
					RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
							.getRequestDispatcher("/index.jsp");
					reqDispatcher.forward(request, response);
				}
			}else {
				
				rs = stmt.executeQuery("SELECT ticket_id FROM ticket WHERE ticket.event_id='"+eventID+"' AND ticket.ticket_type='student' AND ticket.participant_id is null ORDER BY ticket_id DESC LIMIT 1");
				String ticketID = null;
				if(rs.next()) {
					ticketID = rs.getString("ticket_id");
					
					int ks = stmt.executeUpdate("INSERT INTO request_financial_aid VALUES('"+ticketID+"','"+userID+"',null,null,null)");
					
					request.setAttribute("success", "Your request has been added to the list");
					System.out.println("Your request has been added to the list");
					
					RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
							.getRequestDispatcher("/index.jsp");
					reqDispatcher.forward(request, response);
				}else {
					
					request.setAttribute("error", "No empty seats");
					System.out.println("No empty seats");
					RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
							.getRequestDispatcher("/index.jsp");
					reqDispatcher.forward(request, response);
				}
				rs.close();
				
				

			}



		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "You cannot request more than one ticket for an event.");
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "You cannot request more than one ticket for an event.");
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
