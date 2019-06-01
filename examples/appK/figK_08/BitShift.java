// Fig. K.8: BitShift.java
// Using the bitwise shift operators.
import java.util.Scanner;

public class BitShift {
   public static void main(String[] args) {
      int choice = 0; // store operation type
      int input = 0; // store input integer
      int result = 0; // store operation result
      Scanner scanner = new Scanner(System.in); // create Scanner

      // continue execution until user exit
      while (true) {
         // get shift operation
         System.out.println("\n\nPlease choose the shift operation:");
         System.out.println("1--Left Shift (<<)");
         System.out.println("2--Signed Right Shift (>>)");
         System.out.println("3--Unsigned Right Shift (>>>)");
         System.out.println("4--Exit");
         choice = scanner.nextInt();

         // perform shift operation
         switch (choice) {
            case 1: // <<
               System.out.println("Please enter an integer to shift:");
               input = scanner.nextInt(); // get input integer
               result = input << 1; // left shift one position
               System.out.printf("\n%d << 1 = %d", input, result);
               break;
            case 2: // >>
               System.out.println("Please enter an integer to shift:");
               input = scanner.nextInt(); // get input integer
               result = input >> 1; // signed right shift one position
               System.out.printf("\n%d >> 1 = %d", input, result);
               break;
            case 3: // >>>
               System.out.println("Please enter an integer to shift:");
               input = scanner.nextInt(); // get input integer
               result = input >>> 1; // unsigned right shift one position
               System.out.printf("\n%d >>> 1 = %d", input, result);  
               break;
            case 4: default: // default operation is <<
               System.exit(0); // exit application
         } 

         // display input integer and result in bits
         BitRepresentation.display(input); 
         BitRepresentation.display(result);
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
