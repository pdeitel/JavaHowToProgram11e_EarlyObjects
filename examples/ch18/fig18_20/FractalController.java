// Fig. 18.20: FractalController.java
// Drawing the "Lo feather fractal" using recursion.
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;    

public class FractalController {
   // constants 
   private static final int MIN_LEVEL = 0;
   private static final int MAX_LEVEL = 15;

   // instance variables that refer to GUI components
   @FXML private Canvas canvas;
   @FXML private ColorPicker colorPicker;
   @FXML private Label levelLabel;

   // other instance variables
   private Color currentColor = Color.BLUE;
   private int level = MIN_LEVEL; // initial fractal level
   private GraphicsContext gc; // used to draw on Canvas

   // initialize the controller
   public void initialize() {
      levelLabel.setText("Level: " + level);
      colorPicker.setValue(currentColor); // start with purple
      gc = canvas.getGraphicsContext2D(); // get the GraphicsContext
      drawFractal();
   }
   
   // sets currentColor when user chooses a new Color
   @FXML
   void colorSelected(ActionEvent event) {
      currentColor = colorPicker.getValue(); // get new Color
      drawFractal();
   }

   // decrease level and redraw fractal
   @FXML
   void decreaseLevelButtonPressed(ActionEvent event) {
      if (level > MIN_LEVEL) {
         --level;
         levelLabel.setText("Level: " + level);
         drawFractal();
      }
   }

   // increase level and redraw fractal
   @FXML
   void increaseLevelButtonPressed(ActionEvent event) {
      if (level < MAX_LEVEL) {
         ++level;
         levelLabel.setText("Level: " + level);
         drawFractal();
      }
   }

   // clear Canvas, set drawing color and draw the fractal
   private void drawFractal() {
      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
      gc.setStroke(currentColor);
      drawFractal(level, 40, 40, 350, 350); 
   }

   // draw fractal recursively
   public void drawFractal(int level, int xA, int yA, int xB, int yB) {
      // base case: draw a line connecting two given points
      if (level == 0) {
         gc.strokeLine(xA, yA, xB, yB);
      }
      else { // recursion step: determine new points, draw next level
         // calculate midpoint between (xA, yA) and (xB, yB)
         int xC = (xA + xB) / 2;
         int yC = (yA + yB) / 2;

         // calculate the fourth point (xD, yD) which forms an 
         // isosceles right triangle between (xA, yA) and (xC, yC) 
         // where the right angle is at (xD, yD)
         int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
         int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;
         
         // recursively draw the Fractal
         drawFractal(level - 1, xD, yD, xA, yA);
         drawFractal(level - 1, xD, yD, xC, yC);
         drawFractal(level - 1, xD, yD, xB, yB);  
      } 
   } 

   public static void selectionSort(int[] data) {
      // loop over data.length - 1 elements      
      for (int i = 0; i < data.length - 1; i++) {
         int smallest = i; // first index of remaining array

         // loop to find index of smallest element                      
         for (int index = i + 1; index < data.length; index++) {
            if (data[index] < data[smallest]) {
               smallest = index;                                        
             }                                                                 
         }                               
                                                                        
         swap(data, i, smallest); // swap smallest element into position
      }                                                                 
   } 

   // helper method to swap values in two elements
   private static void swap(int[] data, int first, int second) {
      int temporary = data[first]; // store first in temporary
      data[first] = data[second]; // replace first with second
      data[second] = temporary; // put temporary in second
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
