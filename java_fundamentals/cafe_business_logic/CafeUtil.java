import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal() {
        int sum = 0;
        for (int i=1; i<=10; i++) {
            sum+=i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (double price : prices) {
            total+=price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i=0; i<menuItems.size(); i++) {
            String item = menuItems.get(i);
            System.out.println(i + " " + item);
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        int numofCustomers = customers.size();
        System.out.println("There are " + numofCustomers + " people in front of you.");
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i=1; i <= maxQuantity; i++) {
            System.out.println(i + " - $" + (price*i - 0.5*(i-1)));
        }
    }

    boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }
        else {
            for (int i=0; i<menuItems.size(); i++) {
                System.out.println(i + " " + menuItems.get(i) + " -- $" + prices.get(i));
            }
            return true;
        }
    }
}