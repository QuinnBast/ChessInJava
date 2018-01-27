# Welcome to Chess in Java by Quinn Bast!

### This is a side-project of mine where I am practicing my java skills while also learning about GUIs.
### The completed project will include a fully functional chess board that will include 2 player local play chess.
### If I am ambitious I may attempt to code an AI that you can play against at a later date.

I have implemented EnPassant, Castling, Checkmate detection, Stalemate detection.

To Implement: 
- Prevent castling if enemy has possible moves along castle squares
- Stalemate by insufficient material
- Stalemate by 50 moves no captures
- Stalemate by threefold repetition.
- Material value indicator (pawn = 1, knight = 3, etc.)
- Request to draw
- Maximum Turn timer (Toggleable)
- Game timer
- Highlight possible moves for selected pieces for beginners (Toggleable)
- Artificial intelligence (vs. Computer)
  - Recognize pins, forks, defence/pressure, piece priority, hanging pawns, castling, checkmates, smothered mate, 
  - Make basic tree of next 3-5 moves
    - Possibly create algorithm that determines a move is awful and prioritize searching other branches
    - Neural Network that learns as it plays against you?

## Takeaways (so far):

- Using Swing libaray in Java (JFrame, JPanel, JLabel, ImageIcon, etc.)
- Using OOP to create  GUI
- Managing click events in Java
- Effective use of static variables to make life easy
- Game Design
  - GameState, GameBoard
  - Special Chess Logic
