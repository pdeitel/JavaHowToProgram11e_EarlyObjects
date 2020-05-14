// Fig. 32.11: WelcomeRESTXMLResource.java
// REST web service that returns a welcome message as XML.
package com.deitel.welcomerestxml;

import java.io.StringWriter;
import javax.ws.rs.GET; // annotation to indicate method uses HTTP GET
import javax.ws.rs.Path; // annotation to specify path of resource
import javax.ws.rs.PathParam; // annotation to get parameters from URI
import javax.ws.rs.Produces; // annotation to specify type of data
import javax.xml.bind.JAXB; // utility class for common JAXB operations

@Path("welcome") // URI used to access the resource
public class WelcomeRESTXMLResource
{
   // retrieve welcome message
   @GET // handles HTTP GET requests
   @Path("{name}") // URI component containing parameter
   @Produces("application/xml") // response formatted as XML
   public String getXml(@PathParam("name") String name)
   {
      String message = "Welcome to JAX-RS web services with REST and " +
         "XML, " + name + "!"; // our welcome message
      StringWriter writer = new StringWriter();
      JAXB.marshal(message, writer); // marshal String as XML
      return writer.toString(); // return XML as String
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

