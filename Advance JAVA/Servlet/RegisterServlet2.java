import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet
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
			ps = conn.prepareStatement("Insert into Users values(?,?,?)");						
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
		String username = req.getParameter("uname");
		try
		{
			ps.setString(1,userid);
			ps.setString(2,password);
			ps.setString(3,username);
			int ans = ps.executeUpdate();
			if(ans==1)
			{
				pw.println("Welcome <strong>"+username+"</strong><br>");
				pw.println("Please <a href='login.html'>Login</a>");
			}	
			else
			{
				pw.println("<strong>Registeration Unsuccessful.<strong>");
				pw.println("<a href='register.html'>Try Again</a><br>");
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