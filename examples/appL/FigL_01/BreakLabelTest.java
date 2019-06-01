// Fig. L.1: BreakLabelTest.java
// Labeled break statement exiting a nested for statement.
public class BreakLabelTest {
   public static void main(String[] args) {
      stop: // labeled block
      {                     
         // count 10 rows
         for (int row = 1; row <= 10; row++) {
            // count 5 columns
            for (int column = 1; column <= 5 ; column++) {
               if (row == 5) { // if row is 5,
                  break stop;  // jump to end of stop block
               }

               System.out.print("* ");
            } 

            System.out.println(); // outputs a newline
         } 

         // following line is skipped
         System.out.println("\nLoops terminated normally");
      } // end labeled block
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
