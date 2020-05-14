// Fig. 14.5: StringIndexMethods.java
// String searching methods indexOf and lastIndexOf.

public class StringIndexMethods {
   public static void main(String[] args) {
      String letters = "abcdefghijklmabcdefghijklm";

      // test indexOf to locate a character in a string
      System.out.printf(
         "'c' is located at index %d\n", letters.indexOf('c'));
      System.out.printf(
         "'a' is located at index %d\n", letters.indexOf('a', 1));
      System.out.printf(
         "'$' is located at index %d\n\n", letters.indexOf('$'));

      // test lastIndexOf to find a character in a string
      System.out.printf("Last 'c' is located at index %d\n",
         letters.lastIndexOf('c'));
      System.out.printf("Last 'a' is located at index %d\n",
         letters.lastIndexOf('a', 25));
      System.out.printf("Last '$' is located at index %d\n\n",
         letters.lastIndexOf('$'));

      // test indexOf to locate a substring in a string
      System.out.printf("\"def\" is located at index %d\n", 
         letters.indexOf("def"));
      System.out.printf("\"def\" is located at index %d\n",
         letters.indexOf("def", 7));
      System.out.printf("\"hello\" is located at index %d\n\n",
         letters.indexOf("hello"));

      // test lastIndexOf to find a substring in a string
      System.out.printf("Last \"def\" is located at index %d\n",
         letters.lastIndexOf("def"));
      System.out.printf("Last \"def\" is located at index %d\n",
         letters.lastIndexOf("def", 25));
      System.out.printf("Last \"hello\" is located at index %d\n",
         letters.lastIndexOf("hello"));
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
