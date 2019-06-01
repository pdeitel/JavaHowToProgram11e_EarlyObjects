// Fig. 4.4: Student.java
// Student class that stores a student name and average.
public class Student {
   private String name; 
   private double average; 

   // constructor initializes instance variables
   public Student(String name, double average) {
      this.name = name;

      // validate that average is > 0.0 and <= 100.0; otherwise,
      // keep instance variable average's default value (0.0)
      if (average > 0.0) {
         if (average <= 100.0) {
            this.average = average; // assign to instance variable
         }
      }
   }

   // sets the Student's name
   public void setName(String name) {
      this.name = name; 
   }

   // retrieves the Student's name
   public String getName() {
      return name;
   }

   // sets the Student's average
   public void setAverage(double average) {
      // validate that average is > 0.0 and <= 100.0; otherwise,
      // keep instance variable average's current value  
      if (average > 0.0) {
         if (average <= 100.0) {
            this.average = average; // assign to instance variable
         }
      }
   }

   // retrieves the Student's average
   public double getAverage() {
      return average;
   }

   // determines and returns the Student's letter grade
   public String getLetterGrade() {
      String letterGrade = ""; // initialized to empty String

      if (average >= 90.0) {
         letterGrade = "A";
      }
      else if (average >= 80.0) {
         letterGrade = "B";
      }
      else if (average >= 70.0) {
         letterGrade = "C";
      }
      else if (average >= 60.0) {
         letterGrade = "D";
      }
      else {
         letterGrade = "F";
      }

      return letterGrade;
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
