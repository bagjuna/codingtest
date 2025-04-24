package bfs_dfs.bsilver;

import java.util.*;

public class q_2606 {
    static boolean[] visited;
    static ArrayList<Edge> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int N = sc.nextInt();
        visited = new boolean[V + 1];
        queue = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            queue.add(new Edge(a, b));
            queue.add(new Edge(b, a));
        }

        dfs(1);
        int cnt = 0;
        for (int i = 1; i < V + 1; i++) {
            if (visited[i]) {
                cnt++;
            }
        }

        System.out.println(cnt - 1);
    }


    private static void dfs(int start) {
        if (visited[start]) return;
        visited[start] = true;
        for (Edge edge : queue) {
            if (start == edge.start) {
                dfs(edge.end);
            }
        }

    }

    static class Edge {
        int start;
        int end;

        Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
}
