package boj.dp.boj_1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        init();
        divide(n);
    }
    static void init() throws Exception {
        n = input.integer();
        dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
    }

    static void divide(int n) {
        dp[1] = 0;
        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1]+1;
            if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }
        System.out.println(dp[n]);
        System.exit(0);
    }

    static Input input = new Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
