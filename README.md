# terminal-games
This project is a command line implementation of a game selector and the game Mastermind.
More games will be added at a later date.

## Description

Mastermind is a game composed of 8 pieces of different colors.  
A secret code is then composed of 4 distinct pieces.

The player has 10 attempts to find the secret code.  
After each input, the game indicates to the player the number of well placed pieces and the number of misplaced pieces.
If the player finds the code, they win, and the game stops.

For this implementation we will use numbers in lieu of colors and digits in lieu of pieces.  
Numbered digits are '0' '1' '2' '3' '4' '5' '6' '7'.

A well placed piece is when a player has guessed the right number at the right place.  
A misplaced piece is when a player has guessed the right number but at a different digit place.

After each turn the player will be prompted with a message indicating the:
- Right Number Right Digit placed
- Right Number Wrong Digit placed
- The number of guesses the player has used

## Installation

Clone using the following command:

git clone https://github.com/Kelsyn/terminal-games

Build the game using:

javac Game.java

## Playing The Game

Run the game by using:

java Game

You will be asked for the following inputs:

- "-m": will select the Mastermind game.

## Mastermind

Aftwards the following prompts will let you set either the secret code to be guessed for, the number of attempts, both, or to start with a randomly generated code and number of attempts set to 10.

- "-c": to set the secret code (must be of length 4 with integers between 0 & 7).
- "-t": to set the number of attempts.
- "-ct": to set both
- "-start": to start the game with a randomly generated code & 10 attempts.

### Playing Mastermind:
Enter into the terminal a 4 digit code with integers between 0 & 7 and enjoy!

