import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ServletOne extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{ 
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> Init Parameter Display </title>");
		pw.println("<style>");
		pw.println("h2{color:blue;}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");
		ServletConfig cfg = super.getServletConfig();
		String mailid = cfg.getInitParameter("emailid");
		String phoneno = cfg.getInitParameter("phoneno");
		pw.println("<strong>Email Id:</strong>"+mailid+"</br>");
		pw.println("<strong>Contact no:</strong>"+phoneno+"</br>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}