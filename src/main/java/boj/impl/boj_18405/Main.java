package boj.impl.boj_18405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Point[][] board;
    static int n;
    static int k;
    static List<Point> virus = new ArrayList<>();
    static Deque<Point> queue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean [][]visited;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        k = input.integer();
        visited = new boolean[n][n];
        board = new Point[n][n];

        init();

        int s = input.integer();
        int x = input.integer();
        int y = input.integer();

        while(s-->0){
            for(int i=0; i<queue.size(); i++){
                Point point = queue.poll();
                spread(point);
            }
            queue.addAll(virus);
            virus.clear();
        }

        answer(x, y);
    }

    static void init() throws Exception {
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                int number = input.integer();
                if(number == 0) number = -1;
                Point point = new Point(row, col, number);
                board[row][col] = point;
                if(number != -1) virus.add(point);
            }
        }

        for(int i=0; i<virus.size(); i++){
            Point point = virus.get(i);
            visited[point.x][point.y] = true;
        }

        Collections.sort(virus);
        queue.addAll(virus);
        virus.clear();
    }

    static void answer(int x, int y){
        if(!visited[x-1][y-1]){
            System.out.println(0);
        }else {
            System.out.println(board[x-1][y-1].virus);
        }
    }

    static void print(){
        for(int row= 0; row<n; row++){
            System.out.println();
            for(int col=0; col<n; col++){
                System.out.print(visited[row][col]+" ");
            }
        }
    }

    static void spread(Point point){
        int x = point.x;
        int y= point.y;
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int next_x = x + dy[i];
            int next_y = y + dx[i];
            if(!isPossible(next_x, next_y)) continue;
            if(!visited[next_x][next_y] && board[next_x][next_y].virus ==- 1){
                visited[next_x][next_y] = true;
                board[next_x][next_y].virus = point.virus;
                virus.add(new Point(next_x, next_y, point.virus));
            }
        }
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
    };

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int virus;

        public Point(int x, int y, int virus) {
            this.x = x;
            this.y = y;
            this.virus = virus;
        }

        @Override
        public int compareTo(Point o) {
            return this.virus - o.virus;
        }
    }
}
