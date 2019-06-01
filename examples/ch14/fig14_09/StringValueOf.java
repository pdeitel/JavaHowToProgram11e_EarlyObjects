// Fig. 14.9: StringValueOf.java
// String valueOf methods.

public class StringValueOf {
   public static void main(String[] args) {
      char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
      boolean booleanValue = true;
      char characterValue = 'Z';
      int integerValue = 7;
      long longValue = 10000000000L; // L suffix indicates long
      float floatValue = 2.5f; // f indicates that 2.5 is a float
      double doubleValue = 33.333; // no suffix, double is default
      Object objectRef = "hello"; // assign string to an Object reference

      System.out.printf(
         "char array = %s\n", String.valueOf(charArray));
      System.out.printf("part of char array = %s\n", 
         String.valueOf(charArray, 3, 3));
      System.out.printf(
         "boolean = %s\n", String.valueOf(booleanValue));
      System.out.printf(
         "char = %s\n", String.valueOf(characterValue));
      System.out.printf("int = %s\n", String.valueOf(integerValue));
      System.out.printf("long = %s\n", String.valueOf(longValue)); 
      System.out.printf("float = %s\n", String.valueOf(floatValue)); 
      System.out.printf(
         "double = %s\n", String.valueOf(doubleValue)); 
      System.out.printf("Object = %s\n", String.valueOf(objectRef));
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
