// Fig. 7.6: BarChart.java
// Bar chart printing program.

public class BarChart {
   public static void main(String[] args) {
      int[] array = {0, 0, 0, 0, 0, 0, 1, 2, 4, 2, 1};

      System.out.println("Grade distribution:");

      // for each array element, output a bar of the chart
      for (int counter = 0; counter < array.length; counter++) {
         // output bar label ("00-09: ", ..., "90-99: ", "100: ")
         if (counter == 10) {
            System.out.printf("%5d: ", 100);
         } 
         else {
            System.out.printf("%02d-%02d: ", 
               counter * 10, counter * 10 + 9); 
         } 

         // print bar of asterisks                           
         for (int stars = 0; stars < array[counter]; stars++) {
            System.out.print("*");                           
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
