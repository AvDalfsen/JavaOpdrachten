import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args){
        System.out.print("Please enter a word to check whether it's a palindrome: ");
        
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String reverse = "";

        for(int i = input.length() - 1; i >= 0; i--)
        {
            reverse = reverse + input.charAt(i);
        }

        if(input.equals(reverse)){
            System.out.println("The reverse is: " + reverse);
            System.out.println("So yes, it's a palindrome!");
        }
        else if(!input.equals(reverse)){
            System.out.println("The reverse is: " + reverse);
            System.out.println("So no, it's not a palindrome.");
        }
    }
}