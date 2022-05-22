/* Joshua Alberty
 * 801-18-3932
 * CCOM 4029-002
 * Prof. Ordonez
 */

package rummy.ui;

import java.awt.*;

import javax.swing.*;

import rummy.core.Card;

// Creates a player's controls, including Draw, Discard and Lay buttons.
@SuppressWarnings("serial")
class PlayerControlPanel extends JPanel {
  public PlayerControlPanel(String name, JList<Card> hand, JButton drawFromStack, JButton drawFromDeck,
    JButton layOnTableButton, JButton discardButton) {

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JLabel label = new JLabel(name);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(label);

    drawFromDeck.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(drawFromDeck);

    drawFromStack.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(drawFromStack);

    layOnTableButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(layOnTableButton);

    discardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(discardButton);
    this.add(Box.createGlue());

    this.add(hand);
    this.add(Box.createGlue());

  }

}