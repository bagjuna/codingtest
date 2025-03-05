package main1;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 9935번 문자열 폭발
 */
public class day14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer(br.readLine());
        String word = br.readLine();
        int length = word.length();
        for (int i = 0; i < sb.length() - length + 1; i++) {
            if (sb.substring(i, i + length).equals(word)) {
                sb.delete(i, i + length);
                i = 0;
            }
        }
        if (sb.toString().isEmpty() || sb.toString().equals(word)) {
            System.out.println("FRULA");
        } else System.out.println(sb);


    }
}
