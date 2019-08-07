package nl.sogyo.javaopdrachten.avdalfsen.intermediate;

/*double toDecimalNotation() -> 1/3 should return 0.33333
divide numerator by denominator. Type double?

string toString() -> 1/3 should return “1/3”
https://www.javatpoint.com/understanding-toString()-method

Fraction add(int number) -> 1/3 + 1 should become 4/3
numerator += number * denominator = 1 + 1*3 = 4
"numerator/denominator" = 4/3

Fraction subtract(int number) -> 4/3 - 1 should become 1/3
numerator = (numerator * number) % denominator = 4 * 1 = 4 % 3 = 1
"numerator/denominator" = 1/3

Fraction add(Fraction fraction) -> 1/3 + 1/6 should become 1/2
numerator of resulting fraction = (numerator1 * denominator2) + (numerator2 * denominator1) = 9
denominator of resulting fraction = denominator1 * denominator2 = 18
so 9/18

Fraction subtract(Fraction fraction) -> 1/2 - 1/6 should become 1/3
numerator of resulting fraction = (numerator1 * denominator2) - (denominator1 * numerator2) = 4
denominator of resulting fraction = denominator1 * denominator2 = 12
so 4/12
GCD to get to 1/3

Fraction multiply(int number) -> 3/4 * 2 should become 3/2
numerator*2 = 6
if number is even{
    denominator/2 = 2
    numerator/2 = 3
} else{
    don't divide? and just stick to numerator * 2? Might/should be able to simplify. GCD? Depends on if it works with unevens
}

result = 3/2

Fraction multiply(Fraction fraction) -> 3/4 * 2/5 should become 3/10
numerator1 * numerator2
denominator1 * denominator2
GCD to simplify

Fraction divide(int number) -> 3/2 / 2 should become 3/4
denominator2 * number - should work? 5/10 /2 = 5/20, a quarter. Needs further testing though.
GCD to simplify.

Fraction divide(Fraction fraction) -> 3/10 / 2/5 should become 3/4 
numerator1 * denominator2
denominator1 * numerator2
GCD to simplify

*/

import java.util.Scanner;
import java.lang.Math;

public class Fractionals{
    public static void main(String[] args){
        int numerator1;
        int denominator1;
        int numerator2;
        int denominator2;
        double result;
        String input3 = "";

        System.out.print("Please enter a fractional (format e.g.: 1/3): ");
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine().trim();
        int[] fract1 = fractionalSeparator(input1);

        System.out.println("\nWhich of the following functions would you like to use?" +
                            "\n1) Fractional to decimal notation" +
                            "\n2) Fractional to a string" +
                            "\n3) Add a whole number to the fractional" +
                            "\n4) Add a fractional to the fractional" +
                            "\n5) Subtract a whole number from the fractional" +
                            "\n6) Subtract a fractional from the fractional" +
                            "\n7) Multiply the fractional by a whole number" +
                            "\n8) Multiply the fractional by a fractional" +
                            "\n9) Divide the fractional by a whole number" +
                            "\n10) Divide the fractional by a fractional");

        int input2 = scanner.nextInt();

        switch(input2){
            case 1: System.out.println(toDecimals(fract1[0], fract1[1]));
                break;
            case 2: 
                break;
            case 3: 
                break;
            case 4: int[] fract2 = fractionalSeparator(secondNumber());
                int[] resultingFract = addFract(fract1, fract2);
                System.out.println(resultingFract[0] + "/" + resultingFract[1]);
                break;
        }
    }

    static int[] fractionalSeparator(String input){
        int numerator = 0;
        int denominator = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '/'){
                numerator = Integer.parseInt(input.substring(0,i));
                denominator = Integer.parseInt(input.substring(i+1,input.length()));
            }
        }
        return new int[] {numerator, denominator};
    }

    static String secondNumber(){
        System.out.print("Please enter the number or fraction that you wish to add, subtract, or multiply or divide by: ");
        Scanner scanner = new Scanner(System.in);
        String input3 = scanner.nextLine();
        return input3;
    }

    static double toDecimals(int numerator, int denominator){
        double result = (double) numerator / (double) denominator;
        return result;
    }

    static int[] addFract(int[] fract1, int[] fract2){
        int num1 = fract1[0];
        int num2 = fract2[0];
        int denom1 = fract1[1];
        int denom2 = fract2[1];
        int resFractNum = (num1 * denom2) + (num2 * denom1);
        int resFractDenom = denom1 * denom2;

        return new int[] {resFractNum, resFractDenom};
    }
}

    /*GCD needed to reduce to the lowest possible fraction
    /**
    * Calculates gcd of two numbers
    * 
    * @param numerator
    * @param denominator
    * @return
    **/

//    public int calculateGCD(int numerator, int denominator) {
//       if (numerator % denominator == 0) {
//                 return denominator;
//            }
//        return calculateGCD(denominator, numerator % denominator);
//        }
     
        /**
        * Reduce the fraction to lowest form
        **/
//    void reduce() {
//        int gcd = calculateGCD(numerator, denominator);
//        numerator /= gcd;
//        denominator /= gcd;
//    }
//}
