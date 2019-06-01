// Fig. 15.6: ReadTextFile.java
// This program reads a text file and displays each record.
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
   public static void main(String[] args) {
      // open clients.txt, read its contents and close the file
      try(Scanner input = new Scanner(Paths.get("clients.txt"))) {
         System.out.printf("%-10s%-12s%-12s%10s%n", "Account",
            "First Name", "Last Name", "Balance");

         // read record from file
         while (input.hasNext()) { // while there is more to read
            // display record contents                     
            System.out.printf("%-10d%-12s%-12s%10.2f%n", input.nextInt(),
               input.next(), input.next(), input.nextDouble());          
         }       
      } 
      catch (IOException | NoSuchElementException | 
         IllegalStateException e) {
         e.printStackTrace();
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