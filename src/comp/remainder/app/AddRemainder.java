package comp.remainder.app;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comp.connect.server.ConnectDB;

/**
 * Servlet implementation class AddRemainder
 */
public class AddRemainder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRemainder() {
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
		
		String remtitle = request.getParameter("remtitle");
		String remdesc = request.getParameter("remdesc");
		
		 String email=User.getUsername();
		
		try 
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into rem_tbl values(?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, remtitle);
			ps1.setString(3, remdesc);
			ps1.setString(4, email);
			
			int i= ps1.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("content.html");
			}
			else
			{
				response.sendRedirect("Failed.html");
			}
			
			
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
