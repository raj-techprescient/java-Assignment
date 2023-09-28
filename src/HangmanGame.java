import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("What is your name? ");
        String name = scan.nextLine();
        System.out.println("Good Luck ! " + name);

        String[] words = {"Tech", "computer", "science", "Prescient", "python", "java", "c++", "aws", "gcp"};
        String word = words[rand.nextInt(words.length)];
        System.out.println("Guess the characters");

        String guesses = "";
        int turns = 12;

        while (turns > 0) {
            int failed = 0;

            for (char ch : word.toCharArray()) {
                if (guesses.indexOf(ch) != -1) {
                    System.out.print(ch + " ");
                } else {
                    System.out.print("_ ");
                    failed++;
                }
            }

            if (failed == 0) {
                System.out.println("\nYou Win");
                System.out.println("The word is: " + word);
                break;
            }

            System.out.println();

            System.out.print("Guess a character: ");
            String guess = scan.next();
            guesses += guess;

            if (!word.contains(guess)) {
                turns--;
                System.out.println("Wrong");
                System.out.println("You have " + turns + " more guesses");

                if (turns == 0) {
                    System.out.println("You Lose");
                }
            }
        }

        scan.close();

    }
}
