// Fig. 32.1: WelcomeSOAP.java
// Web service that returns a welcome message via SOAP.
package com.deitel.welcomesoap;

import javax.jws.WebService; // program uses the annotation @WebService
import javax.jws.WebMethod; // program uses the annotation @WebMethod
import javax.jws.WebParam; // program uses the annotation @WebParam

@WebService() // annotates the class as a web service
public class WelcomeSOAP
{
   // WebMethod that returns welcome message
   @WebMethod(operationName = "welcome")
   public String welcome(@WebParam(name = "name") String name)
   {
      return "Welcome to JAX-WS web services with SOAP, " + name + "!";
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
