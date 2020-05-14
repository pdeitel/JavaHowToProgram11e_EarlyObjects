// AddressBean.java
// Bean for interacting with the AddressBook database
package addressbook;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition; 
import javax.inject.Named;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

// define the data source
@DataSourceDefinition(
   name = "java:global/jdbc/addressbook",
   className = "org.apache.derby.jdbc.ClientDataSource",
   url = "jdbc:derby://localhost:1527/addressbook",
   databaseName = "addressbook",
   user = "APP",
   password = "APP")

@Named("addressBean")
@javax.faces.view.ViewScoped 
public class AddressBean implements Serializable
{
   // instance variables that represent one address
   private String firstName;
   private String lastName;
   private String street;
   private String city;
   private String state;
   private String zipcode;

   // allow the server to inject the DataSource
   @Resource(lookup="java:global/jdbc/addressbook")
   DataSource dataSource;
  
   // get the first name
   public String getFirstName()
   {
      return firstName;
   }
   
   // set the first name
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }
   
   // get the last name
   public String getLastName()
   {
      return lastName;
   }
   
   // set the last name
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }
   
   // get the street
   public String getStreet()
   {
      return street;
   }
   
   // set the street
   public void setStreet(String street)
   {
      this.street = street;
   }
   
   // get the city
   public String getCity()
   {
      return city;
   }
   
   // set the city
   public void setCity(String city)
   {
      this.city = city;
   }
   
   // get the state
   public String getState()
   {
      return state;
   }
   
   // set the state
   public void setState(String state)
   {
      this.state = state;
   }
   
   // get the zipcode
   public String getZipcode()
   {
      return zipcode;
   }
   
   // set the zipcode
   public void setZipcode(String zipcode)
   {
      this.zipcode = zipcode;
   }
   
   // return a ResultSet of entries
   public ResultSet getAddresses() throws SQLException
   {
      // check whether dataSource was injected by the server
      if (dataSource == null)
      {
         throw new SQLException("Unable to obtain DataSource");
      }
      
      // obtain a connection from the connection pool
      Connection connection = dataSource.getConnection();

      // check whether connection was successful
      if (connection == null)
      {
         throw new SQLException("Unable to connect to DataSource");
      }
      
      try
      {
         // create a PreparedStatement to insert a new address book entry
         PreparedStatement getAddresses = connection.prepareStatement(
            "SELECT FIRSTNAME, LASTNAME, STREET, CITY, STATE, ZIP " +
            "FROM ADDRESSES ORDER BY LASTNAME, FIRSTNAME");
   
         CachedRowSet rowSet = 
            RowSetProvider.newFactory().createCachedRowSet();
         rowSet.populate(getAddresses.executeQuery());
         return rowSet; 
      } 
      finally
      {
         connection.close(); // return this connection to pool
      } 
   } 
   
   // save a new address book entry
   public String save() throws SQLException
   {
      // check whether dataSource was injected by the server
      if (dataSource == null)
      {
         throw new SQLException("Unable to obtain DataSource");
      }
      
      // obtain a connection from the connection pool
      Connection connection = dataSource.getConnection();
      
      // check whether connection was successful
      if (connection == null)
      {
         throw new SQLException("Unable to connect to DataSource");
      }
      
      try
      {
         // create a PreparedStatement to insert a new address book entry
         PreparedStatement addEntry = 
            connection.prepareStatement("INSERT INTO ADDRESSES " +
               "(FIRSTNAME,LASTNAME,STREET,CITY,STATE,ZIP)" +
               " VALUES (?, ?, ?, ?, ?, ?)");

         // specify the PreparedStatement's arguments
         addEntry.setString(1, getFirstName());
         addEntry.setString(2, getLastName());
         addEntry.setString(3, getStreet());
         addEntry.setString(4, getCity());
         addEntry.setString(5, getState());
         addEntry.setString(6, getZipcode());

         addEntry.executeUpdate(); // insert the entry
         return "index"; // go back to index.xhtml page
      } 
      finally
      {
         connection.close(); // return this connection to pool
      } 
   } 
} 



/*************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and              *
 * Pearson Education, Inc. All Rights Reserved.                          *
 *                                                                       *
 * DISCLAIMER: The authors and publisher of this book have used their    *
 * best efforts in preparing the book. These efforts include the         *
 * development, research, and testing of the theories and programs       *
 * to determine their effectiveness. The authors and publisher make      *
 * no warranty of any kind, expressed or implied, with regard to these   *
 * programs or to the documentation contained in these books. The authors*
 * and publisher shall not be liable in any event for incidental or      *
 * consequential damages in connection with, or arising out of, the      *
 * furnishing, performance, or use of these programs.                    *
 ************************************************************************/



