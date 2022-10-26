public class Item {
    private String name;
    private double price;

    public Item(){
        this.name = "";
        this.price = 0;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}