// Fig. 13.24: ArcsJPanel.java
// Drawing arcs.
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ArcsJPanel extends JPanel 
{
   // draw rectangles and arcs
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);  

      // start at 0 and sweep 360 degrees
      g.setColor(Color.RED);
      g.drawRect(15, 35, 80, 80);
      g.setColor(Color.BLACK);
      g.drawArc(15, 35, 80, 80, 0, 360);

      // start at 0 and sweep 110 degrees
      g.setColor(Color.RED);
      g.drawRect(100, 35, 80, 80);
      g.setColor(Color.BLACK);
      g.drawArc(100, 35, 80, 80, 0, 110);

      // start at 0 and sweep -270 degrees
      g.setColor(Color.RED);
      g.drawRect(185, 35, 80, 80);
      g.setColor(Color.BLACK);
      g.drawArc(185, 35, 80, 80, 0, -270);

      // start at 0 and sweep 360 degrees
      g.fillArc(15, 120, 80, 40, 0, 360);

      // start at 270 and sweep -90 degrees
      g.fillArc(100, 120, 80, 40, 270, -90);
                 
      // start at 0 and sweep -270 degrees
      g.fillArc(185, 120, 80, 40, 0, -270);
   } 
} // end class ArcsJPanel

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
