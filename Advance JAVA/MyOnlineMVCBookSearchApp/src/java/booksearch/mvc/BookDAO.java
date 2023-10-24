
package booksearch.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OJQFHOI:1521/xe","advjavabatch","myscholars");
            ps = conn.prepareStatement("select bookname,bookprice from allbooks where subject=?");
            
        }
        catch(Exception ex){
            System.out.println("Error in Dao");
            ex.printStackTrace();
        }
    }
    public static ArrayList<Book> getBooksBySubject(String subject)throws SQLException
    {
        ps.setString(1,subject);
        ResultSet rs = ps.executeQuery();
        ArrayList<Book> bookList = new ArrayList<Book>();
        while(rs.next()){
            String bname = rs.getString(1);
            double amt = rs.getDouble(2);
            Book obj = new Book();
            obj.setBookname(bname);
            obj.setPrice(amt);
            bookList.add(obj);
        }
        return bookList;
    }
}
