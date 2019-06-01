// Fig. 15.3: CreateTextFile.java
// Writing data to a sequential text file with class Formatter.
import java.io.FileNotFoundException;     
import java.lang.SecurityException;       
import java.util.Formatter;               
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;  
import java.util.Scanner;                 

public class CreateTextFile {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.printf("%s%n%s%n? ", 
         "Enter account number, first name, last name and balance.",
         "Enter end-of-file indicator to end input.");

      // open clients.txt, output data to the file then close clients.txt
      try (Formatter output = new Formatter("clients.txt")) {
         while (input.hasNext()) { // loop until end-of-file indicator
            try {
               // output new record to file; assumes valid input
               output.format("%d %s %s %.2f%n", input.nextInt(),  
                  input.next(), input.next(), input.nextDouble());
            } 
            catch (NoSuchElementException elementException) {
               System.err.println("Invalid input. Please try again.");
               input.nextLine(); // discard input so user can try again
            } 

            System.out.print("? ");
         }
      }
      catch (SecurityException | FileNotFoundException | 
         FormatterClosedException e) {
         e.printStackTrace();
         System.exit(1); // terminate the program
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