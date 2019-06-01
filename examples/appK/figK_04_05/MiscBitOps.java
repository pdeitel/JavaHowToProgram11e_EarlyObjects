// Fig. K.4: MiscBitOps.java
// Using the bitwise operators.
import java.util.Scanner;

public class MiscBitOps { 
   public static void main(String[] args) {
      int choice = 0; // store operation type	
      int first = 0; // store first input integer
      int second = 0; // store second input integer
      int result = 0; // store operation result
      Scanner scanner = new Scanner(System.in); // create Scanner

      // continue execution until user exit
      while (true) {
         // get selected operation
         System.out.println("\n\nPlease choose the operation:");
         System.out.printf("%s%s", "1--AND\n2--Inclusive OR\n", 
            "3--Exclusive OR\n4--Complement\n5--Exit\n");
         choice = scanner.nextInt();

         // perform bitwise operation
         switch (choice) {
            case 1: // AND
               System.out.print("Please enter two integers:");
               first = scanner.nextInt(); // get first input integer
               BitRepresentation.display(first); 
               second = scanner.nextInt(); // get second input integer
               BitRepresentation.display(second); 
               result = first & second; // perform bitwise AND
               System.out.printf(
                  "\n\n%d & %d = %d", first, second, result);
               BitRepresentation.display(result); 
               break;
            case 2: // Inclusive OR
               System.out.print("Please enter two integers:");
               first = scanner.nextInt(); // get first input integer
               BitRepresentation.display(first); 
               second = scanner.nextInt(); // get second input integer
               BitRepresentation.display(second); 
               result = first | second; // perform bitwise inclusive OR
               System.out.printf(
                  "\n\n%d | %d = %d", first, second, result);
               BitRepresentation.display(result); 
               break;
            case 3: // Exclusive OR
               System.out.print("Please enter two integers:");
               first = scanner.nextInt(); // get first input integer
               BitRepresentation.display(first); 
               second = scanner.nextInt(); // get second input integer
               BitRepresentation.display(second); 
               result = first ^ second; // perform bitwise exclusive OR
               System.out.printf(
                  "\n\n%d ^ %d = %d", first, second, result); 
               BitRepresentation.display(result);
               break;
            case 4: // Complement
               System.out.print("Please enter one integer:");
               first = scanner.nextInt(); // get input integer
               BitRepresentation.display(first); 
               result = ~first; // perform bitwise complement on first
               System.out.printf("\n\n~%d = %d", first, result);
               BitRepresentation.display(result); 
               break;
            case 5: default: 
               System.exit(0); // exit application
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
