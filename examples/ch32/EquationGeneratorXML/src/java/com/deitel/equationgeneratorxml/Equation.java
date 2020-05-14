// Fig. 31.23: Equation.java
// Equation class that contains information about an equation.
package com.deitel.equationgeneratorxml;

public class Equation
{
   private int leftOperand;
   private int rightOperand;
   private int result;
   private String operationType;

   // required no-argument constructor
   public Equation()
   {
      this(0, 0, "add");
   }
   
   // constructor that receives the operands and operation type
   public Equation(int leftValue, int rightValue, String type)
   {
      leftOperand = leftValue;
      rightOperand = rightValue;

      // determine result
      if (type.equals("add")) // addition
      {
         result = leftOperand + rightOperand;
         operationType = "+";
      } 
      else if (type.equals("subtract")) // subtraction
      {
         result = leftOperand - rightOperand;
         operationType = "-";
      } 
      else 
      {
         result = leftOperand * rightOperand;
         operationType = "*";
      } 
   } 
   
   // gets the leftOperand
   public int getLeftOperand()
   {
      return leftOperand;
   } 
   
   // required setter
   public void setLeftOperand(int value)
   {
      leftOperand = value;
   } 
   
   // gets the rightOperand
   public int getRightOperand()
   {
      return rightOperand;
   } 
   
   // required setter
   public void setRightOperand(int value)
   {
      rightOperand = value;
   }
   
   // gets the resultValue
   public int getResult()
   {
      return result;
   }
   
   // required setter
   public void setResult(int value)
   {
      result = value;
   }
   
   // gets the operationType
   public String getOperationType()
   {
      return operationType;
   }
   
   // required setter
   public void setOperationType(String value)
   {
      operationType = value;
   }
   
   // returns the left hand side of the equation as a String
   public String getLeftHandSide()
   {
      return leftOperand + " " + operationType + " " + rightOperand;
   }
   
   // returns the right hand side of the equation as a String
   public String getRightHandSide()
   {
      return "" + result;
   }
   
   // returns a String representation of an Equation
   public String toString()
   {
      return getLeftHandSide() + " = " + getRightHandSide();
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
