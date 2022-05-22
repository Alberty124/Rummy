# Rummy Card Game

> Joshua Alberty 
> CCOM4029 - High Level Languages

This project is an interactive version of the Rummy card game, provided some basic UI code and some random files.

### Acknowledgements

The only references used to construct this project were:

1. [Stack Overflow](https://stackoverflow.com)

I didn't receive any help from other people nor third parties. I also didn't help anyone else in the group.

## Usage

1. Clone this repository
2. `cd` into this repository
3. Compile the source files with `javac rummy/Main.java` and `javac rummy/core/Game.java`
4. To run:
   1. if you want to play against the computer, use `java rummy.Main`
   2. if you want the computer to play against itself, use `java rummy.core.Game`

## Project Specifications

- [x] Write a stack class, named `MyStack`, which:
  - [x] has a `push()` method
  - [x] has a `pop()` method
  - [x] has a ~`top()`~ `peek()` method
  - [x] has an `isEmpty()` method
  - [x] should be implemented from scratch
  - [x] should use generics
  - [x] can't have a superclass that isn't a primitive type
- [x] Write the `Hand` class, which:
  - [x] implements the `HandInterface` provided
  - [x] should maintain the cards in sorted order
- [x] Write the `Deck` class, which:
  - [x] implements the `DeckInterface` provided
  - [x] should provide a constructor which creates a 52-card deck of shuffled cards
- [x] Write the ~`Pile`~ `Stack`? class, which:
  - [x] implements the ~`PileInterface`~ `StackInterface`? ~provided~
  - [x] ~`Pile`~ `Stack`? should derive from your `MyStack` class
- [x] By default, the provided code can be run directly from the `Table.java` file, whose `main` method should be extracted into a separate file called ~`Proj2.java`~ `Main.java`
- [x] You should wrap the whole project in a package named ~`proj2`~ `rummy`
- [x] The last line should be either `Player 1 Wins!`, `Player 2 Wins!` or `It's a tie!`
- [x] The Computer Opponent AI can make random choices (like decide whether to draw from the stock pile or the discard pile), but it must at the very least ~look for Sets in the hand~ draw and discard each turn...
  - [x] if you implement it so that it can look for Sets, you will receive EXTRA CREDIT
  - [x] if you implement it so that it makes other smarter play routines, you will receive EXTRA CREDIT

### Extra Credit

- [x] The card display in the UI is minimalist. There are card images available in the folder ~`lscards`~ `cards`; use them to spruce up the appearance of your game _(+5pts)_
- [x] Modify the `Table` so that the game begins with the first card being on the Stack _(+5pts)_
- [x] ~Add some heuristics to improve performance in automated play (discussing each rule you add and why you expect it to improve performance in your `README.md` file) _(+2pts per rule added, for a max of 4 rules)_~
