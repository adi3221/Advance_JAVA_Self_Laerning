
package jdbc;
import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;
//import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;

public class Disconnected_Architecture {
    public static void main(String[] args) {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully");
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet obj = factory.createCachedRowSet();
            obj.setUrl("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe");
            obj.setUsername("advjavabatch");
            obj.setPassword("myscholars");
     
            obj.setCommand("select bookname,bookprice from allbooks");
     
            obj.execute();

            while(obj.next()){
                String bname = obj.getString(1);
                double amt =  obj.getDouble(2);
                System.out.println(bname+"\t"+amt);
            }
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
