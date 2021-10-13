package boj.impl.boj_16198;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Integer> beads = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        for(int i=0; i<n; i++){
            int nubmer = input.integer();
            beads.add(nubmer);
        }
        dfs(0, beads);
        System.out.println(answer);
    }

    private static void dfs(int sum, List<Integer> lst) {
        if(lst.size()==2){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i=1; i<lst.size()-1; i++){
            int number = lst.get(i);
            int value = lst.get(i-1)*lst.get(i+1);
            lst.remove(i);
            dfs(sum+value, lst);
            lst.add(i, number);
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