import java.util.ArrayList;

public class Order {
    public String name;
    public double total;
    public boolean ready;
    public ArrayList<Item> items;

    public Order() {
        this.name = "Guest";
        this.total = 0;
        this.ready = false;
        this.items = new ArrayList<Item>();       
    }
    public Order(String name) {
        this.name = name;
        this.total = 0;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }
}