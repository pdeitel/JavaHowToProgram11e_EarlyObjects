// Fig. 24.31: Person.java
// Person class that represents an entry in an address book.
public class Person {
   private int addressID;
   private String firstName;
   private String lastName;
   private String email;
   private String phoneNumber;

   // constructor
   public Person() {}

   // constructor
   public Person(int addressID, String firstName, String lastName, 
      String email, String phoneNumber) {
      this.addressID = addressID;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.phoneNumber = phoneNumber;
   }

   // sets the addressID
   public void setAddressID(int addressID) {this.addressID = addressID;}

   // returns the addressID 
   public int getAddressID() {return addressID;}
   
   // sets the firstName
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   // returns the first name 
   public String getFirstName() {return firstName;}
   
   // sets the lastName
   public void setLastName(String lastName) {this.lastName = lastName;}

   // returns the last name 
   public String getLastName() {return lastName;}
   
   // sets the email address
   public void setEmail(String email) {this.email = email;}

   // returns the email address
   public String getEmail() {return email;}
   
   // sets the phone number
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   } 

   // returns the phone number
   public String getPhoneNumber() {return phoneNumber;}

   // returns the string representation of the Person's name
   @Override
   public String toString() 
      {return getLastName() + ", " + getFirstName();}
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

 