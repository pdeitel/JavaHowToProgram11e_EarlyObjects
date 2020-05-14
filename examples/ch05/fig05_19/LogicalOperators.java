// Fig. 5.19: LogicalOperators.java
// Logical operators.

public class LogicalOperators {
   public static void main(String[] args) {
      // create truth table for && (conditional AND) operator
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "Conditional AND (&&)", "false && false", (false && false),
         "false && true", (false && true), 
         "true && false", (true && false),
         "true && true", (true && true));

      // create truth table for || (conditional OR) operator
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "Conditional OR (||)", "false || false", (false || false),
         "false || true", (false || true),
         "true || false", (true || false),
         "true || true", (true || true));

      // create truth table for & (boolean logical AND) operator
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "Boolean logical AND (&)", "false & false", (false & false),
         "false & true", (false & true),
         "true & false", (true & false),
         "true & true", (true & true));

      // create truth table for | (boolean logical inclusive OR) operator
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "Boolean logical inclusive OR (|)",
         "false | false", (false | false),
         "false | true", (false | true),
         "true | false", (true | false),
         "true | true", (true | true));

      // create truth table for ^ (boolean logical exclusive OR) operator
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "Boolean logical exclusive OR (^)", 
         "false ^ false", (false ^ false),
         "false ^ true", (false ^ true),
         "true ^ false", (true ^ false),
         "true ^ true", (true ^ true));

      // create truth table for ! (logical negation) operator
      System.out.printf("%s%n%s: %b%n%s: %b%n", "Logical NOT (!)",
         "!false", (!false), "!true", (!true));
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
