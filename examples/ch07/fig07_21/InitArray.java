// Fig. 7.21: InitArray.java
// Initializing an array using command-line arguments.

public class InitArray {
   public static void main(String[] args) {
      // check number of command-line arguments 
      if (args.length != 3) {
         System.out.printf(
            "Error: Please re-enter the entire command, including%n" +
            "an array size, initial value and increment.%n");
      }
      else {
         // get array size from first command-line argument
         int arrayLength = Integer.parseInt(args[0]); 
         int[] array = new int[arrayLength]; 

         // get initial value and increment from command-line arguments
         int initialValue = Integer.parseInt(args[1]);
         int increment = Integer.parseInt(args[2]);   

         // calculate value for each array element               
         for (int counter = 0; counter < array.length; counter++) {
            array[counter] = initialValue + increment * counter;   
         }

         System.out.printf("%s%8s%n", "Index", "Value");
         
         // display array index and value
         for (int counter = 0; counter < array.length; counter++) {
            System.out.printf("%5d%8d%n", counter, array[counter]);
         }
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
