/* Joshua Alberty
 * 801-18-3932
 * CCOM 4029-002
 * Prof. Ordonez
 */

package rummy.ui;

import java.awt.Component;

import javax.swing.*;

import rummy.core.Card;

/**
 * Creates the images and labels of the Deck and stack.
 */
class CardPileGroupPanel extends JPanel {

  // Class attributes
  final private static String STACK_LABEL_TEXT = "Stack";
  final private static String DECK_LABEL_TEXT = "Deck";

  
  // Creates the images and labels of the Deck and stack.
   
  public CardPileGroupPanel(JLabel stackGraphic, JLabel deckGraphic) {

    super();

    // Create container where the Deck and the Stack sit in the table.
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.add(Box.createGlue());

    // Create a graphic UI component representing the stack.
    JPanel stackGroup = new JPanel();
    stackGroup.setAlignmentY(Component.CENTER_ALIGNMENT);

    JLabel stackLabel = new JLabel(STACK_LABEL_TEXT);
    stackLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
    stackGroup.add(stackLabel);

    stackGraphic.setIcon(new ImageIcon(Card.BLANK_IMAGE_FILEPATH));
    stackGraphic.setAlignmentY(Component.CENTER_ALIGNMENT);
    stackGroup.add(stackGraphic);

    this.add(stackGroup);
    this.add(Box.createGlue());

    // Create a graphic UI component representing the deck.
    JPanel deckGroup = new JPanel();
    deckGroup.setAlignmentY(Component.CENTER_ALIGNMENT);

    JLabel deckLabel = new JLabel(DECK_LABEL_TEXT);
    deckLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
    deckGroup.add(deckLabel);

    deckGraphic.setIcon(new ImageIcon(Card.CARDBACK_IMAGE_FILEPATH));
    deckGraphic.setAlignmentY(Component.CENTER_ALIGNMENT);
    deckGroup.add(deckGraphic);

    // Add both the Deck and the Stack to the container.
    this.add(deckGroup);
    this.add(Box.createGlue());

  }

}