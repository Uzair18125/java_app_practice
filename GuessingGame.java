import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        // Create objects for generating numbers and reading user input
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Define application constraints
        int numberToGuess = random.nextInt(100) + 1; // Generates a number between 1 and 100
        int numberOfTries = 0;
        int playerGuess = 0;
        boolean hasWon = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");
        
        // Main game loop
        while (!hasWon) {
            System.out.print("Enter your guess: ");
            
            // Validate that the user entered an integer
            if (scanner.hasNextInt()) {
                playerGuess = scanner.nextInt();
                numberOfTries++;
                
                // Check the user's guess against the generated number
                if (playerGuess < 1 || playerGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                } else if (playerGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (playerGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasWon = true;
                    System.out.println("\nCongratulations! You found the number in " + numberOfTries + " tries.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
        }
        
        // Clean up resources
        scanner.close();
    }
}