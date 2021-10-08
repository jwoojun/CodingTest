package boj.impl.boj_2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static int[][][] visit;
    static int[] dx = {1, -1,0 ,0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        System.out.println(n);
        System.out.println(m);
        board = new int[n][m];
        visit = new int[2][n][m];
        for(int row=0; row<n; row++){
            char[] temp = input.next().toCharArray();
            for(int col=0; col<m; col++){
                board[row][col] = temp[col]-'0';
            }
        }
//        print();
        for(int axis=0; axis<2; axis++){
            for(int row=0; row<n; row++){
                for(int col=0; col<m; col++){
                    visit[axis][row][col] = -1;
                }
            }
        }

        visit[0][0][0] = 1;
        bfs();
        print2();
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
                    System.out.print(visit[axis][row][col] + " ");
                }
            }
        }
    }
    static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int breakCount = point.count;
            for(int num=0; num<4; num++){
                int next_x = x + dx[num];
                int next_y = y + dy[num];
                if(isPossible(next_x, next_y)){
                    if(board[next_x][next_y]==0
                            && visit[breakCount][next_x][next_y] == -1){
                        visit[breakCount][next_x][next_y] = visit[breakCount][x][y] +1;
                        queue.add(new Point(next_x,next_y, point.count));
                    }
                    else if(board[next_x][next_y] == 1 && point.count <=0
                            &&visit[breakCount+1][next_x][next_y] == -1){
                        visit[breakCount+1][next_x][next_y] = visit[breakCount][x][y]+1;
                        queue.add(new Point(next_x, next_y, breakCount+1));
                    }
                }
            }
        }
        System.out.println(getAnswer(n, m));
    }

    static int getAnswer(int n, int m){
        if(visit[0][n-1][m-1] == -1 && visit[1][n-1][m-1] == -1){
            return -1;
        } if(visit[0][n-1][m-1] != -1 && visit[1][n-1][m-1] != -1){
            return Math.min(visit[0][n-1][m-1], visit[1][n-1][m-1]);
        }
        return Math.max(visit[0][n-1][m-1], visit[1][n-1][m-1]);
    }

    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
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
    static class Point{
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
