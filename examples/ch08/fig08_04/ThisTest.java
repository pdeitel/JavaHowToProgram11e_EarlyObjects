// Fig. 8.4: ThisTest.java
// this used implicitly and explicitly to refer to members of an object.

public class ThisTest {
   public static void main(String[] args) {
      SimpleTime time = new SimpleTime(15, 30, 19);
      System.out.println(time.buildString());
   } 
} 

// class SimpleTime demonstrates the "this" reference
class SimpleTime {
   private int hour; // 0-23
   private int minute; // 0-59
   private int second; // 0-59 

   // if the constructor uses parameter names identical to 
   // instance variable names the "this" reference is 
   // required to distinguish between the names
   public SimpleTime(int hour, int minute, int second) {
      this.hour = hour; // set "this" object's hour      
      this.minute = minute; // set "this" object's minute
      this.second = second; // set "this" object's second
   }

   // use explicit and implicit "this" to call toUniversalString
   public String buildString() {
      return String.format("%24s: %s%n%24s: %s", 
         "this.toUniversalString()", this.toUniversalString(),
         "toUniversalString()", toUniversalString());
   } 

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString() {
      // "this" is not required here to access instance variables, 
      // because method does not have local variables with same 
      // names as instance variables
      return String.format("%02d:%02d:%02d", 
         this.hour, this.minute, this.second);
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
