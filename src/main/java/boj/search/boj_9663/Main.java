package boj.search.boj_9663;

import java.util.StringTokenizer;

public class Main {

    static int n;
    static int result = 0;
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args){
        n = 30;
        board = new int[n][n];
        visited = new boolean[n][n];
        System.out.println(result);
    }

    static void initBoard(){
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                visited[row][col] = false;
            }
        }
    }

    static boolean check(int x, int y, int value){
        int temp_x = x;
        int temp_y = y;
        for(int num=0; num<n ; num++){
            if(board[x][num] == value) return false;
            if(board[num][y] == value) return false;
        }

        while(moveable(temp_x, temp_y)){
            temp_x--;
            temp_y--;
            if(board[temp_x][temp_y] == value) return false;
        }
        temp_x = x;
        temp_y = y;

        while(moveable(temp_x, temp_y)){
            x++;
            y--;
            if(board[x][y] == value) return false;
        }
        return true;
    }

    static boolean moveable(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }
}
