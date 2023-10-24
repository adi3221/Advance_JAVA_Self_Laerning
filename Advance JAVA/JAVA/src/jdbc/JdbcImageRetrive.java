package jdbc;

//import java.sql.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Scanner;
import java.io.*;

public class JdbcImageRetrive {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe", "advjavabatch", "myscholars");
            System.out.println("Connected successfully to the database");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from movies");
            File mydir = new File("D:/onlineadvjava/mydbpics");
            if(!mydir.exists()){
                if(!mydir.mkdir()){
                    FolderNotCreatedException obj = new FolderNotCreatedException("Sorry! cannot create the folder. Application Terminated...");
                    throw(obj);
                }
            }
            while(rs.next()){
                String mname = rs.getString(1);
                Blob obj = rs.getBlob(2);
                byte [] arr = obj.getBytes(1, (int)obj.length());
                FileOutputStream fout = new FileOutputStream("D:/onlineadvjava/mydbpics/"+mname+".jpg");
                fout.write(arr);
                fout.close();
                System.out.println("Saving "+mname+".jpg ...");
            }
            
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }
        catch(FolderNotCreatedException obj){
            System.out.println(obj.getMessage());
        }
        catch (ClassNotFoundException cnf) {
            System.out.println("Cannot laod the driver class:" + cnf.getMessage());
        } catch (SQLException ex) {
            System.out.println("DB Error:" + ex.getMessage());
        } //        catch(ParseException pe){
        //            System.out.println(".Parse method exception occurs");
        //            System.out.println(pe);
        //        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
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
