package baek.impl.boj_2174;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, a, b;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] board;
    static boolean[][] visitied;
    static Map<Integer, Robot> robots = new HashMap<>();
    static Queue<Command> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        a = input.integer();
        b = input.integer();
        n = input.integer();
        m = input.integer();
        board = new int[a][b];
        visitied = new boolean[a][b];

        robotInit();
        robots.values().forEach(System.out::println);
        commandInit();
        queue.forEach(System.out::println);

        while (!queue.isEmpty()) {
            Command command = queue.poll();
            int robotKind = command.kind;
            int number = command.number;
            String c = command.direction;
      System.out.println(c);
            Robot robot = robots.get(robotKind);
            if (c.equals("L") || c.equals("R")) {
                rotate(robot, c);
                robots.put(robotKind, robot);
            }
            else{
        System.out.println("===============");
                for (int i = 0; i < number; i++) {
                    int next_x = robot.x + dx[cal(c)];
                    int next_y = robot.y + dy[cal(c)];
                    if (isPossible(next_x, next_y)) {
                        if(meetRobot(next_x, next_y)){
                            Robot findRobot = findRobot(next_x, next_y);
                            System.out.println("Robot "+(robot.kind+1)+"crashes into robot "+(findRobot.kind+1));
                            System.exit(0);
                        }else {
                            queue.add(new Command(robot.kind, number-1, c));
                        }
                    } else {
                        System.out.println("Robot "+(robot.kind)+" crashes into the wall");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("OK");
        System.exit(0);

    }

    static Robot findRobot(int x, int y){
        return robots.values()
                .stream().filter(r->r.x==x && r.y == y)
                .findFirst().get();
    }
    static int cal(String s) {
        if(s.equals("N")){
            return 0;
        }else if(s.equals("S")){
            return 2;
        } else if(s.equals("W")){
            return 3;
        } else {
            return 1;

        }
    }
    static boolean meetRobot(int x, int y){
        return visitied[x][y];

    }
    static void rotate(Robot robot, String command){
        if(command.equals("L")){
            robot.directionNumber = (robot.directionNumber +cal(command))%4;
        }else if(command.equals("R")){
            robot.directionNumber = (robot.directionNumber +cal(command)*3)%4;
        }
    }

    static boolean isPossible(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void robotInit() throws Exception {
        for(int i=0; i<n; i++){
            int x = input.integer();
            int y = input.integer();
            String direction = input.next();
            robots.put(i, new Robot(x, y, i, cal(direction)));
            visitied[x-1][y-1] = true;
        }
    }

    static void commandInit() throws Exception {
        for (int i = 0; i < m; i++) {
            int kind = input.integer();
            String command = input.next();
            int number = input.integer();
            queue.add(new Command(kind, number, command));
        }
    }

    static Input input = new Input();
    static class Command {
        int kind, number;
        String direction;

        public Command(int kind, int number, String direction) {
            this.kind = kind;
            this.number = number;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Command{" +
                    "kind=" + kind +
                    ", number=" + number +
                    ", direction='" + direction + '\'' +
                    '}';
        }
    }

    static class Robot {
        int x, y, kind;
        int directionNumber;

        public Robot(int x, int y, int kind, int directionNumber) {
            this.x = x;
            this.y = y;
            this.kind = kind;
            this.directionNumber = directionNumber;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "x=" + x +
                    ", y=" + y +
                    ", kind=" + kind +
                    ", directionNumber=" + directionNumber +
                    '}';
        }
    }
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
        static boolean locatedAlready(int x, int y) {
            return visitied[x][y];
        }

        static boolean meetWall(int x, int y) {
            return x == n - 1 || y == m - 1;
        }


    }
}