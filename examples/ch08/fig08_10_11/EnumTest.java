// Fig. 8.11: EnumTest.java
// Testing enum type Book.
import java.util.EnumSet;

public class EnumTest {
   public static void main(String[] args) {
      System.out.println("All books:");

      // print all books in enum Book 
      for (Book book : Book.values()) {                       
         System.out.printf("%-10s%-45s%s%n", book,
             book.getTitle(), book.getCopyrightYear());
      }

      System.out.printf("%nDisplay a range of enum constants:%n");
    
      // print first four books                                 
      for (Book book : EnumSet.range(Book.JHTP, Book.CPPHTP)) {
         System.out.printf("%-10s%-45s%s%n", book,
             book.getTitle(), book.getCopyrightYear());
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
