// Fig. 18.9: FactorialCalculator.java
// Iterative factorial method.

public class FactorialCalculator {
   // iterative declaration of method factorial   
   public static long factorial(long number) {
      long result = 1;

      // iteratively calculate factorial
      for (long i = number; i >= 1; i--) {
         result *= i;
      }

      return result;
   } 

   public static void main(String[] args) {
      // calculate the factorials of 0 through 10
      for (int counter = 0; counter <= 10; counter++) {
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