// Fig. 13.12: Fonts.java
// Using fonts.
import javax.swing.JFrame;

public class Fonts 
{
   // execute application
   public static void main(String[] args)
   {
      // create frame for FontJPanel
      JFrame frame = new JFrame("Using fonts");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      FontJPanel fontJPanel = new FontJPanel();
      frame.add(fontJPanel); 
      frame.setSize(420, 150);
      frame.setVisible(true);
   } 
} // end class Fonts

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
