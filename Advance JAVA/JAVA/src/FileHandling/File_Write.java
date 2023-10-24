
package FileHandling;

import java.io.*;
import java.util.Scanner;

public class File_Write {
    public static void main(String[] args) {
        FileWriter fw = null;
        try{
            fw = new FileWriter("D:\\Recovery.txt",true);
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter some data about Java: ");
            String str = kb.nextLine();
            fw.write(str);
        }
        catch(IOException ex){
            System.out.println("Error while writing in the file.");
        }
        finally{
            if(fw!=null){
                try{
                    fw.close();
                    System.out.println("File saved successfully");
                }
                catch(IOException ex){
                    System.out.println("Error while saving the data in the file");
                }
            }
        }
    }
    
    
}
