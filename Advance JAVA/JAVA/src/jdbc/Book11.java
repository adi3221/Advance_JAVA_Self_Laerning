
package jdbc;

public class Book11 {

    public Book11(String name, double oldp, double newp) {
        this.name = name;
        this.oldp = oldp;
        this.newp = newp;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", oldp=" + oldp + ", newp=" + newp + '}';
    }
    private String name;
    private double oldp;
    private double newp;
    
}
