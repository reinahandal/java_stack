import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {

        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Yasmeen");
        Order order4 = new Order("Tony");
        Order order5 = new Order("Valentina");

        Item item1 = new Item("Americano", 2.5);
        Item item2 = new Item("Latte", 3.5);
        Item item3 = new Item("Capuccino", 3.5);
        Item item4 = new Item("Mocha", 3.7);
        Item item5 = new Item("Espresso", 2.0);

        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item3);
        order2.addItem(item4);
        order3.addItem(item5);
        order3.addItem(item1);
        order4.addItem(item4);
        order4.addItem(item2);
        order5.addItem(item3);
        order5.addItem(item5);

        order1.isReady(true);
        order3.isReady(true);
        order5.isReady(true);

        order1.display();
        System.out.println(order1.getStatusMessage());
        order2.display();
        System.out.println(order2.getStatusMessage());
        order3.display();
        System.out.println(order3.getStatusMessage());
        order4.display();
        System.out.println(order4.getStatusMessage());
        order5.display();
        System.out.println(order5.getStatusMessage());
    }
}
