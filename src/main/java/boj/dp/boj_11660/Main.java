package boj.dp.boj_11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        board = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        for(int row=1; row<n+1; row++){
            for(int col=1; col<n+1; col++){
                int number = input.integer();
                board[row][col] = number;
                dp[row][col] = dp[row][col-1]+dp[row-1][col]-dp[row-1][col-1]+board[row][col];
            }
        }
        print2();
        System.out.println();
        System.out.println("=================");
        print();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int x1 = input.integer();
            int y1 = input.integer();
            int x2 = input.integer();
            int y2 = input.integer();
            int sum=dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }

    static void print() {
        for (int row = 0; row < n+1; row++) {
            System.out.println();
            for (int col = 0; col < n+1; col++) {
                System.out.print(dp[row][col] + " ");
            }
        }
    }

    static void print2() {
        for (int row = 0; row < n+1; row++) {
            System.out.println();
            for (int col = 0; col < n+1; col++) {
                System.out.print(board[row][col] + " ");
            }
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
