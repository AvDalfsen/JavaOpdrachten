import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a year to check whether it is a leap year: ");
            if(scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if(input % 100 == 0 & input % 400 == 0) {
                    System.out.println(input + " is a leap year!");
                } 
                else if(input % 4 == 0) {
                    System.out.println(input + " is a leap year!");
                } 
                else {
                    System.out.println(input + " is not a leap year.");
                }

            } 
            else {
                String input = scanner.nextLine();
                System.out.println("'" + input + "'" + " is not a valid year. Please enter only numbers.");
            }
    }
}