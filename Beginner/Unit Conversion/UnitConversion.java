import java.util.Scanner;
import java.lang.Math;

public class UnitConversion{
    public static void main (String[] args){
        System.out.println("What would you like to convert to what? \n1) Kilometres to miles \n2) Miles to kilometres \n3) Celsius to Fahrenheit \n4) Fahrenheit to Celsius");
        
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if(input == 1){
            System.out.println("How many kilometres would you like to convert to miles?");
            int input2 = scanner.nextInt();
            double answer = input2 / 1.609344;
            System.out.println("\nThat would be " + Math.round(answer * 100d) / 100d + " miles.");
        }
        else if(input == 2){
            System.out.println("How many miles would you like to convert to kilometres?");
            int input2 = scanner.nextInt();
            double answer = input2 * 1.609344;
            System.out.println("\nThat would be " + Math.round(answer * 100d) / 100d + " kilometres.");
        }
        else if(input == 3){
            System.out.println("How many degrees Celcius would you like to convert to Fahrenheit?");
            int input2 = scanner.nextInt();
            double answer = input2 * (9d/5d) + 32;
            System.out.println("\nThat would be " + Math.round(answer * 100d) / 100d + " degrees Fahrenheit.");
        }
        else if(input == 4){
            System.out.println("How many degrees Fahrenheit would you like to convert to Celcius?");
            int input2 = scanner.nextInt();
            double answer = (input2 - 32) * (5d/9d);
            System.out.println("\nThat would be " + Math.round(answer * 100d) / 100d + " degrees Celcius.");
        }
        else{
            System.out.println("\nPlease enter only a single number from 1 through 4.");
        }
    }
}