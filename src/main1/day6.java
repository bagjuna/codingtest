package main1;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 16139번 인간-컴퓨터 상호작용
 */
public class day6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Character, int[]> map = new HashMap<>();

    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int strLength = str.length();
        int N = Integer.parseInt(br.readLine());
        char[] charArray = str.toCharArray();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            if (!map.containsKey(ch)) {
                int temp = 0;
                int[] arr = new int[strLength];
                for (int j = 0; j < strLength; j++) {
                    if (ch == charArray[j]) {
                        temp++;
                    }
                    arr[j] = temp;
                }
                map.put(ch, arr);
                
            }

            int[] arr = map.get(ch);
            int result = arr[i2] - (i1 == 0 ? 0 : arr[i1 - 1]);
            bw.append(result + "\n");
        }

        bw.flush();

    }
}
