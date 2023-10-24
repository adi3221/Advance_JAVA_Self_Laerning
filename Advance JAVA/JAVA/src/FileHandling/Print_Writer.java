

package FileHandling;


import java.io.*;
import java.util.Scanner;

public class Print_Writer {
    public static void main(String[] args) {
        PrintWriter pw=null;
        try{
            pw = new PrintWriter("D:\\Recovery.txt");
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter ur number");
            long phone = kb.nextLong();
            pw.print(phone);
            
        }
               
        catch(IOException ex){
            System.out.println("Error while reading the file:" +ex.getMessage());
        }
        finally{
            if(pw!=null){
                pw.close();
            }
        }
    }
}
