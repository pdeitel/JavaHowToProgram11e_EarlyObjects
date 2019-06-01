// Fig. 14.2: StringMiscellaneous.java
// This application demonstrates the length, charAt and getChars
// methods of the String class.

public class StringMiscellaneous {
   public static void main(String[] args) {
      String s1 = "hello there";
      char[] charArray = new char[5];

      System.out.printf("s1: %s", s1);

      // test length method
      System.out.printf("\nLength of s1: %d", s1.length());

      // loop through characters in s1 with charAt and display reversed
      System.out.printf("%nThe string reversed is: ");

      for (int count = s1.length() - 1; count >= 0; count--) {
         System.out.printf("%c ", s1.charAt(count));
      }

      // copy characters from string into charArray
      s1.getChars(0, 5, charArray, 0);
      System.out.printf("%nThe character array is: ");

      for (char character : charArray) {
         System.out.print(character); 
      }

      System.out.println();
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
