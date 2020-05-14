// Fig. 14.6: SubString.java
// String class substring methods.

public class SubString {
   public static void main(String[] args) {
      String letters = "abcdefghijklmabcdefghijklm";

      // test substring methods
      System.out.printf("Substring from index 20 to end is \"%s\"\n",
         letters.substring(20));
      System.out.printf("%s \"%s\"\n", 
         "Substring from index 3 up to, but not including, 6 is",
         letters.substring(3, 6));
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
