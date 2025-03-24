package main1;

import java.util.Scanner;

/**
 * 10162번 전자레인지
 */
public class day23 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = 5 * 60;
        int b = 60;
        int c = 10;
        int number = sc.nextInt();
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;

        cntA = number / a;
        number = number % a;

        cntB = (number) / b;
        number = number % b;

        cntC = number / c;
        number = number % c;
        if (number > 0) {
            System.out.println(-1);
        } else
            System.out.println(cntA + " " + cntB + " " + cntC);

    }
}
