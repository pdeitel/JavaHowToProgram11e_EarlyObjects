// Fig. 23.12: UnsynchronizedBuffer.java
// UnsynchronizedBuffer maintains the shared integer that is accessed by 
// a producer thread and a consumer thread.
public class UnsynchronizedBuffer implements Buffer {
   private int buffer = -1; // shared by producer and consumer threads

   // place value into buffer
   @Override
   public void blockingPut(int value) throws InterruptedException {
      System.out.printf("Producer writes\t%2d", value);
      buffer = value;
   } 

   // return value from buffer
   @Override
   public int blockingGet() throws InterruptedException {
      System.out.printf("Consumer reads\t%2d", buffer);
      return buffer;
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