// Fig. 20.8: StackTest.java
// Stack generic class test program.
import java.util.NoSuchElementException;

public class StackTest {
   public static void main(String[] args) {
      double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
      int[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      // Create a Stack<Double> and a Stack<Integer>
      Stack<Double> doubleStack = new Stack<>(5);   
      Stack<Integer> integerStack = new Stack<>();  

      // push elements of doubleElements onto doubleStack
      testPushDouble(doubleStack, doubleElements); 
      testPopDouble(doubleStack); // pop from doubleStack

      // push elements of integerElements onto integerStack
      testPushInteger(integerStack, integerElements); 
      testPopInteger(integerStack); // pop from integerStack
   } 

   // test push method with double stack
   private static void testPushDouble(
      Stack<Double> stack, double[] values) {
      System.out.printf("%nPushing elements onto doubleStack%n");

      // push elements to Stack
      for (double value : values) {
         System.out.printf("%.1f ", value);
         stack.push(value); // push onto doubleStack
      }
   }

   // test pop method with double stack
   private static void testPopDouble(Stack<Double> stack) {
      // pop elements from stack
      try {
         System.out.printf("%nPopping elements from doubleStack%n");
         double popValue; // store element removed from stack

         // remove all elements from Stack
         while (true) {
            popValue = stack.pop(); // pop from doubleStack
            System.out.printf("%.1f ", popValue); 
         } 
      }
      catch(NoSuchElementException noSuchElementException) {
         System.err.println();
         noSuchElementException.printStackTrace();
      } 
   }

   // test push method with integer stack
   private static void testPushInteger(
      Stack<Integer> stack, int[] values) {
      System.out.printf("%nPushing elements onto integerStack%n");

      // push elements to Stack
      for (int value : values) {
         System.out.printf("%d ", value);
         stack.push(value); // push onto integerStack
      } 
   }

   // test pop method with integer stack
   private static void testPopInteger(Stack<Integer> stack) {
      // pop elements from stack
      try {
         System.out.printf("%nPopping elements from integerStack%n");
         int popValue; // store element removed from stack

         // remove all elements from Stack
         while (true) {
            popValue = stack.pop(); // pop from intStack
            System.out.printf("%d ", popValue);
         } 
      } 
      catch(NoSuchElementException noSuchElementException) {
         System.err.println();
         noSuchElementException.printStackTrace();
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