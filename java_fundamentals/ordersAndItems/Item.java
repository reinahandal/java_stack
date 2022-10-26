public class Item {
    public String name;
    public double price;

    public Item(){
        this.name = "";
        this.price = 0;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}