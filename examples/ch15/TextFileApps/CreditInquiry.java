// Fig. 15.8: CreditInquiry.java
// This program reads a file sequentially and displays the
// contents based on the type of account the user requests 
// (credit balance, debit balance or zero balance).
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreditInquiry {
   private final static MenuOption[] choices = MenuOption.values();

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      // get user's request (e.g., zero, credit or debit balance)
      MenuOption accountType = getRequest(input);

      while (accountType != MenuOption.END) {
         switch (accountType) {
            case ZERO_BALANCE:
               System.out.printf("%nAccounts with zero balances:%n");
               break;
            case CREDIT_BALANCE:
               System.out.printf("%nAccounts with credit balances:%n");
               break;
            case DEBIT_BALANCE:
               System.out.printf("%nAccounts with debit balances:%n");
               break;
         } 

         readRecords(accountType);
         accountType = getRequest(input); // get user's request 
      } 
   } 

   // obtain request from user
   private static MenuOption getRequest(Scanner input) {
      int request = 4;

      // display request options
      System.out.printf("%nEnter request%n%s%n%s%n%s%n%s%n",
         " 1 - List accounts with zero balances",
         " 2 - List accounts with credit balances",
         " 3 - List accounts with debit balances", 
         " 4 - Terminate program");

      try {
         do { // input user request
            System.out.printf("%n? ");
            request = input.nextInt();
         } while ((request < 1) || (request > 4));
      } 
      catch (NoSuchElementException noSuchElementException) {
         System.err.println("Invalid input. Terminating.");
      }

      return choices[request - 1]; // return enum value for option
   }

   // read records from file and display only records of appropriate type
   private static void readRecords(MenuOption accountType) {
      // open file and process contents
      try (Scanner input = new Scanner(Paths.get("clients.txt"))) {
         while (input.hasNext()) { // more data to read
            int accountNumber = input.nextInt();
            String firstName = input.next();
            String lastName = input.next();
            double balance = input.nextDouble();

            // if proper account type, display record
            if (shouldDisplay(accountType, balance)) {
               System.out.printf("%-10d%-12s%-12s%10.2f%n", accountNumber,
                  firstName, lastName, balance);
            }
            else {
               input.nextLine(); // discard the rest of the current record
            }
         }
      }
      catch (NoSuchElementException | IllegalStateException | 
         IOException e) {
         System.err.println("Error processing file. Terminating.");
         System.exit(1);
      } 
   } 

   // use record type to determine if record should be displayed
   private static boolean shouldDisplay(
      MenuOption option, double balance) {
      if ((option == MenuOption.CREDIT_BALANCE) && (balance < 0)) {
         return true;
      } 
      else if ((option == MenuOption.DEBIT_BALANCE) && (balance > 0)) {
         return true;
      } 
      else if ((option == MenuOption.ZERO_BALANCE) && (balance == 0)) {
         return true;
      } 

      return false;
   } 
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