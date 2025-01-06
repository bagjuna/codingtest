/*

import java.util.*;

*/



/**
 *
 *//*

public class Main {
    static boolean[] visited;
    static ArrayList<Integer> A[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1];
        DFS(start);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(start);

    }


    private static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            System.out.print(now_node + " ");
            for(int i : A[now_node]){
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void DFS(int Node){
        System.out.print(Node + " ");
        visited[Node] = true;
        for(int i : A[Node]){
            if (!visited[i]) {
                DFS(i);
            }
        }

    }


}*/


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Main {
    static int N, R, Q;
    static int[] qArr,
            cnt;
    static ArrayList<Integer>[] tree;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        cnt = new int[N + 1];

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 문제에서의 그래프는 가중치 없는 무방향 그래프이다.
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }

        qArr = new int[Q];
        for (int i = 0; i < Q; i++)
            qArr[i] = Integer.parseInt(br.readLine());
        solution();
    }

    static void solution() {
        DFS(R, -1); // 시작점은 임의의 루트 R로 한다.
        for (int x : qArr) sb.append(cnt[x]).append("\n");
        System.out.println(sb.toString());
    }

    static void DFS(int x, int prevNode) {
        cnt[x] = 1; // 루트 또한 간선의 개수에 포함된다.

        for (int y : tree[x]) {
            if (y == prevNode) continue; // 방문한 노드는 재 방문하지 않는다.
            DFS(y, x);
            cnt[x] += cnt[y]; // 상위 노드에 간선의 개수를 누적한다.
        }
    }
}