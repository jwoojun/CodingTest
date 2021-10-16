package boj.dp.boj_1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SearchBFS {
    static int n;
    static int answer = Integer.MAX_VALUE-100;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(n, 0));
        while(!queue.isEmpty()){
            Number number = queue.poll();
            int value = number.value;
            if(value <= 1){
                if(value==1)
                    answer = Math.min(number.count, answer);
                System.out.println(answer);
                return;
            }
            if(value%3==0){
                queue.add(new Number(value/3, number.count+1));
            }
            if(value%2==0){
                queue.add(new Number(value/2, number.count+1));
            }
            queue.add(new Number(value - 1, number.count + 1));
        }
    }

    static class Number {
        int value;
        int count;

        public Number(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    static Main.Input input = new Main.Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
