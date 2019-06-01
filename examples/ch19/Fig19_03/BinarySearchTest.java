// Fig. 19.3: BinarySearchTest.java
// Use binary search to locate an item in an array.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {
   // perform a binary search on the data      
   public static int binarySearch(int[] data, int key) {
      int low = 0; // low end of the search area                
      int high = data.length - 1; // high end of the search area
      int middle = (low + high + 1) / 2; // middle element      
      int location = -1; // return value; -1 if not found 

      do { // loop to search for element
         // print remaining elements of array
         System.out.print(remainingElements(data, low, high));

         // output spaces for alignment
         for (int i = 0; i < middle; i++) {
            System.out.print("   ");
         }
         System.out.println(" * "); // indicate current middle

         // if the element is found at the middle                    
         if (key == data[middle]) {                                  
            location = middle; // location is the current middle     
         }                                                           
         else if (key < data[middle]) { // middle element is too high
            high = middle - 1; // eliminate the higher half          
         }                                                           
         else { // middle element is too low                         
            low = middle + 1; // eliminate the lower half            
         }                                                           

         middle = (low + high + 1) / 2; // recalculate the middle
      } while ((low <= high) && (location == -1));               

      return location; // return location of search key
   }                         

   // method to output certain values in array
   private static String remainingElements(
      int[] data, int low, int high) {
      StringBuilder temporary = new StringBuilder();

      // append spaces for alignment
      for (int i = 0; i < low; i++) {
         temporary.append("   ");
      }                         

      // append elements left in array 
      for (int i = low; i <= high; i++) {
         temporary.append(data[i] + " ");
      }                         

      return String.format("%s%n", temporary);
   } 

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      SecureRandom generator = new SecureRandom();

      // create array of 15 random integers in sorted order
      int[] data = generator.ints(15, 10, 91).sorted().toArray();
      System.out.printf("%s%n%n", Arrays.toString(data)); // display array

      // get input from user
      System.out.print("Please enter an integer value (-1 to quit): ");
      int searchInt = input.nextInt(); 

      // repeatedly input an integer; -1 terminates the program
      while (searchInt != -1) {
         // perform search
         int location = binarySearch(data, searchInt);

         if (location == -1) { // not found
            System.out.printf("%d was not found%n%n", searchInt); 
         }                          
         else { // found
            System.out.printf("%d was found in position %d%n%n", 
               searchInt, location);
         }                         
 
         // get input from user
         System.out.print("Please enter an integer value (-1 to quit): ");
         searchInt = input.nextInt();
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