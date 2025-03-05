package main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explosion = br.readLine();
        int explosionLen = explosion.length();

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= explosionLen) {
                boolean flag = true;
                for (int j = 0; j < explosionLen; j++) {
                    if (sb.charAt(sb.length() - explosionLen + j) != explosion.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sb.delete(sb.length() - explosionLen, sb.length());
                }
            }
        }
        
        System.out.println(sb.isEmpty() ? "FRULA" : sb.toString());
    }
}