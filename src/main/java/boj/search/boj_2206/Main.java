package boj.search.boj_2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
        for(int row=0; row<n; row++){
            for(int column=0; column<m; column++){
                board[row][column] = input.integer();
            }
        }

    }

    static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0][0] = 1;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int number=0; number<4; number++){
                int next_x = point.x + dx[number];
                int next_y = point.y + dy[number];
                if(isPossible(next_x, next_y)){
                    if(board[next_x][next_y] == 0 || visited[point.kind][next_x][next_y]==-1){
                        visited[point.kind][next_x][next_y] = visited[point.kind][point.x][point.y]+1;
                        queue.add(new Point(next_x, next_y, point.kind));
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
                for(int column=0; column<m; column++){
                    visited[axis][row][column] = -1;
                }
            }
        }
    }
    static class Point {
        int x;
        int y;
        int kind;

        public Point(int x, int y, int kind) {
            this.x = x;
            this.y = y;
            this.kind = kind;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + kind +
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
    }
}
