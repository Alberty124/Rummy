/* Joshua Alberty
 * 801-18-3932
 * CCOM 4029-002
 * Prof. Ordonez
 */

package rummy.interfaces;

import rummy.core.Card;

public interface HandInterface {

  public void addCard(Card card);

  public Card getCard(int index);

  public Card removeCard(Card card);

  public Card removeCard(int index);

  public int getNumberOfCards();

  public void sort();

  public boolean isEmpty();

  public boolean containsCard(Card card);

  public int findCard(Card card);

  public Card[] findSet();

  public int evaluateHand();

  public String toString();

}