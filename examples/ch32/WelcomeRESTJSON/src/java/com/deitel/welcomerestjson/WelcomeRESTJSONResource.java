// Fig. 32.15: WelcomeRESTJSONResource.java
// REST web service that returns a welcome message as JSON.
package com.deitel.welcomerestjson;

import com.google.gson.Gson; // converts POJO to JSON and back again
import javax.ws.rs.GET; // annotation to indicate method uses HTTP GET
import javax.ws.rs.Path; // annotation to specify path of resource
import javax.ws.rs.PathParam; // annotation to get parameters from URI
import javax.ws.rs.Produces; // annotation to specify type of data

@Path("welcome") // path used to access the resource
public class WelcomeRESTJSONResource
{
   // retrieve welcome message
   @GET // handles HTTP GET requests
   @Path("{name}") // takes name as a path parameter
   @Produces("application/json") // response formatted as JSON
   public String getJson(@PathParam("name") String name)
   {
      // add welcome message to field of TextMessage object
      TextMessage message = new TextMessage(); // create wrapper object
      message.setMessage(String.format("%s, %s!",
         "Welcome to JAX-RS web services with REST and JSON", name));

      return new Gson().toJson(message); // return JSON-wrapped message
   } 
}

// private class that contains the message we wish to send
class TextMessage
{
   private String message; // message we're sending

   // returns the message
   public String getMessage()
   {
      return message;
   } 

   // sets the message
   public void setMessage(String value)
   {
      message = value;
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

