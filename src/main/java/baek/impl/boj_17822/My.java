package baek.impl.boj_17822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class My {
    static int n;
    static int m;
    static int t;
    static int [][] board;
    static int x;
    static int d;
    static int k;
    static int number = 1;
    static List<Integer> multiple = new ArrayList<>();
    public static void main(String args []) throws Exception {
        n = input.integer();
        m = input.integer();
        t = input.integer();
        board = new int[2*n+1][2*n+1];
        for(int i=0; i<n; i++){
            int north = input.integer();
            int east = input.integer();
            int south = input.integer();
            int west = input.integer();
            directionInput(north, east, south, west, number);
            number++;
        }
        findMultiple(x);
        if (d == 0) {
            for (Integer integer : multiple) {
                roateClock(integer, k);
            }
        }else {
            for (Integer integer : multiple) {
                roateCounterClock(integer, k);
            }

        }

        for(int i=0; i<2*n+1; i++){
            for(int j=0; j<2*n+1; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void roateClock(int number, int rotateCount){
        for (int i = 0; i < rotateCount; i++) {
            int temp_north = board[n-number][n];
            int temp_south = board[n+number][n];
            int temp_west = board[n][n-number];
            int temp_east = board[n][n+number];
            board[n][n - number] = temp_south;
            board[n + number][n] = temp_east;
            board[n][n + number] = temp_north;
            board[n - number][n] = temp_west;
        }
    }

    static void roateCounterClock(int number, int rotateCount){
        for (int i = 0; i < rotateCount; i++) {
            int temp_north = board[n-number][n];
            int temp_south = board[n+number][n];
            int temp_west = board[n][n-number];
            int temp_east = board[n][n+number];
            board[n][n - number] = temp_north;
            board[n + number][n] = temp_west;
            board[n][n + number] = temp_south;
            board[n - number][n] = temp_east;
        }
    }


    static void directionInput(int north, int east, int south, int west, int number){
        board[n-number][n] = north;
        board[n][n+number] = east;
        board[n+number][n] = south;
        board[n][n-number] = west;
    }

    static void findMultiple(int number){
        for(int i=1; i<=n; i++){
            if(i%n == 0)
                multiple.add(i);
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
    };
}
