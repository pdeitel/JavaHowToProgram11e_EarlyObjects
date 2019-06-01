// Fig. 21.12: QueueTest.java
// Class QueueTest.
import com.deitel.datastructures.Queue;
import java.util.NoSuchElementException;

public class QueueTest {
   public static void main(String[] args) {
      Queue<Integer> queue = new Queue<>();

      // use enqueue method
      queue.enqueue(-1);   
      queue.print();       
      queue.enqueue(0);    
      queue.print();       
      queue.enqueue(1);    
      queue.print();       
      queue.enqueue(5);    
      queue.print();       

      // remove objects from queue
      boolean continueLoop = true;

      while (continueLoop) {
         try {
            int removedItem = queue.dequeue(); // remove head element
            System.out.printf("%n%d dequeued%n", removedItem);
            queue.print();
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
