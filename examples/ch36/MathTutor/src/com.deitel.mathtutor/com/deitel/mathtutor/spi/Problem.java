// Fig. 36.26: Problem.java
// Problem superclass that contains information about a math problem.
package com.deitel.mathtutor.spi;

public abstract class Problem {
   private int leftOperand;
   private int rightOperand;
   private int result;
   private String operation;

   // constructor  
   public Problem(int leftOperand, int rightOperand, String operation) {
      this.leftOperand = leftOperand;
      this.rightOperand = rightOperand;
      this.operation = operation;
   } 
   
   // gets the leftOperand
   public int getLeftOperand() {return leftOperand;} 
   
   // gets the rightOperand
   public int getRightOperand() {return rightOperand;} 
   
   // gets the operation
   public String getOperation() {return operation;}
   
   // gets the result
   public abstract int getResult();
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
