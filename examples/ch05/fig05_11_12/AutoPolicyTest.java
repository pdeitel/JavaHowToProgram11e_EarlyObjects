// Fig. 5.12: AutoPolicyTest.java
// Demonstrating Strings in switch.
public class AutoPolicyTest {
   public static void main(String[] args) {
      // create two AutoPolicy objects
      AutoPolicy policy1 = 
         new AutoPolicy(11111111, "Toyota Camry", "NJ");
      AutoPolicy policy2 = 
         new AutoPolicy(22222222, "Ford Fusion", "ME");

      // display whether each policy is in a no-fault state
      policyInNoFaultState(policy1);
      policyInNoFaultState(policy2);
   } 

   // method that displays whether an AutoPolicy 
   // is in a state with no-fault auto insurance 
   public static void policyInNoFaultState(AutoPolicy policy) {
      System.out.println("The auto policy:");
      System.out.printf(
         "Account #: %d; Car: %s;%nState %s %s a no-fault state%n%n", 
         policy.getAccountNumber(), policy.getMakeAndModel(), 
         policy.getState(), 
         (policy.isNoFaultState() ? "is": "is not"));
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
