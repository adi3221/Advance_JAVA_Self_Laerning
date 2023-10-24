
package jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class MyJdbcApp16 {
    public static void main(String[] args) {
        Connection conn=null;
        try
         {
              Class.forName("oracle.jdbc.OracleDriver");
              System.out.println("Driver loaded successfully");
               conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe","advjavabatch","myscholars");
              System.out.println("Connected successfully to the database");
              PreparedStatement ps = conn.prepareStatement("Insert into student values(?,?,?)");
              Scanner kb = new Scanner(System.in);
              System.out.println("Enter roll number,name and DOB(dd-MM-yyyy)");
              int roll = kb.nextInt();
              kb.nextLine();
              String name = kb.nextLine();
              String dob = kb.next();
              SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
              java.util.Date dateutil = sdf.parse(dob);
              long ms = dateutil.getTime();
              java.sql.Date sqldate = new java.sql.Date(ms);
              ps.setInt(1, roll);
              ps.setString(2,name);
              ps.setDate(3, sqldate);
              
              int res = ps.executeUpdate();
              if(res>0){
                  System.out.println("Record inserted successfully");
              }
              else{
                  System.out.println("Record not inserted");
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
        catch(ParseException pe){
            System.out.println(".Parse method exception occurs");
            System.out.println(pe);
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
