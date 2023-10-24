
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class MyJdbcApp12 {
    public static void main(String[] args) {
        Connection conn=null;
        try
         {
              Class.forName("oracle.jdbc.OracleDriver");
              System.out.println("Driver loaded successfully");
               conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe","advjavabatch","myscholars");
              System.out.println("Connected successfully to the database");
              Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
              ResultSet rs=st.executeQuery("Select bookis, bookname, subject, bookprice from allbooks");
              
              Scanner kb = new Scanner(System.in);
              System.out.println("Enter book id:");
              int bid = kb.nextInt();
              System.out.println("Enter book name:");
              kb.nextLine();
              String bname = kb.nextLine();
              System.out.println("Enter the subject:");
              String subject = kb.next();
              System.out.println("Enter book price");
              double amt = kb.nextDouble();
              
              rs.moveToInsertRow();
              rs.updateInt(1, bid);
              rs.updateString(2,bname);
              rs.updateString(3, subject);
              rs.updateDouble(4, amt);
              rs.insertRow();
              rs.moveToCurrentRow();
              System.out.println("Record have been inserted successfully.");
             
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
