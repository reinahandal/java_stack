import java.util.Random;
import java.util.Collections;


public class BankAccount {
    private String accountNumber = "";
    private double checkingBalance;
    private double savingsBalance;
    public static int numberOfAccounts = 0;
    public static double totalMoney = 0;

    private String generateAccountNumber() {
        Random random = new Random();
        for (int i=0; i<10; i++) {
            int x = random.nextInt(10);
            accountNumber+=x;
        }
        return accountNumber;
    }
    public BankAccount() {
        this.accountNumber = generateAccountNumber();
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numberOfAccounts++;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void depositChecking(double amount) {
        this.checkingBalance+=amount;
        totalMoney+=amount;
    }

    public void depositSavings(double amount) {
        this.savingsBalance+=amount;
        totalMoney+=amount;
    }

    public void withdrawChecking(double amount) {
        if(amount>this.getCheckingBalance()){
            System.out.println("Insufficient funds.");
        }
        else{
            this.checkingBalance-=amount;
            totalMoney-=amount;
        }
    }

    public double seeBalance() {
        return this.savingsBalance+this.checkingBalance;
    }

}