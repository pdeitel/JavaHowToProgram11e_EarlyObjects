// Fig. 7.25: DrawRainbowController.java
// Drawing a rainbow using arcs.
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class DrawRainbowController { 
   @FXML private Canvas canvas;

   // colors to use in the rainbow, starting from the innermost
   // The two white entries result in an empty arc in the center
   private final Color[] colors = {
      Color.WHITE, Color.WHITE, Color.VIOLET, Color.INDIGO, Color.BLUE,
      Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};
  
   // draws a rainbow using arcs
   @FXML
   void drawRainbowButtonPressed(ActionEvent event) {
      // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();

      final int radius = 20; // radius of an arc
      
      // draw the rainbow near the bottom-center
      final double centerX = canvas.getWidth() / 2;
      final double maxY = canvas.getHeight() - 10;

      // draws filled arcs starting with the outermost
      for (int counter = colors.length; counter > 0; counter--) {
         // set the color for the current arc
         gc.setFill(colors[counter - 1]);
         
         // fill the arc from 0 to 180 degrees
         gc.fillArc(centerX - counter * radius,
            maxY - counter * radius, counter * radius * 2, 
            counter * radius * 2, 0, 180, ArcType.OPEN);
      } 
   }
}

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
