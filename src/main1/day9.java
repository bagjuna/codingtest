package main1;

import java.util.*;
import java.io.*;

class number {
    int index;
    int value;

    public number(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class day9 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<number> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            queue.add(new number(i + 1, Integer.parseInt(st.nextToken())));

        }
        number first = queue.remove(0);
        System.out.println(first.index);
        int preTemp = first.value;
        int nowTemp = 0;
        
        number temp;
        for (int i = 0; i < N - 1; i++) {

            int div = (preTemp + queue.size()) % queue.size();

            if (div >= 0) {
                temp = queue.remove(div);
            }else {
                temp = queue.remove(queue.size() - div);
            }

            System.out.println(temp.index);
            preTemp = temp.value;
        }

    }
}



//class Solution {
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        int[] nums1 = nums;
//        int[] nums2 = nums;
//
//        for(int i = 0;i<nums.length;i++){
//            int temp = num1[i];
//            for(int j = 0;i<nums.length;k++){
//                if(temp==num2[j]){
//                    System.out.println(temp);
//                }
//            }
//        }
//
//    }
//}