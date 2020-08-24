package com.eventino.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
import com.eventino.web.security.Sha512;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Sha512 sha512 = new Sha512();
		password = sha512.encrypt(password);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DBConnection.createConnection();
			Statement stmt = conn.createStatement();
			

			ResultSet rs = stmt.executeQuery("SELECT id,username,user_type FROM user WHERE email='"+ email + "' and pass='" + password + "'");

		
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("id", rs.getInt("id"));
				session.setAttribute("username", rs.getString("username"));
				session.setAttribute("user-type", rs.getString("user_type"));
				
				String aTp = rs.getString("user_type");
				int userID = rs.getInt("id");
				rs.close();
				
				if(aTp.equals("Participant")) {
					ResultSet rs1 = stmt.executeQuery("SELECT participant_type FROM participant WHERE participant_id='"+ userID + "'");
					if(rs1.next()) {
						session.setAttribute("participant-type", rs1.getString("participant_type"));
					}
					session.setAttribute("advertiser-type", "");
					rs1.close();
				}
				else if(aTp.equals("Advertiser")) {
					ResultSet rs1 = stmt.executeQuery("SELECT advertiser_type FROM advertiser WHERE advertiser_id='"+ userID + "'");
					if(rs1.next()) {
						session.setAttribute("advertiser-type", rs1.getString("advertiser_type"));
					}
					session.setAttribute("participant-type", "");
					rs1.close();
				}

				
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp");
				reqDispatcher.forward(request, response);

			} else {
				System.out.println("nope");
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp");
				reqDispatcher.forward(request, response);
			}
			
			
			
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
