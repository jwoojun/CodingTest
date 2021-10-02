package baek.graph.boj17940;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] company;
    static int answer = 0;
    static Point[][] map ;
    static Point[][] graph ;
    static int [] distance;
    static int [] transfer;
    static PriorityQueue<Point> queue = new PriorityQueue<>();
    static boolean[] visit ;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        k = input.integer();
        visit = new boolean[n];
        map = new Point[n][n];
        graph = new Point[n][n];
        distance = new int[n];
        transfer = new int[n];

        for(int i=0; i<n; i++){
            distance[i] = Integer.MAX_VALUE;
            transfer[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<n; i++){
            company[i]=input.integer();
        }

        for(int row=0; row<n; row++){
            for(int column=0; column<k; column++){
                int value = input.integer();
                map[row][column] = new Point(row, column, value);
            }
        }

        for(int row=0; row<n; row++){
            for(int column=0; column<n; column++){
                if(map[row][column].value != 0){
                    if(company[row] == company[column]) {
                        graph[row][column] = new Point(row, column, map[row][column].value);
                    }else {
                        graph[row][column] = new Point(row, column, map[row][column].value+Integer.MAX_VALUE);
                    }
                }
            }
        }
        transfer[0]=0;
        distance[0]=0;
        queue.add(new Point(0, 0,0));

        while (!queue.isEmpty()){
            Point currentCompany = queue.poll();
            if(visit[currentCompany.no]){
                continue;
            }
            visit[currentCompany.no]= true;

        }
    }

    static int djstra(){
        List<Point> lst = new ArrayList<>();
        return 1;

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
    static class Point implements Comparable<Point>{
        int no;
        int transfer;
        int value;


        public Point(int no, int transfer, int value) {
            this.no = no;
            this.transfer = transfer;
            this.value = value;
        }

        @Override
        public int compareTo(Point point) {
            return this.value - point.value;
        }
    }
}
