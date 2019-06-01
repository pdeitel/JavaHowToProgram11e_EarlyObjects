// Fig. 23.20: SynchronizedBuffer.java
// Synchronizing access to a shared integer using the Lock and Condition
// interfaces
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class SynchronizedBuffer implements Buffer {
   // Lock to control synchronization with this buffer 
   private final Lock accessLock = new ReentrantLock();

   // conditions to control reading and writing                 
   private final Condition canWrite = accessLock.newCondition();
   private final Condition canRead = accessLock.newCondition(); 

   private int buffer = -1; // shared by producer and consumer threads
   private boolean occupied = false; // whether buffer is occupied
   
   // place int value into buffer
   @Override
   public void blockingPut(int value) throws InterruptedException {
      accessLock.lock(); // lock this object

      // output thread information and buffer information, then wait
      try {
         // while buffer is not empty, place thread in waiting state
         while (occupied) {
            System.out.println("Producer tries to write.");
            displayState("Buffer full. Producer waits.");
            canWrite.await(); // wait until buffer is empty
         } 

         buffer = value; // set new buffer value

         // indicate producer cannot store another value
         // until consumer retrieves current buffer value
         occupied = true;
        
         displayState("Producer writes " + buffer);

         // signal any threads waiting to read from buffer
         canRead.signalAll();                             
      } 
      finally {
         accessLock.unlock(); // unlock this object
      }
   } 
    
   // return value from buffer
   @Override
   public int blockingGet() throws InterruptedException {
      int readValue = 0; // initialize value read from buffer
      accessLock.lock(); // lock this object

      // output thread information and buffer information, then wait
      try {
         // if there is no data to read, place thread in waiting state
         while (!occupied) {
            System.out.println("Consumer tries to read.");
            displayState("Buffer empty. Consumer waits.");
            canRead.await(); // wait until buffer is full
         } 

         // indicate that producer can store another value 
         // because consumer just retrieved buffer value
         occupied = false;

         readValue = buffer; // retrieve value from buffer
         displayState("Consumer reads " + readValue);

         // signal any threads waiting for buffer to be empty
         canWrite.signalAll();                               
      } 
      finally {
         accessLock.unlock(); // unlock this object
      } 

      return readValue;
   } 
    
   // display current operation and buffer state
   private void displayState(String operation) {
      try {
         accessLock.lock(); // lock this object
         System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, 
            occupied);
      }
      finally {
         accessLock.unlock(); // unlock this objects
      }
   }
}



/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
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