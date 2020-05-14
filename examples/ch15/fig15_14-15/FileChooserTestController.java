// Fig. 13.6: FileChooserTestController.java
// Displays information about a selected file or folder. 
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class FileChooserTestController {
   @FXML private BorderPane borderPane;
   @FXML private Button selectFileButton;
   @FXML private Button selectDirectoryButton;
   @FXML private TextArea textArea;

   // handles selectFileButton's events
   @FXML
   private void selectFileButtonPressed(ActionEvent e) {
      // configure dialog allowing selection of a file 
      FileChooser fileChooser = new FileChooser();               
      fileChooser.setTitle("Select File");

      // display files in folder from which the app was launched
      fileChooser.setInitialDirectory(new File(".")); 

      // display the FileChooser
      File file = fileChooser.showOpenDialog(
         borderPane.getScene().getWindow());               

      // process selected Path or display a message
      if (file != null) {
         analyzePath(file.toPath());            
      }
      else {
         textArea.setText("Select file or directory");
      }
   } 

   // handles selectDirectoryButton's events
   @FXML
   private void selectDirectoryButtonPressed(ActionEvent e) {
      // configure dialog allowing selection of a directory
      DirectoryChooser directoryChooser = new DirectoryChooser();               
      directoryChooser.setTitle("Select Directory");

      // display folder from which the app was launched
      directoryChooser.setInitialDirectory(new File(".")); 

      // display the FileChooser
      File file = directoryChooser.showDialog(
         borderPane.getScene().getWindow());               

      // process selected Path or display a message
      if (file != null) {
         analyzePath(file.toPath());            
      }
      else {
         textArea.setText("Select file or directory");
      }
   } 

   // display information about file or directory user specifies
   public void analyzePath(Path path) {
      try {
         // if the file or directory exists, display its info
         if (path != null && Files.exists(path)) {
            // gather file (or directory) information
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s:%n", path.getFileName()));
            builder.append(String.format("%s a directory%n", 
               Files.isDirectory(path) ? "Is" : "Is not"));
            builder.append(String.format("%s an absolute path%n", 
               path.isAbsolute() ? "Is" : "Is not"));
            builder.append(String.format("Last modified: %s%n", 
               Files.getLastModifiedTime(path)));
            builder.append(String.format("Size: %s%n", Files.size(path)));
            builder.append(String.format("Path: %s%n", path));
            builder.append(String.format("Absolute path: %s%n", 
               path.toAbsolutePath()));

            if (Files.isDirectory(path)) { // output directory listing
               builder.append(String.format("%nDirectory contents:%n"));
               
               // object for iterating through a directory's contents
               DirectoryStream<Path> directoryStream = 
                  Files.newDirectoryStream(path);
      
               for (Path p : directoryStream) {
                  builder.append(String.format("%s%n", p));
               }
            }

            // display file or directory info
            textArea.setText(builder.toString()); 
         } 
         else { // Path does not exist
            textArea.setText("Path does not exist");
         }   
      }
      catch (IOException ioException) {
         textArea.setText(ioException.toString());
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
