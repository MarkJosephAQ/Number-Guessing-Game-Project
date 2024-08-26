import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize the scanner and the other variables
        Scanner input = new Scanner(System.in);
        int chanceCount;
        int min = 1;
        int max = 10;
        int answer = (int) Math.round(Math.random() * ((max - min)) + min);
        boolean hint = true;

        // initialize the welcome message
        String welcomeMessage = """
                Welcome to the Number Guessing Game!\s
                I'm thinking of a number between 1 - 100\s
                You have 3 tries to guess before Game Over\s
                Good luck!""";

        // initialize the difficulty message
        String difficultyMessage = """
                Please choose the difficulty level
                1. Easy (10)
                2. Medium (5)
                3. Hard (3)
                4. Extreme (1)
                """;

        // print the welcome message
        System.out.println(welcomeMessage + "\n");

        // print the difficulty message
        System.out.println(difficultyMessage);

        // print the choice line
        System.out.print("Choose difficulty: ");

        // initialize scanner
        int diffChoice = input.nextInt();

        // switch case for the difficulty mode, set the chanceCount depending on the choices
        switch(diffChoice) {
            case 1: // Easy
                chanceCount = 10;
                break;
            case 2: // Medium
                chanceCount = 5;
                break;
            case 3: // hard
                chanceCount = 3;
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
                You have %d chances to guess.
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
            if(playerAnswer > answer) {

                // initialize string message tryLower using a ternary operator to either show a hint or not
                // depending on the value of boolean hint
                String tryLower = hint?"Nice try, choose a lower number \nTries Left: %d\n":"Tries Left: %d\n";

                System.out.printf(tryLower, chanceCount);
                chanceCount--;
            }
            // else, if the player answer is lower than the answer, print a hint and the tries left
            // decrement chanceCount minus 1
            else if (playerAnswer < answer) {

                // initialize string message tryHigher using a ternary operator to either show a hint or not
                // depending on the value of boolean hint
                String tryHigher = hint?"Almost! pick a higher number \nTries Left: %d\n":"Tries Left: %d\n";

                System.out.printf(tryHigher, chanceCount);
                chanceCount--;
            }
            // else, break out of loop once the player answer matches the answer
            else {
                break;
            }
        } while (chanceCount > 0);

        // if after the loop breaks and the chanceCount is equal to zero, print the game over message
        if(chanceCount == 0) {
            System.out.println("\nGame Over, Thank you for playing!!!");
        }
        // else print the congratulatory message
        else {
            System.out.println("\nCongratulations, You've guessed the answer!!!");
        }

    }
}
