// Fig. 28.13: TicTacToeClient.java
// Client side of client/server Tic-Tac-Toe program.
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TicTacToeClient extends JFrame implements Runnable 
{
   private JTextField idField; // textfield to display player's mark
   private JTextArea displayArea; // JTextArea to display output
   private JPanel boardPanel; // panel for tic-tac-toe board
   private JPanel panel2; // panel to hold board
   private Square[][] board; // tic-tac-toe board
   private Square currentSquare; // current square
   private Socket connection; // connection to server
   private Scanner input; // input from server
   private Formatter output; // output to server
   private String ticTacToeHost; // host name for server
   private String myMark; // this client's mark
   private boolean myTurn; // determines which client's turn it is
   private final String X_MARK = "X"; // mark for first client
   private final String O_MARK = "O"; // mark for second client

   // set up user-interface and board
   public TicTacToeClient(String host)
   { 
      ticTacToeHost = host; // set name of server
      displayArea = new JTextArea(4, 30); // set up JTextArea
      displayArea.setEditable(false);
      add(new JScrollPane(displayArea), BorderLayout.SOUTH);

      boardPanel = new JPanel(); // set up panel for squares in board
      boardPanel.setLayout(new GridLayout(3, 3, 0, 0));

      board = new Square[3][3]; // create board

      // loop over the rows in the board
      for (int row = 0; row < board.length; row++) 
      {
         // loop over the columns in the board
         for (int column = 0; column < board[row].length; column++) 
         {
            // create square
            board[row][column] = new Square(" ", row * 3 + column);
            boardPanel.add(board[row][column]); // add square       
         }
      } 

      idField = new JTextField(); // set up textfield
      idField.setEditable(false);
      add(idField, BorderLayout.NORTH);
      
      panel2 = new JPanel(); // set up panel to contain boardPanel
      panel2.add(boardPanel, BorderLayout.CENTER); // add board panel
      add(panel2, BorderLayout.CENTER); // add container panel

      setSize(300, 225); // set size of window
      setVisible(true); // show window

      startClient();
   }

   // start the client thread
   public void startClient()
   {
      try // connect to server and get streams
      {
         // make connection to server
         connection = new Socket(
            InetAddress.getByName(ticTacToeHost), 12345);

         // get streams for input and output
         input = new Scanner(connection.getInputStream());
         output = new Formatter(connection.getOutputStream());
      } 
      catch (IOException ioException)
      {
         ioException.printStackTrace();         
      } 

      // create and start worker thread for this client
      ExecutorService worker = Executors.newFixedThreadPool(1);
      worker.execute(this); // execute client
   }

   // control thread that allows continuous update of displayArea
   public void run()
   {
      myMark = input.nextLine(); // get player's mark (X or O)

      SwingUtilities.invokeLater(
         new Runnable() 
         {         
            public void run()
            {
               // display player's mark
               idField.setText("You are player \"" + myMark + "\"");
            } 
         } 
      ); 
            
      myTurn = (myMark.equals(X_MARK)); // determine if client's turn

      // receive messages sent to client and output them
      while (true)
      {
         if (input.hasNextLine())
            processMessage(input.nextLine());
      } 
   }

   // process messages received by client
   private void processMessage(String message)
   {
      // valid move occurred
      if (message.equals("Valid move.")) 
      {
         displayMessage("Valid move, please wait.\n");
         setMark(currentSquare, myMark); // set mark in square
      } 
      else if (message.equals("Invalid move, try again")) 
      {
         displayMessage(message + "\n"); // display invalid move
         myTurn = true; // still this client's turn
      }  
      else if (message.equals("Opponent moved")) 
      {
         int location = input.nextInt(); // get move location
         input.nextLine(); // skip newline after int location
         int row = location / 3; // calculate row
         int column = location % 3; // calculate column

         setMark(board[row][column], 
            (myMark.equals(X_MARK) ? O_MARK : X_MARK)); // mark move                
         displayMessage("Opponent moved. Your turn.\n");
         myTurn = true; // now this client's turn
      }  
      else
         displayMessage(message + "\n"); // display the message
   }

   // manipulate displayArea in event-dispatch thread
   private void displayMessage(final String messageToDisplay)
   {
      SwingUtilities.invokeLater(
         new Runnable() 
         {
            public void run() 
            {
               displayArea.append(messageToDisplay); // updates output
            } 
         } 
      ); 
   } 

   // utility method to set mark on board in event-dispatch thread
   private void setMark(final Square squareToMark, final String mark)
   {
      SwingUtilities.invokeLater(
         new Runnable() 
         {
            public void run()
            {
               squareToMark.setMark(mark); // set mark in square
            } 
         } 
      ); 
   } 

   // send message to server indicating clicked square
   public void sendClickedSquare(int location)
   {
      // if it is my turn
      if (myTurn) 
      {
         output.format("%d\n", location); // send location to server
         output.flush();
         myTurn = false; // not my turn any more
      } 
   }

   // set current Square
   public void setCurrentSquare(Square square)
   {
      currentSquare = square; // set current square to argument
   }

   // private inner class for the squares on the board
   private class Square extends JPanel 
   {
      private String mark; // mark to be drawn in this square
      private int location; // location of square
   
      public Square(String squareMark, int squareLocation)
      {
         mark = squareMark; // set mark for this square
         location = squareLocation; // set location of this square

         addMouseListener(
            new MouseAdapter() 
            {
               public void mouseReleased(MouseEvent e)
               {
                  setCurrentSquare(Square.this); // set current square

                  // send location of this square
                  sendClickedSquare(getSquareLocation());
               } 
            } 
         ); 
      } 

      // return preferred size of Square
      public Dimension getPreferredSize() 
      { 
         return new Dimension(30, 30); // return preferred size
      }

      // return minimum size of Square
      public Dimension getMinimumSize() 
      {
         return getPreferredSize(); // return preferred size
      }

      // set mark for Square
      public void setMark(String newMark) 
      { 
         mark = newMark; // set mark of square
         repaint(); // repaint square
      }

      // return Square location
      public int getSquareLocation() 
      {
         return location; // return location of square
      }

      // draw Square
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g);

         g.drawRect(0, 0, 29, 29); // draw square
         g.drawString(mark, 11, 20); // draw mark   
      } 
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
