
package jdbc;

import java.sql.SQLException;
import java.util.Scanner;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


public class Disconnected_Architecture_3 {
    public static void main(String[] args) {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully");
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet obj = factory.createCachedRowSet();
            obj.setUrl("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe");
            obj.setUsername("advjavabatch");
            obj.setPassword("myscholars");
     
            obj.setCommand("select * from allbooks");
     
            obj.execute();

            Scanner kb = new Scanner(System.in);
            System.out.println("Enter boo id:");
            int bid = kb.nextInt();
            System.out.println("Enter book name:");
            kb.nextLine();
            String bname = kb.nextLine();
            System.out.println("Enter the Subject:");
            String sub = kb.next();
            System.out.println("Enter the book price:");
            double amt = kb.nextDouble();
            
            obj.moveToInsertRow();
            obj.updateInt(1,bid);
            obj.updateString(2,bname);
            obj.updateString(3, sub);
            obj.updateDouble(4, amt);
            
            obj.insertRow();
            obj.moveToCurrentRow();
            
            obj.acceptChanges();
            
        }
        catch(ClassNotFoundException cnf){
            System.out.println(cnf);
        }
        catch(SQLException ex)
        {
                System.out.println("DB Error:"+ex.getMessage());
        }
    }
}
