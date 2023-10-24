import javax.servlet.*;

public class MyListener implements ServletContextListener
{
	public void contextInitialized(ServletContextEvent sce)
	{
		System.out.println("hello!.. This msg is from context Intitialized");
	}
	public void contextDestroyed(ServletContextEvent sce)
	{
		System.out.println("hello!.. This msg is from context Destroyed");
	}
}