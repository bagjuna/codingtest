package bfs_dfs.bsilver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2178 {

    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static int wSize;
    static int hSize;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        hSize = Integer.parseInt(st.nextToken());
        wSize = Integer.parseInt(st.nextToken());
        map = new char[hSize][wSize];
        visited = new boolean[hSize][wSize];

        for (int i = 0; i < hSize; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(dfs(0, 0, 1));

    }


    static int dfs(int h, int w, int cnt) {

        if (cnt >= minValue) return minValue;

        if (h == hSize - 1 && w == wSize - 1) {
            minValue = Math.min(minValue, cnt);
            return minValue;
        }

        visited[h][w] = true;

        for (int i = 0; i < 4; i++) {
            int tempH = h + dy[i];
            int tempW = w + dx[i];
            if (tempW >= 0 && tempW < wSize && tempH >= 0 && tempH < hSize) {
                if (map[tempH][tempW] == '1' && !visited[tempH][tempW]) {
                    dfs(tempH, tempW, cnt + 1);
                }
            }
        }

        visited[h][w] = false; // 백트래킹

        return minValue;
    }

}
