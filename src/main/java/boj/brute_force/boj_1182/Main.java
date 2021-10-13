package boj.brute_force.boj_1182;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int s;
    static int[] numbers;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        init();
        answer(s);
    }

    private static void init() throws Exception {
        n = input.integer();
        s = input.integer();
        numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = input.integer();
        }
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(point.no == n){
                if (point.value == s) {
                    answer++;
                }
            }else {
                queue.add(new Point(point.value+numbers[point.no], point.no +1));
                queue.add(new Point(point.value, point.no +1));
            }
        }
        return answer;
    }

    static void answer(int s){
        if(s==0){
            System.out.println(bfs()-1);
        }
        else {
            System.out.println(bfs());
        }
    }

    static class Point {
        int value;
        int no;

        public Point(int value, int index) {
            this.value = value;
            this.no = index;
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
