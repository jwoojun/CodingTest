package boj.impl.boj_2174;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Practice {
    static int a, b;
    static int n, m;
    static int[][] board;
    static Map<Integer, Robot> robots = new HashMap<>();
    static Map<String, Integer> directions = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        init();
        bfs();
    }

    private static void bfs() throws Exception {
        for(int i=0; i<m; i++){
            int robotNo = input.integer();
            String command = input.next();
            int count = input.integer();
            for(int j=0; j<count; j++){
                Robot findRobot = robots.get(robotNo-1);
                String result = findRobot.executeCommand(findRobot, command);
                if(!result.equals("OK\n")){
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println("OK");
    }

    private static void init() throws Exception {
        a = input.integer();
        b = input.integer();
        n = input.integer();
        m = input.integer();
        board = new int[b][a];
        directions.put("N", 0);
        directions.put("E", 1);
        directions.put("S", 2);
        directions.put("W", 3);

        for(int row=0; row<b; row++){
            for(int col=0; col<a; col++){
                board[row][col] = -1;
            }
        }

        for(int no=0; no<n; no++){
            int x = input.integer();
            int y = input.integer();
            String direction = input.next();
            robots.put(no, new Robot(no, b-y, x-1, setDirection(direction)));
            board[b-y][x-1] = no;
        }
    }

    public static int setDirection(String command){
        if(command.equals("N")){
            return 0;
        } else if(command.equals("E")){
            return 1;
        } else if(command.equals("S")){
            return 2;
        } else {
            return 3;
        }
    }

    static class Robot {
        int no;
        int x, y;
        int direction;

        public Robot(int no, int x, int y, int direction) {
            this.no = no;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public String executeCommand(Robot robot, String command) {
            if(command.equals("L")){
                turnLeft(robot);
                return "OK\n";
            }else if(command.equals("R")){
                turnRight(robot);
                return "OK\n";
            }else {
                return moveForward(robot);
            }
        }

        public static void turnLeft(Robot robot) {
            robot.direction -= 1;
            if(robot.direction==-1){
                robot.direction = 3;
            }
        }

        public static void turnRight(Robot robot) {
            robot.direction += 1;
            if(robot.direction == 4){
                robot.direction = 0;
            }
        }

        public String moveForward(Robot robot) {
            int next_x = robot.x+dy[robot.direction];
            int next_y = robot.y+dx[robot.direction];
            if(moveable(next_x, next_y)){
                if(board[next_x][next_y] != -1){
                    return "Robot "+ (robot.no+1)+ " crashes"+ " into robot "+(board[next_x][next_y]+1);
                } else {
                    board[robot.x][robot.y] = -1;
                    robot.x = next_x;
                    robot.y = next_y;
                    board[next_x][next_y] = this.no;
                    return "OK\n";
                }
            } else {
                return "Robot "+ (robot.no+1)+ " crashes" + " into the wall";
            }
        }

    }

    static boolean moveable(int x, int y){
        return x>=0 && x<b && y>=0 && y<a;
    }

    static void print() {
        for(int i=0; i<b; i++){
            System.out.println();
            for(int j=0; j<a; j++){
                System.out.print(board[i][j]+" ");
            }
        }
    }

    static Input input = new Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
