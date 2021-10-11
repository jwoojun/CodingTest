package boj.impl.boj_17822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int t;
    static int [][] board;
    static int [][] visited;
    static int x;
    static int d;
    static int k;
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0, 1,-1};
    static List<Point> points = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        t = input.integer();
        board = new int[n][m];
        visited = new int[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                board[i][j]=input.integer();
            }
        }

        while (t-->0){
            x = input.integer();
            d = input.integer();
            k = input.integer();
            visited = new int[n][m];
            for(int i=x; i<=n; i+=x){
                rotate(i);
            }
            if(!deleteSameNumber()) {
                plusOrMinus();
            }

        }
        sum();
    }

    static void rotate(int number){
        for(int rotation=0; rotation<k; rotation++){
            if(d==0){
                int temp = board[number-1][m-1];
                for(int j=m-1; j>0; j--){
                    board[number-1][j] = board[number-1][j-1];
                }
                board[number-1][0] = temp;
            } else {
                int temp = board[number-1][0];
                for(int j=0; j<m-1; j++){
                    board[number-1][j] = board[number-1][j+1];
                }
                board[number-1][m-1] = temp;
            }
        }
    }

    private static void plusOrMinus(){
        double sum = 0;
        double count =0;
        double avg;
        for(int i= 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]>0){
                    sum+=board[i][j];
                    count++;
                }
            }
        }
        if(count ==0 ){
            return;
        }
        avg = sum/count;
        for(int i= 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==0){
                    continue;
                }
                if(board[i][j]<avg){
                    board[i][j] += 1;
                }else if(board[i][j] > avg){
                    board[i][j] -= 1;
                }
            }
        }
    }

    private static boolean deleteSameNumber(){
        boolean sameNumber = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0 || visited[i][j] == -1){
                    continue;
                }
                Point point = new Point(i,j);
                points.add(point);
                queue.add(point);
                visited[point.x][point.y] = -1;
                bfs(board[i][j]);
                if(points.size()>1){
                    sameNumber = true;
                    for(Point eachPoint : points){
                        board[eachPoint.x][eachPoint.y] = 0;
                    }
                }
                points.clear();
            }
        }
        return sameNumber;
    }

    private static void bfs(int number){
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            for(int i=0; i<4; i++){
                int next_x = x+dy[i];
                int next_y = y+dx[i];
                if(next_y>m-1){
                    next_y = 0;
                }else if(next_y<0){
                    next_y = m-1;
                }
                if(next_x>n-1 || next_x<0 || visited[next_x][next_y] == -1){
                    continue;
                }
                if(board[next_x][ next_y] == number ){
                    visited[next_x][next_y] = -1;
                    Point nextPoint = new Point(next_x, next_y);
                    queue.add(nextPoint);
                    points.add(nextPoint);
                }
            }
        }
    }

    public static void sum(){
        int sum=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sum += board[i][j];
            }
        }
        System.out.print(sum);
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

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}