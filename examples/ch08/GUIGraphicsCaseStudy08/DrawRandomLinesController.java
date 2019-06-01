// Fig. 8.18: DrawRandomLinesController.java
// Drawing random lines using MyLine objects.
import java.security.SecureRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class DrawRandomLinesController { 
   private static final SecureRandom randomNumbers = new SecureRandom();
   @FXML private Canvas canvas;

   // draws random lines
   @FXML
   void drawLinesButtonPressed(ActionEvent event) {
      // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();

      MyLine[] lines = new MyLine[100]; // stores the MyLine objects
      
      final int width = (int) canvas.getWidth();
      final int height = (int) canvas.getHeight();

      // create lines
      for (int count = 0; count < lines.length; count++) {
         // generate random coordinates
         int x1 = randomNumbers.nextInt(width);
         int y1 = randomNumbers.nextInt(height);
         int x2 = randomNumbers.nextInt(width);
         int y2 = randomNumbers.nextInt(height);
         
         // generate a random color
         Color color = Color.rgb(randomNumbers.nextInt(256), 
            randomNumbers.nextInt(256), randomNumbers.nextInt(256));
         
         // add a new MyLine to the array
         lines[count] = new MyLine(x1, y1, x2, y2, color);
      } 

      // clear the Canvas then draw the lines
      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); 

      for (MyLine line : lines) {
         line.draw(gc);
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
