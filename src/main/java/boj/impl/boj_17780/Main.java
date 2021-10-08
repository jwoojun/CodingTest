//package baek.impl.boj_17780;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static int n;
//    static int k;
//    static Point[][] map;
//    static boolean [][] visited;
//    static int [] dx = {1, -1, 0, 0};
//    static int [] dy = {0, 0, 1, -1};
//    static Queue<Horse> horses = new LinkedList<>();
//
//    public static void main(String[] args) throws Exception {
//        n = input.integer();
//        k = input.integer();
//        map = new Point[n][n];
//        visited = new boolean[n][n];
//        initColor(n);
//        initHorse(k);
//
//        for(int row=0; row<n; row++){
//            for(int column=0; column<n; column++){
//                int _row = input.integer();
//                int _column = input.integer();
//                int _color = input.integer();
//                map[row][column] = new Point(_row, _column, _color);
//            }
//        }
//
//        for(int row=0; row<k; row++){
//            int _row = input.integer();
//            int _column = input.integer();
//            int _direction = input.integer();
//            horses.add(new Horse(_row, _column, _direction));
//        }
//
//        bfs(horses);
//    }
//
//    static int bfs(Queue<Horse> horses){
//        int turn = 0;
//
//        while(!horses.isEmpty()){
//            Horse horse = horses.poll();
//            int x = horse.x;
//            int y = horse.y;
//            int direction = horse.direction;
//            int next_x = x +dx[direction];
//            int next_y = y +dy[direction];
//            if(isPossible(next_x, next_y)){
//                Point point = map[next_x][next_y];
//                int color = point.color;
//                if(isWhite(color)){
//                    point.horseGroup.addAll(horse.horses);
//                    turn++;
//                    overFour(point.horseGroup, turn);
//                    horse.horses.addAll(point.horseGroup);
//                    point.horseGroup.clear();
//                    horse.x = next_x;
//                    horse.y = next_y;
//                    horses.add(horse);
//                }else if (isRed(color)){
//                    if(!point.horseGroup.isEmpty()){
//                        horse.reverse();
//                        point.horseGroup.addAll(horse.horses);
//                        turn++;
//                        overFour(point.horseGroup, turn);
//                        horse.horses.addAll(point.horseGroup);
//                        point.horseGroup.clear();
//                        horse.x = next_x;
//                        horse.y = next_y;
//                        horses.add(horse);
//                    }
//
//                }else {
////                    horse.direction
//
//                }
//            }else {
//
//            }
//        }
//        return turn;
//    }
//
//    static void initColor(int n) throws Exception {
//
//    }
//
//    static void initHorse(int k) throws Exception {
//
//    }
//
//    static void overFour(List<Horse> horses, int turn){
//        if(horses.size() >= 4){
//            System.out.println(turn);
//            System.exit(0);
//        }
//    }
//
//    static boolean isPossible(int x, int y){
//        return x>=0 && x<n && y>=0 && y<n;
//    }
//
//    static boolean isWhite(int color){
//        return color == 0;
//    }
//
//    static boolean isRed(int color){
//        return color == 1;
//    }
//
//    static boolean isBlue(int color){
//        return color == 2;
//    }
//
//    static Point findHorse(int x, int y){
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//
//            }
//
//        }
//        return null;
//    }
//
//
//    static Input input = new Input();
//    static class Input {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer("");
//        public int integer() throws Exception{
//            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
//            return Integer.parseInt(st.nextToken());
//        }
//    }
//
//    static class Point {
//        int x;
//        int y;
//        int color;
//        List<Horse> horseGroup = new ArrayList<>();
//
//        public Point(int x, int y, int color) {
//            this.x = x;
//            this.y = y;
//            this.color = color;
//        }
//
//        static void sort(List<Horse> horses) {
//            Collections.reverse(horses);
//        }
//
//        static void addHorses(List<Horse> horseGroup, List<Horse> horses){
//            sort(horses);
//            horseGroup.addAll(horses);
//        }
//        public static void clear(){
//            horseGroup.clear();;
//        }
//
//
//    }
//
//    static class Horse{
//        // 흰(0), 빨(1), 파(2)
//        int x;
//        int y;
//        int direction;
//        List<Horse> horses = new ArrayList<>();
//
//        public Horse(int x, int y, int direction) {
//            this.x = x;
//            this.y = y;
//            this.direction = direction;
//        }
//
//        public void reverse(){
//            Collections.reverse(horses);
//        }
//        static void addHorses(List<Horse> horseGroup, List<Horse> horses){
//            horses.clear();
//            horses.addAll(horseGroup);
//        }
//
//        @Override
//        public String toString() {
//            return "Horse{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    ", direction=" + direction +
//                    '}';
//        }
//    }
//}