package boj.impl.boj_12904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    static  int n;
    // 북동남서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int answer = Integer.MIN_VALUE;
    static Block[][] board;
    static int[][] board_copy;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        board = new Block[n][n];
        board_copy= new int[n][n];
        visited = new boolean[n][n];
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                int value = input.integer();
                board[row][col] = new Block(row, col, value, false);
                if(board[row][col].value != 0) {
                    visited[row][col] = true;
                }
            }
        }

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(board[row][col].value != 0) {
                    board_copy[row][col] = board[row][col].value;
                }
            }
        }

        board[0][0].value = 9;
        System.out.println();
        print();
        System.out.println();
        System.out.println("=========================");
        print2();
    }

    static class Block {
        int x, y;
        int value;
        boolean merge;

        public Block(int x, int y, int value, boolean merge) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.merge = merge;
        }

        @Override
        public String toString() {
            return value + "";
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

    static void print() {
        for(int row=0; row<n; row++){
            System.out.println();
            for(int col=0; col<n; col++){
                System.out.print(board_copy[row][col]+" ");
            }
        }
    }

    static void print2() {
        for(int row=0; row<n; row++){
            System.out.println();
            for(int col=0; col<n; col++){
                System.out.print(board[row][col].value+" ");
            }
        }
    }

}
