package nl.sogyo.java_opdrachten.avdalfsen.intermediate;

import java.util.Scanner;
import java.lang.Math;

public class Fractions{
    public static void main(String[] args){
        System.out.print("This program is for performing math using fractions. Please enter a fraction: ");
        Fraction fract = new Fraction();
        Fraction fract2 = new Fraction();
        int whole;
        String fraction2;
        Scanner scanner = new Scanner(System.in);
        String fraction = getFraction();

        fract.setNumerator(fractionalSeparator(fraction)[0]);
        fract.setDenominator(fractionalSeparator(fraction)[1]);

        switch(Menu()){
            case 1: System.out.println(fract.toDecimal());
                break;
            case 2: System.out.println(fract.toString());
                break;
            case 3: System.out.print("\nPlease enter the whole number you wish to add to the fraction: ");                  
                    whole = scanner.nextInt();
                    reduce(fract.addWhole(whole)[0], fract.addWhole(whole)[1]);
                break;
            case 4: System.out.print("\nPlease enter the fraction you wish to add to the fraction: ");
                    fraction2 = getFraction();
                    fract2.setNumerator(fractionalSeparator(fraction2)[0]);
                    fract2.setDenominator(fractionalSeparator(fraction2)[1]);
                    reduce(fract.addFraction(fract2)[0], fract.addFraction(fract2)[1]);
                break;
            case 5: System.out.print("\nPlease enter the whole number you wish to subtract from the fraction: ");
                    whole = scanner.nextInt();
                    reduce(fract.subtractWhole(whole), fract.getDenominator());
                break;
            case 6: System.out.print("\nPlease enter the fraction you wish to subtract from the fraction: ");
                    fraction2 = getFraction();
                    fract2.setNumerator(fractionalSeparator(fraction2)[0]);
                    fract2.setDenominator(fractionalSeparator(fraction2)[1]);
                    reduce(fract.subtractFraction(fract2)[0], fract.subtractFraction(fract2)[1]);
                break; 
            case 7: System.out.println(fract.getDenominator());
                    System.out.print("\nPlease enter the whole number by which you wish to multiply the fraction: ");
                    whole = scanner.nextInt();
                    reduce(fract.multiplyWhole(whole), fract.getDenominator());
                break;
            case 8: System.out.print("\nPlease enter the fraction which you wish to multiply the fraction: ");
                    fraction2 = getFraction();
                    fract2.setNumerator(fractionalSeparator(fraction2)[0]);
                    fract2.setDenominator(fractionalSeparator(fraction2)[1]);
                    reduce(fract.multiplyFraction(fract2)[0], fract.multiplyFraction(fract2)[1]);
                break;
            case 9: System.out.print("\nPlease enter the whole number by which you wish to divide the fraction: ");
                    whole = scanner.nextInt();
                    reduce(fract.getNumerator(), fract.divideWhole(whole));
                break;
            case 10: System.out.print("\nPlease enter the fraction by which you wish to divide the fraction: ");
                    fraction2 = getFraction();
                    fract2.setNumerator(fractionalSeparator(fraction2)[0]);
                    fract2.setDenominator(fractionalSeparator(fraction2)[1]);
                    reduce(fract.divideFraction(fract2)[0], fract.divideFraction(fract2)[1]);
                break;
        }
    }

    public static int Menu(){
        System.out.println("\nWhat would you like to do with this fraction?" +
        "\n1) Fraction to decimal notation" +
        "\n2) Fraction to a string" +
        "\n3) Add a whole number to the fraction" +
        "\n4) Add a fraction to the fraction" +
        "\n5) Subtract a whole number from the fraction" +
        "\n6) Subtract a fraction from the fraction" +
        "\n7) Multiply the fraction by a whole number" +
        "\n8) Multiply the fraction by a fractional" +
        "\n9) Divide the fraction by a whole number" +
        "\n10) Divide the fraction by a fraction");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    public static String getFraction(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static int[] fractionalSeparator(String input){
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

    private static int calculateGCD(int num, int denom) {
        return denom==0 ? num : calculateGCD(denom, num%denom);
        }
      
    public static void reduce(int num, int denom) {
         int gcd = calculateGCD(num, denom);
         System.out.println((num /= gcd) + "/" + (denom /= gcd));
    }
}

class Fraction{
    private int numerator;
    private int denominator;

    public int getNumerator(){
        return numerator;
    }
    
    public void setNumerator(int num){
        numerator = num;
    }

    public int getDenominator(){
        return denominator;
    }

    public void setDenominator(int denom){
        denominator = denom;
    }

    public double toDecimal(){
        return ((double)numerator) / denominator;
    }

    public String toString(){
        return ("\"" + numerator + "/" + denominator + "\"");
    }

    public int[] addWhole(int whole){
        return new int[] {(numerator + (denominator * whole)), denominator};
    }

    public int[] addFraction(Fraction fract2){
        return new int[] {((numerator * fract2.denominator) + (fract2.numerator * denominator)), (denominator * fract2.denominator)};
    }

    public int subtractWhole(int whole){
        return (numerator * whole) % denominator;
    }
    public int[] subtractFraction(Fraction fract2){
        return new int[] {((numerator * fract2.denominator) - (fract2.numerator * denominator)), (denominator * fract2.denominator)};
    }

    public int multiplyWhole(int whole){
        return numerator * whole;
    }

    public int[] multiplyFraction(Fraction fract2){
        return new int[] {(numerator * fract2.numerator), (denominator * fract2.denominator)};        
    }

    public int divideWhole(int whole){
        return denominator * whole;
    }

    public int[] divideFraction(Fraction fract2){
        return new int[] {(numerator * fract2.denominator), (denominator * fract2.numerator)};
    }
}