package boj.impl.boj_2174;

public class Practice {
    static int x = 6;
    static int y = 9;
    static int[][] board = new int[x][y];
    public static void main(String[] args){
        board[x-1][0] = 1;
        pirnt();

    }
    static void pirnt(){
        for(int row=0; row<x; row++){
            System.out.println();
            for(int col=0; col<y; col++){
                System.out.print(board[row][col]+" ");
            }
        }
    }
}


