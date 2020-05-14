// Fig. 24.33: AddressBookController.java
// Controller for the AddressBook app
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddressBookController {
   @FXML private ListView<Person> listView; // displays contact names
   @FXML private TextField firstNameTextField;
   @FXML private TextField lastNameTextField;
   @FXML private TextField emailTextField;
   @FXML private TextField phoneTextField;
   @FXML private TextField findByLastNameTextField;

   // interacts with the database
   private final PersonQueries personQueries = new PersonQueries();

   // stores list of Person objects that results from a database query
   private final ObservableList<Person> contactList = 
      FXCollections.observableArrayList();
   
   // populate listView and set up listener for selection events
   public void initialize() {
      listView.setItems(contactList); // bind to contactsList
      getAllEntries(); // populates contactList, which updates listView 

      // when ListView selection changes, display selected person's data
      listView.getSelectionModel().selectedItemProperty().addListener(
         (observableValue, oldValue, newValue) -> {
            displayContact(newValue);
         }
      );     
   }

   // get all the entries from the database to populate contactList
   private void getAllEntries() {
      contactList.setAll(personQueries.getAllPeople()); 
      selectFirstEntry();
   }

   // select first item in listView
   private void selectFirstEntry() {
      listView.getSelectionModel().selectFirst();          
   }

   // display contact information
   private void displayContact(Person person) {
      if (person != null) {
         firstNameTextField.setText(person.getFirstName());
         lastNameTextField.setText(person.getLastName());
         emailTextField.setText(person.getEmail());
         phoneTextField.setText(person.getPhoneNumber());
      }
      else {
         firstNameTextField.clear();
         lastNameTextField.clear();
         emailTextField.clear();
         phoneTextField.clear();
      }
   }

   // add a new entry
   @FXML
   void addEntryButtonPressed(ActionEvent event) {
      int result = personQueries.addPerson(
         firstNameTextField.getText(), lastNameTextField.getText(), 
         emailTextField.getText(), phoneTextField.getText());                                     
      
      if (result == 1) {
         displayAlert(AlertType.INFORMATION, "Entry Added", 
            "New entry successfully added.");
      }
      else {
         displayAlert(AlertType.ERROR, "Entry Not Added", 
            "Unable to add entry.");
      }
      
      getAllEntries();
   }

   // find entries with the specified last name
   @FXML
   void findButtonPressed(ActionEvent event) {
      List<Person> people = personQueries.getPeopleByLastName(
         findByLastNameTextField.getText() + "%");

      if (people.size() > 0) { // display all entries
         contactList.setAll(people);
         selectFirstEntry();
      }
      else {
         displayAlert(AlertType.INFORMATION, "Lastname Not Found", 
            "There are no entries with the specified last name.");
      }
   }

   // browse all the entries
   @FXML
   void browseAllButtonPressed(ActionEvent event) {
      getAllEntries();
   }

   // display an Alert dialog
   private void displayAlert(
      AlertType type, String title, String message) {
      Alert alert = new Alert(type);
      alert.setTitle(title);
      alert.setContentText(message);
      alert.showAndWait();
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
