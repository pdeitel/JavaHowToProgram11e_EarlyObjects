// Fig. K.10: BitSetTest.java
// Using a BitSet to demonstrate the Sieve of Eratosthenes.
import java.util.BitSet;
import java.util.Scanner;

public class BitSetTest {
   public static void main(String[] args) {
      // get input integer
      Scanner scanner = new Scanner(System.in);
      System.out.println("Please enter an integer from 2 to 1023");
      int input = scanner.nextInt();

      // perform Sieve of Eratosthenes  
      BitSet sieve = new BitSet(1024);
      int size = sieve.size();          

      // set all bits from 2 to 1023
      for (int i = 2; i < size; i++) {
         sieve.set(i);
      }

      // perform Sieve of Eratosthenes
      int finalBit = (int) Math.sqrt(size);

      for (int i = 2; i < finalBit; i++) {
         if (sieve.get(i)) {
            for (int j = 2 * i; j < size; j += i) {
               sieve.clear(j);
            } 
         } 
      } 

      int counter = 0; 

      // display prime numbers from 2 to 1023
      for (int i = 2; i < size; i++) {
         if (sieve.get(i)) {
            System.out.print(String.valueOf(i));
            System.out.print(++counter % 7 == 0 ? "\n" : "\t");
         } 
      } 

      // display result
      if (sieve.get(input)) {
         System.out.printf("\n%d is a prime number", input);
      } 
      else {
         System.out.printf("\n%d is not a prime number", input);
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
