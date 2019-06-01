// Book.java
public class Book {
   private String title; // book title
   private String thumbImage; // source of book cover's thumbnail image
   private String largeImage; // source of book cover's full-size image

   public Book(String title, String thumbImage, String largeImage) {
      this.title = title;
      this.thumbImage = thumbImage;
      this.largeImage = largeImage;
   }
   
   public String getTitle() {return title;}

   public void setTitle(String title) {this.title = title;}
   
   public String getThumbImage() {return thumbImage;}

   public void setThumbImage(String thumbImage) {this.thumbImage = thumbImage;}

   public String getLargeImage() {return largeImage;}

   public void setLargeImage(String largeImage) {this.largeImage = largeImage;}
   
   @Override
   public String toString() {return getTitle();}
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
 **************************************************************************/
