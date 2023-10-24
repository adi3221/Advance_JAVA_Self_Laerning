package jdbc;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


public class Disconnected_Architecture_2 {
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

            boolean found = false;
            while(obj.next()){
                String subject = obj.getString(3);
                if(subject.equalsIgnoreCase("JSE")){
                    found = true;
                    double amt =  obj.getDouble(4);
                    amt = amt + 0.1*amt;
                    obj.updateDouble(4, amt);
                    obj.updateRow();
                }
            }
            if(found==true)
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
