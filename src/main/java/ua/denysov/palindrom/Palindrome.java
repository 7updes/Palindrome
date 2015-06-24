package ua.denysov.palindrom;

import java.util.Scanner;

/**
 * Created by Alex on 22.06.2015.
 */
public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(palindromeFinder(n));

    }

    public static int palindromeFinder(int num) {

        if(num <= 0){
            throw new IllegalArgumentException(num+" - is not natural number");
        }
        String str = Integer.toString(num);
        //for going in cycle from the end
        int j = str.length() -1;
        //from both sides cycle going into middle and in each iteration
        // right and left element increases by factor, 1, 10, 100, 1000...
        int factor = 1;

        for(int i = 0; i < j; i++, j--) {
            //digit from start
            String leftStr = Character.toString(str.charAt(i));
            //digit from the end
            String rightStr = Character.toString(str.charAt(j));

            //parse to int
            int right = Integer.parseInt(leftStr) * factor;
            int left = Integer.parseInt(rightStr) * factor;

            //last element as first
            num = num + left - right ;
            factor *= 10;
            //increases number if last element greater then first
            if(right > left) {
                num += factor;
                //if the left and right sides of number are met
                if(i == j-1) {
                    num += factor/10;
                }
            }
            //change string to current
            str = Integer.toString(num);
        }
        return num;
    }
}

