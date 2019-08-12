import java.util.*;

public class ExceptionalUsers {
	public static void main(String[] args) {
		newAccount();
	}
	
	public static void newAccount() {
		System.out.println("Welcome new user.\nPlease enter an account name: ");
		Scanner scanner = new Scanner(System.in);
		String accountName = scanner.nextLine();
		
		System.out.println("Please enter a new password that contains at least one upper and lower case letter, as well as a number: ");
		String password = scanner.nextLine();
		
		while(true) {
			if(passwordValidation(password) == true) {
				System.out.println("Welcome, " + accountName + ". Your password is: " + password + ". Please save it carefully and don't share it with anyone under any circumstances.");
				scanner.close();
				return;
			}
			else {
				System.out.println("You entered an invalid password, please enter a new one.");
			}
		}
	}
	
    public static boolean passwordValidation(String password) { 
      String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
      return password.matches(pattern);
    }
}