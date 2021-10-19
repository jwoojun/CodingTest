package boj.dp.boj_1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m ;
    static int[][] board;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        m = input.integer();
        n = input.integer();
        board = new int[m][n];
        dp = new int[m][n];
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                board[row][col] = input.integer();
                dp[row][col] = -1;
            }
        }
        System.out.println(dfs(0,0));
        print();
    }

    static int dfs(int x, int y){
        if( x == m-1 && y == n-1) return 1;
        if(dp[x][y] != -1) return dp[x][y];
        else {
            dp[x][y] = 0;
            for(int dir=0; dir<4; dir++){
                int next_x = x + dx[dir];
                int next_y = y + dy[dir];
                if(!moveable(next_x, next_y)) continue;
                if(board[x][y] > board[next_x][next_y]){
                    dp[x][y] += dfs(next_x, next_y);
                }
            }
        }
        return dp[x][y];
    }

    static boolean moveable(int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }

    static void print(){
        for(int row=0; row<m; row++){
            System.out.println();
            for(int col=0; col<n; col++){
                System.out.print(dp[row][col]+" ");
            }
        }
        System.out.println();
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

