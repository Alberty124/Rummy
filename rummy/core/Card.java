/* Joshua Alberty
 * 801-18-3932
 * CCOM 4029-002
 * Prof. Ordonez
 */

package rummy.core;

import javax.swing.*;

import rummy.interfaces.CardInterface;

/*
 * Representation of a single playing card. A card consists of a suit value
 * (clubs, diamonds, hearts, spades), a rank value (e.g. ace, 7, king), and
 * an image of the front of the card (taken from the cards directory). A card 
 * object is immutable; meaning once instantiated, the values cannot change.
 */
public class Card implements CardInterface, Comparable<Card> {

  // Class attributes
  final public static char[] SUITS = { 'c', 'd', 'h', 's' };
  final public static char[] RANKS = { 'a', '2', '3', '4', '5', '6', '7', '8', '9', 't', 'j', 'q', 'k' };
  final public static String IMAGE_DIR = "cards/";  
  final public static String BLANK_IMAGE_FILENAME = "blank.gif";
  final public static String CARDBACK_IMAGE_FILENAME = "cardback.png";
  final public static String BLANK_IMAGE_FILEPATH = IMAGE_DIR + BLANK_IMAGE_FILENAME;
  final public static String CARDBACK_IMAGE_FILEPATH = IMAGE_DIR + CARDBACK_IMAGE_FILENAME;

  // Instance variables
  final private char suitValue;
  final private char rankValue;
  final private ImageIcon cardImage;

  /**
   * Creates a new playing card.
   * 
   * @param suit = the suit value of this card.
   * @param rank = the rank value of this card
   */
  public Card(char suit, char rank) {
    suitValue = suit;
    rankValue = rank;
    cardImage = new ImageIcon(getImageFile());
  }

  /**
   * Returns the Index of the suit in the defined static array SUITS.
   * 
   * @param suit = the suit value of this card.
   */
  public static int getSuitIndex(char suit) {
    switch (suit) {
    case 'c':
      return 0;
    case 'd':
      return 1;
    case 'h':
      return 2;
    case 's':
      return 3;
    default:
      return -1;
    }
  }

  /**
   * Returns the Index of the rank in the defined static array RANKS.
   * 
   * @param rank = the rank value of this card.
   */
  public static int getRankIndex(char rank) {
    switch (rank) {
    case 'a':
      return 0;
    case '2':
    case '3':
    case '4':
    case '5':
    case '6':
    case '7':
    case '8':
    case '9':
      return rank - '1';
    case 't':
      return 9;
    case 'j':
      return 10;
    case 'q':
      return 11;
    case 'k':
      return 12;
    default:
      return -1;
    }
  }

  /**
   * Returns the path to the card's image.
   * 
   * @return a String representing a file path.
   */
  public String getImageFile() {
    return IMAGE_DIR + toString() + ".gif";
  }

  /**
   * Returns the suit of the card.
   * 
   * @return a char representing the suit value of the card.
   */
  public char getSuit() {
    return this.suitValue;
  }

  /**
   * Returns the rank of the card.
   * 
   * @return a char representing the rank value of the card.
   */
  public char getRank() {
    return this.rankValue;
  }

  /*
   * Returns the graphic image of the card.
   */
  public ImageIcon getCardImage() {
    return this.cardImage;
  }

  /**
   * Returns a two character String with rank being represented by one of the
   * following chars: "a, 1, 2, 3, 4, 5, 6, 7, 8, 9, t, j, q, k" and suit being represented by
   * one of the following chars: "c, d, h, s". Useful for getting the card's image.
   * 
   * @return the name of the card.
   */
  public String toString() {
    return "" + this.getRank() + this.getSuit();
  }

  /**
   * Compares two cards for the purposes of sorting. Cards should be ordered by
   * their rank index as defined in the char static array named RANKS.
   * 
   * @param otherCard = the other card that will be used for comparison.
   * @return a negative integer, zero or a positive integer if this card is less
   *         than, equal to or greater than the referenced card.
   */
  public int compareTo(Card otherCard) {
    int rankDiff = getRankIndex(this.rankValue) - getRankIndex(otherCard.rankValue);
    return rankDiff;
  }

}
