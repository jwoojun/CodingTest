package boj.dp.boj_2294;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice {
    static int n;
    static int k;
    static int[] coins;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        init();
        for(int coin : coins){
            for(int j = coin; j<k+1; j++){
                dp[j] = Math.min(dp[j], dp[j-coin]+1);
            }
        }
        System.out.println(dp[k]==10000001 ? -1 : dp[k]);
    }

    private static void init() throws Exception {
        n = input.integer();
        k = input.integer();
        coins = new int[n];
        dp = new int[k+1];

        for(int i=0; i<n; i++){
            int number = input.integer();
            coins[i] = number;
        }
        Arrays.fill(dp, 10000001);
        dp[0] = 0;
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


