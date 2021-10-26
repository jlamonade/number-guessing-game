package com.company;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import java.lang.Exception;

public class Main {

    public static String getName() throws Exception {
        Scanner getInput = new Scanner(System.in);
        try {
            return getInput.nextLine();
        } catch (Exception e) {
            throw new Exception("Caught Exception: Incorrect Input");
        }
    }

    public static int getGuess() throws Exception {
        Scanner getInput = new Scanner(System.in);
        try {
            return getInput.nextInt();
        } catch (Exception e) {
            throw new Exception("Caught Exception: Incorrect Input");
        }
    }

    public static int getTargetNumber() throws Exception {
        Random rand = new Random();
        return rand.nextInt(21 - 1) + 1;
    }

    public static void guessingGame() throws Exception {
        System.out.println("Hello! What is your name?");
        String playerName = getName();
        System.out.println(String.format("Well, %S, I am thinking of a number between 1 and 20.", playerName));
        System.out.println("Take a guess");
        int target = getTargetNumber();
        int guess = getGuess();
        int guessCounter = 1;
        while (guess != target) {
            if (guessCounter == 6) {
                System.out.println("Too many tries! You lose.");
                break;
            }
            if (guess > target) {
                System.out.println("Your guess is too high!");
            } else {
                System.out.println("Your guess is too low.");
            }
            System.out.println("Take a guess");
            guessCounter++;
            guess = getGuess();
        }
        if (guessCounter < 6) {
            System.out.println(String.format("Good job, %s! You guessed my number in %s guesses!", playerName, guessCounter));
        }
    }

    public static boolean playAgain() throws Exception {
        Scanner getInput = new Scanner(System.in);
        String playerChoice;
        try {
            playerChoice = getInput.nextLine();
        } catch (Exception e) {
            throw new Exception("Caught Exception: Incorrect Input");
        }
        while (Objects.equals(playerChoice, "n") || Objects.equals(playerChoice, "y")) {
            if (playerChoice.equals("y")) {
                return true;
            } else if (playerChoice.equals("n")) {
                return false;
            } else {
                System.out.println("Please enter a valid choice...(y or n)");
                playerChoice = getInput.nextLine();
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
	// write your code here
        boolean play = true;
        while (play) {
            guessingGame();
            System.out.println("Would you like to play again? (y or n)");
            play = playAgain();
        }
    }
}
