package boj.graph.dijak.boj_1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {
    static int n, m, x;
    static int[][] board;
    static int INF = 100_000;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        x = input.integer();
        board = new int[n+1][n+1];
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(i==j) {
                    board[i][j] =0;
                }else {
                    board[i][j] = INF;
                }
            }
        }
        for(int i=0; i<m; i++){
            int from = input.integer();
            int to = input.integer();
            int distance = input.integer();
            board[from][to] = distance;
        }
        for(int k=1; k<n+1; k++) {
            for(int i=1; i<n+1; i++) {
                for(int j=1; j<n+1; j++) {
                    if(board[i][k] + board[k][j] < board[i][j]) {
                        board[i][j] = board[i][k] + board[k][j];
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++) {
            int dis = board[i][x] + board[x][i];
            if(dis >res ) {
                res = dis;
            }
        }
        System.out.println(res);
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
