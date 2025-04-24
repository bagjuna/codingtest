package bfs_dfs.bsilver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q_2178_bfs {

    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int wSize;
    static int hSize;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        hSize = Integer.parseInt(st.nextToken());
        wSize = Integer.parseInt(st.nextToken());
        map = new int[hSize][wSize];
        visited = new boolean[hSize][wSize];

        for (int i = 0; i < hSize; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < wSize; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(dfs(0, 0));

    }


    static int dfs(int h, int w) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{h, w});
        visited[h][w] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int preH = cur[0];
            int preW = cur[1];

            for (int i = 0; i < 4; i++) {
                int tempH = preH + dy[i];
                int tempW = preW + dx[i];

                if (tempW < 0 || tempW >= wSize || tempH < 0 || tempH >= hSize) {
                    continue;
                }
                    if (map[tempH][tempW] == 1 && !visited[tempH][tempW]) {
                        map[tempH][tempW] = map[preH][preW] + 1;
                        visited[tempH][tempW] = true;
                        q.add(new int[]{tempH, tempW});
                    }

            }

        }

        return map[hSize - 1][wSize - 1];
    }

}
