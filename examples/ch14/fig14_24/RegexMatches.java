// Fig. 14.24: RegexMatches.java
// Classes Pattern and Matcher.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
   public static void main(String[] args) {
      // create regular expression
      Pattern expression = 
         Pattern.compile("J.*\\d[0-35-9]-\\d\\d-\\d\\d");
      
      String string1 = "Jane's Birthday is 05-12-75\n" +
         "Dave's Birthday is 11-04-68\n" +
         "John's Birthday is 04-28-73\n" +
         "Joe's Birthday is 12-17-77";

      // match regular expression to string and print matches
      Matcher matcher = expression.matcher(string1);
        
      while (matcher.find()) {
         System.out.println(matcher.group());
      }
   } 
}


/*
 **************************************************************************
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
 **************************************************************************
*/

