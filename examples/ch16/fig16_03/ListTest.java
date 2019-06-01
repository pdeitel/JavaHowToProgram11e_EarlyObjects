// Fig. 16.3: ListTest.java
// Lists, LinkedLists and ListIterators.
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListTest {
   public static void main(String[] args) {
      // add colors elements to list1
      String[] colors = 
         {"black", "yellow", "green", "blue", "violet", "silver"};
      List<String> list1 = new LinkedList<>(); 

      for (String color : colors) {
         list1.add(color);
      }

      // add colors2 elements to list2
      String[] colors2 = 
         {"gold", "white", "brown", "blue", "gray", "silver"};
      List<String> list2 = new LinkedList<>();

      for (String color : colors2) {
         list2.add(color);
      }

      list1.addAll(list2); // concatenate lists
      list2 = null; // release resources
      printList(list1); // print list1 elements

      convertToUppercaseStrings(list1); // convert to uppercase string
      printList(list1); // print list1 elements

      System.out.printf("%nDeleting elements 4 to 6...");
      removeItems(list1, 4, 7); // remove items 4-6 from list
      printList(list1); // print list1 elements
      printReversedList(list1); // print list in reverse order
   }                                     

   // output List contents
   private static void printList(List<String> list) {
      System.out.printf("%nlist:%n");
   
      for (String color : list) {
         System.out.printf("%s ", color);
      }

      System.out.println();
   }                                                    

   // locate String objects and convert to uppercase
   private static void convertToUppercaseStrings(List<String> list) {
      ListIterator<String> iterator = list.listIterator();

      while (iterator.hasNext()) {
         String color = iterator.next(); // get item                
         iterator.set(color.toUpperCase()); // convert to upper case
      } 
   } 

   // obtain sublist and use clear method to delete sublist items
   private static void removeItems(List<String> list, 
      int start, int end) {
      list.subList(start, end).clear(); // remove items
   } 

   // print reversed list
   private static void printReversedList(List<String> list) {
      ListIterator<String> iterator = list.listIterator(list.size());

      System.out.printf("%nReversed List:%n");

      // print list in reverse order
      while (iterator.hasPrevious()) {
         System.out.printf("%s ", iterator.previous()); 
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
