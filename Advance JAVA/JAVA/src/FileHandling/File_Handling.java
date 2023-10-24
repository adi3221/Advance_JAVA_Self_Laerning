
package FileHandling;

import java.io.File;

public class File_Handling {
    public static void main(String[] args) {
        File myFile = new File("D:\\Hello world.docx");
        if(myFile.exists()){
            System.out.println(myFile.getName()+" is present.");
        }
        else{
            System.out.println("File Not Present");
            System.exit(0);
        }
        if(myFile.isFile()){
            System.out.println(myFile.getName()+" is a file");
            System.out.println("Size of the file is "+myFile.length());
        }
        else{
            System.out.println(myFile.getName()+" is a directory");
        }
        if(myFile.isHidden()){
            System.out.println(myFile.getName()+" is hidden");
        }
        else{
            System.out.println(myFile.getName()+" is not hidden");
        }
        if(myFile.canWrite()){
            System.out.println(myFile.getName()+" allows writing");
        }
        else{
            System.out.println(myFile.getName()+"doesn't allow writing");
        }
    }
}
