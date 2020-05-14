// Fig. 3.16: DrawSmileyController.java
// Drawing a smiley face using colors and filled shapes.
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawSmileyController { 
   @FXML private Canvas canvas;
   
   // draws a smiley face
   @FXML
   void drawSmileyButtonPressed(ActionEvent event) {
      // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();

      // draw the face
      gc.setFill(Color.YELLOW);
      gc.fillOval(10, 10, 280, 280);
      gc.strokeOval(10, 10, 280, 280); 
      
      // draw the eyes
      gc.setFill(Color.BLACK);
      gc.fillOval(75, 85, 40, 40);
      gc.fillOval(185, 85, 40, 40);
      
      // draw the mouth
      gc.fillOval(50, 130, 200, 120);
      
      // "touch up" the mouth into a smile
      gc.setFill(Color.YELLOW);
      gc.fillRect(50, 130, 200, 60);
      gc.fillOval(50, 140, 200, 90);
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
