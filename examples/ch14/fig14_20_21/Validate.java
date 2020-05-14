// Fig. 14.21: Validate.java
// Input and validate data from user using the ValidateInput class.
import java.util.Scanner;

public class Validate {
   public static void main(String[] args) {
      // get user input
      Scanner scanner = new Scanner(System.in);
      System.out.println("Please enter first name:");
      String firstName = scanner.nextLine();
      System.out.println("Please enter last name:");
      String lastName = scanner.nextLine();
      System.out.println("Please enter address:");
      String address = scanner.nextLine();
      System.out.println("Please enter city:");
      String city = scanner.nextLine();
      System.out.println("Please enter state:");
      String state = scanner.nextLine();
      System.out.println("Please enter zip:");
      String zip = scanner.nextLine();
      System.out.println("Please enter phone:");
      String phone = scanner.nextLine();

      // validate user input and display error message
      System.out.println("\nValidate Result:");

      if (!ValidateInput.validateFirstName(firstName)) {
         System.out.println("Invalid first name");
      }
      else if (!ValidateInput.validateLastName(lastName)) {
         System.out.println("Invalid last name");
      }
      else if (!ValidateInput.validateAddress(address)) {
         System.out.println("Invalid address");
      }
      else if (!ValidateInput.validateCity(city)) {
         System.out.println("Invalid city");
      }
      else if (!ValidateInput.validateState(state)) {
         System.out.println("Invalid state");
      }
      else if (!ValidateInput.validateZip(zip)) {
         System.out.println("Invalid zip code");
      }
      else if (!ValidateInput.validatePhone(phone)) {
         System.out.println("Invalid phone number");
      }
      else {
         System.out.println("Valid input.  Thank you.");
      }
   } 
}

/*
 **************************************************************************
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
 **************************************************************************
*/

