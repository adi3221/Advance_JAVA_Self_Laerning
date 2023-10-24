package jdbc;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Batch {

    public static void main(String[] args) {
        Connection conn = null;
        boolean status = true;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe", "advjavabatch", "myscholars");
            System.out.println("Connected successfully to the database");
            Statement st = conn.createStatement();
            conn.setAutoCommit(false);
            st.addBatch("insert into allbooks values(105,'oracle cert','oracle',790)");
            st.addBatch("delete from student where rollno=101");
            st.addBatch("update emp set sal=sal+1000 where empno>102");
            int[] result = st.executeBatch();
            for (int i = 0; i < result.length; i++) {
                System.out.println("Query " + (i + 1) + " effected " + result[i] + "rows");
            }

        } catch (ClassNotFoundException cnf) {
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
