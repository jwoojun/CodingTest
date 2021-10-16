package boj.dp.boj_1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SearchDFS {
    static int n;
    static int answer = Integer.MAX_VALUE-100;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        dfs(n, 0);
        System.out.println(answer);
    }

    static void dfs(int value, int count){
        if(value==1){
            answer = Math.min(count, answer);
        }
        if(count>=answer) return;;

        if(value%3==0){
            dfs(value/3, count+1);
        }
        if(value%2==0){
            dfs(value/2, count+1);
        }
        dfs(value-1, count+1);
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
