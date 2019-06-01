// Fig. 23.10: Producer.java
// Producer with a run method that inserts the values 1 to 10 in buffer.
import java.security.SecureRandom;

public class Producer implements Runnable {
   private static final SecureRandom generator = new SecureRandom();
   private final Buffer sharedLocation; // reference to shared object

   // constructor
   public Producer(Buffer sharedLocation) {
      this.sharedLocation = sharedLocation;
   } 

   // store values from 1 to 10 in sharedLocation
   @Override
   public void run() {                           
      int sum = 0;

      for (int count = 1; count <= 10; count++) {
         try { // sleep 0 to 3 seconds, then place value in Buffer
            Thread.sleep(generator.nextInt(3000)); // random sleep   
            sharedLocation.blockingPut(count); // set value in buffer
            sum += count; // increment sum of values
            System.out.printf("\t%2d%n", sum);
         } 
         catch (InterruptedException exception) {
            Thread.currentThread().interrupt(); 
         } 
      } 

      System.out.printf(
         "Producer done producing%nTerminating Producer%n");
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