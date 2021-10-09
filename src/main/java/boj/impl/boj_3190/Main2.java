package boj.impl.boj_3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int n;
    static int l;
    static int k;
    static int[][] board;
    static boolean[][] visited;
    static Map<Integer, Command> commands = new HashMap<>();

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
            time++;
            Snake s = queue.poll();
            int next_x = s.x + dy[s.direction];
            int next_y = s.y + dx[s.direction];
            if (isPossible(next_x, next_y)) {
                if (touchSnamke(next_x, next_y)) {
                    System.out.println(time);
                    System.exit(0);
                } else {
                    s.path.add(new Point(next_x, next_y));
                    visited[next_x][next_y] = true;
                    if (isApple(next_x, next_y)) {
                        board[next_x][next_y] = 0;
                    }else if (!isApple(next_x, next_y)) {
                        Point point = s.path.pollFirst();
                        visited[point.x][point.y] = false;
                    }
                    if(commands.containsKey(time)){
                        Command command = commands.get(time);
                        int direction = turn(command.command, s.direction);
                        commands.remove(time);
                        queue.add(new Snake(next_x, next_y, direction, s.path));
                    }else {
                        queue.add(new Snake(next_x, next_y, s.direction, s.path));
                    }
                }
            } else {
                System.out.println(time);
                System.exit(0);
            }
        }
    }

    static boolean touchSnamke(int x, int y){
        return visited[x][y];
    }

    static boolean isApple(int x, int y){
        return board[x][y] == 1;
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
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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
    }
}
