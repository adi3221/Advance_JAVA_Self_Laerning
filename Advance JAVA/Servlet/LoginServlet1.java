import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet
{
	private Connection conn;
	private PreparedStatement ps;
	public void init()throws ServletException
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading successfully completed");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe","advjavabatch","myscholars");
			System.out.println("Connection opened Successfully");
			ps = conn.prepareStatement("Select username from users where userid=? and password = ?");						
		}	
		catch(Exception ex)
		{
			System.out.println("Error in init "+ex.getMessage());
			ServletException se = new ServletException("Error in init"+ex);
			throw se;
		}
	}	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{ 
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> Home Page </title>");
		pw.println("</head>");
		pw.println("<body>");
		String userid = req.getParameter("uid");
		String password = req.getParameter("pwd");
		try
		{
			ps.setString(1,userid);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String name = rs.getString(1);
				pw.println("Welcome <strong>"+name+"</strong><br>");
				pw.println("Enjoy Surfing");
			}	
			else
			{
				pw.println("<strong>You cannot login as login id and password are invalid <strong>");
				pw.println("<a href='login.html'>Try Again</a><br>");
				pw.println("New User <a href='register.html'>Register</a>");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error in doPost "+ex);
			pw.println("Servlet is experiencing some issues. Come back letter");
		}
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
	public void destroy()
	{
		try
		{
			conn.close();
			System.out.println("Connection Disconnected Successfully");
		}
		catch(SQLException ex)
		{
			System.out.println("Error in closing the connection: "+ex);
		}
	}
	
}