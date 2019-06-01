// Fig. 22.14: CanvasShapesController.java
// Drawing on a Canvas.
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;

public class CanvasShapesController {
   // instance variables that refer to GUI components
   @FXML private Canvas drawingCanvas;       

   // draw on the Canvas
   public void initialize() {
      GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
      gc.setLineWidth(10); // set all stroke widths

      // draw red line
      gc.setStroke(Color.RED);
      gc.strokeLine(10, 10, 100, 100);

      // draw green line
      gc.setGlobalAlpha(0.5); // half transparent
      gc.setLineCap(StrokeLineCap.ROUND);
      gc.setStroke(Color.GREEN);
      gc.strokeLine(100, 10, 10, 100);

      gc.setGlobalAlpha(1.0); // reset alpha transparency

      // draw rounded rect with red border and yellow fill
      gc.setStroke(Color.RED);
      gc.setFill(Color.YELLOW);
      gc.fillRoundRect(120, 10, 90, 90, 50, 50);
      gc.strokeRoundRect(120, 10, 90, 90, 50, 50);

      // draw circle with blue border and red/white radial gradient fill
      gc.setStroke(Color.BLUE);
      Stop[] stopsRadial = 
         {new Stop(0, Color.RED), new Stop(1, Color.WHITE)};
      RadialGradient radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 
         0.6, true, CycleMethod.NO_CYCLE, stopsRadial);
      gc.setFill(radialGradient);
      gc.fillOval(230, 10, 90, 90);
      gc.strokeOval(230, 10, 90, 90);

      // draw ellipse with green border and image fill
      gc.setStroke(Color.GREEN);
      gc.setFill(new ImagePattern(new Image("yellowflowers.png")));
      gc.fillOval(340, 10, 200, 90);
      gc.strokeOval(340, 10, 200, 90);

      // draw arc with purple border and cyan/white linear gradient fill 
      gc.setStroke(Color.PURPLE);
      Stop[] stopsLinear = 
         {new Stop(0, Color.CYAN), new Stop(1, Color.WHITE)};
      LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, 
         true, CycleMethod.NO_CYCLE, stopsLinear);
      gc.setFill(linearGradient);
      gc.fillArc(560, 10, 90, 90, 45, 270, ArcType.ROUND);
      gc.strokeArc(560, 10, 90, 90, 45, 270, ArcType.ROUND);
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
