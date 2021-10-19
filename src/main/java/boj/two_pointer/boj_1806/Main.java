package boj.two_pointer.boj_1806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int sum = 0;
    static int end = 0;
    static int[] numbers;
    static int answer = Integer.MIN_VALUE-100000;
    public static void main(String[] args) throws Exception {
        init();
        two_pointer();
        answer();
    }

    private static void two_pointer() {
        for(int start=0; start<n; start++){
            while(end<n && sum<s){
                sum+=numbers[end];
                end++;
            }
            if(sum>s){
                answer = Math.min(answer, end-start);
            }
            sum-=numbers[start];
        }
    }

    private static void answer() {
        if(answer == Integer.MIN_VALUE-100000){
            System.out.println(0);
        }else {
            System.out.println(answer);
        }
    }

    private static void init() throws Exception {
        n = input.integer();
        s = input.integer();
        numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = input.integer();
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
