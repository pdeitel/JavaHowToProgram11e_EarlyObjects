// Fig. 29.4: AddressBookController.java
// Controller for a simple address book
package com.deitel.jhtp.jpa;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AddressBookController {
   @FXML private ListView<Addresses> listView;
   @FXML private TextField firstNameTextField;
   @FXML private TextField lastNameTextField;
   @FXML private TextField emailTextField;
   @FXML private TextField phoneTextField;
   @FXML private TextField findByLastNameTextField;

   // create an EntityManagerFactory for the persistence unit
   private final EntityManagerFactory entityManagerFactory = 
      Persistence.createEntityManagerFactory("AddressBookPU");

   // create an EntityManager for interacting with the persistence unit
   private final EntityManager entityManager = 
      entityManagerFactory.createEntityManager();
   
   // stores list of Addresses objects that results from a database query
   private final ObservableList<Addresses> contactList = 
      FXCollections.observableArrayList();
   
   // populate listView and set up listener for selection events
   public void initialize() {
      listView.setItems(contactList); // bind to contactsList

      // when ListView selection changes, display selected person's data
      listView.getSelectionModel().selectedItemProperty().addListener(
         (observableValue, oldValue, newValue) -> {
            displayContact(newValue);
         }
      );     
      getAllEntries(); // populates contactList, which updates listView 
   }

   // get all the entries from the database to populate contactList
   private void getAllEntries() {
      // query that returns all contacts
      TypedQuery<Addresses> findAllAddresses = 
         entityManager.createNamedQuery(
            "Addresses.findAll", Addresses.class);

      contactList.setAll(findAllAddresses.getResultList()); 
      selectFirstEntry();
   }

   // select first item in listView
   private void selectFirstEntry() {
      listView.getSelectionModel().selectFirst();          
   }

   // display contact information
   private void displayContact(Addresses contact) {
      if (contact != null) {
         firstNameTextField.setText(contact.getFirstname());
         lastNameTextField.setText(contact.getLastname());
         emailTextField.setText(contact.getEmail());
         phoneTextField.setText(contact.getPhonenumber());
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
      Addresses address = new Addresses();
      address.setFirstname(firstNameTextField.getText());
      address.setLastname(lastNameTextField.getText());
      address.setPhonenumber(phoneTextField.getText());
      address.setEmail(emailTextField.getText());

      // get an EntityTransaction to manage insert operation
      EntityTransaction transaction = entityManager.getTransaction();
      
      try
      {
         transaction.begin(); // start transaction
         entityManager.persist(address); // store new entry
         transaction.commit(); // commit changes to the database
         displayAlert(AlertType.INFORMATION, "Entry Added", 
            "New entry successfully added.");
      }
      catch (Exception e) // if transaction failed
      {
         transaction.rollback(); // undo database operations 
         displayAlert(AlertType.ERROR, "Entry Not Added", 
            "Unable to add entry: " + e);
      }      
      
      getAllEntries();
   }

   // find entries with the specified last name
   @FXML
   void findButtonPressed(ActionEvent event) {
      // query that returns all contacts
      TypedQuery<Addresses> findByLastname = 
         entityManager.createNamedQuery(
            "Addresses.findByLastname", Addresses.class);

      // configure parameter for query
      findByLastname.setParameter(
         "lastname", findByLastNameTextField.getText() + "%");

      // get all addresses      
      List<Addresses> people = findByLastname.getResultList(); 

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
