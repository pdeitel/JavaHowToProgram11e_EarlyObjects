// Fig. 9.8: BasePlusCommissionEmployee.java
// private superclass members cannot be accessed in a subclass.
public class BasePlusCommissionEmployee extends CommissionEmployee {
   private double baseSalary; // base salary per week

   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, 
      String socialSecurityNumber, double grossSales, 
      double commissionRate, double baseSalary) {
      // explicit call to superclass CommissionEmployee constructor
      super(firstName, lastName, socialSecurityNumber,             
         grossSales, commissionRate);                              

      // if baseSalary is invalid throw exception
      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }       

      this.baseSalary = baseSalary;
   }
   
   // set base salary
   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }

      this.baseSalary = baseSalary;                
   }

   // return base salary
   public double getBaseSalary() {return baseSalary;}

   // calculate earnings
   @Override
   public double earnings() {
      // not allowed: commissionRate and grossSales private in superclass
      return baseSalary + (commissionRate * grossSales);                 
   }  

   // return String representation of BasePlusCommissionEmployee
   @Override
   public String toString() {
      // not allowed: attempts to access private superclass members   
      return String.format(                                           
         "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f",           
         "base-salaried commission employee", firstName, lastName,    
         "social security number", socialSecurityNumber,              
         "gross sales", grossSales, "commission rate", commissionRate,
         "base salary", baseSalary);                                  
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
