package comp.remainder.app;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comp.connect.server.ConnectDB;

/**
 * Servlet implementation class Login
 */
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
		
		String username = request.getParameter("username");
		String upassword = request.getParameter("upassword");
		try 
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("select * from user_tbl where uemail=? and upassword=?");
			ps1.setString(1, username);
			ps1.setString(2, upassword);
			
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
			{
				User.setUsername(username);
				response.sendRedirect("content.html");
				System.out.println("success");
			}
			else
			{
				response.sendRedirect("Register.html");
				System.out.println("fail");
			}
			
			
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
