// Fig. 23.28: FindPrimesController.java
// Displaying prime numbers as they're calculated; updating a ProgressBar
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class FindPrimesController {
   @FXML private TextField inputTextField;
   @FXML private Button getPrimesButton;
   @FXML private ListView<Integer> primesListView;
   @FXML private Button cancelButton;
   @FXML private ProgressBar progressBar;
   @FXML private Label statusLabel;

   // stores the list of primes received from PrimeCalculatorTask
   private ObservableList<Integer> primes = 
      FXCollections.observableArrayList();
   private PrimeCalculatorTask task; // finds prime numbers

   // binds primesListView's items to the ObservableList primes
   public void initialize() {
      primesListView.setItems(primes);
   }

   // start calculating primes in the background
   @FXML
   void getPrimesButtonPressed(ActionEvent event) {
      primes.clear();

      // get Fibonacci number to calculate
      try {
         int input = Integer.parseInt(inputTextField.getText());
         task = new PrimeCalculatorTask(input); // create task

         // display task's messages in statusLabel
         statusLabel.textProperty().bind(task.messageProperty());

         // update progressBar based on task's progressProperty
         progressBar.progressProperty().bind(task.progressProperty());

         // store intermediate results in the ObservableList primes
         task.valueProperty().addListener(
            (observable, oldValue, newValue) -> {
               if (newValue != 0) { // task returns 0 when it terminates
                  primes.add(newValue);
                  primesListView.scrollTo(
                     primesListView.getItems().size());
               }
            });

         // when task begins, 
         // disable getPrimesButton and enable cancelButton
         task.setOnRunning((succeededEvent) -> {
            getPrimesButton.setDisable(true);
            cancelButton.setDisable(false);
         });

         // when task completes successfully, 
         // enable getPrimesButton and disable cancelButton
         task.setOnSucceeded((succeededEvent) -> {
            getPrimesButton.setDisable(false);
            cancelButton.setDisable(true);
         });

         // create ExecutorService to manage threads
         ExecutorService executorService = 
            Executors.newFixedThreadPool(1);
         executorService.execute(task); // start the task
         executorService.shutdown();
      }
      catch (NumberFormatException e) {
         inputTextField.setText("Enter an integer");
         inputTextField.selectAll();
         inputTextField.requestFocus();
      }  
   }

   // cancel task when user presses Cancel Button
   @FXML
   void cancelButtonPressed(ActionEvent event) {
      if (task != null) {
         task.cancel(); // terminate the task
         getPrimesButton.setDisable(false);
         cancelButton.setDisable(true);
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
