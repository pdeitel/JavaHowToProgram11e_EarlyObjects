// Fig. 17.9: IntStreamOperations.java
// Demonstrating IntStream operations.
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {
   public static void main(String[] args) {
      int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

      // display original values
      System.out.print("Original values: ");
      System.out.println(
         IntStream.of(values)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));

      // count, min, max, sum and average of the values
      System.out.printf("%nCount: %d%n", IntStream.of(values).count());
      System.out.printf("Min: %d%n",
         IntStream.of(values).min().getAsInt());
      System.out.printf("Max: %d%n",
         IntStream.of(values).max().getAsInt());
      System.out.printf("Sum: %d%n", IntStream.of(values).sum());
      System.out.printf("Average: %.2f%n",
         IntStream.of(values).average().getAsDouble());

      // sum of values with reduce method
      System.out.printf("%nSum via reduce method: %d%n",
         IntStream.of(values)
                  .reduce(0, (x, y) -> x + y));

      // product of values with reduce method
      System.out.printf("Product via reduce method: %d%n",
         IntStream.of(values)
                  .reduce((x, y) -> x * y).getAsInt());

      // sum of squares of values with map and sum methods
      System.out.printf("Sum of squares via map and sum: %d%n%n",
         IntStream.of(values)
                  .map(x -> x * x)
                  .sum());        

      // displaying the elements in sorted order
      System.out.printf("Values displayed in sorted order: %s%n",
         IntStream.of(values)
                  .sorted()
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));
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
