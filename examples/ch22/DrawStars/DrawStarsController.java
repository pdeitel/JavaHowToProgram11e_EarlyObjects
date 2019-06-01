// DrawStarsController.java
// Create a circle of stars using Polygons and Rotate transforms.
import java.security.SecureRandom;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Transform;

public class DrawStarsController {   
   @FXML private Pane pane;
   private static final SecureRandom random = new SecureRandom();
   
   public void initialize() {
      // points that define a five-pointed star shape
      Double[] points = {205.0,150.0, 217.0,186.0, 259.0,186.0, 
         223.0,204.0, 233.0,246.0, 205.0,222.0, 177.0,246.0, 187.0,204.0, 
         151.0,186.0, 193.0,186.0};
      
      // create 18 stars
      for (int count = 0; count < 18; ++count) {
         // create a new Polygon and copy existing points into it
         Polygon newStar = new Polygon();
         newStar.getPoints().addAll(points); 

         // create random Color and set as newStar's fill
         newStar.setStroke(Color.GREY);
         newStar.setFill(Color.rgb(random.nextInt(255), 
            random.nextInt(255), random.nextInt(255), 
            random.nextDouble())); 

         // apply a rotation to the shape
         newStar.getTransforms().add(
            Transform.rotate(count * 20, 150, 150));
         pane.getChildren().add(newStar);
      } 
   }   
}

/*************************************************************************
* (C) Copyright 1992-2017 by Deitel & Associates, Inc. and               *
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
