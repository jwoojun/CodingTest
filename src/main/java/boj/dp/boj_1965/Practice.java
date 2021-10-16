package boj.dp.boj_1965;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice {
    static int n;
    static int[] numbers;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        init();
        for(int i=1; i<n+1; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(numbers[j]<numbers[i] && dp[j]<dp[i]+1){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        System.out.println(getMax());
    }

    static void init() throws Exception {
        n = input.integer();
        numbers = new int[n+1];
        dp = new int[n+1];
        for(int i=0; i<n; i++){
            numbers[i+1] = input.integer();
        }
    }

    static int getMax(){
        return Arrays.stream(dp).max().orElseThrow();
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
