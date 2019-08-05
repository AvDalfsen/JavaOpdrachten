import java.util.Random;
import java.util.Scanner;

public class HigherLower{
    public static void main(String[] args){
        Random rnd = new Random();
        int number = rnd.nextInt(51);

        System.out.println("Enter a number to guess the randomly generated number between 0 and 50");
        
        Boolean guessed = false;
        int guesses = 10;
        while(guessed == false){
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            if(input < number){
                System.out.println("\nNope, higher!");
                guesses--;
                System.out.println("You have " + guesses + " guesses remaining.");
            }
            else if(input > number){
                System.out.println("\nNope, lower!");
                guesses--;
                System.out.println("You have " + guesses + " guesses remaining.");
            }
            else if(input == number){
                System.out.println("\nYep! Correct!");
                guessed = true;
            }
        }
    }
}