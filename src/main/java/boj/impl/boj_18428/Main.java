package boj.impl.boj_18428;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Point[][] board;
    static List<Point> blocks = new ArrayList<>();
    static List<Point> teachers = new ArrayList<>();
    static boolean [][] visited ;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        board = new Point[n][n];
        visited = new boolean[n][n];

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                String s = input.next();
                if(s.equals("T")){
                    teachers.add(new Point(row, col, s, false));
                    board[row][col] = new Point(row, col, s, false);
                    visited[row][col] = true;
                }else if(s.equals("S")){
                    board[row][col] = new Point(row, col, s, false);
                    visited[row][col] = true;
                }else if(s.equals("X")){
                    board[row][col] = new Point(row, col, s, false);
                    blocks.add(new Point(row, col, s, false));
                }
            }
        }

        int blockCount = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(!visited[row][col] && blockCount<3){
                    visited[row][col] = true;
                    board[row][col].block = true;
                    blockCount+=1;
                    dfs(blockCount);
                    board[row][col].block = false;
                    visited[row][col] = false;
                    blockCount--;
                }
            }
        }
        System.out.println("NO");
    }

    private static void dfs(int count) {
        if(count<3){
            for(int row=0; row<n; row++){
                for(int col=0; col<n; col++){
                    if(!visited[row][col]){
                        visited[row][col] = true;
                        board[row][col].block = true;
                        dfs(count+1);
                        visited[row][col] = false;
                        board[row][col].block = false;
                    }
                }
            }
        }
        else if (count == 3) {
            if (possible()) {
                System.out.println("YES");
                System.exit(0);
            }
        }
    }

    static void print(){
        for(int row=0; row<n; row++){
            System.out.println();
            for(int col=0; col<n; col++){
                System.out.print(visited[row][col]+" ");
            }
        }
    }

    static void print2(){
        for(int row=0; row<n; row++){
            System.out.println();
            for(int col=0; col<n; col++){
                System.out.print(board[row][col]+" ");
            }
        }
    }

    /**
     *  학생을 발견하게 되면 false를 반환.
     *  즉, 끝까지 발견하지 못 했다는 것은(true) 이 배치가 가능하다는 말.
     * */
    static boolean possible(){
        for (Point teacher : teachers) {
            for (int dir = 0; dir < 4; dir++) {
                if (findStudent(teacher.x, teacher.y, dir)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean findStudent(int x, int y, int direction){
        if (direction == 0) {
            while (x >= 0) {
                if (board[x][y].job.equals("S")) return true;
                if (board[x][y].block) return false;;
                x--;
            }
        } else if (direction == 1) {
            while (y >= 0) {
                if (board[x][y].job.equals("S")) return true;
                if (board[x][y].block) return false;;
                y--;
            }
        }
        else if (direction == 2) {
            while (x < n) {
                if (board[x][y].job.equals("S")) return true;
                if (board[x][y].block) return false;;
                x++;
            }
        } else if(direction==3){
            while (y < n) {
                if (board[x][y].job.equals("S")) return true;
                if (board[x][y].block) return false;
                y++;
            }
        }
        return false;
    }

    static class Point{
        int x;
        int y;
        String job;
        boolean block;

        public Point(int x, int y, String job, boolean block) {
            this.x = x;
            this.y = y;
            this.job = job;
            this.block = block;
        }

        @Override
        public String toString() {
            return "Point{block=" + block +
                    '}';
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
    }
}
