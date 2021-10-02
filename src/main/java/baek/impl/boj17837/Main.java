package baek.impl.boj17837;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static Point[][] map;
    static int turn = 0;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static Deque<Horse> horses = new LinkedList<>();
    static void print(){
        for(int row=0; row<n; row++){
            System.out.println();
            for(int column =0; column<n; column++){
                System.out.print(visit[row][column]+" ");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        n = input.integer();
        k = input.integer();
        map = new Point[n][n];
        visit = new boolean[n][n];

        System.out.println("1======================");
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                int color = input.integer();
                map[row][column] = new Point(row, column, color);
            }
        }
        System.out.println("2======================");
        for (int count = 0; count < k; count++) {
            int row = input.integer();
            int column = input.integer();
            int direction = input.integer();
            Horse horse = new Horse(row - 1, column - 1, direction);
            horse.add(horse);
            horses.add(horse);
            visit[row - 1][column - 1] = true;
        }
        System.out.println("3======================");

        while (!horses.isEmpty()) {
            validateGame(turn);
            Horse horse = horses.poll();
            horses.forEach(System.out::println);
            System.out.println("Horse= " + horse);
            int x = horse.x;
            int y = horse.y;
            int direction = horse.direction;

            int next_x = x + dx[direction - 1];
            int next_y = y + dy[direction - 1];
            if (isPossible(next_x, next_y)) {
                System.out.println("---------------------------");
                // 파란색 또는 장외일 경우
                if (isBlue(map[next_x][next_y].color) || !isPossible(next_x, next_y)) {
                    int newDirection = changeDirection(direction);
                    int blue_x = x + dx[newDirection - 1];
                    int blue_y = y + dy[newDirection - 1];
                    int color = map[blue_x][blue_y].color;
                    // 파란색인데 이동 가능한 경우
                    if (isPossible(blue_x, blue_y)) {
                        if (isWhite(color)) {
                            // 다른 말이 있는 경우
                            if (visit[blue_x][blue_y]) {
                                Horse existHorse = findHorse(blue_x, blue_y);
                                existHorse.addAll(horse.horses);
                                turn++;
                                overFour(existHorse.horses);
                                visit[x][y] = false;
                                System.out.println("존재하는 말="+existHorse);    // 다른 말이 없는 경우
                                System.out.println("파란색-한 번 이동. 이동할 칸에 말 존재");

                            } else {
                                visit[blue_x][blue_y] = true;
                                visit[x][y] = false;
                                horses.add(new Horse(blue_x, blue_y, direction));
                                print();
                                System.out.println("파란색-한 번 이동. 이동할 칸에 말 없음");
                                turn++;
                            }
                            // 이동할 칸이 빨간색
                        } else if (isRed(color)) {
                            // 이동한 칸에 말이 있는 경우
                            if (visit[blue_x][blue_y]) {
                                Horse existHorse = findHorse(blue_x, blue_y);
                                horse.reverse();
                                existHorse.addAll(horse.horses);
                                turn++;
                                overFour(existHorse.horses);
                                visit[x][y] = false;
                                System.out.println("존재하는 말="+existHorse);

                                System.out.println("빨간색-한 번 이동. 이동할 칸에 말 존재");

                                // 이동한 칸에 말이 없는 경우
                            } else {
                                visit[blue_x][blue_y] = true;
                                visit[x][y] = false;
                                horses.add(new Horse(blue_x, blue_y, direction));
                                print();
                                System.out.println("빨간색-이동할 칸에 말 없음");
                                turn++;
                            }
                        }
                        // 파란색인데 이동도 불가능한 경우 : 그대로
                    } else {
                        horses.add(new Horse(x, y, direction));
                        print();
                        System.out.println("이동할 칸이 파란색-뒤 돌았더니 또 파란색");
                    }
                }
                // 파란색이 아닐 경우 - 이동 가능할 경우
            } else {
                int color = map[next_x][next_y].color;
                if(isPossible(next_x, next_y)){
                    if (isWhite(color)) {
                        if (visit[next_x][next_y]) {

                            Horse existHorse = findHorse(next_x, next_y);
                            System.out.println("존재하는 말="+existHorse);
                            existHorse.addAll(horse.horses);
                            turn++;
                            overFour(existHorse.horses);
                            visit[x][y] = false;

                            System.out.println("흰색인데 말 존재");
                            System.out.println("====");
                        } else {
                            visit[next_x][next_y] = true;
                            visit[x][y] = false;
                            horses.add(new Horse(next_x, next_y, direction));
                            turn++;
                            print();
                            System.out.println("흰색인데 말 없음");
                            System.out.println("====");
                        }
                    } else if (isRed(color)) {
                        if (visit[next_x][next_y]) {
                            Horse existHorse = findHorse(next_x, next_y);
                            System.out.println("존재하는 말="+existHorse);
                            horse.reverse();
                            existHorse.addAll(horse.horses);
                            visit[x][y] = false;
                            turn++;
                            System.out.println("빨간색인데 말 존재");
                            System.out.println("====");
                        } else {
                            System.out.println("맵에 말 없음");
                            visit[next_x][next_y] = true;
                            visit[x][y] = false;
                            horses.add(new Horse(next_x, next_y, direction));
                            turn++;
                            print();
                            System.out.println("빨간색인데 말 없음");
                            System.out.println("====");
                        }
                    }
                }
            }
            System.out.println(turn);
        }
    }

    static Horse findHorse(int x, int y){
        return horses.stream()
                .filter(horse->horse.x==x && horse.y==y)
                .findAny().get();
    }

    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }

    // 반대방향 바라보기
    static int changeDirection(int direction){
        if(direction==1){
            return 2;
        }
        else if(direction==2){
            return 1;
        }
        else if(direction==3){
            return 4;
        }
        else
            return 3;
    }

    static boolean isWhite(int color){
        return color==0;
    }
    static boolean isRed(int color){
        return color==1;
    }
    static boolean isBlue(int color){
        return color==2;
    }

    static void validateGame(int turn){
        if(turn>=1000){
            System.out.println(-1);
            System.exit(0);
        };
    }
    static void overFour(List<Horse> horses){
        if(horses.size()>=4){
            System.out.println(turn);
            System.exit(0);
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

    static class Point{
        int x;
        int y;
        int color;

        public Point(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    static class Horse {
        int x;
        int y;
        int direction;
        List<Horse> horses = new ArrayList<>();

        void add(Horse horse){
            horses.add(horse);
        }
        void reverse(){
            Collections.reverse(this.horses);
        }

        void addAll(List<Horse> horseList){
            this.horses.addAll(horseList);
        }

        public Horse(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Horse{" +
                    "x=" + x +
                    ", y=" + y +
                    ", direction=" + direction +
                    "size"+ horses.size()+'}';
        }

        public void clear() {
            horses.clear();
        }

        public void print(){
            horses.forEach(System.out::println);
        }
    }

  // 흠...
}


class Test {
    public static void main(String[] args){
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        Collections.reverse(lst);

        lst.add(4);
        lst.forEach(System.out::println);
    }
}