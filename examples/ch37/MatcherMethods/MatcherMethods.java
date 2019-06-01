// Fig. 37.1: MatcherMethods.java
// Java 9's new Matcher methods.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherMethods {
   public static void main(String[] args) {
      String sentence = "a man a plan a canal panama"; 

      System.out.printf("sentence: %s%n", sentence);

      // using Matcher methods appendReplacement and appendTail
      Pattern pattern = Pattern.compile("an"); // regex to match

      // match regular expression to String and replace 
      // each match with uppercase letters
      Matcher matcher = pattern.matcher(sentence);

      // used to rebuild String
      StringBuilder builder = new StringBuilder(); 

      // append text to builder; convert each match to uppercase
      while (matcher.find()) {
         matcher.appendReplacement(
            builder, matcher.group().toUpperCase());
      } 

      // append the remainder of the original String to builder
      matcher.appendTail(builder);
      System.out.printf(
         "%nAfter appendReplacement/appendTail: %s%n", builder);

      // using Matcher method replaceFirst
      matcher.reset(); // reset matcher to its initial state
      System.out.printf("%nBefore replaceFirst: %s%n", sentence);
      String result = matcher.replaceFirst(m -> m.group().toUpperCase());
      System.out.printf("After replaceFirst: %s%n", result);

      // using Matcher method replaceAll
      matcher.reset(); // reset matcher to its initial state
      System.out.printf("%nBefore replaceAll: %s%n", sentence);
      result = matcher.replaceAll(m -> m.group().toUpperCase());
      System.out.printf("After replaceAll: %s%n", result);

      // using method results to get a Stream<MatchResult>
      System.out.printf("%nUsing Matcher method results:%n"); 
      pattern = Pattern.compile("\\w+"); // regular expression to match
      matcher = pattern.matcher(sentence);
      System.out.printf("The number of words is: %d%n", 
         matcher.results().count());

      matcher.reset(); // reset matcher to its initial state
      System.out.printf("Average characters per word is: %f%n", 
         matcher.results()
                .mapToInt(m -> m.group().length())
                .average().orElse(0));
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

