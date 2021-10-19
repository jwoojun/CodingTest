package boj.dp.boj_11722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(numbers[i]<numbers[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().orElseThrow());
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
