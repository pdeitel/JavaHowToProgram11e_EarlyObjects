// Fig. 7.22: ArrayManipulations.java
// Arrays class methods and System.arraycopy.
import java.util.Arrays;

public class ArrayManipulations {
   public static void main(String[] args) {
      // sort doubleArray into ascending order
      double[] doubleArray = {8.4, 9.3, 0.2, 7.9, 3.4};
      Arrays.sort(doubleArray); 
      System.out.printf("%ndoubleArray: ");

      for (double value : doubleArray) {
         System.out.printf("%.1f ", value);
      }

      // fill 10-element array with 7s
      int[] filledIntArray = new int[10]; 
      Arrays.fill(filledIntArray, 7);
      displayArray(filledIntArray, "filledIntArray");

      // copy array intArray into array intArrayCopy
      int[] intArray = {1, 2, 3, 4, 5, 6};
      int[] intArrayCopy = new int[intArray.length];
      System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
      displayArray(intArray, "intArray");
      displayArray(intArrayCopy, "intArrayCopy");

      // compare intArray and intArrayCopy for equality
      boolean b = Arrays.equals(intArray, intArrayCopy);
      System.out.printf("%n%nintArray %s intArrayCopy%n", 
         (b ? "==" : "!="));

      // compare intArray and filledIntArray for equality
      b = Arrays.equals(intArray, filledIntArray);
      System.out.printf("intArray %s filledIntArray%n", 
         (b ? "==" : "!="));

      // search intArray for the value 5
      int location = Arrays.binarySearch(intArray, 5);
      
      if (location >= 0) {
         System.out.printf(
            "Found 5 at element %d in intArray%n", location); 
      } 
      else {
         System.out.println("5 not found in intArray"); 
      } 

      // search intArray for the value 8763
      location = Arrays.binarySearch(intArray, 8763);

      if (location >= 0) {
         System.out.printf(
            "Found 8763 at element %d in intArray%n", location); 
      } 
      else {
         System.out.println("8763 not found in intArray"); 
      } 
   } 

   // output values in each array
   public static void displayArray(int[] array, String description) {
      System.out.printf("%n%s: ", description);

      for (int value : array) {
         System.out.printf("%d ", value);
      } 
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
