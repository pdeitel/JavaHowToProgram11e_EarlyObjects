// Fig. 4.15: Increment.java
// Prefix increment and postfix increment operators.

public class Increment {
   public static void main(String[] args) {   
      // demonstrate postfix increment operator
      int c = 5; 
      System.out.printf("c before postincrement: %d%n", c); // prints 5
      System.out.printf("    postincrementing c: %d%n", c++); // prints 5
      System.out.printf(" c after postincrement: %d%n", c); // prints 6

      System.out.println(); // skip a line

      // demonstrate prefix increment operator
      c = 5; 
      System.out.printf(" c before preincrement: %d%n", c); // prints 5
      System.out.printf("     preincrementing c: %d%n", ++c); // prints 6
      System.out.printf("  c after preincrement: %d%n", c); // prints 6
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
