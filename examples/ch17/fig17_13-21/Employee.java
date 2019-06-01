// Fig. 17.13: Employee.java
// Employee class.
public class Employee {
   private String firstName;
   private String lastName;
   private double salary; 
   private String department;
   
   // constructor 
   public Employee(String firstName, String lastName, 
      double salary, String department) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.salary = salary;
      this.department = department;
   } 

   // get firstName
   public String getFirstName() {
      return firstName;
   }

   // get lastName
   public String getLastName() {
      return lastName;
   }

   // get salary
   public double getSalary() {
      return salary;
   }

   // get department
   public String getDepartment() {
      return department;
   }

   // return Employee's first and last name combined
   public String getName() {
      return String.format("%s %s", getFirstName(), getLastName());
   }

   // return a String containing the Employee's information
   @Override
   public String toString() {
      return String.format("%-8s %-8s %8.2f   %s", 
         getFirstName(), getLastName(), getSalary(), getDepartment());
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
