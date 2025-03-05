package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                cnt++;
                break;
            }
            int max = 0;
            for (int j = i + 1; j < N; j++) {
                if (max <= arr[j]) {
                    max = arr[j];
                    System.out.print("num1: " + arr[i]);
                    System.out.println(", num2: " + arr[j]);
                    if (arr[i] > arr[j]) {
                        cnt++;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
