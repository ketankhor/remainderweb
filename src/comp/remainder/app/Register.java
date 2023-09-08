package comp.remainder.app;


import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comp.connect.server.ConnectDB;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		
		String uname = request.getParameter("uname");
		String umob = request.getParameter("umob");
		String uemail = request.getParameter("uemail");
		String upass = request.getParameter("upass");
		
		try 
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into user_tbl values(?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, uname);
			ps1.setString(3, umob);
			ps1.setString(4, uemail);
			ps1.setString(5, upass);
			
			int i = ps1.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				response.sendRedirect("Register.html");
			}
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
