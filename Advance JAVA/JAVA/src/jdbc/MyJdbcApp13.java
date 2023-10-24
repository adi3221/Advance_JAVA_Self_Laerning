
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class MyJdbcApp13 {
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
              String choice;
              ArrayList<Book13> al = new ArrayList<>();
              while(rs.next()){
                  int bid = rs.getInt(1);
                  String bname = rs.getString(2);
                  String sub = rs.getString(3);
                  double amt = rs.getDouble(4);
                  System.out.println(bid+" "+bname+" "+sub+" "+amt);
                  System.out.println("You want to delete this row(yes/no)!");
                  choice = kb.next(); 
                  if(choice.equalsIgnoreCase("yes")){
                      Book13 obj = new Book13(bid,bname,sub,amt);
                      al.add(obj);
                      rs.deleteRow();
                  }
              }
              System.out.println("Number of record deleted were:"+al.size());
              for(Book13 b:al){
                  System.out.println(b);
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
