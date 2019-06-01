// Fig. 36.33: module-info.java
// Module declaration for the com.deitel.multiplicationprovider module
module com.deitel.multiplicationprovider {
   requires com.deitel.mathtutor;

   provides com.deitel.mathtutor.spi.ProblemProvider with 
      com.deitel.multiplicationprovider.MultiplicationProblemProvider; 
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

