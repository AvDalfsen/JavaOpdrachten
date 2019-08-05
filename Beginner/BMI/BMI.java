import java.util.Scanner;

public class BMI{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program will calculate your BMI on your weight and height.");
        System.out.print("Please enter your height in centimetres (e.g. 176): ");
        double height = scanner.nextInt();
        System.out.print("Please enter your weight in kilograms: ");
        double weight = scanner.nextInt();
        height = height / 100;
        double bmi = weight / (height * height);
        System.out.println("\nYour BMI is: " + bmi);

        if(bmi > 0 && bmi < 18.5){
            System.out.println("You're underweight! Start eating without concern while them chubbier people languish at the sight of your freedom");
        }
        else if(bmi >= 18.5 && bmi <= 24.9){
            System.out.println("You're at so called 'normal weight'. Rejoice, for thou art without a plethora of health issues.");
        }
        else if(bmi >= 25 && bmi <= 29.9){
            System.out.println("You're overweight, lil' chubbo! Either get used to the flabbiness that is your body, or get to exercising.");
        }
        else{
            System.out.println("Either you've managed to get a negative BMI or you're grossly overweight. Get yo'self to a doctor, stat!");
        }
    }
}