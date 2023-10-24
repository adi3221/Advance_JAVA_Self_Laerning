import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet
{
	private Connection conn;
	private ResultSet rs;
	private Statement st;
	public void init()throws ServletException
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading successfully completed");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe","advjavabatch","myscholars");
			System.out.println("Connection opened Successfully");
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("Select userid, password, username from users");					
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
			rs.moveToInsertRow();
              		rs.updateString(1,userid);
              		rs.updateString(2, password);
              		rs.updateString(3, username);
              		rs.insertRow();
              		rs.moveToCurrentRow();
              		System.out.println("Record have been inserted successfully.");			
			pw.println("Registered Succcessfully. Please <a href='login.html'>Login</a>");
			
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