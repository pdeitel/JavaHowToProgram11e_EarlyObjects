// Fig. 4.5: StudentTest.java
// Create and test Student objects.
public class StudentTest {
   public static void main(String[] args) {
      Student account1 = new Student("Jane Green", 93.5);
      Student account2 = new Student("John Blue", 72.75); 

      System.out.printf("%s's letter grade is: %s%n", 
         account1.getName(), account1.getLetterGrade());      
      System.out.printf("%s's letter grade is: %s%n", 
         account2.getName(), account2.getLetterGrade());      
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