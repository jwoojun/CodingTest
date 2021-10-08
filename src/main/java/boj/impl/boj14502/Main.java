package boj.impl.boj14502;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int m;
    static int answer = 0;
    static int [][] virus;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String args []){

    }

    static void spreadVirus(){
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(virus[row][col] == 2){
                    bfs(row, col);
                }
            }
        }
    }

    private static void bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        while (!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int next_x = point.x + dx[i];
                int next_y = point.y + dy[i];
                if(isPossible(next_x, next_y)){
                    if(virus[row][col] == 0){
                        virus[row][col] = 2;
                        queue.add(new Point(next_x, next_y));
                    }
                }
            }
        }
    }

    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
    static int countSafeZone(){
        int count = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(virus[row][col] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
