package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int num = 0; num < N; num++) {

            int K = Integer.parseInt(br.readLine());
            int[] fileSizes = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];
            int[] prefixSum = new int[K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 파일 크기 입력
            for (int i = 1; i <= K; i++) {
                fileSizes[i] = Integer.parseInt(st.nextToken());

                prefixSum[i] = prefixSum[i - 1] + fileSizes[i];
            }

            // 구간 길이 2 이상부터 DP 계산
            for (int length = 2; length <= K; length++) {
                for (int i = 1; i + length - 1 <= K; i++) {
                    int j = i + length - 1;
                    dp[i][j] = Integer.MAX_VALUE;

                    // 구간을 나누는 k를 기준으로 최소 비용 계산
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] +
                                prefixSum[j] - prefixSum[i - 1]);
                    }



                }
            }

            // 최종 결과 출력
            System.out.println(dp[1][K]);
        }

    }


}
