/* Joshua Alberty
 * 801-18-3932
 * CCOM 4029-002
 * Prof. Ordonez
 */

package rummy.core;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

  // Class attributes
  final private static int MAX_NUMBER_OF_TURNS = 1000; // some big number.
  final private static int NUM_DEALT_CARDS = 9;

  // Data Models
  final private Deck cardDeck = new Deck(); // creates a shuffled deck of 52 cards.
  final private Stack stackDeck = new Stack(); // creates an empty card stack.

  final private Hand p1Hand = new Hand();
  final private Hand p2Hand = new Hand();

  // creates a list of sets layed on the table.
  final private List<Set> laidSets = new ArrayList<Set>(); 

  // Game configuration
  final private boolean p1IsCPU = false; 
  final private boolean p2IsCPU = true; 
  final private boolean loggingEnabled = true; 

  // Game flags
  private boolean p1Turn = true;
  private boolean currentPlayerHasDrawn = false;
  private boolean announcedPlayerTurn = false;

  public void start() {

    // Prepare each players' hands.
    dealCardsToPlayers();

    // After dealing cards to the  players, the next card from the Deck initiates the Stack.
    Card firstStackCard = cardDeck.dealCard();
    stackDeck.addCard(firstStackCard);

    // Alternate between Player 1 and Player 2 until the game ends.
    for (int i = 0; i < MAX_NUMBER_OF_TURNS; i++) {
      if (p1Turn) makeMove(p1Hand);
      
      else makeMove(p2Hand);
    }

    // If MAX_NUMBER_OF_TURNS is exceeded, terminate game.
    int p1Points = p1Hand.evaluateHand();
    int p2Points = p2Hand.evaluateHand();
    System.out.println("\nMaximum number of turns exceeded!");
    System.out.println("Points: " + p1Points + " (P1) vs. " + p2Points + " (P2)");

  }

  // Deals 9 cards to each player.
   
  private void dealCardsToPlayers() {

    // Create Player 1's hand of 9 cards.
    for (int i = 0; i < NUM_DEALT_CARDS; i++) {
      Card c = cardDeck.dealCard();
      p1Hand.addCard(c);
    }

    // Create Player 2's hand of 9 cards.
    for (int i = 0; i < NUM_DEALT_CARDS; i++) {
      Card c = cardDeck.dealCard();
      p2Hand.addCard(c);
    }
    // Prints out Player 1's and Player 2's initial hands.
    if (loggingEnabled) {
      System.out.println("Initial Player 1: " + p1Hand.toString());
      System.out.println("Initial Player 2: " + p2Hand.toString());
    }

  }

  /**
   * Handles logic to lay a single card on the table.
   * 
   * @param card = the Card that will be laid on the table.
   */
  private void layCardOnTable(Card card) {
    System.out.println("\tLaying " + card.toString().toUpperCase());
  }

  // Announces who the winner is.
  
  private void announceWinner() {
    int p1MinusP2 = p1Hand.compareTo(p2Hand);
    int p1Points = p1Hand.evaluateHand();
    int p2Points = p2Hand.evaluateHand();

    System.out.println("Points: " + p1Points + " (P1) vs. " + p2Points + " (P2)");

    if (p1MinusP2 < 0) {
      System.out.println("Player 1 Wins!");
    } else if (p1MinusP2 == 0) {
      System.out.println("It's a tie!");
    } else {
      System.out.println("Player 2 Wins!");
    }

    System.exit(0);

  }

  /**
   * Handles user clicking on "Draw from Deck" button.
   * 
   * @param playersHand = the Hand of the player who clicked on the button.
   */
  private void handleDrawFromDeck(Hand playersHand) {

    Card card = cardDeck.dealCard();

    // If deck is empty, don't do anything.
    if (card == null) return;
    
    // Add card to hand.
    playersHand.addCard(card);

    // Announces what Player added a card to their hand from the deck.
    if (loggingEnabled) {
      if (!announcedPlayerTurn) {
        System.out.println(p1Turn ? "Player 1" : "Player 2");
        announcedPlayerTurn = true;
      }
      System.out.println("\tAdded from Deck: " + card.toString().toUpperCase());
    }

    // Game Over.
    if (cardDeck.isEmpty()) {
      announceWinner();
    }

  }

  /**
   * Handles user clicking on "Draw from Stack" button.
   * 
   * @param playersHand = the Hand of the player who clicked on the button.
   */
  private void handleDrawFromStack(Hand playersHand) {

    Card card = stackDeck.removeCard();

    // If stack is empty, don't do anything.
    if (card == null) return;    

    // Add the removed card to the player's hand.
    playersHand.addCard(card);

    // Announces what Player added a card to their hand from the deck.
    if (loggingEnabled) {
      if (!announcedPlayerTurn) {
        System.out.println(p1Turn ? "Player 1" : "Player 2");
        announcedPlayerTurn = true;
      }
      System.out.println("\tAdded from Stack: " + card.toString().toUpperCase());
    }

  }

  /**
   * Handles user clicking on "Lay on Table" button.
   * 
   * @param playersHand = the Hand of the player who clicked on the button.
   * @param cards = the cards about to be laid on the table.
   */
  private void handleLayOnTable(Hand playersHand, Card[] cards) {

    List<Card> selectedCards = Arrays.asList(cards);

    /* NO CARDS SELECTED SECTION 
     * Abort if there are no selected cards.
     */
    if (selectedCards.isEmpty()) return;
    

    /* ONE CARD SELECTED SECTION 
     * If only one card is selected, check if it fits in a Set already on the table.
     */
    if (selectedCards.size() == 1) {

      Card selectedCard = selectedCards.get(0);

      // Find the Set where the card fits and lay it on the table.
      for (int i = 0; i < laidSets.size(); i++) {
        if (selectedCard.getRank() == laidSets.get(i).getRank()) {
          laidSets.get(i).addCard(selectedCard);
          layCardOnTable(selectedCard);
          playersHand.removeCard(selectedCard);
          break;
        }
      }

      // Game Over
      if (playersHand.isEmpty()) announceWinner();
      
      return;

    }

    /* MULTIPLE CARDS SELECTED SECTION 
     * First check if selectedCards forms a Set before laying
     */ 
    if (!Set.isSet(selectedCards)) return;
    

    // Lay Set on table, one card at a time.
    for (int i = 0; i < selectedCards.size(); i++) {
      Card card = selectedCards.get(i);
      layCardOnTable(card);
      playersHand.removeCard(card);
    }

    // Keep track of the Set that has been layed on the table.
    Set newSet = new Set(selectedCards);
    laidSets.add(newSet);

    // Game Over
    if (playersHand.isEmpty()) announceWinner();
    

  }

  /**
   * Handles user clicking on "Discard" button.
   * 
   * @param playersHand = the Hand of the player who clicked on the button.
   * @param selectedCard = the card we're about to discard
   */
  private void handleDiscard(Hand playersHand, Card selectedCard) {

    // Don't do anything if no card is selected or more than one card is selected.
    if (selectedCard == null) return;
    

    // Discard from hand.
    playersHand.removeCard(selectedCard);
    stackDeck.addCard(selectedCard);

    // Announces which card just got discarded and which cards are currently in the hand.
    if (loggingEnabled) {
      System.out.println("\tDiscarded: " + selectedCard.toString().toUpperCase());
      System.out.println("\tHand now: " + playersHand.toString());
    }

    // Game Over
    if (playersHand.isEmpty()) {
      announceWinner();
    }

  }

  /**
   * Generic function that mimics a player's move (drawing from deck/stack, laying
   * sets and finally discarding).
   * 
   * @param playersHand = the Hand of the player who clicked on the button.
   */
  private void makeMove(Hand playersHand) {

    // Draw from Deck or Stack.
    if (stackDeck.isEmpty()) handleDrawFromDeck(playersHand);

    else {

      // Choose whether to draw from Deck or from Stack
      int oneOrTwo = ThreadLocalRandom.current().nextInt(1, 3);
      if (oneOrTwo == 1) {
        handleDrawFromDeck(playersHand);
      } else {
        handleDrawFromStack(playersHand);
      }

    }

    currentPlayerHasDrawn = true;

    // Search for a Set in the hand and lay on the table (if possible).
    Card[] set = playersHand.findSet();
    if (set != null) handleLayOnTable(playersHand, set);

    // Select a random card from the hand to discard.
    int randomIndex = ThreadLocalRandom.current().nextInt(0, playersHand.getNumberOfCards());
    Card c = playersHand.getCard(randomIndex);

    // Discard to Stack.
    handleDiscard(playersHand, c);

    currentPlayerHasDrawn = true;
    p1Turn = !p1Turn;
    announcedPlayerTurn = false;

  }

  public static void main(String[] args) {
    Game g = new Game();
    g.start();
  }

}