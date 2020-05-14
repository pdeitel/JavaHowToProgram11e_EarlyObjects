// Fig. 32.22: ReservationBean.java
// Bean for seat reservation client.
package reservationclient;

import com.deitel.reservation.Reservation;
import com.deitel.reservation.ReservationService;
import java.io.Serializable;
import javax.inject.Named;

@Named("reservationBean")
@javax.faces.view.ViewScoped 
public class ReservationBean implements Serializable
{
   // references the service endpoint interface object (i.e., the proxy)
   private Reservation reservationServiceProxy; // reference to proxy
   private String seatType; // type of seat to reserve
   private String classType; // class of seat to reserve
   private String result; // result of reservation attempt

   // no-argument constructor
   public ReservationBean()
   {
      // get service endpoint interface
      ReservationService reservationService = new ReservationService();
      reservationServiceProxy = reservationService.getReservationPort();
   } 

   // return classType
   public String getClassType()
   {
      return classType;
   } 

   // set classType
   public void setClassType(String classType)
   {
      this.classType = classType;
   } 

   // return seatType
   public String getSeatType()
   {
      return seatType;
   } 

   // set seatType
   public void setSeatType(String seatType)
   {
      this.seatType = seatType;
   } 

   // return result
   public String getResult()
   {
      return result;
   } 

   // invoke the web service when the user clicks Reserve button
   public void reserveSeat()
   {
      try
      {
         boolean reserved = reservationServiceProxy.reserve(
            getSeatType(), getClassType());

         if (reserved)
            result = "Your reservation has been made. Thank you!";
         else
            result = "This type of seat is not available. " +
               "Please modify your request and try again.";
      } 
      catch (Exception e)
      {
         e.printStackTrace();
      } 
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

