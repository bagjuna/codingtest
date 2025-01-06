package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 15681번 트리와 쿼리
 */
public class day5 {
    static ArrayList<Integer> A[];
    static int N;
    static int root;
    // 트리
    static int[] cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        cnt = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            A[num1].add(num2);
            A[num2].add(num1);

        }
        DFS(root, -1);
        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(cnt[num]);
        }


    }

    static void DFS(int x, int prevNode) {
        cnt[x] = 1;
        for (int y : A[x]) {
            if (y == prevNode) continue; // 방문한 노드는 재 방문하지 않는다.
            DFS(y, x);
            cnt[x] += cnt[y];
        }
    }


}
