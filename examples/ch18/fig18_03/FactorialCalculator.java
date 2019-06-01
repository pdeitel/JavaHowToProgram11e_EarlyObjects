// Fig. 18.3: FactorialCalculator.java
// Recursive factorial method.

public class FactorialCalculator {
   // recursive method factorial (assumes its parameter is >= 0)
   public static long factorial(long number) {
      if (number <= 1) { // test for base case
         return 1; // base cases: 0! = 1 and 1! = 1
      }
      else { // recursion step
         return number * factorial(number - 1);
      }
   } 

   public static void main(String[] args) {
      // calculate the factorials of 0 through 21
      for (int counter = 0; counter <= 21; counter++) {
         System.out.printf("%d! = %d%n", counter, factorial(counter));
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