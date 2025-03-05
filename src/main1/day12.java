package main1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 4195번 친구 네트워크
 */
public class day12 {

    static int[] parent = new int[200002];
    static int[] sizes = new int[200002];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            int nodeNum = 1;
            for (int j = 0; j < 200002; j++) {
                sizes[j] = 1;
                parent[j] = j;
            }

            for (int j = 0; j < M; j++) {
                String person1 = sc.next();
                String person2 = sc.next();
                if (!map.containsKey(person1)) {
                    map.put(person1, nodeNum++);
                }
                if (!map.containsKey(person2)) {
                    map.put(person2, nodeNum++);
                }
                union(map.get(person1), map.get(person2));
                int a = find(map.get(person1));
                int b = find(map.get(person2));
                System.out.println(Math.max(sizes[a], sizes[b]));
            }
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) {
                int temp = b;
                b = a;
                a = temp;
            }
            sizes[a] += sizes[b];
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else
            return parent[a] = find(parent[a]);

    }
}
