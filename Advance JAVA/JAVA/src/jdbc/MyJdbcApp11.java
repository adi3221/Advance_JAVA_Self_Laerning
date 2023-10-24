/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class MyJdbcApp11 {
    public static void main(String[] args) {
        Connection conn=null;
        try
         {
              Class.forName("oracle.jdbc.OracleDriver");
              System.out.println("Driver loaded successfully");
               conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe","advjavabatch","myscholars");
              System.out.println("Connected successfully to the database");
              Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
              ResultSet rs=st.executeQuery("Select bookprice,subject,bookname from allbooks");
              int count=0;
              ArrayList<Book11> al = new ArrayList<>();
              while(rs.next())
              {
                 String subject=rs.getString(2);
                 if(subject.equalsIgnoreCase("JSE"))
                 {
                     String bname = rs.getString(3);
                     double oldamt=rs.getDouble(1);
                     double newamt=oldamt+oldamt*0.1;
                     rs.updateDouble(1,newamt);
                     rs.updateRow();
                     ++count;
                     Book11 obj = new Book11(bname,oldamt,newamt);
                     al.add(obj);
                 }
             }
             System.out.println("Total books updated:"+count);
             for(Book11 b : al){
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
