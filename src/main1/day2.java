package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class day2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            num -= arr[i];
            if (num <= 0) {
                System.out.println(N - i);
                break;
            }
        }

        if (num > 0) {
            System.out.println(-1);
        }


    }
}
