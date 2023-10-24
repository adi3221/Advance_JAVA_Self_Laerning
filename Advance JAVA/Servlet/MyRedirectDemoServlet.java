import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class MyRedirectDemoServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{ 
		String browserName = req.getHeader("user-agent");
		String siteName = "";
		if(browserName.indexOf("chrome")!=-1)
		{
			siteName = "http://www.google.com";
		}
		else if(browserName.indexOf("mozilla")!=-1)
		{
			siteName = "http://www.mozilla.org";
		}
		else if(browserName.indexOf("MSIE")!=-1)
		{
			siteName = "http://www.microsoft.com";
		}
		else{
			siteName = "http://www.rgpv.ac.in";
		}
		resp.sendRedirect(siteName);
	}
}