package jdbc;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.*;

public class JdbcImage {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe", "advjavabatch", "myscholars");
            System.out.println("Connected successfully to the database");
            PreparedStatement ps = conn.prepareStatement("Insert into movies values(?,?)");
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter path to the imge:");
            String str = kb.nextLine();
            File f = new File(str);
            FileInputStream fin = new FileInputStream(f);
            String fname = f.getName();//will hold dangal.jpg
            int dotpos = fname.lastIndexOf(".");
            String movname = fname.substring(0, dotpos);

            ps.setString(1, movname);
            ps.setBinaryStream(2, fin, (int) f.length());

            int res = ps.executeUpdate();
            System.out.println("Rec inserted: " + res);
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found:" + fnf.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println("Cannot laod the driver class:" + cnf.getMessage());
        } catch (SQLException ex) {
            System.out.println("DB Error:" + ex.getMessage());
        } //        catch(ParseException pe){
        //            System.out.println(".Parse method exception occurs");
        //            System.out.println(pe);
        //        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Disconnected successfully to the database");
                } catch (SQLException sq) {
                    System.out.println("Error in closing the connection");
                }
            }
        }
    }
}
