import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class MyDateTimeServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{ 
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> My Date Time Servlet App</title>");
		pw.println("<style>");
		pw.println("h2{color:red;}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");
		Date today = new Date();
		pw.println("<h2>Current date and time are "+today+"</h2>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}