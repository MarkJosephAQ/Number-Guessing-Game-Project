import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize the scanner and the other variables
        Scanner input = new Scanner(System.in);
        int chanceCount;

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
    }
}
