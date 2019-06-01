// Fig. 18.5: FactorialCalculator.java
// Recursive factorial method.
import java.math.BigInteger;

public class FactorialCalculator {
   // recursive method factorial (assumes its parameter is >= 0)
   public static BigInteger factorial(BigInteger number) {
      if (number.compareTo(BigInteger.ONE) <= 0) { // test base case
         return BigInteger.ONE; // base cases: 0! = 1 and 1! = 1
      }
      else {// recursion step
         return number.multiply(
            factorial(number.subtract(BigInteger.ONE)));
      }
   } 

   public static void main(String[] args) {
      // calculate the factorials of 0 through 50
      for (int counter = 0; counter <= 50; counter++) {
         System.out.printf("%d! = %d%n", counter, 
            factorial(BigInteger.valueOf(counter)));
      }
   } 
} 

/*************************************************************************
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