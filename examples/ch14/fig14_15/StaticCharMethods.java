// Fig. 14.15: StaticCharMethods.java
// Character static methods for testing characters and converting case.
import java.util.Scanner;

public class StaticCharMethods {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in); // create scanner
      System.out.println("Enter a character and press Enter");
      String input = scanner.next(); 
      char c = input.charAt(0); // get input character

      // display character info
      System.out.printf("is defined: %b\n", Character.isDefined(c));
      System.out.printf("is digit: %b\n", Character.isDigit(c));
      System.out.printf("is first character in a Java identifier: %b\n",
         Character.isJavaIdentifierStart(c));
      System.out.printf("is part of a Java identifier: %b\n",
         Character.isJavaIdentifierPart(c));
      System.out.printf("is letter: %b\n", Character.isLetter(c));
      System.out.printf(
         "is letter or digit: %b\n", Character.isLetterOrDigit(c));
      System.out.printf(
         "is lower case: %b\n", Character.isLowerCase(c));
      System.out.printf(
         "is upper case: %b\n", Character.isUpperCase(c));
      System.out.printf(
         "to upper case: %s\n", Character.toUpperCase(c));
      System.out.printf(
         "to lower case: %s\n", Character.toLowerCase(c));
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
