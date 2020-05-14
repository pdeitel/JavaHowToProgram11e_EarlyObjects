// Fig. 26.31: MouseDetailsFrame.java
// Demonstrating mouse clicks and distinguishing between mouse buttons.
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseDetailsFrame extends JFrame 
{
   private String details; // String displayed in the statusBar
   private final JLabel statusBar; // JLabel at bottom of window

   // constructor sets title bar String and register mouse listener
   public MouseDetailsFrame()
   {
      super("Mouse Clicks and Buttons");

      statusBar = new JLabel("Click the mouse");
      add(statusBar, BorderLayout.SOUTH);
      addMouseListener(new MouseClickHandler()); // add handler
   }

   // inner class to handle mouse events
   private class MouseClickHandler extends MouseAdapter 
   {
      // handle mouse-click event and determine which button was pressed
      @Override
      public void mouseClicked(MouseEvent event)
      {
         int xPos = event.getX(); // get x-position of mouse
         int yPos = event.getY(); // get y-position of mouse

         details = String.format("Clicked %d time(s)", 
            event.getClickCount());
      
         if (event.isMetaDown()) // right mouse button   
            details += " with right mouse button";
         else if (event.isAltDown()) // middle mouse button
            details += " with center mouse button";
         else // left mouse button                       
            details += " with left mouse button";

         statusBar.setText(details); 
      }
   } 
} // end class MouseDetailsFrame


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
