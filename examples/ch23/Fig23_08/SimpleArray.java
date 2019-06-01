// Fig. 23.8: SimpleArray.java
// Class that manages an integer array to be shared by multiple
// threads with synchronization.
import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray {
   private static final SecureRandom generator = new SecureRandom();
   private final int[] array; // the shared integer array
   private int writeIndex = 0; // index of next element to be written

   // construct a SimpleArray of a given size
   public SimpleArray(int size) {
      array = new int[size];
   } 

   // add a value to the shared array
   public synchronized void add(int value) {
      int position = writeIndex; // store the write index

      try {
         // in real applications, you shouldn't sleep while holding a lock
         Thread.sleep(generator.nextInt(500)); // for demo only 
      } 
      catch (InterruptedException ex) {
         Thread.currentThread().interrupt(); 
      } 

      // put value in the appropriate element
      array[position] = value;             
      System.out.printf("%s wrote %2d to element %d.%n", 
         Thread.currentThread().getName(), value, position);

      ++writeIndex; // increment index of element to be written next
      System.out.printf("Next write index: %d%n", writeIndex);
   } 
   
   // used for outputting the contents of the shared integer array
   @Override
   public synchronized String toString() {
      return Arrays.toString(array);
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