import java.io.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.*;
public class ClientInfo extends HttpServlet
{
   protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
   {
        resp.setContentType("text/html");
        PrintWriter pw=resp.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Client Info Servlet</title>");
        pw.println("<style>table,tr,td,th{border:2px;color: white;background-color: black;border-collapse: collapse;}</style>");
        pw.println("</head>");
        pw.println("<body>");
        String ipAddr=req.getRemoteAddr();
        String compName=req.getRemoteHost();
        pw.println("<h3>Client Machine Details</h3>");
        pw.println("Your ip address:"+ipAddr+"<br>");
        pw.println("Your computer name:"+compName+"<br>");
        Enumeration en=req.getHeaderNames();
        pw.println("<table>");
        pw.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
        while(en.hasMoreElements())
        {
            String headerName=(String)en.nextElement();
            String headerValue=req.getHeader(headerName);
            pw.println("<tr><td>"+headerName+"</td><td>"+headerValue+"</td></tr>");
        }
        pw.println("</body>");
        pw.println("</html>");

       pw.close();
   }
}
