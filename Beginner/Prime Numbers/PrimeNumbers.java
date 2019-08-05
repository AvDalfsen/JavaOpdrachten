import java.util.ArrayList;

class PrimeNumbers {
	public static boolean primeChck (int number) { 
		for (int i = 2; i < number; i++) { 
			if (number % i == 0) { 
				return false;
			}
		}
    return true;
	}
    public static void main (String [] args) { 
        ArrayList <Integer> primes = new ArrayList<Integer>();
        int number = 2;

        while (primes.size() != 10001) { 
            if (primeChck(number) == true) { 
                primes.add(number);
            }
            number = number + 1;
        }
        System.out.println("The 10001st prime number is: " + (number-1));	
    } 
}