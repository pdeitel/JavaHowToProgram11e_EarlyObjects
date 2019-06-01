// Fig. 21.4: ListTest.java
// ListTest class to demonstrate List capabilities.
import com.deitel.datastructures.List;
import java.util.NoSuchElementException;

public class ListTest {
   public static void main(String[] args) {
      List<Integer> list = new List<>();

      // insert integers in list
      list.insertAtFront(-1);   
      list.print();             
      list.insertAtFront(0);    
      list.print();             
      list.insertAtBack(1);     
      list.print();             
      list.insertAtBack(5);     
      list.print();             

      // remove objects from list; print after each removal
      try {
         int removedItem = list.removeFromFront();
         System.out.printf("%n%d removed%n", removedItem);
         list.print();

         removedItem = list.removeFromFront();
         System.out.printf("%n%d removed%n", removedItem);
         list.print();

         removedItem = list.removeFromBack();
         System.out.printf("%n%d removed%n", removedItem);
         list.print();

         removedItem = list.removeFromBack();
         System.out.printf("%n%d removed%n", removedItem);
         list.print();
      } 
      catch (NoSuchElementException noSuchElementException) {
         noSuchElementException.printStackTrace();
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
