// Fig. 13.32: Shapes2.java
// Demonstrating a general path.
import java.awt.Color;
import javax.swing.JFrame;

public class Shapes2
{
   // execute application
   public static void main(String[] args)
   {
      // create frame for Shapes2JPanel
      JFrame frame = new JFrame("Drawing 2D Shapes");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Shapes2JPanel shapes2JPanel = new Shapes2JPanel(); 
      frame.add(shapes2JPanel); 
      frame.setBackground(Color.WHITE);
      frame.setSize(315, 330);
      frame.setVisible(true);
   } 
} // end class Shapes2

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
