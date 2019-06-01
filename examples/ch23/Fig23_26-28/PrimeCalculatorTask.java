// Fig. 23.26: PrimeCalculatorTask.java
// Calculates the first n primes, publishing them as they are found.
import java.util.Arrays;
import javafx.concurrent.Task;

public class PrimeCalculatorTask extends Task<Integer> {
   private final boolean[] primes; // boolean array for finding primes

   // constructor
   public PrimeCalculatorTask(int max) {
      primes = new boolean[max]; 
      Arrays.fill(primes, true); // initialize all primes elements to true
   } 

   // long-running code to be run in a worker thread
   @Override
   protected Integer call() {
      int count = 0; // the number of primes found

      // starting at index 2 (the first prime number), cycle through and
      // set to false elements with indices that are multiples of i
      for (int i = 2; i < primes.length; i++) {
         if (isCancelled()) { // if calculation has been canceled
            updateMessage("Cancelled");
            return 0;
         }
         else { 
            try { 
               Thread.sleep(10); // slow the thread 
            }  
            catch (InterruptedException ex) {
               updateMessage("Interrupted");
               return 0;
            } 

            updateProgress(i + 1, primes.length); 

            if (primes[i]) { // i is prime
               ++count;
               updateMessage(String.format("Found %d primes", count));
               updateValue(i); // intermediate result                 

               // eliminate multiples of i 
               for (int j = i + i; j < primes.length; j += i) {
                  primes[j] = false; // i is not prime
               }
            } 
         }  
      } 
      
      return 0;   
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