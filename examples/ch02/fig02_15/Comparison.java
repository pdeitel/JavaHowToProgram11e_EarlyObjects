// Fig. 2.15: Comparison.java
// Compare integers using if statements, relational operators 
// and equality operators.
import java.util.Scanner; // program uses class Scanner

public class Comparison {
   // main method begins execution of Java application
   public static void main(String[] args) {
      // create Scanner to obtain input from command line
      Scanner input = new Scanner(System.in);

      System.out.print("Enter first integer: "); // prompt 
      int number1 = input.nextInt(); // read first number from user 

      System.out.print("Enter second integer: "); // prompt 
      int number2 = input.nextInt(); // read second number from user 
      
      if (number1 == number2) {
         System.out.printf("%d == %d%n", number1, number2);
	  }

      if (number1 != number2) {
         System.out.printf("%d != %d%n", number1, number2);
	  }

      if (number1 < number2) {
         System.out.printf("%d < %d%n", number1, number2);
	  }

      if (number1 > number2) {
         System.out.printf("%d > %d%n", number1, number2);
	  }

      if (number1 <= number2) {
         System.out.printf("%d <= %d%n", number1, number2);
	  }

      if (number1 >= number2) {
         System.out.printf("%d >= %d%n", number1, number2);
	  }
   } // end method main
} // end class Comparison

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
