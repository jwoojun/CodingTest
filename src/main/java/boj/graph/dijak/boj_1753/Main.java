package boj.graph.dijak.boj_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int v, e, start;
    static int[][] board;
    static Node[] nodes;
    static int[] distance;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE-100000;
    static PriorityQueue<Node> queue = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        init();
//        Stream.of(nodes).forEach(System.out::println);

        dijakstra(start);
        for(int i = 0; i < v; i++){
            if(distance[i] == INF) sb.append("INF\n");
            else sb.append(distance[i] + "\n");
        }
        System.out.println(sb);
    }

    private static void init() throws Exception {
        v = input.integer();
        e = input.integer();
        start = input.integer();
        board = new int[v][v];
        distance = new int[v];
        visited = new boolean[v];
        nodes = new Node[v];
        for(int i=0; i<v; i++){
            distance[i] = INF;
            nodes[i] = new Node(i, 0, new ArrayList<>());
        }

        for(int edge=0; edge<e; edge++){
            int from = input.integer();
            int to = input.integer();
            int value = input.integer();
            nodes[from-1].value = value;
            nodes[from-1].adjacent.add(to-1);
        }
    }

    private static void dijakstra(int start) {
        distance[start-1] = 0;
        queue.add(new Node(start-1, 0, nodes[start-1].adjacent));
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(distance[current.no] < current.value) continue;
            for(int i=0; i<current.adjacent.size(); i++){
                Node next = nodes[current.adjacent.get(i)];
                if(distance[next.no] > current.value + next.value ){
                    distance[next.no] = current.value + next.value;
                    queue.add(nodes[next.no]);
                }
            }
        }

    }
    static void printDistance() {
        for(int i=0; i<distance.length; i++){
            System.out.println(distance[i]);
        }
    }

    static class Node implements Comparable<Node>{
        int no;
        int value;
        List<Integer> adjacent = new ArrayList<>();

        public Node(int no, int value, List<Integer> adjacent) {
            this.no = no;
            this.value = value;
            this.adjacent = adjacent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", value=" + value +
                    ", adjacent=" + adjacent +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
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
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public char[] nToCharArray() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken().toCharArray();
        }
    }
}
