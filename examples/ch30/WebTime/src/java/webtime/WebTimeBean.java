// WebTimeBean.java
// Bean that enables the JSF page to retrieve the time from the server
package webtime;

import java.text.DateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="webTimeBean")
public class WebTimeBean 
{
   // return the time on the server at which the request was received
   public String getTime()
   {
      return DateFormat.getTimeInstance(DateFormat.LONG).format(
         new Date());   
   } 
} 

/*************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and              *
 * Pearson Education, Inc. All Rights Reserved.                          *
 *                                                                       *
 * DISCLAIMER: The authors and publisher of this book have used their    *
 * best efforts in preparing the book. These efforts include the         *
 * development, research, and testing of the theories and programs       *
 * to determine their effectiveness. The authors and publisher make      *
 * no warranty of any kind, expressed or implied, with regard to these   *
 * programs or to the documentation contained in these books. The authors*
 * and publisher shall not be liable in any event for incidental or      *
 * consequential damages in connection with, or arising out of, the      *
 * furnishing, performance, or use of these programs.                    *
 ************************************************************************/

