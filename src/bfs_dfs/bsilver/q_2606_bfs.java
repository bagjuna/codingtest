package bfs_dfs.bsilver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class q_2606_bfs {
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int N = sc.nextInt();
        visited = new boolean[V + 1];
        ArrayList<Integer>[] graph = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        int cnt = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            Integer start = queue.poll();
            for (int end : graph[start]) {
                if (!visited[end]) {
                    queue.add(end);
                    visited[end] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }


}
