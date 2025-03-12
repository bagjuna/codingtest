package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1012번 유기농 배추
 */
public class day20 {

    static boolean[][] visited;
    static boolean[][] farm;
    static StringTokenizer st;
    static int colSize;
    static int rowSize;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            farm = new boolean[colSize][rowSize];
            visited = new boolean[colSize][rowSize];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                farm[b][a] = true;
            }
            for (int j = 0; j < colSize; j++) {
                for (int k = 0; k < rowSize; k++) {
                    if (farm[j][k] && !visited[j][k]) {
                        if (bfs(j, k)) {
                            cnt++;
                        }
                    }
                }
            }
            System.out.println(cnt);

        }

    }

    static boolean bfs(int col, int row) {
        if (!canVisit(col, row)) {
            return false;
        }
        boolean isTrue = false;
        visited[col][row] = true;
        if (canVisit(col + 1, row)) {
            isTrue = true;
            bfs(col + 1, row);

        }
        if (canVisit(col, row + 1)) {
            isTrue = true;
            bfs(col, row + 1);
        }

        if (canVisit(col - 1, row)) {
            isTrue = true;
            bfs(col - 1, row);

        }
        if (canVisit(col, row - 1)) {
            isTrue = true;
            bfs(col, row - 1);
        }
        return isTrue;
    }

    static boolean canVisit(int col, int row) {
        if (col < 0 || col >= colSize - 1 || row < 0 || row >= rowSize - 1) {
            return false;
        } else if (visited[col][row]) {
            return false;
        }
        return true;
    }

}
