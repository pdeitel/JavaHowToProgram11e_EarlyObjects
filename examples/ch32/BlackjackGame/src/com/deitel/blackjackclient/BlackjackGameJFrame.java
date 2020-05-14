// Fig. 32.18: BlackjackGameJFrame.java
// Blackjack game that uses the Blackjack Web Service.
package com.deitel.blackjackclient;

import com.deitel.blackjack.Blackjack;
import com.deitel.blackjack.BlackjackService;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.ws.BindingProvider;

public class BlackjackGameJFrame extends javax.swing.JFrame
{
   private String playerCards;
   private String dealerCards;
   private ArrayList<JLabel> cardboxes; // list of card image JLabels
   private int currentPlayerCard; // player's current card number
   private int currentDealerCard; // blackjackProxy's current card number
   private BlackjackService blackjackService; // used to obtain proxy
   private Blackjack blackjackProxy; // used to access the web service

   // enum of game states
   private enum GameStatus
   {
      PUSH, // game ends in a tie
      LOSE, // player loses
      WIN, // player wins
      BLACKJACK // player has blackjack
   } 

   // no-argument constructor
   public BlackjackGameJFrame()
   {
      initComponents();

      // due to a bug in NetBeans, we must change the JFrame's background
      // color here rather than in the designer
      getContentPane().setBackground(new Color(0, 180, 0));

      // initialize the blackjack proxy
      try
      {
         // create the objects for accessing the Blackjack web service
         blackjackService = new BlackjackService();
         blackjackProxy = blackjackService.getBlackjackPort();

         // enable session tracking
         ((BindingProvider) blackjackProxy).getRequestContext().put(
            BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
      } 
      catch (Exception e)
      {
         e.printStackTrace();
      } 

      // add JLabels to cardBoxes ArrayList for programmatic manipulation
      cardboxes = new ArrayList<JLabel>();

      cardboxes.add(dealerCard1JLabel);
      cardboxes.add(dealerCard2JLabel);
      cardboxes.add(dealerCard3JLabel);
      cardboxes.add(dealerCard4JLabel);
      cardboxes.add(dealerCard5JLabel);
      cardboxes.add(dealerCard6JLabel);
      cardboxes.add(dealerCard7JLabel);
      cardboxes.add(dealerCard8JLabel);
      cardboxes.add(dealerCard9JLabel);
      cardboxes.add(dealerCard10JLabel);
      cardboxes.add(dealerCard11JLabel);
      cardboxes.add(playerCard1JLabel);
      cardboxes.add(playerCard2JLabel);
      cardboxes.add(playerCard3JLabel);
      cardboxes.add(playerCard4JLabel);
      cardboxes.add(playerCard5JLabel);
      cardboxes.add(playerCard6JLabel);
      cardboxes.add(playerCard7JLabel);
      cardboxes.add(playerCard8JLabel);
      cardboxes.add(playerCard9JLabel);
      cardboxes.add(playerCard10JLabel);
      cardboxes.add(playerCard11JLabel);
   } 

   // play the dealer's hand
   private void dealerPlay()
   {
      try
      {
         // while the value of the dealers's hand is below 17
         // the dealer must continue to take cards
         String[] cards = dealerCards.split("\t");

         // display dealer's cards
         for (int i = 0; i < cards.length; i++)
         {
            displayCard(i, cards[i]);
         }

         while (blackjackProxy.getHandValue(dealerCards) < 17)
         {
            String newCard = blackjackProxy.dealCard(); // deal new card
            dealerCards += "\t" + newCard; // deal new card
            displayCard(currentDealerCard, newCard);
            ++currentDealerCard;
            JOptionPane.showMessageDialog(this, "Dealer takes a card",
               "Dealer's turn", JOptionPane.PLAIN_MESSAGE);
         } 

         int dealersTotal = blackjackProxy.getHandValue(dealerCards);
         int playersTotal = blackjackProxy.getHandValue(playerCards);

         // if dealer busted, player wins
         if (dealersTotal > 21)
         {
            gameOver(GameStatus.WIN);
            return;
         } 

         // if dealer and player are below 21
         // higher score wins, equal scores is a push
         if (dealersTotal > playersTotal)
         {
            gameOver(GameStatus.LOSE);
         }
         else if (dealersTotal < playersTotal)
         {
            gameOver(GameStatus.WIN);
         }
         else
         {
            gameOver(GameStatus.PUSH);
         }
      } 
      catch (Exception e)
      {
         e.printStackTrace();
      } 
   } 

   // displays the card represented by cardValue in specified JLabel
   private void displayCard(int card, String cardValue)
   {
      try
      {
         // retrieve correct JLabel from cardBoxes
         JLabel displayLabel = cardboxes.get(card);

         // if string representing card is empty, display back of card
         if (cardValue.equals(""))
         {
            displayLabel.setIcon(new ImageIcon(getClass().getResource(
               "/com/deitel/blackjackclient/" +
               "blackjack_images/cardback.png")));
            return;
         } 

         // retrieve the face value of the card
         String face = cardValue.substring(0, cardValue.indexOf(" "));

         // retrieve the suit of the card
         String suit =
            cardValue.substring(cardValue.indexOf(" ") + 1);

         char suitLetter; // suit letter used to form image file

         switch (Integer.parseInt(suit))
         {
            case 0: // hearts
               suitLetter = 'h';
               break;
            case 1: // diamonds
               suitLetter = 'd';
               break;
            case 2: // clubs
               suitLetter = 'c';
               break;
            default: // spades
               suitLetter = 's';
               break;
         } 

         // set image for displayLabel
         displayLabel.setIcon(new ImageIcon(getClass().getResource(
            "/com/deitel/blackjackclient/blackjack_images/" +
            face + suitLetter + ".png")));
      } 
      catch (Exception e)
      {
         e.printStackTrace();
      } 
   } 

   // displays all player cards and shows appropriate message
   private void gameOver(GameStatus winner)
   {
      String[] cards = dealerCards.split("\t");

      // display blackjackProxy's cards
      for (int i = 0; i < cards.length; i++)
      {
         displayCard(i, cards[i]);
      }

      // display appropriate status image
      if (winner == GameStatus.WIN)
      {
         statusJLabel.setText("You win!");
      }
      else if (winner == GameStatus.LOSE)
      {
         statusJLabel.setText("You lose.");
      }
      else if (winner == GameStatus.PUSH)
      {
         statusJLabel.setText("It's a push.");
      }
      else // blackjack
      {
         statusJLabel.setText("Blackjack!");
      }

      // display final scores
      int dealersTotal = blackjackProxy.getHandValue(dealerCards);
      int playersTotal = blackjackProxy.getHandValue(playerCards);
      dealerTotalJLabel.setText("Dealer: " + dealersTotal);
      playerTotalJLabel.setText("Player: " + playersTotal);

      // reset for new game
      standJButton.setEnabled(false);
      hitJButton.setEnabled(false);
      dealJButton.setEnabled(true);
   } 

   // The initComponents method is autogenerated by NetBeans and is called
   // from the constructor to initialize the GUI. This method is not shown
   // here to save space. Open BlackjackGameJFrame.java in this
   // example's folder to view the complete generated code
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      dealerJLabel = new javax.swing.JLabel();
      dealerCard1JLabel = new javax.swing.JLabel();
      dealerCard7JLabel = new javax.swing.JLabel();
      dealerCard2JLabel = new javax.swing.JLabel();
      dealerCard8JLabel = new javax.swing.JLabel();
      dealerCard3JLabel = new javax.swing.JLabel();
      dealerCard9JLabel = new javax.swing.JLabel();
      dealerCard4JLabel = new javax.swing.JLabel();
      dealerCard10JLabel = new javax.swing.JLabel();
      dealerCard5JLabel = new javax.swing.JLabel();
      dealerCard6JLabel = new javax.swing.JLabel();
      dealJButton = new javax.swing.JButton();
      hitJButton = new javax.swing.JButton();
      dealerCard11JLabel = new javax.swing.JLabel();
      statusJLabel = new javax.swing.JLabel();
      standJButton = new javax.swing.JButton();
      playerJLabel = new javax.swing.JLabel();
      playerCard1JLabel = new javax.swing.JLabel();
      playerCard2JLabel = new javax.swing.JLabel();
      playerCard3JLabel = new javax.swing.JLabel();
      playerCard4JLabel = new javax.swing.JLabel();
      playerCard5JLabel = new javax.swing.JLabel();
      playerCard6JLabel = new javax.swing.JLabel();
      dealerTotalJLabel = new javax.swing.JLabel();
      playerTotalJLabel = new javax.swing.JLabel();
      playerCard7JLabel = new javax.swing.JLabel();
      playerCard8JLabel = new javax.swing.JLabel();
      playerCard9JLabel = new javax.swing.JLabel();
      playerCard10JLabel = new javax.swing.JLabel();
      playerCard11JLabel = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Blackjack");

      dealerJLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
      dealerJLabel.setForeground(new java.awt.Color(255, 255, 255));
      dealerJLabel.setText("Dealer's hand:");

      dealerCard1JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard1JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard1JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerCard7JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard7JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard7JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerCard2JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard2JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard2JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerCard8JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard8JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard8JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerCard3JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard3JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard3JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerCard9JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard9JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard9JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerCard4JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard4JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard4JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerCard10JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard10JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard10JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerCard5JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard5JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard5JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerCard6JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard6JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard6JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      dealJButton.setText("Deal");
      dealJButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            dealJButtonActionPerformed(evt);
         }
      });

      hitJButton.setFont(new java.awt.Font("Tahoma", 1, 14));
      hitJButton.setText("Hit");
      hitJButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            hitJButtonActionPerformed(evt);
         }
      });

      dealerCard11JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      dealerCard11JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      dealerCard11JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      statusJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
      statusJLabel.setForeground(new java.awt.Color(255, 255, 255));
      statusJLabel.setText(" ");

      standJButton.setFont(new java.awt.Font("Tahoma", 1, 14));
      standJButton.setText("Stand");
      standJButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            standJButtonActionPerformed(evt);
         }
      });

      playerJLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
      playerJLabel.setForeground(new java.awt.Color(255, 255, 255));
      playerJLabel.setText("Player's hand:");

      playerCard1JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard1JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard1JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      playerCard2JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard2JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard2JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      playerCard3JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard3JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard3JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      playerCard4JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard4JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard4JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      playerCard5JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard5JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard5JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      playerCard6JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard6JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard6JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      dealerTotalJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
      dealerTotalJLabel.setForeground(new java.awt.Color(255, 255, 255));
      dealerTotalJLabel.setText(" ");

      playerTotalJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
      playerTotalJLabel.setForeground(new java.awt.Color(255, 255, 255));
      playerTotalJLabel.setText(" ");

      playerCard7JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard7JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard7JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      playerCard8JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard8JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard8JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      playerCard9JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard9JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard9JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      playerCard10JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard10JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard10JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      playerCard11JLabel.setMaximumSize(new java.awt.Dimension(65, 87));
      playerCard11JLabel.setMinimumSize(new java.awt.Dimension(65, 87));
      playerCard11JLabel.setPreferredSize(new java.awt.Dimension(65, 87));

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(10, 10, 10)
                  .addComponent(dealerJLabel))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(dealerCard1JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(dealerCard7JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(dealerCard2JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(dealerCard8JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(dealerCard3JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(dealerCard9JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(dealerCard4JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(dealerCard10JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(dealerCard5JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(dealerCard6JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(dealerCard11JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(28, 28, 28)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(standJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                     .addComponent(dealJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                     .addComponent(hitJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                     .addComponent(statusJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(playerJLabel))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(playerCard1JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(playerCard2JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(playerCard3JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(playerCard4JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(playerCard5JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(playerCard6JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(dealerTotalJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                     .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerTotalJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(playerCard7JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(playerCard8JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(playerCard9JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(playerCard10JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(playerCard11JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(dealerJLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(dealJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(hitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(dealerCard6JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(dealerCard5JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(dealerCard4JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(dealerCard3JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(dealerCard1JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(dealerCard2JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(dealerCard7JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(dealerCard8JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(dealerCard9JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(dealerCard10JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(dealerCard11JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(standJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(playerJLabel)
                     .addComponent(statusJLabel))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(playerCard1JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(playerCard2JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addComponent(playerCard3JLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(playerCard4JLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(playerCard5JLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(dealerTotalJLabel)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(playerTotalJLabel))
                  .addComponent(playerCard6JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(playerCard7JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(playerCard8JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(playerCard9JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(playerCard10JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(playerCard11JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   // handles dealJButton click
   private void dealJButtonActionPerformed(//GEN-FIRST:event_dealJButtonActionPerformed
      java.awt.event.ActionEvent evt)
   {//GEN-HEADEREND:event_dealJButtonActionPerformed
      String card; // stores a card temporarily until it's added to a hand

      // clear card images
      for (int i = 0; i < cardboxes.size(); i++)
      {
         cardboxes.get(i).setIcon(null);
      }

      statusJLabel.setText("");
      dealerTotalJLabel.setText("");
      playerTotalJLabel.setText("");

      // create a new, shuffled deck on remote machine
      blackjackProxy.shuffle();

      // deal two cards to player
      playerCards = blackjackProxy.dealCard(); // add first card to hand
      displayCard(11, playerCards); // display first card
      card = blackjackProxy.dealCard(); // deal second card
      displayCard(12, card); // display second card
      playerCards += "\t" + card; // add second card to hand

      // deal two cards to blackjackProxy, but only show first
      dealerCards = blackjackProxy.dealCard(); // add first card to hand
      displayCard(0, dealerCards); // display first card
      card = blackjackProxy.dealCard(); // deal second card
      displayCard(1, ""); // display back of card
      dealerCards += "\t" + card; // add second card to hand

      standJButton.setEnabled(true);
      hitJButton.setEnabled(true);
      dealJButton.setEnabled(false);

      // determine the value of the two hands
      int dealersTotal = blackjackProxy.getHandValue(dealerCards);
      int playersTotal = blackjackProxy.getHandValue(playerCards);

      // if hands both equal 21, it is a push
      if (playersTotal == dealersTotal && playersTotal == 21)
      {
         gameOver(GameStatus.PUSH);
      }
      else if (dealersTotal == 21) // blackjackProxy has blackjack
      {
         gameOver(GameStatus.LOSE);
      }
      else if (playersTotal == 21) // blackjack
      {
         gameOver(GameStatus.BLACKJACK);
      }

      // next card for blackjackProxy has index 2
      currentDealerCard = 2;

      // next card for player has index 13
      currentPlayerCard = 13;
   }//GEN-LAST:event_dealJButtonActionPerformed

   // handles standJButton click
   private void hitJButtonActionPerformed(//GEN-FIRST:event_hitJButtonActionPerformed
      java.awt.event.ActionEvent evt) 
   {//GEN-HEADEREND:event_hitJButtonActionPerformed
      // get player another card
      String card = blackjackProxy.dealCard(); // deal new card
      playerCards += "\t" + card; // add card to hand

      // update GUI to display new card
      displayCard(currentPlayerCard, card);
      ++currentPlayerCard;

      // determine new value of player's hand
      int total = blackjackProxy.getHandValue(playerCards);

      if (total > 21) // player busts
      {
         gameOver(GameStatus.LOSE);
      }
      else if (total == 21) // player cannot take any more cards
      {
         hitJButton.setEnabled(false);
         dealerPlay();
      } 
   }//GEN-LAST:event_hitJButtonActionPerformed

   // handles standJButton click
   private void standJButtonActionPerformed(//GEN-FIRST:event_standJButtonActionPerformed
      java.awt.event.ActionEvent evt)
   {//GEN-HEADEREND:event_standJButtonActionPerformed
      standJButton.setEnabled(false);
      hitJButton.setEnabled(false);
      dealJButton.setEnabled(true);
      dealerPlay();
   }//GEN-LAST:event_standJButtonActionPerformed

   // begins application execution
   public static void main(String args[])
   {
      java.awt.EventQueue.invokeLater(
         new Runnable()
         {
            public void run()
            {
               new BlackjackGameJFrame().setVisible(true);
            }
         }
      ); 
   } 

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton dealJButton;
   private javax.swing.JLabel dealerCard10JLabel;
   private javax.swing.JLabel dealerCard11JLabel;
   private javax.swing.JLabel dealerCard1JLabel;
   private javax.swing.JLabel dealerCard2JLabel;
   private javax.swing.JLabel dealerCard3JLabel;
   private javax.swing.JLabel dealerCard4JLabel;
   private javax.swing.JLabel dealerCard5JLabel;
   private javax.swing.JLabel dealerCard6JLabel;
   private javax.swing.JLabel dealerCard7JLabel;
   private javax.swing.JLabel dealerCard8JLabel;
   private javax.swing.JLabel dealerCard9JLabel;
   private javax.swing.JLabel dealerJLabel;
   private javax.swing.JLabel dealerTotalJLabel;
   private javax.swing.JButton hitJButton;
   private javax.swing.JLabel playerCard10JLabel;
   private javax.swing.JLabel playerCard11JLabel;
   private javax.swing.JLabel playerCard1JLabel;
   private javax.swing.JLabel playerCard2JLabel;
   private javax.swing.JLabel playerCard3JLabel;
   private javax.swing.JLabel playerCard4JLabel;
   private javax.swing.JLabel playerCard5JLabel;
   private javax.swing.JLabel playerCard6JLabel;
   private javax.swing.JLabel playerCard7JLabel;
   private javax.swing.JLabel playerCard8JLabel;
   private javax.swing.JLabel playerCard9JLabel;
   private javax.swing.JLabel playerJLabel;
   private javax.swing.JLabel playerTotalJLabel;
   private javax.swing.JButton standJButton;
   private javax.swing.JLabel statusJLabel;
   // End of variables declaration//GEN-END:variables
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




