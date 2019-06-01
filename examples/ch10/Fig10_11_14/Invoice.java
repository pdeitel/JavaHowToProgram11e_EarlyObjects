// Fig. 10.12: Invoice.java
// Invoice class that implements Payable.

public class Invoice implements Payable {
   private final String partNumber; 
   private final String partDescription;
   private final int quantity;
   private final double pricePerItem;

   // constructor
   public Invoice(String partNumber, String partDescription, int quantity,
      double pricePerItem) {
      if (quantity < 0) { // validate quantity
         throw new IllegalArgumentException("Quantity must be >= 0");
      }
      
      if (pricePerItem < 0.0) { // validate pricePerItem
         throw new IllegalArgumentException(
            "Price per item must be >= 0");
      }

      this.quantity = quantity;
      this.partNumber = partNumber;
      this.partDescription = partDescription;
      this.pricePerItem = pricePerItem;
   } 

   // get part number
   public String getPartNumber() {return partNumber;}

   // get description
   public String getPartDescription() {return partDescription;}

   // get quantity
   public int getQuantity() {return quantity;}

   // get price per item
   public double getPricePerItem() {return pricePerItem;}

   // return String representation of Invoice object
   @Override
   public String toString() {
      return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f", 
         "invoice", "part number", getPartNumber(), getPartDescription(), 
         "quantity", getQuantity(), "price per item", getPricePerItem());
   } 

   // method required to carry out contract with interface Payable     
   @Override                                                           
   public double getPaymentAmount() {                                  
      return getQuantity() * getPricePerItem(); // calculate total cost
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
