package boj.brute_force.boj_1405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [][] board = new int[30][30];
    static double[] prob = new double[4];   // 동서남북
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static double answer = 0;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        for (int i = 0; i < 4; i++) {
            prob[i] = Double.parseDouble(String.valueOf(input.integer()))*0.01;
        }
        dfs(new Point(15, 15, 0, 1));
        System.out.println(answer);
    }

    static void dfs(Point point) {
        if (point.count == n) {
            answer += point.probability;;
            return;
        }
        board[point.x][point.y] = -1;
        for(int i=0; i<4; i++){
            int next_x = point.x + dx[i];
            int next_y = point.y + dy[i];
            if(isVisitable(next_x, next_y)){
                board[next_x][next_y] = -1;
                dfs(new Point(next_x, next_y, point.count+1, point.probability*prob[i]));
                board[next_x][next_y] = 0;
            }
        }
    }

    static boolean isVisitable(int x, int y){
        return x>=0 && x<30 && y>=0 && y<30 && board[x][y] == 0;
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
        int count;
        double probability;
        public Point(int x, int y, int count, double probability) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.probability = probability;
        }
    }
}