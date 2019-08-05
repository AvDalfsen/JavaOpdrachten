import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte{
    public static void main(String[] args){
        int streak = 0;
        String[] field = {
            "AA ## ## \nAA ## ## \n1  2  3\n",
            "## AA ## \n## AA ## \n1  2  3\n",
            "## ## AA \n## ## AA \n1  2  3\n",
        };

        System.out.println("Do you wish to start? y/n");
        Scanner scanner = new Scanner(System.in);
        String input = (scanner.nextLine());
        
        while(input.equals("y")){
            System.out.println("Guess where the Ace is.");
            System.out.println("\n## ## ## \n## ## ## \n1  2  3\n");
            Random rnd = new Random();
            int position = (rnd.nextInt(3));
            System.out.println(position);

            Scanner scanner2 = new Scanner(System.in);
            int input2 = ((scanner2.nextInt()));

            if(position == (input2-1)){
                System.out.println(field[position]);
                System.out.println("Correct!\n");
                streak++;
                System.out.println("You now have a win streak of: " + streak);
                System.out.println("/////");
            }
            else if(position != (input2-1)){
                System.out.println(field[position]);
                System.out.println("Incorrect!\n");
                System.out.println("/////");
                streak = 0;
            
            System.out.println("Do you wish to continue playing? y/n");
            input = (scanner.nextLine());
            }
        }
    }
}