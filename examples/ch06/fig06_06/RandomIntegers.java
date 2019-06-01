// Fig. 6.6: RandomIntegers.java
// Shifted and scaled random integers.
import java.security.SecureRandom; // program uses class SecureRandom

public class RandomIntegers {
   public static void main(String[] args) {
      // randomNumbers object will produce secure random numbers
      SecureRandom randomNumbers = new SecureRandom();          

      // loop 20 times
      for (int counter = 1; counter <= 20; counter++) {
         // pick random integer from 1 to 6    
         int face = 1 + randomNumbers.nextInt(6);

         System.out.printf("%d  ", face); // display generated value
         
         // if counter is divisible by 5, start a new line of output
         if (counter % 5 == 0) {
            System.out.println();
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
