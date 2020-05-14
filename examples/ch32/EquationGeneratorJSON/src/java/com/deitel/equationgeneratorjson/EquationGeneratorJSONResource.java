// Fig. 31.26: EquationGeneratorJSONResource.java
// RESTful equation generator that returns JSON.
package com.deitel.equationgeneratorjson;

import com.google.gson.Gson; // converts POJO to JSON and back again
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("equation")
public class EquationGeneratorJSONResource
{
   static Random randomObject = new Random(); // random number generator

   // retrieve an equation formatted as JSON
   @GET
   @Path("{operation}/{level}")
   @Produces("application/json")
   public String getJson(@PathParam("operation") String operation,
      @PathParam("level") int level)
   {
      // compute minimum and maximum values for the numbers
      int minimum = (int) Math.pow(10, level - 1);
      int maximum = (int) Math.pow(10, level);

      // create the numbers on the left-hand side of the equation
      int first = randomObject.nextInt(maximum - minimum) + minimum;
      int second = randomObject.nextInt(maximum - minimum) + minimum;

      // create Equation object and return result
      Equation equation = new Equation(first, second, operation);
      return new Gson().toJson(equation); // convert to JSON and return
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


