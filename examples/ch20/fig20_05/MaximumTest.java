// Fig. 20.5: MaximumTest.java
// Generic method maximum returns the largest of three objects.

public class MaximumTest {
   public static void main(String[] args) {
      System.out.printf("Maximum of %d, %d and %d is %d%n", 3, 4, 5, 
         maximum(3, 4, 5));
      System.out.printf("Maximum of %.1f, %.1f and %.1f is %.1f%n", 
         6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
      System.out.printf("Maximum of %s, %s and %s is %s%n", "pear", 
         "apple", "orange", maximum("pear", "apple", "orange"));
   } 

   // determines the largest of three Comparable objects                 
   public static <T extends Comparable<T>> T maximum(T x, T y, T z) {    
      T max = x; // assume x is initially the largest                    
                                                                         
      if (y.compareTo(max) > 0) {                                        
         max = y; // y is the largest so far                             
      }                                                                  
                                                                         
      if (z.compareTo(max) > 0) {                                        
         max = z; // z is the largest                                    
      }                                                                  
                                                                         
      return max; // returns the largest object                          
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