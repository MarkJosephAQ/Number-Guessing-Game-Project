public class Game {
    boolean hint, answerFound;
    int chanceCount, attempt, min, max, answer;
    Game() {
        this.min = 1;
        this.max = 10;
        this.hint = true;
    }
    void setGameValues(int diffChoice) {
        // set the answer and answerFound values
        this.answerFound = false;
        this.answer = (int) Math.round(Math.random() * ((max - min)) + min);

        // switch case for the difficulty mode, set the chanceCount depending on the choices
        switch (diffChoice) {
            case 1: // Easy
                this.chanceCount = 5;
                break;
            case 2: // Medium
                this.chanceCount = 3;
                break;
            case 3: // hard
                this.hint = false; // set hint to false if chosen difficulty is hard
                this.chanceCount = 2;
                break;
            case 4: // Extreme
                this.chanceCount = 1;
                break;
            default:
                this.chanceCount = 0;
        }

        // set the attempt value after chanceCount value is determined
        this.attempt = chanceCount;
    }
    void getGameMessage(int playerAnswer, int answer) {
        //set value for answerFound and answer
        this.answerFound = false;

        // if the players answer is higher than the answer, print a hint and the tries left
        // decrement chanceCount minus 1
        if (playerAnswer > answer) {

            // initialize string message tryLower using a ternary operator to either show a hint or not
            // depending on the value of boolean hint
            String tryLower = this.hint ? "Nice guess, you have %d tries left\nHint: choose a LOWER number than %d\n"
                                        : "Tries Left: %d\n";

            this.chanceCount--;
            System.out.printf(tryLower, this.chanceCount,playerAnswer);
        }
        // else, if the player answer is lower than the answer, print a hint and the tries left
        // decrement chanceCount minus 1
        else if (playerAnswer < answer) {

            // initialize string message tryHigher using a ternary operator to either show a hint or not
            // depending on the value of boolean hint
            String tryHigher = this.hint ? "Almost! you have %d tries left\nHint: choose a HIGHER number than %d\n"
                                         : "Tries Left: %d\n";

            this.chanceCount--;
            System.out.printf(tryHigher, this.chanceCount, playerAnswer);
        }
        // else, break out of loop and decrement chanceCount, once the player answer matches the answer
        else {
            this.chanceCount--;
            this.answerFound = true;
        }
    }
}
