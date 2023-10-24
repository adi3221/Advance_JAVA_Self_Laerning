
package FileHandling;


import java.io.*;

public class Buffered_Reader {
    public static void main(String[] args) {
        FileReader fr=null;
        try{
            fr = new FileReader("D:\\Recovery.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            int count=0;
            while((str=br.readLine())!=null){
                System.out.println(str);
                count += str.length();
            }
            System.out.println("Total characters read: "+count);
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
