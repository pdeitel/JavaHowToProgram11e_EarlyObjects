// Fig. 26.47: TextAreaFrame.java
// Copying selected text from one textarea to another. 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextAreaFrame extends JFrame 
{
   private final JTextArea textArea1; // displays demo string
   private final JTextArea textArea2; // highlighted text is copied here
   private final JButton copyJButton; // initiates copying of text

   // no-argument constructor
   public TextAreaFrame() 
   {
      super("TextArea Demo"); 
      Box box = Box.createHorizontalBox(); // create box
      String demo = "This is a demo string to\n" + 
         "illustrate copying text\nfrom one textarea to \n" +
         "another textarea using an\nexternal event\n";

      textArea1 = new JTextArea(demo, 10, 15); 
      box.add(new JScrollPane(textArea1)); // add scrollpane

      copyJButton = new JButton("Copy >>>"); 
      box.add(copyJButton); // add copy button to box
      copyJButton.addActionListener(
         new ActionListener() // anonymous inner class
         {   
            // set text in textArea2 to selected text from textArea1
            @Override
            public void actionPerformed(ActionEvent event)
            {
               textArea2.setText(textArea1.getSelectedText());
            } 
         } // end anonymous inner class
      ); // end call to addActionListener

      textArea2 = new JTextArea(10, 15);
      textArea2.setEditable(false); 
      box.add(new JScrollPane(textArea2)); // add scrollpane

      add(box); // add box to frame
   } // end TextAreaFrame constructor
} // end class TextAreaFrame

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
