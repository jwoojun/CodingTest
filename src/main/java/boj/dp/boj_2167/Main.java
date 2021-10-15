package boj.dp.boj_2167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        init();
        answer();
    }

    private static void answer() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            int x1 = input.integer();
            int y1 = input.integer();
            int x2 = input.integer();
            int y2 = input.integer();
            int sum=dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }


    private static void init() throws Exception {
        n = input.integer();
        m = input.integer();
        board = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        for(int row=1; row<n+1; row++){
            for(int col=1; col<m+1; col++){
                board[row][col] = input.integer();
            }
        }

        k = input.integer();

        for(int row=1; row<n+1; row++){
            for(int col=1; col<m+1; col++){
                dp[row][col] = dp[row][col-1]+dp[row-1][col] -dp[row-1][col-1] + board[row][col];
            }
        }
    }

    static void print() {
        for(int row=0; row<n+1; row++){
            System.out.println();
            for(int col=0; col<m+1; col++){
                System.out.print(dp[row][col]+" ");
            }
        }
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
