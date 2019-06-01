// Fig. 16.8: TimeComparator.java
// Custom Comparator class that compares two Time2 objects.
import java.util.Comparator;

public class TimeComparator implements Comparator<Time2> {
   @Override
   public int compare(Time2 time1, Time2 time2) {
      int hourDifference = time1.getHour() - time2.getHour();
         
      if (hourDifference != 0) { // test the hour first
         return hourDifference; 
      }
         
      int minuteDifference = time1.getMinute() - time2.getMinute(); 
         
      if (minuteDifference != 0) { // then test the minute
         return minuteDifference;
      }
         
      int secondDifference = time1.getSecond() - time2.getSecond(); 
      return secondDifference; 
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
