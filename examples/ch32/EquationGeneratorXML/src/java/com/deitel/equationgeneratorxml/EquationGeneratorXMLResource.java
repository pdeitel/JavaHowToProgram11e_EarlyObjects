// Fig. 31.24: EquationGeneratorXMLResource.java
// RESTful equation generator that returns XML.
package com.deitel.equationgeneratorxml;

import java.io.StringWriter;
import java.security.SecureRandom;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXB; // utility class for common JAXB operations

@Path("equation")
public class EquationGeneratorXMLResource
{
   private static SecureRandom randomObject = new SecureRandom(); 

   // retrieve an equation formatted as XML
   @GET
   @Path("{operation}/{level}")
   @Produces("application/xml")
   public String getXml(@PathParam("operation") String operation,
      @PathParam("level") int level)
   {
      // compute minimum and maximum values for the numbers
      int minimum = (int) Math.pow(10, level - 1);
      int maximum = (int) Math.pow(10, level);

      // create the numbers on the left-hand side of the equation
      int first = randomObject.nextInt(maximum - minimum) + minimum;
      int second = randomObject.nextInt(maximum - minimum) + minimum;

      // create Equation object and marshal it into XML
      Equation equation = new Equation(first, second, operation);
      StringWriter writer = new StringWriter(); // XML output here
      JAXB.marshal(equation, writer); // write Equation to StringWriter
      return writer.toString(); // return XML string
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

