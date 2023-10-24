
package jdbc;


public class Book13 {

    @Override
    public String toString() {
        return "Book13{" + "id=" + id + ", bname=" + bname + ", sub=" + sub + ", amt=" + amt + '}';
    }

    public Book13(int id, String bname, String sub, double amt) {
        this.id = id;
        this.bname = bname;
        this.sub = sub;
        this.amt = amt;
    }
    private int id;
    private String bname;
    private String sub;
    private double amt;
    
}
