package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 20040번 사이클 게임
 */
public class day17 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parent = new int[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (union(u, v)) {
                cnt = i;
                break;
            }
        }
         System.out.println(cnt);
    }


    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return true;
        else {
            parent[u] = v;
            return false;
        }
    }

    private static int find(int u) {
        if (parent[u] == u) return u;
        else return parent[u] = find(parent[u]);
    }
}
