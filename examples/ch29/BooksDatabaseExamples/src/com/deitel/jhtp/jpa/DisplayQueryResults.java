// Fig. 29.2: DisplayQueryResults.java
// Display the results of various queries.

package com.deitel.jhtp.jpa;

import java.util.Comparator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DisplayQueryResults
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

      // TypedQuery that returns all authors
      TypedQuery<Authors> findAllAuthors = 
         entityManager.createNamedQuery("Authors.findAll", Authors.class);
      
      // display titles grouped by author
      System.out.printf("Titles grouped by author:%n");

      // get the List of Authors then display the results
      findAllAuthors.getResultList().stream()
         .sorted(Comparator.comparing(Authors::getLastname)
            .thenComparing(Authors::getFirstname))
         .forEach((author) ->
            {
               System.out.printf("%n%s %s:%n", 
                  author.getFirstname(), author.getLastname());          

               for (Titles title : author.getTitlesList())
               {
                  System.out.printf("\t%s%n", title.getTitle()); 
               }
            }
         );

      // TypedQuery that returns all titles
      TypedQuery<Titles> findAllTitles = 
         entityManager.createNamedQuery("Titles.findAll", Titles.class);
      
      // display authors grouped by title
      System.out.printf("%nAuthors grouped by title:%n%n");
      
      // get the List of Titles then display the results
      findAllTitles.getResultList().stream()
         .sorted(Comparator.comparing(Titles::getTitle))
         .forEach((title) ->
            {
               System.out.println(title.getTitle());
               
               for (Authors author : title.getAuthorsList())
               {
                  System.out.printf("\t%s %s%n", 
                     author.getFirstname(), author.getLastname());
               }
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
