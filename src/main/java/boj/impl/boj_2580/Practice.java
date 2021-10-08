package boj.impl.boj_2580;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {
    static int [][] board = new int[9][9];
    static int [][] answer = new int[9][9];

    public static void main(String[] args) throws Exception {
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                board[row][col] = input.integer();
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for(int row=0; row<9; row++){
            sb.append(answer[row][0]);
            for(int col=1; col<9;col++){
                sb.append(" ").append(answer[row][col]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int index) {
        if (index == 81) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    answer[row][col] = board[row][col];
                }
            }
            return;
        }
        int x = index/9;
        int y = index%9;
        if(board[x][y]>0){
            dfs(index+1);
        }else{
            for(int val=1; val<=9; val++){
                if(answer[0][0] == 0 && check(x, y, val)){
                    board[x][y] = val;
                    dfs(index+1);
                    board[x][y] = 0;
                }
            }
        }



    }


    static boolean check(int x, int y, int val){
        for(int i=0; i<9; i++){
            if(board[x][i] == val) return false;
            if(board[i][y] == val) return false;
        }

        int r = (x/3) * 3;
        int c = (y/3) * 3;

        for(int row=r; row<r+3; row++){
            for(int col=c; col<c+3; col++){
                if(board[row][col] == val){
                    return false;
                }
            }
        }
        return true;
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
