// Fig. 13.16: Metrics.java
// Displaying font metrics.
import javax.swing.JFrame;

public class Metrics 
{
   // execute application
   public static void main(String[] args)
   {
      // create frame for MetricsJPanel
      JFrame frame = new JFrame("Demonstrating FontMetrics");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      MetricsJPanel metricsJPanel = new MetricsJPanel(); 
      frame.add(metricsJPanel); 
      frame.setSize(510, 240);
      frame.setVisible(true);
   } 
} // end class Metrics

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
