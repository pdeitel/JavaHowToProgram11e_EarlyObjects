// Fig. 3.13: DrawShapesController.java
// Using strokeRect and strokeOval to draw rectangles and ovals.
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawShapesController { 
   @FXML private Canvas canvas;
   
   // when user presses Draw Rectangles button, call draw for rectangles
   @FXML
   void drawRectanglesButtonPressed(ActionEvent event) {
      draw("rectangles"); 
   }

   // when user presses Draw Ovals button, call draw for ovals
   @FXML
   void drawOvalsButtonPressed(ActionEvent event) {
      draw("ovals"); 
   }

   // draws rectangles or ovals based on which Button the user pressed
   public void draw(String choice) {
      // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();

      // clear the canvas for next set of shapes
      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

      int step = 10;

      // draw 10 overlapping shapes
      for (int i = 0; i < 10; i++) {
         // pick the shape based on the user's choice
         switch (choice) {
            case "rectangles": // draw rectangles
               gc.strokeRect(10 + i * step, 10 + i * step, 
                  90 + i * step, 90 + i * step);
               break;
            case "ovals": // draw ovals
               gc.strokeOval(10 + i * step, 10 + i * step, 
                  90 + i * step, 90 + i * step);
               break;
         } 
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
