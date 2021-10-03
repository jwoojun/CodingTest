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
    static int [] company = new int[1001];
    static int [][] map ;
    static int [] distance = new int[1001];
    static int [] transfer = new int[1001];
    static PriorityQueue<Point> queue = new PriorityQueue<>();
    static boolean[] visit = new boolean[1001];
    static final int MAX_VALUE = 987654321;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        k = input.integer();
        map = new int[n][n];

        for(int number=0; number<n; number++){
            company[number] = input.integer();
            transfer[number] = MAX_VALUE;
            distance[number] = MAX_VALUE;
        }

        for(int row=0; row<n; row++){
            for(int column=0; column<n; column++){
                map[row][column] = input.integer();
            }
        }

        distance[0] = 0;
        transfer[0] = 0;
        queue.add(new Point(0, 0, 0));
        solve();
        System.out.println(transfer[k]+" "+distance[k]);
    }

    static void solve(){
        while (!queue.isEmpty()){
            Point current = queue.poll();
            if(visit[current.no]){
                continue;
            }
            visit[current.no] = true;
            List<Point> connections = findConnection(current.no);
            for (Point next : connections) {
                if (next.transfer + transfer[current.no] < transfer[next.no]) {
                    transfer[next.no] = transfer[current.no] + next.transfer;
                    distance[next.no] = distance[current.no] + next.distance;
                    queue.add(new Point(next.no, transfer[next.no], distance[next.no]));
                } else if (next.transfer + transfer[current.no] == transfer[next.no]) {
                    if (next.distance + distance[current.no] < distance[next.no]) {
                        transfer[next.no] = transfer[current.no] + next.transfer;
                        distance[next.no] = distance[current.no] + next.distance;
                        queue.add(new Point(next.no, transfer[next.no], distance[next.no]));
                    }
                }
            }
        }
    }



    static List<Point> findConnection(int current){
        List<Point> connections = new ArrayList<>();
        for(int number=0; number<n; number++){
            if(map[current][number]>0){
                int transfer = company[current] != company[number] ? 1 : 0;
                connections.add(new Point(number, transfer, map[current][number]));
            }
        }
        return connections;
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

    static class Point implements Comparable<Point> {
        private int no;
        private int transfer;
        private int distance;

        public Point(int no, int transfer, int distance) {
            this.no = no;
            this.transfer = transfer;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            if (this.transfer != o.transfer) {
                return this.transfer - o.transfer;
            }
            return this.distance - o.distance;
        }
    }
}



