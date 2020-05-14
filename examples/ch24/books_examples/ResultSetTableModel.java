// Fig. 24.25: ResultSetTableModel.java
// A TableModel that supplies ResultSet data to a JTable.
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

// ResultSet rows and columns are counted from 1 and JTable 
// rows and columns are counted from 0. When processing 
// ResultSet rows or columns for use in a JTable, it is 
// necessary to add 1 to the row or column number to manipulate
// the appropriate ResultSet column (i.e., JTable column 0 is 
// ResultSet column 1 and JTable row 0 is ResultSet row 1).
public class ResultSetTableModel extends AbstractTableModel {
   private final Connection connection;
   private final Statement statement;
   private ResultSet resultSet;
   private ResultSetMetaData metaData;
   private int numberOfRows;

   // keep track of database connection status 
   private boolean connectedToDatabase = false;
   
   // constructor initializes resultSet and obtains its metadata object;
   // determines number of rows
   public ResultSetTableModel(String url, String username,
       String password, String query) throws SQLException {
      // connect to database
      connection = DriverManager.getConnection(url, username, password);

      // create Statement to query database                             
      statement = connection.createStatement(                           
         ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

      // update database connection status
      connectedToDatabase = true;         

      // set query and execute it
      setQuery(query);
   } 

   // get class that represents column type
   public Class getColumnClass(int column) throws IllegalStateException {
      // ensure database connection is available                      
      if (!connectedToDatabase) {                                     
         throw new IllegalStateException("Not Connected to Database");
      }                                                               

      // determine Java class of column
      try {
         String className = metaData.getColumnClassName(column + 1);
         
         // return Class object that represents className
         return Class.forName(className);              
      } 
      catch (Exception exception) {
         exception.printStackTrace();
      } 
      
      return Object.class; // if problems occur above, assume type Object
   } 

   // get number of columns in ResultSet
   public int getColumnCount() throws IllegalStateException {
      // ensure database connection is available
      if (!connectedToDatabase) {
         throw new IllegalStateException("Not Connected to Database");
      }                                                               

      // determine number of columns
      try {
         return metaData.getColumnCount(); 
      } 
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
      } 
      
      return 0; // if problems occur above, return 0 for number of columns
   } 

   // get name of a particular column in ResultSet
   public String getColumnName(int column) throws IllegalStateException {
      // ensure database connection is available
      if (!connectedToDatabase) {
         throw new IllegalStateException("Not Connected to Database");
      }                                                               

      // determine column name
      try {
         return metaData.getColumnName(column + 1);  
      } 
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
      } 
      
      return ""; // if problems, return empty string for column name
   } 

   // return number of rows in ResultSet
   public int getRowCount() throws IllegalStateException {
      // ensure database connection is available
      if (!connectedToDatabase) {
         throw new IllegalStateException("Not Connected to Database");
      }                                                               
 
      return numberOfRows;
   } 

   // obtain value in particular row and column
   public Object getValueAt(int row, int column) 
      throws IllegalStateException {

      // ensure database connection is available
      if (!connectedToDatabase) {
         throw new IllegalStateException("Not Connected to Database");
      }

      // obtain a value at specified ResultSet row and column
      try {
         resultSet.absolute(row + 1);           
         return resultSet.getObject(column + 1);
      } 
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
      } 
      
      return ""; // if problems, return empty string object
   } 
   
   // set new database query string
   public void setQuery(String query) 
      throws SQLException, IllegalStateException {
   
      // ensure database connection is available
      if (!connectedToDatabase) {
         throw new IllegalStateException("Not Connected to Database");
      }

      // specify query and execute it
      resultSet = statement.executeQuery(query);

      // obtain metadata for ResultSet
      metaData = resultSet.getMetaData(); 

      // determine number of rows in ResultSet
      resultSet.last(); // move to last row
      numberOfRows = resultSet.getRow(); // get row number      
      
      
      fireTableStructureChanged(); // notify JTable that model has changed
   } 
                                                  
   // close Statement and Connection                  
   public void disconnectFromDatabase() {             
      if (connectedToDatabase) {                      
         // close Statement and Connection            
         try {                                        
            resultSet.close();                        
            statement.close();                        
            connection.close();                       
         }                                            
         catch (SQLException sqlException) {          
            sqlException.printStackTrace();           
         }                                            
         finally { // update database connection status
            connectedToDatabase = false;              
         }                      
      }                    
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
