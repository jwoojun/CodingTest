package boj.impl.boj_2174;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, a, b;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    static int[][] board;
    static HashMap<String,Integer> directionMap = new HashMap<>();
    static Map<Integer, Robot> robots = new HashMap<>();
    public static void main(String[] args) throws Exception {
        init();
        for (int i = 0; i < m; i++) {
            int robotNo = input.integer();
            String command = input.next();
            int count = input.integer();
            for (int j = 0; j < count; j++) {
                String result = command(robotNo-1, command);
                if(!result.equals("OK\n")){
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println("OK");
    }

    private static void init() throws Exception {
        directionMap.put("N", 0);
        directionMap.put("E", 1);
        directionMap.put("S", 2);
        directionMap.put("W", 3);

        a = input.integer();
        b = input.integer();
        n = input.integer();
        m = input.integer();

        board = new int[b+1][a+1];
        for(int i=0; i<b+1; i++){
            for(int j=0; j<a+1;j++ ){
                board[i][j] = -1;
            }
        }

        for(int i=0; i<n; i++){
            int x = input.integer();
            int y = input.integer();
            String direction = input.next();
            robots.put(i, new Robot(b-y, x-1, i, directionMap.get(direction)));
            board[b-y][x-1] = i;
        }

    }

    static void print() {
        for (int i = 0; i < b; i++) {
            System.out.println();
            for (int j = 0; j < a; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
    }

    static String command(int robotNo, String command){
        if(command.equals("L")){
            robots.get(robotNo).turnLeft();
            return "OK\n";
        }else if(command.equals("R")){
            robots.get(robotNo).turnRight();
            return "OK\n";
        }else {
            return robots.get(robotNo).move();
        }
    }

    static boolean isPossible(int x, int y) {
        return x >= 0 && x < b && y >= 0 && y < a;
    }

    static Input input = new Input();


    static class Robot {
        int x, y, no;
        int direction;

        public Robot(int x, int y, int no, int direction) {
            this.x = x;
            this.y = y;
            this.no = no;
            this.direction = direction;
        }

        public void turnLeft() {
            this.direction -= 1;
            if(this.direction == -1){
                this.direction = 3;
            }
        }

        public void turnRight(){
            this.direction += 1;
            if(this.direction == 4){
                this.direction = 0;
            }
        }

        public String move() {
            int next_x = x + dy[this.direction];
            int next_y = y + dx[this.direction];
            if(!isPossible(next_x, next_y)){
                return "Robot "+(this.no +1)+" crashes into the wall\n";
            }
            if(board[next_x][next_y]!=-1){
                return "Robot "+(this.no +1)+" crashes into robot "+(board[next_x][next_y]+1)+"\n";
            }
            board[this.x][this.y] = -1;
            board[next_x][next_y] = this.no;
            this.x = next_x;
            this.y = next_y;
            return "OK\n";
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
//2 2
//3 3 E
//4 5 N
//2 L 3
//2 R 8
// https://www.acmicpc.net/board/view/35421

// 추가 테케3 -> 통과
//1 1
//1 1
//1 1 E
//1 F 1
//https://www.acmicpc.net/board/view/49983

