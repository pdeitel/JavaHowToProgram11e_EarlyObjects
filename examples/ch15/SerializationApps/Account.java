// Fig. 15.9: Account.java
// Account class for storing records as objects.
public class Account {
   private int accountNumber;
   private String firstName;
   private String lastName;
   private double balance;
   
   // initializes an Account with default values
   public Account() {this(0, "", "", 0.0);} 
  
   // initializes an Account with provided values
   public Account(int accountNumber, String firstName, 
      String lastName, double balance) {
      this.accountNumber = accountNumber;
      this.firstName = firstName;
      this.lastName = lastName;
      this.balance = balance;
   }

   // get account number   
   public int getAccountNumber() {return accountNumber;} 
   
   // set account number   
   public void setAccountNumber(int accountNumber) 
      {this.accountNumber = accountNumber;}

   // get first name   
   public String getFirstName() {return firstName;} 
   
   // set first name   
   public void setFirstName(String firstName) 
      {this.firstName = firstName;} 

   // get last name   
   public String getLastName() {return lastName;} 
   
   // set last name   
   public void setLastName(String lastName) {this.lastName = lastName;} 

   // get balance   
   public double getBalance() {return balance;} 

   // set balance  
   public void setBalance(double balance) {this.balance = balance;} 
} 


/*************************************************************************
* (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/