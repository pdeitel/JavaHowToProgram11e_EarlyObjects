// Fig. 13.7: ShowColors2JFrame.java
// Choosing colors with JColorChooser.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ShowColors2JFrame extends JFrame 
{
   private final JButton changeColorJButton;
   private Color color = Color.LIGHT_GRAY;
   private final JPanel colorJPanel;

   // set up GUI
   public ShowColors2JFrame()
   {
      super("Using JColorChooser");

      // create JPanel for display color
      colorJPanel = new JPanel();
      colorJPanel.setBackground(color);

      // set up changeColorJButton and register its event handler
      changeColorJButton = new JButton("Change Color");
      changeColorJButton.addActionListener(
         new ActionListener() // anonymous inner class
         {
            // display JColorChooser when user clicks button
            @Override
            public void actionPerformed(ActionEvent event)
            {
               color = JColorChooser.showDialog(
                  ShowColors2JFrame.this, "Choose a color", color);

               // set default color, if no color is returned 
               if (color == null)
                  color = Color.LIGHT_GRAY;

               // change content pane's background color
               colorJPanel.setBackground(color);
            } 
         } // end anonymous inner class
      ); // end call to addActionListener
 
      add(colorJPanel, BorderLayout.CENTER); 
      add(changeColorJButton, BorderLayout.SOUTH);

      setSize(400, 130);
      setVisible(true);
   } // end ShowColor2JFrame constructor
} // end class ShowColors2JFrame

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
