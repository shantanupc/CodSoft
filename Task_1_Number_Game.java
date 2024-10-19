import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        boolean playAgain = true;
        int totalScore = 0;
        
        while (playAgain) {
            System.out.print("\nEnter the number of rounds you want to play: ");
            int rounds = scanner.nextInt();
            
            for (int round = 1; round <= rounds; round++) {
                System.out.println("\n--- Round " + round + " ---");
                int targetNumber = random.nextInt(100) + 1;
                int maxAttempts = 10;
                int attempts = 0;
                
                System.out.println("You have " + maxAttempts + " attempts to guess the number.");
                
                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess (1-100): ");
                    int guess = scanner.nextInt();
                    attempts++;
                    
                    if (guess < targetNumber) {
                        System.out.println("Too low!");
                    } else if (guess > targetNumber) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                        totalScore += (maxAttempts - attempts + 1);
                        break;
                    }
                }
                
                if (attempts == maxAttempts) {
                    System.out.println("You've used all your attempts! The correct number was " + targetNumber + ".");
                }
            }
            
            System.out.println("\nYour current score is: " + totalScore);
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        
        System.out.println("\nGame over! Your final score is: " + totalScore);
        scanner.close();
    }
}
