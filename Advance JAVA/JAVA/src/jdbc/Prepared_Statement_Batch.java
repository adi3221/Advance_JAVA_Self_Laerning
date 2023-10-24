
package jdbc;

import java.beans.Statement;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Prepared_Statement_Batch {
    public static void main(String[] args) {
        Connection conn = null;
        boolean status = true;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe", "advjavabatch", "myscholars");
            System.out.println("Connected successfully to the database");
            PreparedStatement ps = conn.prepareStatement("insert into allbooks values(?,?,?,?)");
            conn.setAutoCommit(false);
            Scanner kb = new Scanner(System.in);
            do{
                System.out.println("Enter book id");
                int id = kb.nextInt();
                System.out.println("Enter book name");
                kb.nextLine();
                String bname = kb.nextLine();
                System.out.println("Enter subject");
                String sub = kb.next();
                System.out.println("Enter book price");
                double amt = kb.nextDouble();
                
                ps.setInt(1, id);
                ps.setString(2,bname);
                ps.setString(3, sub);
                ps.setDouble(4,amt);
                
                ps.addBatch();
                
                System.out.println("Do you want to continue(yes/no)");
                String choice = kb.next();
                if(choice.equalsIgnoreCase("NO"))
                    break;
            }
            while(true);
            
            int [] result = ps.executeBatch();
            for(int i=0;i<result.length;i++){
//                if(result[i]==Statement.EXECUTE_FAILED)
//                    status = false;
                System.out.println("Query "+(i+1)+" inserted "+result[i]+" rows");
            }

        } 
        catch (ClassNotFoundException cnf) {
            System.out.println("Cannot laod the driver class:" + cnf.getMessage());
        } catch (BatchUpdateException bue) {
            int[] arr = bue.getUpdateCounts();//ye aapko array dega jo ye batayega jis query tak exception nhi
// ayyi hai waha tak integer hoga matlab array ki length wale query par wali query par exception aaya hai
            int count = arr.length + 1;
            System.out.println("Query " + count + " gave the exception");
            System.out.println(bue.getMessage());
            status = false;
        } catch (SQLException ex) {
            System.out.println("DB Error:" + ex.getMessage());
            status = false;
        } finally {
            if (conn != null) {
                try {
                    if(status){
                        System.out.println("Everything executed successfully. Commiting changes!");
                        conn.commit();
                    }
                    else{
                        System.out.println("Something went wrong Rollback Changes...");
                        conn.rollback();
                    }
                        conn.close();
                        System.out.println("Disconnected successfully to the database");
                    
                } catch (SQLException sq) {
                    System.out.println("Error in closing the connection");
                }
            }
        }
    }

}
