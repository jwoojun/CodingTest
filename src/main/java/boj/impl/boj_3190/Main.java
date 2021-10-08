package boj.impl.boj_3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int l;
    static int k;
    static int[][] board;
    static boolean[][] visited;
    static Map<Integer, Command> commands = new HashMap<>();

    // 북동남서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        n = input.integer();
        k = input.integer();
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int number = 0; number < k; number++) {
            int row = input.integer();
            int col = input.integer();
            board[row - 1][col - 1] = 1;
        }

//        print_board();
//        System.out.println();
//        System.out.println("===================");

        l = input.integer();
        for (int number = 0; number < l; number++) {
            int time = input.integer();
            String command = input.st.nextToken();
            commands.put(time, new Command(time, command));
        }
        Deque<Snake> queue = new LinkedList<>();
        Snake snake = new Snake(0, 0, 1, new LinkedList<>());
        snake.path.add(new Point(0, 0));
        queue.add(snake);


        visited[0][0]=true;
        int time = 0;
        while (!queue.isEmpty()) {
//            System.out.println("============================================================");
            time++;
            Snake s = queue.poll();
            int next_x = s.x + dy[s.direction];
            int next_y = s.y + dx[s.direction];
            if (isPossible(next_x, next_y)) {
                if (touchSnamke(next_x, next_y)) {
//                    System.out.println("1.뱀 만남");
                    System.out.println(time);
                    System.exit(0);
                    // 만나지 않는 경우
                } else {
//                    System.out.println("1.뱀을 안 만남");
                    s.path.add(new Point(next_x, next_y));
                    visited[next_x][next_y] = true;
                    // 사과가 있을 때
                    if (board[next_x][next_y] == 1) {
//                        System.out.println("2.사과먹음");
                        board[next_x][next_y] = 0;
//                        print();
//                        System.out.println();
//                        System.out.println("===================");
                        if(commands.containsKey(time)){
//                            System.out.println("3.시간초 됨= "+time);
                            Command command = commands.get(time);
                            int direction = turn(command.command, s.direction);
                            commands.remove(time);
                            queue.add(new Snake(next_x, next_y, direction, s.path));
                        }else {
//                            System.out.println("3.시간초 안 됨= "+time);
                            queue.add(new Snake(next_x, next_y, s.direction, s.path));
                        }
                        // 사과가 없을 때
                    } else if(board[next_x][next_y] == 0){
//                        System.out.println("2.사과 안먹음");
//                        s.path.forEach(System.out::println);
                        Point point = s.path.pollFirst();
//                        System.out.println("==============================");
//                        System.out.println("Point= "+point+", time= "+time);
//                        System.out.println("==============================");
                        visited[point.x][point.y] = false;
//                        print();
//                        System.out.println();
//                        System.out.println("===================");
                        if(commands.containsKey(time)){
//                            System.out.println("3.시간초 됨= "+time);
                            Command command = commands.get(time);
                            int direction = turn(command.command, s.direction);
                            commands.remove(time);
                            queue.add(new Snake(next_x, next_y, direction, s.path));
                        }else {
//                            System.out.println("3.시간초 안 됨= "+time);
                            queue.add(new Snake(next_x, next_y, s.direction, s.path));
                        }
                    }
                }

            } else {
                // 맵을 벗어날 때
                System.out.println(time);
                System.exit(0);
            }
        }
    }

    static boolean touchSnamke(int x, int y){

        return visited[x][y];
    }

    static void print_board(){
        for(int i=0; i<n; i++){
            System.out.println();
            for(int j=0; j<n; j++){
                System.out.print(board[i][j]+" ");
            }
        }
    }
    static void print(){
        for(int i=0; i<n; i++){
            System.out.println();
            for(int j=0; j<n; j++){
                System.out.print(visited[i][j]+" ");
            }
        }
    }
    static int turn(String command, int direction) {
        if (command.equals("L")) {
            direction -= 1;
            if (direction == -1) {
                direction = 3;
            }
            return direction;
        } else if(command.equals("D")){
            direction+=1;
            if (direction == 4) {
                direction = 0;
            }
            return direction;
        }
        return direction;
    }


    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
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

    static class Command {
        int time;
        String command;

        public Command(int time, String command) {
            this.time = time;
            this.command = command;
        }

        @Override
        public String toString() {
            return "Command{" +
                    "time=" + time +
                    ", command='" + command + '\'' +
                    '}';
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static class Snake{
        int x;
        int y;
        int direction;
        Deque<Point> path = new LinkedList<>();

        public Snake(int x, int y, int direction, Deque<Point> path) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.path = path;
        }

        @Override
        public String toString() {
            return "Snake{" +
                    "x=" + x +
                    ", y=" + y +
                    ", direction=" + direction +
                    ", path=" + path +
                    '}';
        }
    }
}
