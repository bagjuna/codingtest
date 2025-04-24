package bfs_dfs.bsilver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q_16953_bfs {
    static int start;
    static int end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        start = sc.nextInt();
        end = sc.nextInt();

        Queue<Node> list = new LinkedList<>();
        list.add(new Node(start, 1));

        while (!list.isEmpty()) {
            Node polled = list.poll();
            if (polled.value == end) {
                System.out.println(polled.cnt);
                return;
            }
            if (polled.value > end) {
                continue;
            }
            list.add(new Node(polled.value * 2, polled.cnt + 1));
            list.add(new Node(polled.value * 10 + 1, polled.cnt + 1));

        }

        System.out.println(-1);


    }

    static class Node{
        long value;
        int cnt;

        public Node(long value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }


}
