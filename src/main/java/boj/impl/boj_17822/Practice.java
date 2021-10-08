package boj.impl.boj_17822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Practice {
    static int n;
    static int m;
    static int t;
    static int [][] board;
    static int x;
    static int d;
    static int k;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static List<Point> points = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();
    private static int[][] visited;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        t = input.integer();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = input.integer();
            }
        }

        while (t-- > 0) {
            x = input.integer();
            d = input.integer();
            k = input.integer();
            visited = new int[n][m];
            for (int i = x; i <= n; i += x) {
                roate(i);
            }
            if (!deleteSameNumber()) {
                operate();
            }
        }
        sum();
    }
    static void print(){
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    static void roate(int number){
        for(int num=0; num<k; num++)
            if (d == 0) {
                int temp = board[number-1][m-1];
                for(int j=m-1; j>=1; j--){
                    board[number-1][j] = board[number-1][j-1];
                }
                board[number-1][0] = temp;
            }else {
                int temp = board[number-1][0];
                for(int j=1; j<m; j++){
                    board[number-1][j-1] = board[number-1][j];
                }
                board[number-1][m-1] = temp;
            }
    }

    static void operate(){
        double sum = 0;
        double count = 0;
        double average;
        for(int row=0; row<n; row++){
            for(int column=0; column<m; column++){
                if (board[row][column] > 0) {
                    sum += board[row][column];
                    count++;
                }
            }
        }
        if(count == 0){
            return ;
        }
        average = sum/count;
        for(int row=0; row<n; row++){
            for(int column=0; column<m; column++){
                if(board[row][column] == 0){
                    continue;
                }
                if (board[row][column] < average) {
                    board[row][column] += 1;
                }else if(board[row][column] > average){
                    board[row][column] -=1;
                }
            }
        }
    }



    static boolean deleteSameNumber(){
        boolean sameNumber = false;
        for(int row=0; row<n; row++){
            for(int column=0; column < m; column++){
                if(board[row][column] == 0 || visited[row][column] == -1){
                    continue;
                }
                Point point = new Point(row, column);
                queue.add(point);
                points.add(point);
                bfs(board[row][column]);
                if(points.size()>1){
                    sameNumber = true;
                    for(Point each : points){
                        board[each.x][each.y] = 0;
                    }
                }
                points.clear();
            }
        }
        return sameNumber;
    }

    static void bfs(int number){
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            for(int i=0; i< 4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                if(next_y>m-1){
                    next_y = 0;
                } else if(next_y<0){
                    next_y = m-1;
                }
                if(next_x>n-1 || next_x<0 || visited[next_x][next_y] == -1){
                    continue;
                }
                if(board[next_x][next_y] == number){
                    visited[next_x][next_y] = -1;
                    Point next = new Point(next_x, next_y);
                    queue.add(next);
                    points.add(next);
                }
            }
        }
    }

    static void sum(){
        int sum = 0;
        for(int row=0; row<n; row++){
            for(int column=0; column<m; column++){
                sum += board[row][column];
            }
        }
        System.out.println(sum);
        System.exit(0);
    }


    static Input input = new Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    };

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
