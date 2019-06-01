// Fig. 8.16: Interest.java
// Compound-interest calculations with BigDecimal.
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Interest {
   public static void main(String args[]) {
      // initial principal amount before interest                 
      BigDecimal principal = BigDecimal.valueOf(1000.0);          
      BigDecimal rate = BigDecimal.valueOf(0.05); // interest rate

      // display headers
      System.out.printf("%s%20s%n", "Year", "Amount on deposit");

      // calculate amount on deposit for each of ten years
      for (int year = 1; year <= 10; year++) {
         // calculate new amount for specified year                
         BigDecimal amount =                                       
            principal.multiply(rate.add(BigDecimal.ONE).pow(year));

         // display the year and the amount
         System.out.printf("%4d%20s%n", year, 
            NumberFormat.getCurrencyInstance().format(amount));
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
