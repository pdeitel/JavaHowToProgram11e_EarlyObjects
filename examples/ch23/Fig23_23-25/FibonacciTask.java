// Fig. 23.24: FibonacciTask.java
// Task subclass for calculating Fibonacci numbers in the background
import javafx.concurrent.Task;

public class FibonacciTask extends Task<Long> {
   private final int n; // Fibonacci number to calculate

   // constructor
   public FibonacciTask(int n) {
      this.n = n;
   } 

   // long-running code to be run in a worker thread
   @Override
   protected Long call() {
      updateMessage("Calculating...");
      long result = fibonacci(n);
      updateMessage("Done calculating."); 
      return result;
   } 

   // recursive method fibonacci; calculates nth Fibonacci number
   public long fibonacci(long number) {
      if (number == 0 || number == 1) {
         return number;
      }
      else {
         return fibonacci(number - 1) + fibonacci(number - 2);
      }
   }
} 

/*************************************************************************
* (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
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