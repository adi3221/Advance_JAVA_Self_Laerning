import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ListenerDateDisplayServlet extends HttpServlet
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
		ServletContext ctxt = super.getServletContext();
		Date d = (Date)ctxt.getAttribute("now");
		pw.println("<h2>Current date is "+d+"</h2>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}