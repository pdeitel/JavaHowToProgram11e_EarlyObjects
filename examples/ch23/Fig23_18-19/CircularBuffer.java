// Fig. 23.18: CircularBuffer.java
// Synchronizing access to a shared three-element bounded buffer.
public class CircularBuffer implements Buffer {
   private final int[] buffer = {-1, -1, -1}; // shared buffer

   private int occupiedCells = 0; // count number of buffers used
   private int writeIndex = 0; // index of next element to write to
   private int readIndex = 0; // index of next element to read
   
   // place value into buffer
   @Override
   public synchronized void blockingPut(int value)
      throws InterruptedException {               
   
      // wait until buffer has space available, then write value; 
      // while no empty locations, place thread in blocked state  
      while (occupiedCells == buffer.length) {                    
         System.out.printf("Buffer is full. Producer waits.%n");  
         wait(); // wait until a buffer cell is free              
      }                                            

      buffer[writeIndex] = value; // set new buffer value

      // update circular write index
      writeIndex = (writeIndex + 1) % buffer.length;

      ++occupiedCells; // one more buffer cell is full
      displayState("Producer writes " + value);
      notifyAll(); // notify threads waiting to read from buffer
   }
    
   // return value from buffer
   @Override
   public synchronized int blockingGet() throws InterruptedException {
      // wait until buffer has data, then read value;
      // while no data to read, place thread in waiting state
      while (occupiedCells == 0) { 
         System.out.printf("Buffer is empty. Consumer waits.%n");
         wait(); // wait until a buffer cell is filled
      } 

      int readValue = buffer[readIndex]; // read value from buffer

      // update circular read index
      readIndex = (readIndex + 1) % buffer.length;

      --occupiedCells; // one fewer buffer cells are occupied
      displayState("Consumer reads " + readValue);
      notifyAll(); // notify threads waiting to write to buffer

      return readValue;
   } 
    
   // display current operation and buffer state
   public synchronized void displayState(String operation) {
      // output operation and number of occupied buffer cells
      System.out.printf("%s%s%d)%n%s", operation, 
         " (buffer cells occupied: ", occupiedCells, "buffer cells:  ");

      for (int value : buffer) {
         System.out.printf(" %2d  ", value); // output values in buffer
      }

      System.out.printf("%n               ");

      for (int i = 0; i < buffer.length; i++) {
         System.out.print("---- ");
      }

      System.out.printf("%n               ");

      for (int i = 0; i < buffer.length; i++) {
         if (i == writeIndex && i == readIndex) {
            System.out.print(" WR"); // both write and read index
         }
         else if (i == writeIndex) {
            System.out.print(" W   "); // just write index  
         }
         else if (i == readIndex) {
            System.out.print("  R  "); // just read index
         }
         else {
            System.out.print("     "); // neither index
         }
      } 

      System.out.printf("%n%n");
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