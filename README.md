# Tic-Tac-Toe Terminal Duel

A Java Tic-Tac-Toe game featuring an unbeatable AI opponent built with a depth-weighted Minimax algorithm. The AI's optimality is verified exhaustively — a custom test runner simulates every possible game state and confirms the AI never loses.

## Features

- Human vs Human, Human vs AI, and AI vs AI modes
- Unbeatable Minimax AI with depth-weighted scoring and positional heuristics
- Intuitive QWEASDZXC keyboard mapping for move input
- Exhaustive test runner that validates optimal play across all possible game states

## How to Play

Moves are entered using the following key mapping, mirroring the board layout:

```
q | w | e
a | s | d
z | x | c
```

## Tech Stack

Java, OOP, Minimax Algorithm, Recursive Game Tree Search, Console I/O

## Test Results

```
AI vs AI        — Games played: 1    | X wins: 0 | O wins: 0 | Draws: 1
AI vs Random    — Games played: 108  | X wins: 100 | O wins: 0 | Draws: 8
Random vs AI    — Games played: 457  | X wins: 0 | O wins: 368 | Draws: 89
```

The AI never loses across all possible games.
