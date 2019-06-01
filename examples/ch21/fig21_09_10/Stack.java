// Fig. 21.9: Stack.java
// Stack uses a composed List object.
package com.deitel.datastructures;

import java.util.NoSuchElementException;

public class Stack<E> {
   private List<E> stackList;

   // constructor
   public Stack() {stackList = new List<E>("stack");} 

   // add object to stack
   public void push(E object) {stackList.insertAtFront(object);}

   // remove object from stack
   public E pop() throws NoSuchElementException {
      return stackList.removeFromFront(); 
   } 

   // determine if stack is empty
   public boolean isEmpty() {return stackList.isEmpty();}

   // output stack contents
   public void print() {stackList.print();}
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
