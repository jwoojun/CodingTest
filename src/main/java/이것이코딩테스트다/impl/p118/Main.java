package 이것이코딩테스트다.impl.p118;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int a;
    static int b;
    static int d;
    static int[][] board;
    static boolean[][] visited;

    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        a = input.integer();
        b = input.integer();
        d = input.integer();
        board = new int[n][m];
        visited = new boolean[n][m];
        for(int row=0; row < n; row++){
            for(int column=0; column < m; column++){
                board[row][column] = input.integer();
            }
        }
        visited[a][b] = true;
        Robot robot = new Robot(a, b, 0);
        int count = 1;
        int turn_time = 0;
        while (true) {
            print();
            turnLeft(robot);
            int next_x = robot.x + dx[robot.direction];
            int next_y = robot.y + dy[robot.direction];
            if (isPossible(next_x, next_y)) {
                if (!visited[next_x][next_y] && board[next_x][next_y] != 1) {
                    visited[next_x][next_y] = true;
                    robot.x = next_x;
                    robot.y = next_y;
                    count+=1;
                    turn_time+=1;
                    continue;
                } else {
                    turn_time+=1;
                }
                if (turn_time == 4) {
                    int back_x = robot.x - dx[robot.direction];
                    int back_y = robot.y - dy[robot.direction];
                    if(isPossible(back_x, back_y)){
                        if (board[back_x][back_y] == 0) {
                            robot.x = back_x;
                            robot.y = back_y;
                        } else {
                            System.out.println(count);
                            System.exit(0);
                        }
                    }else {
                        System.out.println(count);
                        System.exit(0);
                    }
                    turn_time = 0;
                }
            }
        }
    }

    static void print(){
        for(int row=0; row<n; row++){
            System.out.println();
            for(int column=0; column<m; column++){
                System.out.print(visited[row][column]+" ");
            }
        }
        System.out.println("============================");
    }
    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }

    static void changeDirectionAndGo(Robot robot){
        robot.direction += 2;
        robot.direction %= 4;
        robot.x = robot.x + dx[robot.direction];
        robot.y = robot.y + dy[robot.direction];
    }

    static void turnLeft(Robot robot){
        robot.direction-=1;
        if(robot.direction == -1){
            robot.direction = 3;
        }
    }

    static class Robot{
        int x;
        int y;
        int direction;

        public Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "x=" + x +
                    ", y=" + y +
                    ", direction=" + direction +
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
//4 4
//1 1 0
//1 1 1 1
//1 0 0 1
//1 1 0 1
//1 1 1 1