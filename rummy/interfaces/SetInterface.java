/* Joshua Alberty
 * 801-18-3932
 * CCOM 4029-002
 * Prof. Ordonez
 */

package rummy.interfaces;

import rummy.core.Card;

public interface SetInterface {

  public void addCard(Card card);

  public boolean isFull();

  public int getRankIndex();

  public char getRank();

}
