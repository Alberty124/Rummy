# Rummy Card Game

> Joshua Alberty Rivera
> CCOM4029 - High Level Languages

This project is an interactive version of the Rummy card game, provided with some basic UI code and some card files.

### Acknowledgements

The only references used to construct this project were:

[Stack Overflow](https://stackoverflow.com)

I didn't receive any help from other people nor third parties.I also didn't help anyone else in the group.

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
  - [ ] ~can't have any data elements that aren't of primitive type~
- [x] Write the `Hand` class, which:
  - [x] implements the `HandInterface` provided
  - [ ] may derive from other Java classes, like those in the `Collection` framework
  - [x] should maintain the cards in sorted order
  - [ ] ~should provide a `play()` function to implement a Computer Opponent~
- [x] Write the `Deck` class, which:
  - [x] implements the `DeckInterface` provided
  - [ ] may derive from other Java classes, like those in the `Collection` framework
  - [x] should provide a constructor which creates a 52-card deck of shuffled cards
- [x] Write the ~`Pile`~ `Stack`? class, which:
  - [x] implements the ~`PileInterface`~ `StackInterface`? ~provided~
  - [x] ~`Pile`~ `Stack`? should derive from your `MyStack` class
- [ ] ~You may **NOT** change the provided interfaces (but you can add methods to the classes themselves)~
- [x] By default, the provided code can be run directly from the `Table.java` file, whose `main` method should be extracted into a separate file called ~`Proj2.java`~ `Main.java`
- [x] You should wrap the whole project in a package named ~`proj2`~ `rummy`
- [x] The last line should be either `Player 1 Wins!`, `Player 2 Wins!` or `It's a tie!`
- [x] The Computer Opponent AI can make random choices (like decide whether to draw from the stock pile or the discard pile), but it must at the very least ~look for Sets in the hand~ draw and discard each turn...
  - [x] if you implement it so that it can look for Sets, you will receive EXTRA CREDIT
  - [ ] if you implement it so that it can look for Runs, you will receive EXTRA CREDIT
  - [x] if you implement it so that it makes other smarter play routines, you will receive EXTRA CREDIT

### Extra Credit

- [x] The card display in the UI is minimalist. There are card images available in the folder ~`lscards`~ `cards`; use them to spruce up the appearance of your game _(+5pts)_
- [x] Modify the `Table` so that the game begins with the first card being on the Stack _(+5pts)_
- [ ] The base project only requires Sets to be discovered and laid on the table. Extend the program to include Runs using an interface named `RunInterface.java` and its class `Run.java` _(+5pts)_
- [ ] ~If you created the `RunInterface`, make it `SetInterface`'s super interface to deal with both the sets and the runs _(+5pts)_~
- [x] ~Add some heuristics to improve performance in automated play (discussing each rule you add and why you expect it to improve performance in your `README.md` file) _(+2pts per rule added, for a max of 4 rules)_~
- [ ] The implement an additional flag when running the program indicating the number of interactive players in the game (i.e. `-0`, `-1` or `-2`), where the default is 2 interactive players _(+10pts)_
- [ ] Write a two-page paper briefly summarizing the research challenges of intelligent game play and discussing how AI research might be used to iprove your Rummy program. Your paper should be gramatically correct, include appropriate bibliographic references, and be submitted in `pdf` format _(+10pts)_
