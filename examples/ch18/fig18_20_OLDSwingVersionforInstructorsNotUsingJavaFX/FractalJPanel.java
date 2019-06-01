// Fig. 18.18: FractalJPanel.java
// Drawing the "Lo feather fractal" using recursion.
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class FractalJPanel extends JPanel
{
   private Color color; // stores color used to draw fractal
   private int level;   // stores current level of fractal

   private static final int WIDTH = 400;  // defines width of JPanel
   private static final int HEIGHT = 400; // defines height of JPanel

   // set the initial fractal level to the value specified
   // and set up JPanel specifications
   public FractalJPanel(int currentLevel)
   {
      color = Color.BLUE; 
      level = currentLevel; // set initial fractal level
      setBackground(Color.WHITE);
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
   } 

   // draw fractal recursively
   public void drawFractal(int level, int xA, int yA, int xB, 
      int yB, Graphics g)
   {
      // base case: draw a line connecting two given points
      if (level == 0) 
         g.drawLine(xA, yA, xB, yB);
      else // recursion step: determine new points, draw next level
      {	
         // calculate midpoint between (xA, yA) and (xB, yB)
         int xC = (xA + xB) / 2;
         int yC = (yA + yB) / 2;

         // calculate the fourth point (xD, yD) which forms an 
         // isosceles right triangle between (xA, yA) and (xC, yC) 
         // where the right angle is at (xD, yD)
         int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
         int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;
         
         // recursively draw the Fractal
         drawFractal(level - 1, xD, yD, xA, yA, g);
         drawFractal(level - 1, xD, yD, xC, yC, g);
         drawFractal(level - 1, xD, yD, xB, yB, g);  
      } 
   } 

   // start the drawing of fractal
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);

      // draw fractal pattern
      g.setColor(color);
      drawFractal(level, 100, 90, 290, 200, g); 
   } 

   // set the drawing color to c
   public void setColor(Color c)
   {
      color = c;
   } 
    
   // set the new level of recursion
   public void setLevel(int currentLevel)
   {
      level = currentLevel;
   } 

   // returns level of recursion 
   public int getLevel()
   {
      return level;
   } 
} // end class FractalJPanel

/*************************************************************************
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