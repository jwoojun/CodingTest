package boj.dp.boj_11055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] numbers;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        numbers = new int[n];
        dp = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = input.integer();
        }
        for(int i=0; i<n; i++){
            dp[i] = numbers[i];
            for(int j=0; j<i; j++){
                if(numbers[j]<numbers[i] && dp[i]<dp[j]+numbers[i]){
                    dp[i] = dp[j]+numbers[i];
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().orElseThrow());
    }
    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }

    static Input input = new Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
