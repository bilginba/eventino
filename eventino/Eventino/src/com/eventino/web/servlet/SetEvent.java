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
 * Servlet implementation class SetEvent
 */
@WebServlet("/SetEvent")
public class SetEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetEvent() {
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
		
		String eventID = request.getParameter("event-id");
		
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


			ResultSet rs = stmt.executeQuery("SELECT * FROM event WHERE event_id='"+eventID+"'");
			if(rs.next()) {
				
				
				request.setAttribute("ali", "");
			}
			/*
event_id INT NOT NULL AUTO_INCREMENT,
advertiser_id INT,
system_account_transaction_id INT,
account_transaction_id INT,
event_address VARCHAR(255),
event_title VARCHAR(70),
event_desc VARCHAR(255),
event_expire_date DATE,
event_publish_date DATE,
event_time DATE,
event_type VARCHAR(70),
event_photo VARCHAR(255),
			 */
			
			
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
					.getRequestDispatcher("/create_event.jsp");
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
