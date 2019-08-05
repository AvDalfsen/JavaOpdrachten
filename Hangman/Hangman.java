import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

class Hangman {
    public static void main (String[] args) {
        Hangman hangman = new Hangman();
        String word = hangman.generateWord();
        int length = word.length();
        String playWord = "";
        String mistakes = "";

        for (int i = 0; i < length; i++) {
            playWord = playWord + "_"; //playWord is set as length of word in underscores
        }

        System.out.println(playWord);

        int turns = 10;
        boolean win = false;
        while (turns > 0 && win == false){ //while the player isn't out of turns and hasn't won
            System.out.print("Enter a letter: "); //print this

        Scanner scanner = new Scanner(System.in); //I miss "input()"
        String letter = scanner.nextLine().trim();

        if (letter.length() == 0){ //if input isn't null
            System.out.println("Please enter a letter.");
        }
        else { if (letter.length() > 1){ //if input is more than 1 letter
                System.out.println("Please enter only one letter.");
            }
            else if (mistakes.contains(letter) == true || playWord.contains(letter) == true) { //if input letter is already in mistakes or playWord (used before)
                System.out.println("You have already used this letter before. Please play a different one.");
            }       
            else {for (int i = 0; i < length; i++) {
                    if (letter.equalsIgnoreCase("" + word.charAt(i))) { //if the inputted letter is the same as the one at position i
                        playWord = playWord.substring(0,i) + letter + playWord.substring(i+1,length); //replace playWord with inputted letter wrapped by what precedes and succeeds its position in playWord
                    } else if (i == length - 1 && (word.contains(letter) == false)) { //if i equals the length of the word (-1 for indexing) and the word does not contain the inputted letter
                        mistakes += (letter + "-"); //mistakes + letter and a dash
                        turns = turns - 1; //decrease number of turns left by 1
                    }
                }
            } 
        }

        System.out.println("\n" + playWord);
        System.out.println("\n" + "You have " + turns + " turns left!");
        System.out.println("Wrong letters already used: " + mistakes + "\n");

        if (word.equalsIgnoreCase("" + playWord)) {
            win = true;
            System.out.println("You win!");
        }
        if(turns == 0) {
            System.out.println("Out of turns; game over. You lost.");
            }
        }
    }

    public String generateWord() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10); // produces a random number from 0 to 10 (excludes 10)
        List<String> words = Arrays.asList("never", "gonna", "give", "you", "up", /*never gonna*/ "let", /*you*/ "down", /*never gonna run*/ "around", "and", "desert" /*you*/);
        String word = words.get(randomNum); //uses the random number as index to pick a word from the list
        
        return word;
   } 
}