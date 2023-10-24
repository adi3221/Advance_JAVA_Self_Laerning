
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.text.*;


public class MyJdbcApp14 {
    public static void main(String[] args) {
        Connection conn=null;
        try
         {
              Class.forName("oracle.jdbc.OracleDriver");
              System.out.println("Driver loaded successfully");
               conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe","advjavabatch","myscholars");
              System.out.println("Connected successfully to the database");
              Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
              ResultSet rs=st.executeQuery("Select ename,hiredate from emp");
              while(rs.next()){
                  String ename = rs.getString(1);
                  Date hd = rs.getDate(2);
                  SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/YYYY");
                  String fd = sdf.format(hd);
                  System.out.println(ename+"\t"+fd);
              }
             
       }
      catch(ClassNotFoundException cnf)
      {
                      System.out.println("Cannot laod the driver class:"+cnf.getMessage());
      }
      catch(SQLException ex)
      {
                System.out.println("DB Error:"+ex.getMessage());
       }
      finally
      {
              if(conn!=null)
              {
              	     try
	      {
		conn.close();
           		System.out.println("Disconnected successfully to the database");     
	       }
          	      catch(SQLException sq)
              	     {
                    	System.out.println("Error in closing the connection");
              	     }
	}
      }
    }
}
