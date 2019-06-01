// Fig. 23.16: SynchronizedBuffer.java
// Synchronizing access to shared mutable data using Object 
// methods wait and notifyAll.
public class SynchronizedBuffer implements Buffer {
   private int buffer = -1; // shared by producer and consumer threads
   private boolean occupied = false; 
   
   // place value into buffer
   @Override
   public synchronized void blockingPut(int value)
      throws InterruptedException {               
      // while there are no empty locations, place thread in waiting state
      while (occupied) {
         // output thread information and buffer information, then wait
         System.out.println("Producer tries to write."); // for demo only
         displayState("Buffer full. Producer waits."); // for demo only
         wait();
      } 
        
      buffer = value; // set new buffer value
        
      // indicate producer cannot store another value 
      // until consumer retrieves current buffer value
      occupied = true;                                
        
      displayState("Producer writes " + buffer); // for demo only
      
      notifyAll(); // tell waiting thread(s) to enter runnable state
   } // end method blockingPut; releases lock on SynchronizedBuffer 
    
   // return value from buffer
   @Override
   public synchronized int blockingGet() throws InterruptedException {
      // while no data to read, place thread in waiting state
      while (!occupied) {
         // output thread information and buffer information, then wait
         System.out.println("Consumer tries to read."); // for demo only
         displayState("Buffer empty. Consumer waits."); // for demo only
         wait();
      } 

      // indicate that producer can store another value
      // because consumer just retrieved buffer value  
      occupied = false;                                

      displayState("Consumer reads " + buffer); // for demo only
      
      notifyAll(); // tell waiting thread(s) to enter runnable state

      return buffer;
   } // end method blockingGet; releases lock on SynchronizedBuffer 
    
   // display current operation and buffer state; for demo only
   private synchronized void displayState(String operation) {
      System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
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