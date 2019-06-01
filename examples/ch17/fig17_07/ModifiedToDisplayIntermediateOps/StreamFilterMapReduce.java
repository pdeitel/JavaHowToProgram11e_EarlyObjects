// Fig. 17.7: StreamFilterMapReduce.java
// Triple the even ints from 2 through 10 then sum them with IntStream.
import java.util.stream.IntStream;

public class StreamFilterMapReduce {
   public static void main(String[] args) {
      // sum the triples of the even integers from 2 through 10
      System.out.printf(
         "Sum of the triples of the even ints from 2 through 10 is: %d%n",
         IntStream.rangeClosed(1, 10)
                  .filter(
                     x -> {
                        System.out.printf("%nfilter: %d%n", x); 
                        return x % 2 == 0;
                     })
                  .map(
                     x -> {
                        System.out.println("map: " + x); 
                        return x * 3;
                     })
                  .sum());      
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
