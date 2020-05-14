// Fig. 26.39: FlowLayoutFrame.java
// FlowLayout allows components to flow over multiple lines.
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class FlowLayoutFrame extends JFrame 
{
   private final JButton leftJButton; // button to set alignment left
   private final JButton centerJButton; // button to set alignment center
   private final JButton rightJButton; // button to set alignment right
   private final FlowLayout layout; // layout object
   private final Container container; // container to set layout
   
   // set up GUI and register button listeners
   public FlowLayoutFrame()
   {
      super("FlowLayout Demo");

      layout = new FlowLayout(); 
      container = getContentPane(); // get container to layout
      setLayout(layout); 

      // set up leftJButton and register listener
      leftJButton = new JButton("Left"); 
      add(leftJButton); // add Left button to frame
      leftJButton.addActionListener(
         new ActionListener() // anonymous inner class
         {  
            // process leftJButton event  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               layout.setAlignment(FlowLayout.LEFT);

               // realign attached components
               layout.layoutContainer(container);
            } 
         } 
      ); 

      // set up centerJButton and register listener
      centerJButton = new JButton("Center"); 
      add(centerJButton); // add Center button to frame
      centerJButton.addActionListener(
         new ActionListener() // anonymous inner class 
         { 
            // process centerJButton event  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               layout.setAlignment(FlowLayout.CENTER);

               // realign attached components
               layout.layoutContainer(container);
            }
         }
      ); 

      // set up rightJButton and register listener
      rightJButton = new JButton("Right"); // create Right button
      add(rightJButton); // add Right button to frame
      rightJButton.addActionListener(
         new ActionListener() // anonymous inner class
         {  
            // process rightJButton event  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               layout.setAlignment(FlowLayout.RIGHT);

               // realign attached components
               layout.layoutContainer(container);
            } 
         } 
      ); 
   } // end FlowLayoutFrame constructor
} // end class FlowLayoutFrame


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
