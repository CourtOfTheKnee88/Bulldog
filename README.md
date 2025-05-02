# Bulldog

This is a GitHub Repo for COS 420 Spring 2025. The purpose of this repo is to store and contain all segments and updates to the Bulldog project that will be made throughout the semester.

## What is Bulldog?

Bulldog is a turn-based dice game where players take turns rolling dice to accumulate points. The game includes various types of players, each with unique strategies for deciding whether to continue rolling or stop. The goal is to reach a winning score before other players.

## AI Usage

For all but the first iteration of this assignment, a large majority of the code was written by AI and modified by Courtney Jackson when it was needed. The AI-assisted development process allowed for rapid prototyping and implementation of features, while I ensured the code met the project requirements and adhered to best practices.

## How it Works

1. **Player Types**: The game includes multiple player types such as HumanPlayer, RandomPlayer, WimpPlayer, UniquePlayer, SevenPlayer, and FifteenPlayer. Each player type has a unique strategy for deciding whether to continue rolling.

2. **Game Flow**: 
   - Players take turns rolling dice.
   - Each roll contributes to the player's turn total unless a six is rolled, which ends the turn with zero points.
   - The game continues until one player reaches the winning score (104)

3. **User Interface**:
   - The game features a graphical interface for managing players and displaying scores.
   - Players can be added, removed, or reset before starting the game.
   - A scoreboard updates dynamically during gameplay to show the current scores.

## How to Play

1. **Setup**:
   - Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
   - Locate the `Prog6.java` file, which serves as the entry point for the game.

2. **Run the Game**:
   - Run the `Prog6.java` file to start the game.
   - The home screen will appear, allowing you to configure the players.

3. **Configure Players**:
   - Use the "Add" button to add new players to the game.
   - Select the player type (e.g., Human, Random, Wimp, Unique, Seven, Fifteen) from the dropdown menu.
   - Use the "Remove" button to delete a selected player.
   - Use the "Reset" button to reset the player list to default values.

4. **Start the Game**:
   - Once all players are configured, click the "Start Game" button.
   - The game screen will appear, showing the scoreboard and the play table.

5. **Gameplay**:
   - Players take turns rolling dice.
   - Each roll contributes to the player's turn total unless a six is rolled, which ends the turn with zero points.
   - The game continues until one player reaches the winning score (104 points).

6. **Winning**:
   - When a player reaches the winning score, the game ends, and the winner is announced.
   - You can restart the game by re-running the `Prog6.java` file or by clicking the "Play Again" button