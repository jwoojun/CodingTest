package boj.dp.boj_1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        board = new int[n+1][n+1];
        dp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                board[i][j] = input.integer();
            }
        }

        dp[0][0] = board[0][0];
        for(int i=0; i<n-1; i++){
            dp[i+1][0] = dp[i][0] + board[i+1][0];
            dp[i+1][i+1] = dp[i][i] + board[i+1][i+1];
        }

        for(int i=2; i<n; i++){
            for(int j=1; j<i+1; j++){
                dp[i][j] = Math.max(dp[i-1][j-1]+board[i][j], dp[i-1][j]+board[i][j]);
            }
        }
        System.out.println(getMaxValue(dp));
    }

    static int getMaxValue(int[][] array){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(array[i][j]>max){
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    static void print(){
        for(int row=0; row<n+1; row++){
            System.out.println();
            for(int col=0; col<n+1; col++){
                System.out.print(board[row][col]+" ");
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
