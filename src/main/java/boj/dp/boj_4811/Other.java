package boj.dp.boj_4811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://lotuslee.tistory.com/117
public class Other {
    public static void main(String[] args) throws Exception {
        while (true) {
            int n = input.integer();
            if(n==0){
                break;
            }
            long[][][] dp = new long[2*n+1][2*n+1][n+1];
            dp[1][1][n-1] = 1;
            for(int t=2; t<=2*n; t++){
                for(int half=0; half<=2*n; half++){
                    for(int one=0; one<=n; one++){
                        if(half+1<=2*n){
                            dp[t][half][one] += dp[t-1][half+1][one];
                        }
                        if(half-1>=0 && one+1 <= n){
                            dp[t][half][one] += dp[t-1][half-1][one+1];
                        }
                    }
                }
            }
            long sum = 0;
            for(int h = 0; h<=2*n; h++){
                for(int w=0; w<=n ; w++){
                    sum += dp[2*n][h][w];
                }
            }
            System.out.println(sum);
        }
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
