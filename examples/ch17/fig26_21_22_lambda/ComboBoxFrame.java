// Fig. 12.21: ComboBoxFrame.java
// JComboBox that displays a list of image names.
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // hold icon names
   private final JLabel label; // displays selected icon

   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3])) };

   // ComboBoxFrame constructor adds JComboBox to JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox");
      setLayout(new FlowLayout()); // set frame layout     

      imagesJComboBox = new JComboBox<String>(names); // set up JComboBox
      imagesJComboBox.setMaximumRowCount(3); // display three rows

      add(imagesJComboBox); // add combobox to JFrame
      label = new JLabel(icons[0]); // display first icon
      add(label); // add label to JFrame
      imagesJComboBox.addItemListener(event -> { 
           if (event.getStateChange() == ItemEvent.SELECTED)
              label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
           }); // end call to addItemListener
   } // end ComboBoxFrame constructor
} // end class ComboBoxFrame


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
