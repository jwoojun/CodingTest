package baek.impl.boj_2174;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, a, b;
    // 북 동 남 서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] board;
    static boolean[][] visitied;
    static Map<Integer, Robot> robots = new HashMap<>();
    static Queue<Command> queue = new LinkedList<>();
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        a = input.integer();
        b = input.integer();
        n = input.integer();
        m = input.integer();
        board = new int[b][a];
        visitied = new boolean[b][a];
        for(int i=0; i<n; i++){
            int x = input.integer();
            int y = input.integer();
            String direction = input.next();
            robots.put(i, new Robot(b-y, x-1, i, setDirection(direction)));
            visitied[b-y][x-1] = true;
        }
//        System.out.println("1=====");
//        for(int i=0; i<b;i++){
//            System.out.println();
//            for(int j=0; j<a; j++){
//                System.out.print(visitied[i][j]+" ");
//            }
//        }

        for (int i = 0; i < m; i++) {
            int robotKind = input.integer();
            String command = input.next();
            int commandCount = input.integer();
            move(robotKind, command, commandCount);
            print();
            System.out.println("1회===========");
        }

    }

    static void print() {
        for (int i = 0; i < b; i++) {
            System.out.println();
            for (int j = 0; j < a; j++) {
                System.out.print(visitied[i][j] + " ");
            }
        }
    }

    static void move(int robotKind, String direction, int commandCount){
        for (int i = 0; i < commandCount; i++) {
            // map에서 로봇 찾기
            Robot robot = robots.get(robotKind-1);

            // 방향이 L또는 R일 경우 단순 회전
            if (direction.equals("L") || direction.equals("R")) {
                rotate(robot, direction);

                // 직진 -> 이동이 있기 때문에 다음 칸 체크
            } else if(direction.equals("F")){
                int next_x = robot.x + dx[robot.directionNumber];
                int next_y = robot.y + dy[robot.directionNumber];

                if (isPossible(next_x, next_y)) {

                    // 이미 다른 로봇이 위치에 존재하면 충돌 후 종료
                    if (visitied[next_x][next_y]) {
                        Robot findRobot = findRobot(next_x, next_y);
                        System.out.println(
                                "Robot " + (robot.kind+1) + "crashes into robot " + (findRobot.kind+1));
                        System.exit(0);
                        // 로봇이 없으면 로봇의 현재 위치는 false로, 이동 후 위치는 true로
                    } else {
                        robot.x = next_x;
                        robot.y = next_y;
                        visitied[robot.x][robot.y] = false;
                        visitied[next_x][next_y] = true;
                    }
                    // 이동 불가능하다면 벽에 박고 종료
                } else {
                    System.out.println("Robot " + (robot.kind+1) + " crashes into the wall");
                    System.exit(0);
                }
            }
        }
        // 다 돌았는데 무사하면 OK
        System.out.println("OK");
        System.exit(0);
    }

    static Robot findRobot(int x, int y){
        return robots.values()
                .stream().filter(r->r.x==x && r.y == y)
                .findFirst().get();
    }

    // 북(0) 동(1) 남(2) 서(3)
    static int setDirection(String command) {
        if (command.equals("N")) {
            return 0;
        }
        else if (command.equals("E")) {
            return 1;
        }
        else if (command.equals("S")) {
            return 2;
        }
        else  {
            return 3;
        }
    }


    static void rotate(Robot robot, String command){
        if(command.equals("L")){
            if(robot.directionNumber == 0){
                robot.directionNumber = 3;
            }else {
                robot.directionNumber -=1;
            }
        }else if(command.equals("R")){
            if(robot.directionNumber == 3){
                robot.directionNumber = 0;
            }else {
                robot.directionNumber +=1;
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return x >= 0 && x < b && y >= 0 && y < a;
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

    }
}

// 추가 테케 1 -> 통과
//3 3
//1 9
//2 2 W
//1 F 1
//1 L 1
//1 F 1
//1 L 1
//1 F 2
//1 L 5
//1 F 2
//1 R 3
//1 F 2



// 추가 테케2 -> 실패
//5 5
//2 3
//3 3 E
//4 5 N
//2 L 3
//2 R 8
//2 F 3
// https://www.acmicpc.net/board/view/35421

// 추가 테케3 -> 통과
//1 1
//1 1
//1 1 E
//1 F 1
//https://www.acmicpc.net/board/view/49983

