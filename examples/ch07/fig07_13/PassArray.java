// Fig. 7.13: PassArray.java
// Passing arrays and individual array elements to methods.

public class PassArray {
   // main creates array and calls modifyArray and modifyElement
   public static void main(String[] args) {
      int[] array = {1, 2, 3, 4, 5};
      
      System.out.printf(
         "Effects of passing reference to entire array:%n" +
         "The values of the original array are:%n");

      // output original array elements 
      for (int value : array) {
         System.out.printf("   %d", value);
      }
   
      modifyArray(array); // pass array reference
      System.out.printf("%n%nThe values of the modified array are:%n");

      // output modified array elements 
      for (int value : array) {
         System.out.printf("   %d", value);
      }
   
      System.out.printf(
         "%n%nEffects of passing array element value:%n" +
         "array[3] before modifyElement: %d%n", array[3]);
   
      modifyElement(array[3]); // attempt to modify array[3]
      System.out.printf(
         "array[3] after modifyElement: %d%n", array[3]);
   } 
   
   // multiply each element of an array by 2                     
   public static void modifyArray(int[] array2) {                
      for (int counter = 0; counter < array2.length; counter++) {
         array2[counter] *= 2;                                   
      }                                                          
   }                                                             
   
   // multiply argument by 2                                  
   public static void modifyElement(int element) {            
      element *= 2;                                           
      System.out.printf(                                      
         "Value of element in modifyElement: %d%n", element); 
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
