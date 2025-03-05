package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 17299번 오등큰수
 */

public class day16 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 문제 조건에 따라 수의 범위가 1부터 1,000,000까지 라고 가정
        int[] freq = new int[1000001];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            freq[arr[i]] += 1;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && freq[arr[stack.peek()]] < freq[arr[i]]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);



    }
}
