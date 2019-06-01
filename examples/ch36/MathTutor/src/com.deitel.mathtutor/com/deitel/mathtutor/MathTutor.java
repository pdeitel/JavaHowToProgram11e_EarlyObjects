// Fig. 36.28: MathTutor.java
// Math tutoring app using ProblemProviders to display math problems.
package com.deitel.mathtutor;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.stream.Collectors;
import com.deitel.mathtutor.spi.Problem;
import com.deitel.mathtutor.spi.ProblemProvider;

public class MathTutor {
   private static Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      // get a service loader for ProblemProviders
      ServiceLoader<ProblemProvider> serviceLoader = 
        ServiceLoader.load(ProblemProvider.class);

      // get the list of service providers
      List<Provider<ProblemProvider>> providersList = 
         serviceLoader.stream().collect(Collectors.toList());

      // check whether there are any providers
      if (providersList.isEmpty()) {
         System.out.println(
            "Terminating MathTutor: No problem providers found.");
         return;
      }
      
      boolean shouldContinue = true;
      Random random = new Random();

      do {
         // choose a ProblemProvider at random 
         ProblemProvider provider = 
            providersList.get(random.nextInt(providersList.size())).get();
         
         // get the Problem
         Problem problem = provider.getProblem();

         // display the problem to the user
         showProblem(problem);
      } while (playAgain());
   }   

   // show the math problem to the user
   private static void showProblem(Problem problem) {
      String problemStatement = String.format("What is %d %s %d? ", 
         problem.getLeftOperand(), problem.getOperation(), 
         problem.getRightOperand());
      
      // display problem and get answer from user
      System.out.printf(problemStatement);
      int answer = input.nextInt();

      while (answer != problem.getResult()) {
         System.out.println("Incorrect. Please try again: ");
         System.out.printf(problemStatement);
         answer = input.nextInt();
      }

      System.out.println("Correct!");
   }

   // play again?
   private static boolean playAgain() {
      System.out.printf("Try another? y to continue, n to terminate: ");
      String response = input.next();

      return response.toLowerCase().startsWith("y");
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
