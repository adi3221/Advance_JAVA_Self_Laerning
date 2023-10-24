import java.io.*;
import javax.servlet.*;

public class MyFirstServlet extends GenericServlet
{
	public void service(ServletRequest req, ServletResponse resp)throws ServletException,IOException
	{
		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> My First Servlet App </title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<b>Welcome to the world of Servlets!<b>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}