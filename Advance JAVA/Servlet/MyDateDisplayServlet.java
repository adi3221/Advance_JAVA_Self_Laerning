import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class MyDateDisplayServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{ 
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> My Date Display Servlet App</title>");
		pw.println("<style>");
		pw.println("h2{color:blue;}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String datestr = sdf.format(today);
		pw.println("<h2>Current date is "+datestr+"</h2>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}