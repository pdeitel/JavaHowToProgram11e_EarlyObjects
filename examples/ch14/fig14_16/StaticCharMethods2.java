// Fig. 14.16: StaticCharMethods2.java
// Character class static conversion methods.
import java.util.Scanner;

public class StaticCharMethods2 {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      // get radix
      System.out.println("Please enter a radix:");
      int radix = scanner.nextInt();

      // get user choice
      System.out.printf("Please choose one:\n1 -- %s\n2 -- %s\n",
         "Convert digit to character", "Convert character to digit");
      int choice = scanner.nextInt(); 

      // process request
      switch (choice) {
         case 1: // convert digit to character
            System.out.println("Enter a digit:");
            int digit = scanner.nextInt();
            System.out.printf("Convert digit to character: %s\n",
               Character.forDigit(digit, radix));
            break;
         case 2: // convert character to digit
            System.out.println("Enter a character:");
            char character = scanner.next().charAt(0);
            System.out.printf("Convert character to digit: %s\n",
               Character.digit(character, radix));
            break;
      } 
   } 
}

/**************************************************************************
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
