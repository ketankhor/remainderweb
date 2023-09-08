package comp.remainder.app;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comp.connect.server.ConnectDB;

/**
 * Servlet implementation class DeleteRemainder
 */
public class DeleteRemainder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRemainder() {
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
		
		String email;
		email=User.getUsername();
		int rid = Integer.parseInt(request.getParameter("rid"));
		
		
		try 
		{
			Connection con  = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("delete from rem_tbl where uemail=?and remid=?");
			ps1.setString(1, email);
			ps1.setInt(2, rid);
			
			int i = ps1.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("content.html");
			}
			else
			{
				response.sendRedirect("failed.html");
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
