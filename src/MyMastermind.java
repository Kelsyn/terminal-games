import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MyMastermind {
    int count = 0;
    GameStartUpValues reference = new GameStartUpValues();

    /**
     * Runs the game, while the count is lower than the number of attempts
     */
    public void runMastermind() {
        System.out.println("Try your luck, enter your guess!");
        while (count < reference.getNumberOfAttempts()) {
            if (numberCompare()) {
                break;
            }
        }
    }

    /**
     * Allows the user to set the secret code and the number of attempts for the mastermind game
     */

    void mastermindSetup() {
        boolean userCodeSet = false;
        boolean userAttemptsSet = false;
        while (!userCodeSet && !userAttemptsSet) {
            System.out.println("Type -c to set the secret code (must be of length 4 with integers between 0 & 7)");
            System.out.println("Type -t to set the number of attempts");
            System.out.println("Type -ct to set both");
            System.out.println("Type -start to start the game with a randomly generated code & 10 attempts");

            String userChoice = getUserInput();

            if(userChoice.equals("-start")){
                generateSecretNumber();
                userCodeSet = true;
                userAttemptsSet = true;
            }

            if (userChoice.equals( "-ct")) {
                boolean hasUserInputted = false;
                boolean hasUserInputtedCode = false;
                boolean hasUserInputtedAttempts = false;
                while(!hasUserInputted) {
                    while (!hasUserInputtedCode) {
                        System.out.println("set the secret code! (must be of length 4 with integers between 0 & 7)");
                        reference.setSecretNumberArray(convertToArray());
                        hasUserInputtedCode = true;
                        userCodeSet = true;
                    }
                    while (!hasUserInputtedAttempts) {
                        System.out.println("set the number of attempts!");
                        reference.setNumberOfAttempts(Integer.parseInt(getUserInput()));
                        hasUserInputtedAttempts = true;
                        userAttemptsSet = true;
                    }
                    hasUserInputted = true;
                }
            }
            if (userChoice.equals( "-c")) {
                boolean hasUserInputted = false;
                System.out.println("set the secret code! (must be of length 4 with integers between 0 & 7)");
                while(!hasUserInputted) {
                    reference.setSecretNumberArray(convertToArray());
                    userCodeSet = true;
                    userAttemptsSet = true;
                    hasUserInputted = true;
                }
            }
            if (userChoice.equals( "-t")) {
                generateSecretNumber();
                boolean hasUserInputted = false;
                System.out.println("set the number of attempts!");
                while(!hasUserInputted) {
                    reference.setNumberOfAttempts(Integer.parseInt(getUserInput()));
                    userCodeSet = true;
                    userAttemptsSet = true;
                    hasUserInputted = true;
                }
            }
        }
    }

    /**
     * reference setter getter
     */

    public class GameStartUpValues {
        private int numberOfAttempts = 10;
        private int[] secretNumberArray;

        public void setNumberOfAttempts(int value) {
            numberOfAttempts = value;
        }

        public void setSecretNumberArray(int[] value) {
            secretNumberArray = value;
        }

        public int getNumberOfAttempts() {
            return numberOfAttempts;
        }

        public int[] getSecretNumberArray() {
            return secretNumberArray;
        }
    }

    /**
     * generates a secret number to be guessed for in the game
     */
    public void generateSecretNumber() {
        reference.secretNumberArray = new int[4];
        for (int i = 0; i < 4; i++) {
            int randomNumber = (int) (Math.random() * 8);
            reference.secretNumberArray[i] = randomNumber;
        }
    }

    /**
     * gets the user input
     *
     * @return the user input string
     */
    String getUserInput() {
        String userInputtedResponse = null;
        boolean isAnInput = false;
        while (!isAnInput) {
            try {
                BufferedReader userInputtedString = new BufferedReader(new InputStreamReader(System.in));
                userInputtedResponse = userInputtedString.readLine();
                isAnInput = true;
            } catch (Exception e) {
                System.out.println("Wrong Input!");
                return null;
            }
        }
        return userInputtedResponse;
    }

    /**
     * Converts the user input string of numbers accepting integers 0 to 7 into an integer array
     *
     * @return an integer array
     */

    int[] convertToArray() {
        String inputted = getUserInput();
        int[] intArray = new int[inputted.length()];
        if (inputted.length() != 4) {
            System.out.println("Must have 4 numbers!");
        }
        try {
            for (int i = 0; i < inputted.length(); i++) {
                int currentInteger = Integer.parseInt(inputted.substring(i, i + 1));
                if (currentInteger > 7) {
                    throw new RuntimeException("Wrong Input: " + currentInteger + " at index " + i + ", entered numbers must contain integers between 0 & 7");
                }
                intArray[i] = currentInteger;
            }
        } catch (Exception masterMindIntegerOutOfBounds) {
            System.out.println(masterMindIntegerOutOfBounds.getMessage());
        }
        return intArray;
    }

    /**
     * compares the user input array to the secret number array
     *
     * @return a boolean of whether the user has guessed correctly
     */
    public boolean numberCompare() {
        int wellPlacedPieces = 0;
        int misplacedPieces = 0;
        int[] guess = convertToArray();
        boolean didTheyGetIt = false;

        if (Arrays.equals(guess, reference.getSecretNumberArray())) {
            didTheyGetIt = true;
            System.out.println("Congrats! You did it!");
        } else {
            for (int i = 0; i < 4; i++) {
                if (guess[i] == reference.getSecretNumberArray()[i]) {
                    wellPlacedPieces++;

                }
                for (int j = 0; j < 4; j++) {
                    if (guess[j] == reference.getSecretNumberArray()[i] && guess[i] != reference.getSecretNumberArray()[i]) {
                        misplacedPieces++;
                        break;
                    }
                }
            }
        }
        count++;
        System.out.println("Attempt Number: " + count);
        System.out.println("Well placed pieces: " + wellPlacedPieces);
        System.out.println("Misplaced pieces: " + misplacedPieces);
        return didTheyGetIt;
    }
}
