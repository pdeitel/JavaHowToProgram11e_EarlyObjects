// Fig. 14.4: StringStartEnd.java
// String methods startsWith and endsWith.

public class StringStartEnd {
   public static void main(String[] args) {
      String[] strings = {"started", "starting", "ended", "ending"};

      // test method startsWith
      for (String string : strings) {
         if (string.startsWith("st")) {
            System.out.printf("\"%s\" starts with \"st\"\n", string);
         }
      } 

      System.out.println();

      // test method startsWith starting from position 2 of string
      for (String string : strings) {
         if (string.startsWith("art", 2)) {
            System.out.printf(
               "\"%s\" starts with \"art\" at position 2\n", string);
         }
      } 

      System.out.println();

      // test method endsWith
      for (String string : strings) {
         if (string.endsWith("ed")) {
            System.out.printf("\"%s\" ends with \"ed\"\n", string);
         }
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
