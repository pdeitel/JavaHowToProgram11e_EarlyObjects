// Fig. E.1: AccountTest.java
// Create and manipulate an Account object.
public class AccountTest {
   public static void main(String[] args) {
      Account account = new Account("Jane Green", 50.00); 

      // display initial balance of Account object
      System.out.printf("initial account balance: $%.2f%n", 
         account.getBalance());
      
      double depositAmount = 25.0; // deposit amount
      
      System.out.printf("%nadding %.2f to account balance%n%n", 
         depositAmount);
      account.deposit(depositAmount); // add to account balance

      // display new balance
      System.out.printf("new account balance: $%.2f%n", 
         account.getBalance());
   } 
} 
