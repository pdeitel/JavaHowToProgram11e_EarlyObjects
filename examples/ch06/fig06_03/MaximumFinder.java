// Fig. 6.3: MaximumFinder.java
// Programmer-declared method maximum with three double parameters.
import java.util.Scanner;

public class MaximumFinder {
   public static void main(String[] args) {
      // create Scanner for input from command window
      Scanner input = new Scanner(System.in);

      // prompt for and input three floating-point values
      System.out.print(
         "Enter three floating-point values separated by spaces: ");
      double number1 = input.nextDouble(); // read first double
      double number2 = input.nextDouble(); // read second double
      double number3 = input.nextDouble(); // read third double

      // determine the maximum value
      double result = maximum(number1, number2, number3); 

      // display maximum value 
      System.out.println("Maximum is: " + result);
   } 

   // returns the maximum of its three double parameters          
   public static double maximum(double x, double y, double z) {   
      double maximumValue = x; // assume x is the largest to start
                                                                  
      // determine whether y is greater than maximumValue         
      if (y > maximumValue) {                                     
         maximumValue = y;                                        
      }                                                           
                                                                  
      // determine whether z is greater than maximumValue         
      if (z > maximumValue) {                                     
         maximumValue = z;                                        
      }                                                           
                                                                  
      return maximumValue;                                        
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
