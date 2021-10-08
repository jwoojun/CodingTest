package boj.impl.boj_17144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Practice {
    static int r;
    static int c;
    static int t;
    static int[] dx= {1, -1,0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] board;
    static List<Point> cleaner = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        r = input.nInt();
        c = input.nInt();
        t = input.nInt();
        board = new int[r][c];
        for(int row=0; row<r; row++){
            for(int column=0; column<c; column++){
                board[row][column] = input.nInt();
                if(board[row][column]==-1){
                    cleaner.add(new Point(row, column));
                }
            }
        }
        print(board);
        System.out.println("==================origin");
        while (t-- > 0) {
            spread();
            print(board);
            moveDust();
        }

        int answer= 0;
        for(int row=0; row<r; row++){
            for(int column=0; column<c; column++){
                if(board[row][column]>0){
                    answer+= board[row][column];
                }
            }
        }
        System.out.println(answer);
    }
    static void print(int[][] board){
        for(int i=0; i<r; i++){
            System.out.println();
            for(int j=0; j<c; j++){
                System.out.print(board[i][j]+" ");
            }
        }
    }

    static void moveDust(){
        int [][] temp = board.clone();
        Point upperCleaner = cleaner.get(0);
        Point underCleaner = cleaner.get(1);
        board[upperCleaner.row][upperCleaner.column]=0;


        for(int number = upperCleaner.row; number>=1 ; number--){
            temp[number][0] = board[number-1][0];
        }

        for(int number=0; number<c-1; number++){
            temp[0][number] = board[0][number+1];
        }

        for(int number = 0; number<upperCleaner.row; number++){
            temp[number][c-1] = board[number+1][c-1];
        }

        for(int number = c-1; number>=1; number --){
            temp[upperCleaner.row][number] = board[upperCleaner.row][number-1];
        }


        ////--------
        board[underCleaner.row][underCleaner.column]=0;
        for(int number = r-1; number>underCleaner.row+1; number--){
            temp[number][0] = board[number-1][0];
        }

        for(int number= 0; number<c-1; number++){
            temp[r-1][number] = board[r-1][number+1];
        }


        for(int number = r-1; number>=underCleaner.row+1; number--){
            temp[number][c-1] = board[number-1][c-1];
        }

        for(int number = c-1; number>=1; number--){
            temp[underCleaner.row][number] = board[underCleaner.row][number-1];
        }
        print(temp);
        System.out.println("============================");
        /////////////////////////////////////////

        for(Point point : cleaner){
            temp[point.row][point.column] = -1;
        }

        board = temp;

    }

    static void spread(){
        int[][] temp = new int[r][c];
        for(int row=0; row<r; row++){
            for(int column=0; column<c; column++){
                if(board[row][column]>0){
                    int count = 0 ;
                    int minus = board[row][column]/5;
                    for(int number=0; number<4; number++){
                        int next_x = row + dx[number];
                        int next_y = column + dy[number];
                        if(isPossible(next_x, next_y)){
                            count+=1;
                            temp[next_x][next_y] += minus;
                        }
                    }
                    board[row][column] -= count*minus;
                }
            }

        }
        for(int row=0; row<r; row++){
            for(int column=0; column<c; column++){
                if(board[row][column]>0){
                    temp[row][column] += board[row][column];
                }
            }
        }
        for(Point point : cleaner){
            temp[point.row][point.column] = -1;
        }
        board = temp;
    }

    static void operate(int x, int y, int[][] temp){

    }

    static boolean isPossible(int x, int y){
        return x>=0 && x<r && y>=0 && y<c && board[x][y] != -1;
    }
    static Main.Input input = new Main.Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int nInt() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
    static class Point{
        int row;
        int column;

        public Point(int x, int y) {
            this.row = x;
            this.column = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + row +
                    ", y=" + column +
                    '}';
        }

    }
}
