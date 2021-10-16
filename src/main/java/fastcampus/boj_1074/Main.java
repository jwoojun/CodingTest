package fastcampus.boj_1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,r,c;
    static Point[][] board;
    static  int size;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        r = input.integer();
        c = input.integer();
        size = (int) Math.pow(2, n);
        board = new Point[size][size];
        dfs(size, r, c);
        print();
    }

    static void dfs(int size, int x, int y){
        if(size==1){
            return;
        }
        if(r<size/2 && c<size/2){
            dfs(size/2, r, c);
        }else if(r<size/2 && c>=size/2){
            count+=size*size/4;
        }

    }

    static class Point {
        int x, y;
        int no;

        public Point(int x, int y, int no) {
            this.x = x;
            this.y = y;
            this.no = no;
        }

        @Override
        public String toString() {
            return no +" ";
        }
    }

    static void print(){
        for(int row = 0; row< size; row++){
            System.out.println();
            for(int col = 0; col< size; col++){
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
