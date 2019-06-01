// Fig. L.2: ContinueLabelTest.java
// Labeled continue statement terminating a nested for statement.
public class ContinueLabelTest {
   public static void main(String[] args) {
      nextRow: // target label of continue statement
         // count 5 rows
         for (int row = 1; row <= 5; row++) {
            System.out.println(); // outputs a newline
  
            // count 10 columns per row
            for (int column = 1; column <= 10; column++) {
               // if column greater than row, start next row
               if (column > row) {
                  continue nextRow; // next iteration of labeled loop
               }
   
               System.out.print("* ");
            } 
         }

      System.out.println(); // outputs a newline
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
