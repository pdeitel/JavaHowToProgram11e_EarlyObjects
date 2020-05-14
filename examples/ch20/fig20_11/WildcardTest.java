// Fig. 20.13: WildcardTest.java
// Wildcard test program.
import java.util.ArrayList;
import java.util.List;

public class WildcardTest {
   public static void main(String[] args) {
      // create, initialize and output List of Integers, then 
      // display total of the elements 
      Integer[] integers = {1, 2, 3, 4, 5};
      List<Integer> integerList = new ArrayList<>();

      // insert elements in integerList
      for (Integer element : integers) {
         integerList.add(element);
      }

      System.out.printf("integerList contains: %s%n", integerList);
      System.out.printf("Total of the elements in integerList: %.0f%n%n",
         sum(integerList));

      // create, initialize and output List of Doubles, then 
      // display total of the elements 
      Double[] doubles = {1.1, 3.3, 5.5};
      List<Double> doubleList = new ArrayList<>();

      // insert elements in doubleList
      for (Double element : doubles) {
         doubleList.add(element);
      }

      System.out.printf("doubleList contains: %s%n", doubleList);
      System.out.printf("Total of the elements in doubleList: %.1f%n%n", 
         sum(doubleList));

      // create, initialize and output List of Numbers containing 
      // both Integers and Doubles, then display total of the elements 
      Number[] numbers = {1, 2.4, 3, 4.1}; // Integers and Doubles
      List<Number> numberList = new ArrayList<>();

      // insert elements in numberList
      for (Number element : numbers) {
         numberList.add(element);
      }

      System.out.printf("numberList contains: %s%n", numberList);
      System.out.printf("Total of the elements in numberList: %.1f%n", 
         sum(numberList));
   }

   // total the elements; using a wildcard in the List parameter
   public static double sum(List<? extends Number> list) {
      double total = 0; // initialize total

      // calculate sum
      for (Number element : list) {
         total += element.doubleValue();
      }

      return total;
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