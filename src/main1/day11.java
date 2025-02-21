package main1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Balloon {
    int order;
    int value;

    public Balloon(int order, int value) {
        this.order = order;
        this.value = value;
    }

}

public class day11 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            list.add(new Balloon(i, Integer.parseInt(st.nextToken())));

        }
        Balloon temp = list.removeFirst();
        System.out.println(temp.order);
        while (!list.isEmpty()) {

            if (temp.value > 0) {
                int rotations = (temp.value - 1) % list.size();
                for (int i = 0; i < rotations; i++) {
                    list.add(list.poll());
                }
            } else {
                int rotations = (-temp.value) % list.size();
                for (int i = 0; i < rotations; i++) {
                    list.addFirst(list.pollLast());
                }
            }

            temp = list.poll();
            assert temp != null;
            System.out.println(temp.order);
        }

    }
}
