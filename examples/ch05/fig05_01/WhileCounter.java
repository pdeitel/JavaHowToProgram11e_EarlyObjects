// Fig. 5.1: WhileCounter.java
// Counter-controlled iteration with the while iteration statement.

public class WhileCounter {
   public static void main(String[] args) {
      int counter = 1; // declare and initialize control variable

      while (counter <= 10) { // loop-continuation condition
         System.out.printf("%d  ", counter);
         ++counter; // increment control variable
      }

      System.out.println(); 
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
