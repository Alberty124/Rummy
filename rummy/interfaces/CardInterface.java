/* Joshua Alberty
 * 801-18-3932
 * CCOM 4029-002
 * Prof. Ordonez
 */

package rummy.interfaces;

import javax.swing.*;

public interface CardInterface {

  final public static char[] SUITS = { 'c', 'd', 'h', 's' };

  final public static char[] RANKS = { 'a', '2', '3', '4', '5', '6', '7', '8', '9', 't', 'j', 'q', 'k' };

  final public static String IMAGE_DIR = "cards/";

  public String getImageFile();

  public char getSuit();

  public char getRank();

  public ImageIcon getCardImage();

  public String toString();

}
