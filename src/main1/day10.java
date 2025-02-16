package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

/**
 * 1753번
 * 최단경로
 */
public class day10 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V + 1];  // 방문된 노드
        int[] result = new int[V + 1];          // 최종 결과
        List<Node>[] list = new List[V + 1];    //

        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        result[S] = 0;
        queue.add(new Node(S, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!visited[now.end]) visited[now.end] = true;
            for (int i = 0; i < list[now.end].size(); i++) {
                Node next = list[now.end].get(i);
                if (!visited[next.end] && now.weight + next.weight < result[next.end]) {

                    result[next.end] = now.weight + next.weight;

                    queue.add(new Node(next.end, result[next.end]));
                }
            }
        }

        for(int i = 1; i<=V; i++) {
            if(result[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(result[i]);
        }

    }
}
