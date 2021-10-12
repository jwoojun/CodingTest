package boj.search.boj_10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Point[][] board;
    static Point[][] temp;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0,0, 1,-1};
    static int n;
    static int colorWeakness = 0;
    static int normarl = 0;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        board = new Point[n][n];
        temp = new Point[n][n];
        visited = new boolean[n][n];

        init();

        temp = copyArray(board, n, n);
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(!visited[row][col]){
                    bfs(row, col);
                    normarl++;
                }
            }
        }

        temp = copyArray(board, n, n);
        changeColor();
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(!visited[row][col]){
                    bfs(row, col);
                    colorWeakness++;
                }
            }
        }
        System.out.print(normarl+" "+colorWeakness);
    }

    private static void init() throws Exception {
        for(int row=0; row<n; row++){
            char[] temp = input.nToCharArray();
            for(int col=0; col<n; col++){
                board[row][col] = new Point(row, col, String.valueOf(temp[col]));
            }
        }
    }

    static void changeColor(){
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                Point point = board[row][col];
                if(point.color.equals("G")){
                    temp[row][col] = new Point(point.x, point.y, "R");
                }else {
                    temp[row][col] = new Point(point.x, point.y, point.color);
                }
            }
        }
    }

    private static void bfs(int row, int col) {
        visited[row][col] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col, temp[row][col].color));
        while (!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int next_x = point.x + dx[i];
                int next_y = point.y + dy[i];
                if (moveable(next_x, next_y) && !visited[next_x][next_y]
                        && hasSameColor(point.x, point.y, next_x, next_y)) {
                    visited[next_x][next_y] = true;
                    queue.add(new Point(next_x, next_y, temp[next_x][next_y].color));
                }
            }
        }
    }

    static boolean hasSameColor(int x, int y, int x2, int y2){
        return temp[x][y].color.equals(temp[x2][y2].color);
    }

    static boolean moveable(int x, int y){
        return x>=0 && x< n && y>=0 && y<n;
    }

    static Point[][] copyArray(Point[][] original, int n, int m){
        Point [][] array = new Point[n][m];
        for(int row=0;row<n; row ++){
            for(int col=0; col<m; col++){
                array[row][col] = original[row][col];
            }
        }
        initVisited(n, m);
        return array;
    }

    static void initVisited(int n, int m) {
        for(int row=0;row<n; row ++){
            for(int col=0; col<m; col++){
                visited[row][col] = false;
            }
        }
    }

    static class Point{
        int x;
        int y;
        String color;

        public Point(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
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