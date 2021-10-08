package boj.brute_force.boj_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int n, m ,v;
    static int [][] board;
    static boolean[] visited;
    static List<Point> points = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();
    static int [] dx = {1, -1,0,0};
    static int [] dy = {0, 0,1,-1};

    public static void main(String args []) throws Exception {
        n = input.integer();
        m = input.integer();
        v = input.integer();
        board = new int[n][n];
        visited = new boolean[n];
        init();
        dfs_v2(v-1);
        Arrays.fill(visited, false);
        bfs();


    }

    static void print(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void init() throws Exception {
        for(int i=0; i<m; i++){
            int x = input.integer();
            int y = input.integer();
            board[x-1][y-1] = 1;
            board[y-1][x-1] = 1;
        }


    }

    static void dfs_v2(int i){
        visited[i] = true;
        System.out.print((i+1)+" ");
        for(int a=0; a<n; a++){
            if(isPossible(i,a, a)){
                dfs_v2(a);
                visited[i]=false;
            }
        }
    }
    static void bfs(){
        queue.add(new Point(1, v+"", v-1));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int count = point.count;
            int city = point.city;
            String value = point.value;
            visited[city] = true;

            if (count == n) {
//                System.out.println(count);
//                System.out.println(value);
                System.exit(0);
            }

            for(int i=0; i<n; i++){
                if (isPossible(city, i, i)) {
                    queue.add(new Point(count+1, value+" "+(i+1), i));
                }
            }
        }



    }


    static boolean isPossible(int x, int y, int city){
        return board[x][y] == 1 && !visited[city] ;
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
        int x,y, count;
        String value;
        int city;

        public Point(int count, String value, int city) {
            this.count = count;
            this.value = value;
            this.city = city;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    ", value='" + value + '\'' +
                    ", city=" + city +
                    '}';
        }
    }

}
