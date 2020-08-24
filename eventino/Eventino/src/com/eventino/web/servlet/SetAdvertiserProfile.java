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
 * Servlet implementation class AdvertiserProfile
 */
@WebServlet("/SetAdvertiserProfile")
public class SetAdvertiserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetAdvertiserProfile() {
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
		
		
		String advertiserName = request.getParameter("advertiser_name");
		String advertiserDesc = request.getParameter("description");
		String advertiserType = request.getParameter("advertiser_type");
		String advertiserLogo = request.getParameter("logo");
		
		System.out.println(advertiserName);
		System.out.println(advertiserDesc);
		System.out.println(advertiserType);
		System.out.println(advertiserLogo);


		try {
			HttpSession session = request.getSession();
			
			if(session.getAttribute("id")==null) {
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp");
				reqDispatcher.forward(request, response);
			}

			int userID = (int) session.getAttribute("id");
			System.out.println(userID);

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DBConnection.createConnection();
			String sql = "UPDATE advertiser SET advertiser_name=?, logo=?, advertiser_description=?, advertiser_type=? WHERE advertiser.advertiser_id=?";

			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

				preparedStatement.setString(1, advertiserName);
				preparedStatement.setString(2, advertiserLogo);
				preparedStatement.setString(3, advertiserDesc);
				preparedStatement.setString(4, advertiserType);
				preparedStatement.setLong(5, userID);
				preparedStatement.addBatch();

				int[] affectedRecord = preparedStatement.executeBatch();
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
