// Fig. 7.17: InitArray.java
// Initializing two-dimensional arrays.

public class InitArray {
   // create and output two-dimensional arrays
   public static void main(String[] args) {
      int[][] array1 = {{1, 2, 3}, {4, 5, 6}};  
      int[][] array2 = {{1, 2}, {3}, {4, 5, 6}};

      System.out.println("Values in array1 by row are");
      outputArray(array1); // displays array1 by row
   
      System.out.printf("%nValues in array2 by row are%n");
      outputArray(array2); // displays array2 by row
   } 

   // output rows and columns of a two-dimensional array
   public static void outputArray(int[][] array) {
      // loop through array's rows                                   
      for (int row = 0; row < array.length; row++) {                 
         // loop through columns of current row                      
         for (int column = 0; column < array[row].length; column++) {
            System.out.printf("%d  ", array[row][column]);           
         }                                                           
                                                                     
         System.out.println();                                       
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
