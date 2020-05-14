// SelectionsBean.java
// Manages a user's topic selections
package sessiontracking;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="selectionsBean")
@SessionScoped
public class SelectionsBean implements Serializable
{
   // map of topics to book titles
   private static final HashMap<String, String> booksMap =
      new HashMap<>();

   // initialize booksMap
   static 
   {
      booksMap.put("java", "Java How to Program");
      booksMap.put("cpp", "C++ How to Program");
      booksMap.put("iphone",
         "iPhone for Programmers: An App-Driven Approach");
      booksMap.put("android",
         "Android for Programmers: An App-Driven Approach");
   } 

   // stores individual user's selections
   private Set<String> selections = new TreeSet<String>();
   private String selection; // stores the current selection
   
   // return number of selections
   public int getNumberOfSelections()
   {
      return selections.size();
   } 

   // returns the current selection
   public String getSelection()
   {
      return selection;
   }

   // store user's selection
   public void setSelection(String topic)
   {
      selection = booksMap.get(topic);
      selections.add(selection);
   }

   // return the Set of selections
   public String[] getSelections()
   {
      return selections.toArray(new String[selections.size()]);
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

