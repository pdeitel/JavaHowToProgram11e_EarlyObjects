// Fig. 29.1: DisplayAuthors.java
// Displaying the contents of the authors table.
package com.deitel.jhtp.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DisplayAuthors 
{
   public static void main(String[] args)
   {
      // create an EntityManagerFactory for the persistence unit
      EntityManagerFactory entityManagerFactory = 
         Persistence.createEntityManagerFactory(
            "BooksDatabaseExamplesPU");

      // create an EntityManager for interacting with the persistence unit
      EntityManager entityManager = 
         entityManagerFactory.createEntityManager();

      // create a dynamic TypedQuery<Authors> that selects all authors
      TypedQuery<Authors> findAllAuthors = entityManager.createQuery(
         "SELECT author FROM Authors AS author", Authors.class);
      
      // display List of Authors
      System.out.printf("Authors Table of Books Database:%n%n");
      System.out.printf("%-12s%-13s%s%n", 
         "Author ID", "First Name", "Last Name");
      
      // get all authors, create a stream and display each author
      findAllAuthors.getResultList().stream()
         .forEach((author) -> 
            {
               System.out.printf("%-12d%-13s%s%n", author.getAuthorid(), 
                  author.getFirstname(), author.getLastname());
            }
         );
   }
}


/**************************************************************************
 * (C) Copyright 1992-2018  by Deitel & Associates, Inc. and               *
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
