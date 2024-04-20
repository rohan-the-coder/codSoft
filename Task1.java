import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        final int MIN_NUM = 1;
        final int MAX_NUM = 100;
        final int MAX_ATTEMPTS = 5;
        int totalScore = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out
                .println("I've picked a number between " + MIN_NUM + " and " + MAX_NUM + ". Can you guess what it is?");

        for (int round = 1; round <= 3; round++) {
            int targetNumber = random.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;
            int attempts = 0;

            System.out.println("\nRound " + round + ":");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in "
                            + attempts + " attempts!");
                    totalScore++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
        }

        System.out.println("\nGame Over! Your total score is " + totalScore + "/3.");

        scanner.close();
    }
}
