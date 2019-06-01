// Ex. 2.6: Product.java
// Calculate the product of three integers.
import java.util.Scanner; // program uses Scanner

public class Product {
   public static void main(String[] args) {
      // create Scanner to obtain input from command window
      Scanner input = new Scanner(System.in);

      System.out.print("Enter first integer: "); // prompt for input
      int x = input.nextInt(); // read first integer

      System.out.print("Enter second integer: "); // prompt for input
      int y = input.nextInt(); // read second integer
      
      System.out.print("Enter third integer: "); // prompt for input
      int z = input.nextInt(); // read third integer

      int result = x * y * z; // calculate product of numbers

      System.out.printf("Product is %d%n", result);
   } // end method main
} // end class Product


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