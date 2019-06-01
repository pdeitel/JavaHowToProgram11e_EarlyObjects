// Fig. 37.2: StreamMethods.java
// Java 9's new stream methods takeWhile, dropWhile, iterate 
// and ofNullable.
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethods {
   public static void main(String[] args) {
      int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

      System.out.printf("Array values contains: %s%n", 
         IntStream.of(values)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));

      // take the largest stream prefix of elements less than 6
      System.out.println("Demonstrating takeWhile and dropWhile:");
      System.out.printf("Elements less than 6: %s%n", 
         IntStream.of(values)
                  .takeWhile(e -> e < 6)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));

      // drop the largest stream prefix of elements less than 6
      System.out.printf("Elements 6 or greater: %s%n", 
         IntStream.of(values)
                  .dropWhile(e -> e < 6)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));

      // use iterate to generate stream of powers of 3 less than 10000
      System.out.printf("%nDemonstrating iterate:%n");
      System.out.printf("Powers of 3 less than 10,000: %s%n", 
         IntStream.iterate(3, n -> n < 10_000, n -> n * 3)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));

      // demonstrating ofNullable
      System.out.printf("%nDemonstrating ofNullable:%n");
      System.out.printf("Number of stream elements: %d%n", 
         Stream.ofNullable(null).count());
      System.out.printf("Number of stream elements: %d%n", 
         Stream.ofNullable("red").count());
   }  
}


/*
 **************************************************************************
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
 **************************************************************************
*/

