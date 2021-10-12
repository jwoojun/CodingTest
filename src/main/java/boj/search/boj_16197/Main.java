package boj.search.boj_16197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int n;
    static int m;
    static int[] dx= {1, -1, 0, 0};
    static int[] dy= {0, 0, 1, -1};
    static String[][] board;
    static List<Coin> circle = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        init();
        Queue<Coin> queue = new LinkedList<>();
        for (Coin point : circle) {
            queue.add(new Coin(point.x, point.y, 0));
        }
        while (!queue.isEmpty()){
            Coin coinA = queue.poll();
            Coin coinB = queue.poll();
            over10(coinA.count);
            for(int i=0; i<4; i++){
                int coinA_next_x = coinA.x+dx[i];
                int coinA_next_y = coinA.y+dy[i];
                int coinB_next_x = coinB.x+dx[i];
                int coinB_next_y = coinB.y+dy[i];
                if(moveable(coinA_next_x, coinA_next_y) && moveable(coinB_next_x, coinB_next_y)){
                    if(board[coinA_next_x][coinA_next_y].equals("#")){
                        coinA_next_x = coinA.x;
                        coinA_next_y = coinA.y;
                    }
                    if(board[coinB_next_x][coinB_next_y].equals("#")){
                        coinB_next_x = coinB.x;
                        coinB_next_y = coinB.y;
                    }
                    queue.add(new Coin(coinA_next_x, coinA_next_y, coinA.count+1));
                    queue.add(new Coin(coinB_next_x, coinB_next_y, coinA.count+1));
                } else if(moveable(coinA_next_x, coinA_next_y)){
                    System.out.println(coinA.count+1);
                    System.exit(0);
                } else if(moveable(coinB_next_x, coinB_next_y)){
                    System.out.println(coinA.count+1);
                    System.exit(0);
                }else{
                    continue;
                }
            }
        }
    }

    static void over10(int count){
        if(count>=10){
            System.out.println(-1);
            System.exit(0);
        }
    }
    static boolean moveable(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
    static void init() throws Exception {
        n = input.integer();
        m = input.integer();
        board = new String[n][m];
        for(int row=0; row<n; row++){
            char[] temp = input.nToCharArray();
            for(int col=0; col<m; col++){
                board[row][col] = String.valueOf(temp[col]);
                if(board[row][col].equals("o")){
                    circle.add(new Coin(row, col, 0));
                }
            }
        }
    }

    static class Coin {
        int x;
        int y;
        int count;

        public Coin(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
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
