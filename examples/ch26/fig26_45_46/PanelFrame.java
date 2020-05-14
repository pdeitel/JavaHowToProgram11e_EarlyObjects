// Fig. 26.45: PanelFrame.java
// Using a JPanel to help lay out components.
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelFrame extends JFrame 
{
   private final JPanel buttonJPanel; // panel to hold buttons
   private final JButton[] buttons; 

   // no-argument constructor
   public PanelFrame()
   {
      super("Panel Demo");
      buttons = new JButton[5]; 
      buttonJPanel = new JPanel(); 
      buttonJPanel.setLayout(new GridLayout(1, buttons.length));

      // create and add buttons
      for (int count = 0; count < buttons.length; count++) 
      {
         buttons[count] = new JButton("Button " + (count + 1));
         buttonJPanel.add(buttons[count]); // add button to panel
      } 

      add(buttonJPanel, BorderLayout.SOUTH); // add panel to JFrame
   } 
} // end class PanelFrame


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
