// Fig. 14.17: OtherCharMethods.java
// Character class instance methods
public class OtherCharMethods {
   public static void main(String[] args) {
      Character c1 = 'A';
      Character c2 = 'a';

      System.out.printf(
         "c1 = %s\nc2 = %s\n\n", c1.charValue(), c2.toString());

      if (c1.equals(c2)) {
         System.out.println("c1 and c2 are equal\n");
      }
      else {
         System.out.println("c1 and c2 are not equal\n");
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
