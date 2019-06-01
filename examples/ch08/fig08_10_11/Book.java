// Fig. 8.10: Book.java
// Declaring an enum type with a constructor and explicit instance fields 
// and accessors for these fields

public enum Book {
   // declare constants of enum type                          
   JHTP("Java How to Program", "2018"),                       
   CHTP("C How to Program", "2016"),                          
   IW3HTP("Internet & World Wide Web How to Program", "2012"),
   CPPHTP("C++ How to Program", "2017"),                      
   VBHTP("Visual Basic How to Program", "2014"),              
   CSHARPHTP("Visual C# How to Program", "2017");             

   // instance fields 
   private final String title; // book title
   private final String copyrightYear; // copyright year

   // enum constructor
   Book(String title, String copyrightYear) {
      this.title = title;
      this.copyrightYear = copyrightYear;
   } 

   // accessor for field title
   public String getTitle() {
      return title;
   } 

   // accessor for field copyrightYear
   public String getCopyrightYear() {
      return copyrightYear;
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
