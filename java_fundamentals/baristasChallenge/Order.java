import java.util.ArrayList;
public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order() {
        this.name = "Guest";
        // this.total = 0;
        this.ready = false;
        this.items = new ArrayList<Item>();       
    }
    public Order(String name) {
        this.name = name;
        // this.total = 0;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void isReady(boolean ready) {
        this.ready = ready;
    }

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return ready;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getStatusMessage() {
        if (this.ready == true){
            return "Your order is ready.";
        }
        else{
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        double sum = 0;
        for(Item item : this.items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void display() {
        System.out.println("----------------------");
        System.out.println("Customer name: "+ this.name);
        for(Item item : this.items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $"+ this.getOrderTotal());
    }
}