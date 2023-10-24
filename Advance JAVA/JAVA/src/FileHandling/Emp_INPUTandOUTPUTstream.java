
package FileHandling;

import java.util.Scanner;
import java.io.*;

class Emp{
    private int age;
    private String name;
    private double sal;
    public void get(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter age, name and sal:");
        age = kb.nextInt();
        name = kb.next();
        sal = kb.nextDouble();
    }
    public void show(){
        System.out.println(age);
        System.out.println(name);
        System.out.println(sal);
    }
    public void writeInFile(){
        try{
            DataOutputStream dout;
            dout = new DataOutputStream(new FileOutputStream("D:\\Recovery.txt"));
            dout.writeInt(age);
            dout.writeUTF(name);
            dout.writeDouble(sal);
            dout.close();
        }
        catch(IOException ex){
            System.out.println("Error in writing "+ex);
            System.exit(0);
        }
    }
    public void readFromFile(){
        try{
            DataInputStream din;
            din = new DataInputStream(new FileInputStream("D:\\Recovery.txt"));
            age = din.readInt();
            name = din.readUTF();
            sal = din.readDouble();
            din.close();
        }
        catch(IOException ex){
            System.out.println("Error in reading"+ex);
            System.exit(0);
        }
    }
}
class Emp_INPUTandOUTPUTstream {
    public static void main(String[] args) {
        Emp E = new Emp();
        E.get();
        E.writeInFile();
        Emp F = new Emp();
        F.readFromFile();
        F.show();
    }
}
