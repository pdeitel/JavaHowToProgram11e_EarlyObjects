// Fig. 13.15: MetricsJPanel.java
// FontMetrics and Graphics methods useful for obtaining font metrics.
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MetricsJPanel extends JPanel 
{
   // display font metrics
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 

      g.setFont(new Font("SansSerif", Font.BOLD, 12));
      FontMetrics metrics = g.getFontMetrics();
      g.drawString("Current font: " + g.getFont(), 10, 30);
      g.drawString("Ascent: " + metrics.getAscent(), 10, 45);
      g.drawString("Descent: " + metrics.getDescent(), 10, 60);
      g.drawString("Height: " + metrics.getHeight(), 10, 75);
      g.drawString("Leading: " + metrics.getLeading(), 10, 90);

      Font font = new Font("Serif", Font.ITALIC, 14);
      metrics = g.getFontMetrics(font);
      g.setFont(font);
      g.drawString("Current font: " + font, 10, 120);
      g.drawString("Ascent: " + metrics.getAscent(), 10, 135);
      g.drawString("Descent: " + metrics.getDescent(), 10, 150);
      g.drawString("Height: " + metrics.getHeight(), 10, 165);
      g.drawString("Leading: " + metrics.getLeading(), 10, 180);
   } 
} // end class MetricsJPanel

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
