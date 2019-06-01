// Fig K.5: BitRepresentation.java
// Utility class that displays bit representation of an integer.

public class BitRepresentation {
   // display bit representation of specified int value
   public static void display(int value) {
      System.out.printf("\nBit representation of %d is: \n", value);

      // create int value with 1 in leftmost bit and 0s elsewhere
      int displayMask = 1 << 31;

      // for each bit display 0 or 1 
      for (int bit = 1; bit <= 32; bit++) {
         // use displayMask to isolate bit
         System.out.print((value & displayMask) == 0 ? '0' : '1');

         value <<= 1; // shift value one position to left 

         if (bit % 8 == 0) {
            System.out.print(' '); // display space every 8 bits
         } 
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

