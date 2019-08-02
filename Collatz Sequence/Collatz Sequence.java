import java.util.*;

public class CollatzSequence{
    public static void main(String[] args){
        Random rand = new Random();
        long posRandInt = rand.nextInt(Integer.MAX_VALUE) + 1; //provides a random positive integer. +1 so it can't provide 0.

        System.out.println(posRandInt);

        while(posRandInt != 1){
            if(posRandInt % 2 == 0){
                posRandInt = posRandInt / 2;
            }
            posRandInt = 3 * posRandInt + 1;
            System.out.println(posRandInt);
        }

        System.out.println("The number is now 1. The Collatz Sequence has prevailed!");

    }
} //even with type long it doesn't seem like Java is built for this. Overflows and thus negative numbers to the max!