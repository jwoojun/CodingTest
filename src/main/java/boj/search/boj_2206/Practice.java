package boj.search.boj_2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice {
    static int n;
    static int m;
    static int[][] board;
    static int[][][] visited = new int[2][n][m];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        board = new int[n][m];
        visited = new int[2][n][m];
        for(int row=0; row<n; row++){
            char[] temp = input.next().toCharArray();
            for(int col=0; col<m; col++){
                board[row][col] = temp[col]-'0';
            }
        }
        init();
        bfs();
        System.out.println(answer(n,m));
    }

    static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0][0] = 1;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int breakCount = point.count;
            for(int i=0; i<4; i++){
                int next_x = point.x+dx[i];
                int next_y = point.y+dy[i];
                if(isPossible(next_x, next_y)){
                    if(!meetWall(next_x, next_y)){
                        visited[breakCount][next_x][next_y] = visited[breakCount][x][y] +1;
                        queue.add(new Point(next_x, next_y, breakCount));
                    }else if(meetWall(next_x, next_y) && breakCount == 0 && visited[0][next_x][next_y] == -1){
                        visited[breakCount+1][next_x][next_y] = visited[breakCount][x][y] +1;
                        queue.add(new Point(next_x, next_y, breakCount+1));
                    }
                }
            }
        }
    }

    static boolean isPossible(int x, int y){
        return x>=0 && x< n && y>=0 && y<m;
    }

    static void init() {
        for(int axis=0; axis<2; axis++){
            for(int row=0; row<n; row++){
                for(int col=0; col<m; col++){
                    visited[axis][row][col] = -1;
                }
            }
        }
    }

    static boolean meetWall(int x, int y){
        return board[x][y] == 1;
    }

    static int answer(int n, int m){
        if(visited[0][n-1][m-1] == -1 && visited[1][n-1][m-1] == -1){
            return -1;
        }
        if(visited[0][n-1][m-1] != -1 && visited[1][n-1][m-1] != -1){
            return Math.min(visited[0][n-1][m-1], visited[1][n-1][m-1]);
        }
        return Math.max(visited[0][n-1][m-1], visited[1][n-1][m-1]);
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    }

    static void print(){
        for(int row=0; row<n; row++){
            System.out.println();
            for(int col=0; col<m; col++){
                System.out.print(board[row][col]+" ");
            }
        }
    }

    static void print2(){
        for (int axis = 0; axis < 2; axis++){
            System.out.println("===========================");
            for (int row = 0; row < n; row++) {
                System.out.println();
                for (int col = 0; col < m; col++) {
                    System.out.print(visited[axis][row][col] + " ");
                }
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

    }



}
