// Fig. 21.10: StackTest.java
// Stack manipulation program.
import com.deitel.datastructures.Stack;
import java.util.NoSuchElementException;

public class StackTest {
   public static void main(String[] args) {
      Stack<Integer> stack = new Stack<>();

      // use push method
      stack.push(-1);   
      stack.print();    
      stack.push(0);    
      stack.print();    
      stack.push(1);    
      stack.print();    
      stack.push(5);    
      stack.print();    

      // remove items from stack
      boolean continueLoop = true;

      while (continueLoop) {
         try {
            int removedItem = stack.pop(); // remove top element
            System.out.printf("%n%d popped%n", removedItem);
            stack.print();
         } 
         catch (NoSuchElementException noSuchElementException) {
            continueLoop = false;
            noSuchElementException.printStackTrace();
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
