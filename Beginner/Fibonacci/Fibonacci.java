import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci{
    public static void main(String[] args){
        int term1 = 0;
        int term2 = 1;
        int sumterm = 0;
        ArrayList<Integer> fiboterms = new ArrayList<Integer>();

        //So long as the value of the newest Fibonacci value isn't higher than 1 million, continue finding the next value
        while(sumterm < 1000000){
            sumterm = term1 + term2;
            term1 = term2;
            term2 = sumterm;
            fiboterms.add(sumterm); //Saves the new value to an ArrayList
        }

        System.out.println("This program provides a perusal of the first 30 values of the Fibonacci sequence.");

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please provide a number: ");
        int input = (scanner.nextInt() - 1); //-1 for indexing
        System.out.println("\nThe value of term #" + input + " of the Fibonacci sequence is: " + fiboterms.get(input));

        int sumfiboterms = 0;

        //Iterates over the arraylist and adds all even values to the variable sumfiboterms.
        for(int i = 0; i <= input; i++){
            if(fiboterms.get(i) % 2 == 0){
                sumfiboterms = sumfiboterms + fiboterms.get(i);
            }
        }
        System.out.println("The sum of all even values of the first " + input + " terms is: " + sumfiboterms);
    }
}