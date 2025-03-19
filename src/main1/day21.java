package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class day21 {
    //    static int tree[] = new int[100000];
    static int tree[];
    //    static int tree_distance[] = new int[100000];
    static int tree_distance[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[N];
        tree_distance = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tree);


    }

    // 최대공약수를 구하는 함수 (유클리드 호제법)
    private static int Euclidean(int a, int b) {
        int r = a % b;
        if (r == 0)
            return b;
        else
            return Euclidean(b, r);
    }

}
