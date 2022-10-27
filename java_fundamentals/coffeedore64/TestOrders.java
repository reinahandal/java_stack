import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();
        kiosk.addMenuItem("Espresso", 2.0);
        kiosk.addMenuItem("Capuccino", 3.5);
        kiosk.addMenuItem("Americano", 2.5);
        kiosk.addMenuItem("Mocha", 3.5);
        kiosk.newOrder();
    }
}
