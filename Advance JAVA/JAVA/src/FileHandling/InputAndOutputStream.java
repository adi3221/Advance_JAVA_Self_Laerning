
package FileHandling;

import java.io.*;

public class InputAndOutputStream {
    public static void main(String[] args) {
        DataInputStream din=null;
        DataOutputStream dout = null;
        try{
            int a = 12134567;
            dout = new DataOutputStream(new FileOutputStream("D:\\Recovery.txt"));
            dout.writeDouble(Math.PI);
            dout.writeInt(a);
            dout.close();
            
            din = new DataInputStream(new FileInputStream("D:\\Recovery.txt"));
            double x = din.readDouble();
            int b = din.readInt();
            System.out.println("Value saved in file is"+x);
            System.out.println("Value saved in file is"+b);
            din.close();
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }
}
