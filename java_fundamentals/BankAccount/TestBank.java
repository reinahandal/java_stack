public class TestBank {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        account1.depositChecking(200.45);
        account1.depositSavings(1028.25);
        account1.depositChecking(532);
        account1.depositChecking(200.45);        
        account1.depositChecking(300);        
        
        account2.depositChecking(300.45);
        account2.depositSavings(1500.50);
        account2.depositChecking(305);
        account2.depositChecking(200.45);        
        account2.depositChecking(160);        
        
        account1.withdrawChecking(2000);
        account2.withdrawChecking(350);
        System.out.println("Your Account Number is: "+ account2.getAccountNumber());
        System.out.println("Your checking account balance is: "+ account2.getCheckingBalance());
        System.out.println("Your savings account balance is: "+ account2.getSavingsBalance());

    }
}