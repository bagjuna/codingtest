package main1;

import java.util.Scanner;

/**
 * 1003번 피보나치 함수
 */
public class day22 {
    static int cnt0[] = new int[41];
    static int cnt1[] = new int[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cnt0[0] = 1;
        cnt1[0] = 0;
        cnt0[1] = 0;
        cnt1[1] = 1;
        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            fibonacci(number);

            System.out.println(cnt0[number] + " " + cnt1[number]);
        }

    }

    private static void fibonacci(int n) {
        for (int i = 2; i <= n; i++) {
            cnt0[i] = cnt0[i - 1] + cnt0[i - 2];
            cnt1[i] = cnt1[i - 1] + cnt1[i - 2];
        }


    }
}
