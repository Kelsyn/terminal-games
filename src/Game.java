import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) {
        if(gameSelection().equals("-m")) {
            MyMastermind game = new MyMastermind();
            game.mastermindSetup();
            try {
                game.runMastermind();
            } catch (NumberFormatException e) {
                System.out.println("Wrong Input!");
                throw new RuntimeException(e);
            }
        }
    }

    private static String gameSelection() {
        String userInputtedResponse = null;
        boolean isAnInput = false;
        while (!isAnInput) {
            System.out.println("Type -m for mastermind game");
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
}
