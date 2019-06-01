// Fig. 15.13: ReadSequentialFile.java
// Reading a file of XML serialized objects with JAXB and a 
// BufferedReader and displaying each object.
import java.io.BufferedReader;      
import java.io.IOException;      
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.bind.JAXB;

public class ReadSequentialFile {
   public static void main(String[] args) {
      // try to open file for deserialization
      try(BufferedReader input = 
         Files.newBufferedReader(Paths.get("clients.xml"))) {
         // unmarshal the file's contents
         Accounts accounts = JAXB.unmarshal(input, Accounts.class);
         
         // display contents
         System.out.printf("%-10s%-12s%-12s%10s%n", "Account",
            "First Name", "Last Name", "Balance");

         for (Account account : accounts.getAccounts()) {
            System.out.printf("%-10d%-12s%-12s%10.2f%n",  
               account.getAccountNumber(), account.getFirstName(), 
               account.getLastName(), account.getBalance());
         }
      } 
      catch (IOException ioException) {
         System.err.println("Error opening file.");
      } 
   }
}


/*************************************************************************
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