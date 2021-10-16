package boj.dp.boj_1965;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] numbers;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        init();
        inputBox();
    }

    private static void init() throws Exception {
        n = input.integer();
        numbers = new int[n];
        dp = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = input.integer();
        }
    }


    static void inputBox() {
        int answer = 0;
        for (int i = 0; i<n; i++) {
            dp[i] = 1;
            for (int j = 0; j<i; j++) {
                if (numbers[i] > numbers[j] && dp[j]<dp[i]+1) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    System.out.println("i="+i+", dp[j]="+dp[j]+", dp[i]="+dp[i]);
                }
            }
            answer = Math.max(dp[i], answer);
        }

        Arrays.stream(dp).forEach(element->sb.append(element).append(" "));
        System.out.println(answer);
        System.out.println(sb);
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
