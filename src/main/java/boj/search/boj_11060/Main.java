package boj.search.boj_11060;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean[] visited = new boolean[1001];
    static List<Integer> commands = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();
        bfs();
    }

    static void init() throws Exception {
        n = input.integer();
        for(int i=0; i<n; i++){
            commands.add(input.integer());
        }
    }
    static boolean movable(int x) {
        return x>=0 && x<=n && !visited[x];
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()){
            Point point = queue.poll();
            int position = point.position;
            if(position+1 == n){
                System.out.println(point.count);
                System.exit(0);
            }
            for(int i=1; i<=commands.get(position); i++){
                int next_position = position + i;
                if(movable(next_position)){
                    visited[next_position] = true;
                    queue.add(new Point(next_position, point.count+1));
                }
            }
        }
        System.out.println(-1);
    }

    static class Point{
        int position;
        int count;

        public Point(int position, int count) {
            this.position = position;
            this.count = count;
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
}
