import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class List {
    static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
  
    } 
    public static void main(String[] args) {

        Random rd = new Random(); // creates a Random object
        int[] n = new int[10]; // creates an array object of 10 integers long
        ArrayList<Integer> filter = new ArrayList<Integer>();
        ArrayList<Integer> two = new ArrayList<Integer>();
        ArrayList<Integer> three = new ArrayList<Integer>();
        ArrayList<Integer> five = new ArrayList<Integer>();
        ArrayList<Integer> rest = new ArrayList<Integer>();

        System.out.print("This is an array of 10 random numbers between 0 and 100: ");
        for (int i = 0; i < n.length; i++) { // so long as i is smaller than the length of n, add 1 to i.
            n[i] = rd.nextInt(100); // storing random integers in an array
        }
        
        System.out.print(Arrays.toString(n));
        bubbleSort(n); // sorts the numbers in the array from lowest to highest

        for (int i = 0; i < n.length; i++) {
            if(n[i] % 2 == 0){ // checks whether an entry in arr is divisible by 2
                filter.add(n[i]); // adds those numbers to the filter array
            }
        }
        for (int i = 0; i < n.length; i++) {
            if(n[i] % 2 == 0){ // checks whether an entry in arr is divisible by 2
                two.add(n[i]); // adds those numbers to the filter array
            }
            else if (n[i] % 3 == 0){
                three.add(n[i]);
            }
            else if (n[i] % 5 == 0){
                five.add(n[i]);
            }
            else if (n[i] % 2 != 0 & n[i] % 3 != 0 & n[i] % 5 != 0){
                rest.add(n[i]);
            }
        }

        //the highest
        System.out.println("\n\nThe highest number of the array is: " + n[9]); // the 10th number is now the highest
        //the lowest two
        System.out.println("\nThe two lowest numbers of the array are: " + n[0] + " & " + n[1]); // the 1st and 2nd numbers are now the lowest
        //filter
        System.out.println("\nThe even numbers are: " + filter);
        //split
        System.out.println("\nThe numbers divisible by 2 are: " + two + "\nThe numbers divisible by 3 are: " + three + "\nThe numbers divisible by 5 are: " + five + "\nThe remaining numbers are: " + rest + ".");
        //sort
        System.out.println("\nThe sorted numbers are: " + Arrays.toString(n));
    }
}