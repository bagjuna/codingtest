package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  1967번 트리의 지름
 */
public class day19 {
    static int N;
    static List<Node>[] nodes;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }


        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodes[start].add(new Node(end,value));
            nodes[end].add(new Node(start,value));
        }


        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i,0);
        }
        System.out.println(max);

    }

    private static void dfs(int num, int value) {
        for (Node node : nodes[num]) {
            if (!visited[node.link]) {
                visited[node.link] = true;
                dfs(node.link, value + node.value);
            }
        }
        max = Math.max(max, value);
    }


    static class Node {
        public int link;
        public int value;

        public Node(int link, int value) {
            this.link = link;
            this.value = value;
        }
    }

}
