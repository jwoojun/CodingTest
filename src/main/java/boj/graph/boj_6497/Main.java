package boj.graph.boj_6497;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int [] parent;
    static PriorityQueue<Node> nodes = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        while (true) {
            m = input.integer();
            n = input.integer();
            if(m==0 && n==0){
                System.exit(0);
            }
            int totalCost = 0;
            initParent(m);
            for (int i = 0; i < n; i++) {
                int x = input.integer();
                int y = input.integer();
                int z = input.integer();
                totalCost += z;
                nodes.offer(new Node(z, x, y));
            }
            System.out.println(totalCost-kruskal());
        }
    }

    public static int kruskal(){
        int cost = 0;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            int node1 = findParent(node.start);
            int node2 = findParent(node.end);
            if (node1 != node2) {
                unionParent(node1, node2);
                cost += node.value;
            }
        }
        return cost;
    }

    public static int findParent(int number){
        if(parent[number] != number){
            return findParent(parent[number]);
        }
        return parent[number];
    }

    public static void unionParent(int valueA, int valueB){
        int a = findParent(valueA);
        int b = findParent(valueB);
        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    public static void initParent(int m){
        parent = new int[m];
        for(int i=0; i<m; i++){
            parent[i] = i;
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

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int value;

        public Node(int value, int start, int end) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    ", value=" + value +
                    '}';
        }
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
