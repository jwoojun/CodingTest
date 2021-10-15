package boj.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<Number> lstA = new ArrayList<>();
    static List<Number> lstB = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        for(int i=0; i<n; i++){
            lstA.add(i, new Number(input.integer()));
        }
        for(int i=0; i<m; i++){
            lstB.add(i, new Number(input.integer()));
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Number> queue = new PriorityQueue<>();
        queue.addAll(lstA);
        queue.addAll(lstB);
        queue.stream().sorted(Number::compareTo).forEach(value->sb.append(value.value).append(" "));
        System.out.println(sb);
    }
    static class Number implements Comparable<Number> {
        long value;

        public Number(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Number o) {
            return Long.compare(this.value, o.value);
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
    };
}
