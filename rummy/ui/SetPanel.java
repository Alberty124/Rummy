/* Joshua Alberty
 * 801-18-3932
 * CCOM 4029-002
 * Prof. Ordonez
 */

package rummy.ui;

import javax.swing.*;

import rummy.core.*;


// Graphic representation of Sets layed on the table.
class SetPanel extends JPanel {
  // Instance attributes
  final private Set data;
  final public JButton[] array = new JButton[Set.CAPACITY];

  public SetPanel(int index) {
    super();
    data = new Set(Card.RANKS[index]);

    for (int i = 0; i < array.length; i++) {
      array[i] = new JButton(" ");
      this.add(array[i]);
    }
  }

}