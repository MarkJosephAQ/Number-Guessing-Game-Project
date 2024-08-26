import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize the scanner and the other variables
        Scanner input = new Scanner(System.in);
        String restartGame;
        int chanceCount, min = 1, max = 10;
        int answer = (int) Math.round(Math.random() * ((max - min)) + min);
        boolean hint = true;

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

            // switch case for the difficulty mode, set the chanceCount depending on the choices
            switch (diffChoice) {
                case 1: // Easy
                    chanceCount = 5;
                    break;
                case 2: // Medium
                    chanceCount = 3;
                    break;
                case 3: // hard
                    chanceCount = 2;
                    hint = false; // set hint to false if chosen difficulty is hard
                    break;
                case 4: // Extreme
                    chanceCount = 1;
                    break;
                default:
                    chanceCount = 0;
                    break;
            }

            // game start message
            String gameStartMessage = """
                    You have %d chance/s to guess.
                    Let's Start!
                    """;

            // print game start message
            System.out.printf(gameStartMessage, chanceCount);

            // create a loop that decreases the number of chances everytime the player guess wrong, break out of the loop
            // once the player guess right.
            do {
                // print the message for guess input
                System.out.print("\nGuess the Number: ");

                // initialize scanner for the players answer
                int playerAnswer = input.nextInt();

                // if the players answer is higher than the answer, print a hint and the tries left
                // decrement chanceCount minus 1
                if (playerAnswer > answer) {

                    // initialize string message tryLower using a ternary operator to either show a hint or not
                    // depending on the value of boolean hint
                    String tryLower = hint ? "Nice try, choose a lower number than %d \nTries Left: %d\n" : "Tries Left: %d\n";

                    System.out.printf(tryLower, playerAnswer, chanceCount);
                    chanceCount--;
                }
                // else, if the player answer is lower than the answer, print a hint and the tries left
                // decrement chanceCount minus 1
                else if (playerAnswer < answer) {

                    // initialize string message tryHigher using a ternary operator to either show a hint or not
                    // depending on the value of boolean hint
                    String tryHigher = hint ? "Almost! pick a higher number than %d \nTries Left: %d\n" : "Tries Left: %d\n";

                    System.out.printf(tryHigher, playerAnswer, chanceCount);
                    chanceCount--;
                }
                // else, break out of loop once the player answer matches the answer
                else {
                    break;
                }
            } while (chanceCount > 0);

            // if after the loop breaks and the chanceCount is equal to zero, print the game over message
            if (chanceCount < 1) {
                System.out.print("""

                        Game Over, It's ok you did your best
                        Want to go again? (Y/N):\s""");
            }
            // else print the congratulatory message
            else {
                System.out.print("""

                        Congratulations, You've guessed the answer!!!
                        That was fun, Want to play again? (Y/N):\s""");
            }
            // initialize the restartGame variable to the value of the next input
            restartGame = input.next().toUpperCase();

            // add a space for the next
            System.out.println();

        // restart the loop if the user inputs "Y" and end the loop if the user inputs "N"
        } while (restartGame.equals("Y"));

        // print a thank-you message
        System.out.println("\nThank you for playing");
    }
}
