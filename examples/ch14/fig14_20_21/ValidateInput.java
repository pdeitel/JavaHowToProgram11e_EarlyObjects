// Fig. 14.20: ValidateInput.java
// Validating user information using regular expressions.

public class ValidateInput {
   // validate first name
   public static boolean validateFirstName(String firstName) {
      return firstName.matches("[A-Z][a-zA-Z]*");
   } 

   // validate last name
   public static boolean validateLastName(String lastName) {
      return lastName.matches("[a-zA-z]+(['-][a-zA-Z]+)*");
   } 

   // validate address
   public static boolean validateAddress(String address) {
      return address.matches(
         "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
   }

   // validate city
   public static boolean validateCity(String city) {
      return city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
   } 

   // validate state
   public static boolean validateState(String state) {
      return state.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)") ;
   }

   // validate zip
   public static boolean validateZip(String zip) {
      return zip.matches("\\d{5}");
   }

   // validate phone
   public static boolean validatePhone(String phone) {
      return phone.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
   }
} 

/*
 **************************************************************************
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
 **************************************************************************
*/

