// Fig. 5.11: AutoPolicy.java
// Class that represents an auto insurance policy.
public class AutoPolicy {
   private int accountNumber; // policy account number
   private String makeAndModel; // car that the policy applies to
   private String state; // two-letter state abbreviation

   // constructor
   public AutoPolicy(int accountNumber, String makeAndModel, 
      String state) {
      this.accountNumber = accountNumber;
      this.makeAndModel = makeAndModel;
      this.state = state;
   }

   // sets the accountNumber
   public void setAccountNumber(int accountNumber) {
      this.accountNumber = accountNumber;
   }

   // returns the accountNumber
   public int getAccountNumber() {
      return accountNumber;
   } 

   // sets the makeAndModel
   public void setMakeAndModel(String makeAndModel) {
      this.makeAndModel = makeAndModel;
   }

   // returns the makeAndModel
   public String getMakeAndModel() {
      return makeAndModel;
   } 

   // sets the state
   public void setState(String state) {
      this.state = state;
   }

   // returns the state
   public String getState() {
      return state;
   }

   // predicate method returns whether the state has no-fault insurance
   public boolean isNoFaultState() {
      boolean noFaultState; 

      // determine whether state has no-fault auto insurance             
      switch (getState()) { // get AutoPolicy object's state abbreviation
         case "MA": case "NJ": case "NY": case "PA":                     
            noFaultState = true;                                         
            break;                                                       
         default:                                                        
            noFaultState = false;                                        
            break;                                                       
      }                                                                  

      return noFaultState;
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
