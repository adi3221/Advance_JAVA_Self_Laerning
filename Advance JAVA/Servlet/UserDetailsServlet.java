import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class UserDetailsServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{ 
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> User Details</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>User Details</h3>");
		String user = req.getParameter("username");
		String gen = req.getParameter("gender");
		String [] hobbies = req.getParameterValues("hobbies");
		String hob = "";
		for(String s:hobbies)
		{
			hob+=s+", ";
		}
		pw.println("<strong>Your name: </strong>"+user+"<br>");
		pw.println("<strong>Your name: </strong>"+gen+"<br>");
		pw.println("<strong>Your name: </strong>"+hob+"<br>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}