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
            for(int number=x; number<=n; number+=x){
                roate(number);
            }
            if (!findSameNumber()) {
                operate();
            }
        }
        sum();
    }

    static void roate(int number) {
        for (int p = 0; p < k; p++) {
            if (d == 0) {
                int temp = board[number - 1][m - 1];
                for (int i = m - 1; i > 0; i--) {
                    board[number - 1][i] = board[number - 1][i - 1];
                }
                board[number - 1][0] = temp;
            } else if (d == 1) {
                int temp = board[number - 1][0];
                for (int i = 0; i < m - 1; i++) {
                    board[number - 1][i] = board[number][i + 1];
                }
                board[number - 1][m - 1] = temp;
            }
        }
    }

    static void operate(){
        double sum = 0;
        double count = 0;
        double avg;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(board[row][col]>0){
                    sum+=board[row][col];
                    count++;
                }
            }
        }

        if(count == 0) return;;
        avg = sum/count;

        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(board[row][col]==0){
                    continue;
                }
                if(board[row][col]<avg){
                    board[row][col]+=1;
                }
                else if(board[row][col]>avg){
                    board[row][col]-=1;
                }
            }
        }
    }

    static boolean findSameNumber(){
        boolean sameNumber = false;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(board[row][col] ==0 || visited[row][col] == -1){
                    continue;
                }
                Point point = new Point(row, col);
                points.add(point);
                queue.add(point);
                visited[point.x][point.y] = -1;
                bfs(board[row][col]);
                if(points.size()>1){
                    sameNumber = true;
                    for(Point eachPoint : points){
                        board[eachPoint.x][eachPoint.y] = 0;
                    }
                    points.clear();
                }
            }
        }
        return sameNumber;
    }

    static void bfs(int number){
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int next_x = point.x + dy[i];
                int next_y = point.y + dx[i];

                if(next_y>m-1){
                    next_y = 0;
                }else if(next_y<0){
                    next_y = m-1;
                }

                if(next_x<0 || next_x>n-1 || visited[next_x][next_y]==-1){
                    continue;
                }

                if(board[next_x][next_y] == number){
                    visited[next_x][next_y] = -1;
                    Point newPoint = new Point(next_x, next_y);
                    points.add(newPoint);
                    queue.add(newPoint);
                }
            }
        }
    }

    static void sum(){
        int result = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(board[row][col] > 0){
                    result+=board[row][col];
                }
            }
        }
        System.out.println(result);
        System.exit(0);
    }

    static boolean movable(int x, int y){
        return x>=0 && x<n;
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

    static void print(){
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
