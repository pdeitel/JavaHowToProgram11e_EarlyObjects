// Fig. 20.9: StackTest2.java
// Passing generic Stack objects to generic methods.
import java.util.NoSuchElementException;
      
public class StackTest2 {
   public static void main(String[] args) {
      Double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
      Integer[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      // Create a Stack<Double> and a Stack<Integer>
      Stack<Double> doubleStack = new Stack<>(5); 
      Stack<Integer> integerStack = new Stack<>(); 

      // push elements of doubleElements onto doubleStack         
      testPush("doubleStack", doubleStack, doubleElements);       
      testPop("doubleStack", doubleStack); // pop from doubleStack
 
      // push elements of integerElements onto integerStack          
      testPush("integerStack", integerStack, integerElements);       
      testPop("integerStack", integerStack); // pop from integerStack
   }

   // generic method testPush pushes elements onto a Stack
   public static <E> void testPush(String name , Stack<E> stack,
      E[] elements) {                                           
      System.out.printf("%nPushing elements onto %s%n", name);

      // push elements onto Stack
      for (E element : elements) {
         System.out.printf("%s ", element);
         stack.push(element); // push element onto stack
      }
   } 

   // generic method testPop pops elements from a Stack
   public static <E> void testPop(String name, Stack<E> stack) {
      // pop elements from stack
      try {
         System.out.printf("%nPopping elements from %s%n", name);
         E popValue; // store element removed from stack

         // remove all elements from Stack
         while (true) {
            popValue = stack.pop(); 
            System.out.printf("%s ", popValue);
         }
      } 
      catch(NoSuchElementException noSuchElementException) {
         System.out.println();
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