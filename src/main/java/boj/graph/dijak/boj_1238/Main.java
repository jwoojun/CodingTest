package boj.graph.dijak.boj_1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, x;
    static int[][] board;
    static int[] distance;
    static PriorityQueue<City> queue = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        x = input.integer();
        board = new int[n][n];
        distance = new int[n];
        for(int i=0; i<m; i++){
            queue.add(new City(input.integer(), input.integer()-1, input.integer()-1));
        }

        for(int i=0; i<n; i++){
            distance[i] = Integer.MAX_VALUE-1000;
        }


        while(!queue.isEmpty()){
            City city = queue.poll();

        }

    }

    static class City implements Comparable<City>{
        int distance;
        int start, end;

        public City(int distance, int start, int end) {
            this.distance = distance;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(City o) {
            return Integer.compare(this.distance, o.distance);
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
