package boj.search.boj_14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://regularmember.tistory.com/91?category=747444
public class Main {
    static int n;
    static boolean [] selected;
    static int answer = Integer.MAX_VALUE-100;
    static int[][] board;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        selected = new boolean[n];
        board = new int[n][n];

        init();
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int count) {
        if(count == n/2){
            int start = 0;
            int link = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(selected[i] && selected[j]){
                        start += board[i][j];
                    }else if(!selected[i] && !selected[j]){
                        link += board[i][j];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(start-link));
            return;
        }

        for(int i=0; i<n; i++){
            if(selected[i]) continue;
            selected[i] = true;
            dfs(i+1, count+1);
            selected[i] = false;
        }
    }

    static void init() throws Exception {
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                board[row][col] = input.integer();
            }
        }
    }


    static void print(int n, int m){
        for(int row=0; row<n; row++){
            System.out.println();
            for(int col=0; col<n; col++){
                System.out.print(board[row][col]+" ");
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
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public char[] nToCharArray() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken().toCharArray();
        }
    }
}
