// Fig. 3.5: Account.java
// Account class with a constructor that initializes the name.

public class Account {
   private String name; // instance variable

   // constructor initializes name with parameter name
   public Account(String name) { // constructor name is class name
      this.name = name;
   }                                            

   // method to set the name
   public void setName(String name) {
      this.name = name; 
   } 

   // method to retrieve the name
   public String getName() {
      return name; 
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
