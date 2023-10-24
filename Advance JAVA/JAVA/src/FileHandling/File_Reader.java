
package FileHandling;


import java.io.*;

public class File_Reader {
    public static void main(String[] args) {
        FileReader fr=null;
        try{
            fr = new FileReader("D:\\Recovery.txt");
            int ch;
            int count=0;
            
            while((ch = fr.read())!=-1){
                System.out.print((char)ch);
                ++count;
            }
            System.out.println("\nTotal characters Read: "+count);
        }
        catch(FileNotFoundException fnf){
            System.out.println("Cannot open the file: "+fnf.getMessage());
        }        
        catch(IOException ex){
            System.out.println("Error while reading the file:" +ex.getMessage());
        }
        finally{
            if(fr!=null){
                try{
                    fr.close();
                }
                catch(IOException ex){
                    System.out.println("Error while closing file");
                }
            }
        }
    }
}
