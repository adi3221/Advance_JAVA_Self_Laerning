
package FileHandling;
import java.util.*;
import java.io.*;

class MyEmp implements Serializable{
    private int age;
    private String name;
    private double sal;
    
    public void get(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter age, name and sal");
        age= kb.nextInt();
        name = kb.next();
        sal = kb.nextDouble();
    }
    public void show(){
        System.out.println(age);
        System.out.println(name);
        System.out.println(sal);
    }
}
public class Serialiazable_Implementation {
    public static void main(String[] args) {
        try{
            MyEmp E = new MyEmp();
            E.get();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Recovery.txt"));
            oos.writeObject(E);
            oos.close();
            ObjectInputStream ios = new ObjectInputStream(new FileInputStream("D:\\Recovery.txt"));
            MyEmp F = (MyEmp)ios.readObject();
            F.show();
            ios.close();
        }
        catch(Exception e){
            System.out.println("Exception in the file I/O:"+e);
        }
    }
}
