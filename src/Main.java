import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize the scanner and the other variables
        Scanner input = new Scanner(System.in);
        String restartGame;

        // create game object
        Game game = new Game();

        do {
            // print the welcome message
            System.out.println("""
                    Welcome to the Number Guessing Game!\s
                    I'm thinking of a number between 1 - 10\s
                    You have 1-5 tries to guess before Game Over\s
                    Good luck!""");

            // print the difficulty message
            System.out.println("""
                    \nPlease choose the difficulty level
                    1. Easy (5 chances)
                    2. Medium (3 chances)
                    3. Hard (2 chances)
                    4. Extreme (1 chance)
                    """);

            // print the choice line
            System.out.print("Choose the difficulty (1-4): ");

            // initialize scanner
            int diffChoice = input.nextInt();

            // set game variables (attempt, answer, answerFound)
            game.setGameValues(diffChoice);

            // game start message
            String gameStartMessage = """
                    You have %d chance/s to guess.
                    Let's Start!
                    """;

            // print game start message
            System.out.printf(gameStartMessage, game.chanceCount);

            // main game loop
            do {
                // print the message for guess input & initialize scanner for the players answer
                System.out.print("\nGuess the Number: ");
                int playerAnswer = input.nextInt();

                // void method that prints a message everytime a player inputs an answer
                game.getGameMessage(playerAnswer, game.answer);

            // break out of loop if chanceCount is 0 and if answer is found
            } while (game.chanceCount > 0 && !game.answerFound);

            // print the game over message
            if (game.chanceCount < 1) {
                System.out.print("""

                        Game Over, It's ok you did your best
                        Want to go again? (Y/N):\s""");
            }
            // else print the congratulatory message
            else {
                System.out.printf("""

                        Congratulations, You've guessed the answer with only %d attempt/s!!!
                        That was fun, Want to play again? (Y/N):\s""",game.attempt-game.chanceCount);
            }
            // initialize the restartGame variable
            restartGame = input.next().toUpperCase();

            // add a space for the next
            System.out.println();

        // restart the loop if the user inputs "Y" and end the loop if the user inputs "N"
        } while (restartGame.equals("Y"));

        // print a thank-you message
        System.out.println("\nThank you for playing");
    }
}
