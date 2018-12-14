public class BankAccount {

    private String name;
    private String lastName;
    private double balance=0;

    public static final int CHECKING=1;
    public static final int SAVINGS=2;

    private int accountType;

    public BankAccount(String name, String lastName, double balance,int typeOfAccount) {
        this.name = name;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType=typeOfAccount;
    }
    public double deposit(double amount,boolean branch){
        balance+=amount;
        return balance;
    }

    public double withdraw(double amount,boolean branch){
        if((amount>500)&&!branch){
            throw new IllegalArgumentException();
        }
        balance-=amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
    public boolean isChecking(){
        return accountType==CHECKING;
    }
    public double finalValue(){
        return this.balance;
    }
}
