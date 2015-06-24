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

        String str = Integer.toString(num);
        int j = str.length() -1;
        int factor = 1;

        for(int i = 0; i < j; i++, j--) {
            String leftStr = Character.toString(str.charAt(i));
            String rightStr = Character.toString(str.charAt(j));

            int right = Integer.parseInt(leftStr) * factor;
            int left = Integer.parseInt(rightStr) * factor;

            num = num + left - right ;
            factor *= 10;
            if(right > left) {
                num += factor;
                if(i == j-1) {
                    num += factor/10;
                }
            }

            str = Integer.toString(num);
        }
        return num;
    }
}

