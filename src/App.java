import java.util.Scanner;

public class App {

    final static int N_ELEMENTS_IN_GALLOWS = 7;

    private static int mistakeCount = 0;
    private static String[] words = { "cat", "dog", "fish", "bird", "human" };
    private static String randomWord = words[(int) (Math.random() * words.length)];
    private static String wordToDisplay = new String(new char[randomWord.length()]).replace("\0", "_");

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        while (mistakeCount < N_ELEMENTS_IN_GALLOWS && wordToDisplay.contains("_")) {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Word: " + wordToDisplay);
            System.out.print("Guess: ");

            char inputChar = input.next().charAt(0);

            guess(inputChar);
        }

        input.close();
    }

    private static void guess(char inputChar) {

        // String updatedWordToDisplay = new String();
        StringBuilder updatedWordToDisplay = new StringBuilder();

        // Check if char exists in the word and update temp strings
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == inputChar) {
                // updatedWordToDisplay += inputChar;
                updatedWordToDisplay.append(inputChar);
            } else if (wordToDisplay.charAt(i) != '_') {
                updatedWordToDisplay.append(randomWord.charAt(i));
            } else {
                updatedWordToDisplay.append('_');
            }
        }

        if (wordToDisplay.equals(updatedWordToDisplay.toString())) {
            mistakeCount++;

            drawHangmanImage();
        } else {
            wordToDisplay = updatedWordToDisplay.toString();
        }

        if (wordToDisplay.equals(randomWord.toString())) {
            System.out.println("YOU GOT IT! The word is " + randomWord);
        }
    }

    public static void drawHangmanImage() {
        if (mistakeCount == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }

        if (mistakeCount == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        if (mistakeCount == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }

        if (mistakeCount == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        if (mistakeCount == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        if (mistakeCount == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        
        if (mistakeCount == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was " + randomWord);
        }
    }
}
