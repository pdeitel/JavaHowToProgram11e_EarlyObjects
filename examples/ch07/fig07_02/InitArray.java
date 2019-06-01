// Fig. 7.2: InitArray.java
// Initializing the elements of an array to default values of zero.

public class InitArray {
   public static void main(String[] args) {
      // declare variable array and initialize it with an array object
      int[] array = new int[10]; // create the array object           

      System.out.printf("%s%8s%n", "Index", "Value"); // column headings
   
      // output each array element's value                      
      for (int counter = 0; counter < array.length; counter++) {
         System.out.printf("%5d%8d%n", counter, array[counter]);
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
