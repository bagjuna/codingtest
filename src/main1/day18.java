package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 11725번
 * 트리의 부모 찾기
 */
public class day18 {
    static int[] parent;
    static List<Integer> numList[];

    static boolean[] visited ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        numList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            numList[i] = new ArrayList<>();
            parent[i] = i;
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            numList[a].add(b);
            numList[b].add(a);
        }

        dfs(1);
        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }

    }

    private static void dfs(int node) {
        for (int i : numList[node]) {
            if (!visited[i]) {
                visited[i] = true;
                parent[i] = node;
                dfs(i);
            }
        }
    }
}
