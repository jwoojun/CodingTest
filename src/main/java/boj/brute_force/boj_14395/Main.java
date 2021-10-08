package boj.brute_force.boj_14395;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int s;
    static int t;
    static HashSet<Integer> set = new HashSet<>();
    static int ADD_MAX_NUMBER = 1070000000;
    static int MUL_MAX_NUMBER = 31700;
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.MAX_VALUE/2-1);
        s = input.integer();
        t = input.integer();
        canFinish(s,t);
        set.add(s);
        bfs(new Number(s, ""));
    }
    static void bfs(Number number){
        Queue<Number> queue = new LinkedList<>();
        queue.add(number);
        while (!queue.isEmpty()){
            Number n = queue.poll();
            int value = n.value;
            String operation = n.operation;

            if(value == t){
                System.out.println(operation);
                return;
            }

            if(value<= MUL_MAX_NUMBER){
                int next = value*value;
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(new Number(next, operation + "*"));
                }
            }

            if(value<= ADD_MAX_NUMBER){
                int next = value*2;
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(new Number(next, operation+"+"));
                }
            }

            if(!set.contains(1)){
                set.add(1);
                queue.add(new Number(1, operation + "/"));
            }
        }
        System.out.println(-1);

    }

    static void canFinish(int s, int t){
        if(t==0){
            System.out.println("-");
            System.exit(0);
        }else if(t==1) {
            System.out.println("/");
            System.exit(0);
        }else if(t==s){
            System.out.println(0);
            System.exit(0);
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

    static class Number{
        int value;
        String operation;

        public Number(int value, String operation) {
            this.value = value;
            this.operation = operation;
        }
    }
}
