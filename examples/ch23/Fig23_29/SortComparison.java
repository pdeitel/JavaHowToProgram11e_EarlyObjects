// Fig. 23.29: SortComparison.java
// Comparing performance of Arrays methods sort and parallelSort.
import java.time.Duration;
import java.time.Instant;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;

public class SortComparison {
   public static void main(String[] args) {
      Random random = new Random();

      // create array of random ints, then copy it
      int[] array1 = random.ints(100_000_000).toArray();
      int[] array2 = array1.clone();

      // time the sorting of array1 with Arrays method sort 
      System.out.println("Starting sort");
      Instant sortStart = Instant.now();
      Arrays.sort(array1);              
      Instant sortEnd = Instant.now();  

      // display timing results
      long sortTime = Duration.between(sortStart, sortEnd).toMillis();
      System.out.printf("Total time in milliseconds: %d%n%n", sortTime);

      // time the sorting of array2 with Arrays method parallelSort
      System.out.println("Starting parallelSort");
      Instant parallelSortStart = Instant.now();
      Arrays.parallelSort(array2);              
      Instant parallelSortEnd = Instant.now();  

      // display timing results
      long parallelSortTime = 
         Duration.between(parallelSortStart, parallelSortEnd).toMillis();
      System.out.printf("Total time in milliseconds: %d%n%n", 
         parallelSortTime);

      // display time difference as a percentage
      String percentage = NumberFormat.getPercentInstance().format(
         (double) (sortTime - parallelSortTime) / parallelSortTime);                    
      System.out.printf("sort took %s more time than parallelSort%n", 
         percentage);
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