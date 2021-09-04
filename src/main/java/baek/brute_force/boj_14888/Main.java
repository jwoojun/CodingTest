package baek.brute_force.boj_14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Input input = new Input();
    static int n;
    static int add;
    static int subtract;
    static int multiply;
    static int division;
    static long max = -99999999;
    static long min= 999999999;
    static List<Integer> numbers = new ArrayList<>();
    public static void main(String args []) throws Exception {
        n = input.integer();
        for(int i=0; i<n; i++){
            numbers.add(input.integer());
        }
        add = input.integer();
        subtract = input.integer();
        multiply = input.integer();
        division = input.integer();
        dfs(numbers.get(0), 1, add, subtract, multiply, division);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int result, int count, int add, int subract, int multiply, int division){
        if (count == numbers.size()) {
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }
        System.out.println(result);
        if (add > 0) {
            dfs(result+numbers.get(count), count+1, add-1, subract, multiply, division);
        }

        if(subract>0){
            dfs(result-numbers.get(count), count+1, add, subract-1, multiply, division);
        }
        if(multiply>0){
            dfs(result*numbers.get(count), count+1, add, subract, multiply-1, division);
        }

        if(division>0){
            dfs(result/numbers.get(count), count+1, add, subract, multiply, division-1);
        }


    }

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    };

}
