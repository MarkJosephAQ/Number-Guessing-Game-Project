import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize the scanner and the other variables
        Scanner input = new Scanner(System.in);
        int chanceCount;
        int min = 1;
        int max = 10;
        int answer = (int) Math.round(Math.random() * ((max - min)) + min);

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
            case 1:
                chanceCount = 10;
                break;
            case 2:
                chanceCount = 5;
                break;
            case 3:
                chanceCount = 3;
                break;
            case 4:
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
                System.out.printf("Nice try, choose a lower number \nTries Left: %d\n", chanceCount);
                chanceCount--;
            }
            // else, if the player answer is lower than the answer, print a hint and the tries left
            // decrement chanceCount minus 1
            else if (playerAnswer < answer) {
                System.out.printf("Almost! pick a higher number \nTries Left: %d\n", chanceCount);
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
