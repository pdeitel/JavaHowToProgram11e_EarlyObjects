// Fig. 21.11: Queue.java
// Queue uses class List.
package com.deitel.datastructures;

import java.util.NoSuchElementException;

public class Queue<E> {
   private List<E> queueList;

   // constructor
   public Queue() {queueList = new List<E>("queue");}

   // add object to queue
   public void enqueue(E object) {queueList.insertAtBack(object);}

   // remove object from queue
   public E dequeue() throws NoSuchElementException {
      return queueList.removeFromFront(); 
   } 

   // determine if queue is empty
   public boolean isEmpty() {return queueList.isEmpty();}

   // output queue contents
   public void print() {queueList.print();}
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
