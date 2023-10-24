import javax.servlet.*;
import java.util.*;

public class MyListener1 implements ServletContextListener
{
	public void contextInitialized(ServletContextEvent sce)
	{
		Date today = new Date();
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("now",today);
		System.out.println("Date set and stored in ServletContext...");
	}
	public void contextDestroyed(ServletContextEvent sce)
	{
		
	}
}