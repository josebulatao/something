import static org.junit.Assert.*;

public class BankAccountTest {

    private static BankAccount account;
    private static int count=0;
    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("This excecutes before any test cases. Count = "+ count++);
    }
    @org.junit.Before
    public void setup() {
        account=new BankAccount("Jose","Bulatao",1000,BankAccount.CHECKING);
        System.out.println("Running a test....");
    }
    @org.junit.Test
    public void deposit() throws Exception {
        double balance=account.deposit(200,true);
        assertEquals(1200,balance,0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_branch() throws Exception{
    double balance = account.withdraw(600.00,false);
    assertEquals(400.00,balance,0);
    }
    @org.junit.Test//(expected = IllegalArgumentException.class)
    public void withdraw_notBranch()throws Exception{
        account.withdraw(600.00,false);
    }
    @org.junit.Test
    public void getBalance_deposit() throws Exception{
        account.deposit(1200,true);
    }
    @org.junit.Test
    public void getBalance_withdraw()throws Exception {
       account.withdraw(200,true);
        assertEquals(800,account.getBalance(),0);
    }
    @org.junit.Test
    public void isChecking_true() {
    assertTrue("The account is NOT Checking account",account.isChecking());
    }
    @org.junit.After
    public void after() {
        System.out.println("Count = " +count++);
    }
    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This is afterClass method");
    }
}