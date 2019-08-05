import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CoinToss{
    
    public static String coinToss(){
        Random rand = new Random();
        int coin = rand.nextInt(2); //Produces either 0 or 1 randomly.
        String coinstate = "";

        if(coin == 0){ //If random product is 0, declare heads. If 1, declare tails.
            coinstate = "heads";
        }
        else if(coin == 1){
            coinstate = "tails";
        }
        return coinstate; //When method is called, produces a string of either 'heads' or 'tails'.
    }

    public static String choice(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static void main(String[] args){
        System.out.println("Please guess either 'heads' or 'tails'");
        
        String toss = coinToss(); //Initially tried directly using the methods in the if statements, but the results were buggy. This solved it. Somehow. Got to love programming.
        String guess = choice();

        if(toss.equals("heads") && guess.equals("heads")){
            System.out.println("\nCorrect! It's heads.");
        }
        else if(toss.equals("tails") && guess.equals("tails")){
            System.out.println("\nCorrect! It's tails.");
        }
        else if(toss.equals("heads") && guess.equals("tails")){
            System.out.println("\nWrong! It's heads.");
        }
        else if(toss.equals("tails") && guess.equals("heads")){
            System.out.println("\nWrong! It's tails.");
        }
        else{
            System.out.println("\nPlease enter only exactly either 'heads' or 'tails'");
        }
        System.out.println("\n...");
        System.out.println("And you'll just have to believe me on that, really.");
    }
}