package boj.impl.boj_2961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean [] ingredients;
    static int[] bitter;
    static int[] sour;
    static int answer;
    public static void main(String[] args) throws Exception {
        answer = Integer.MAX_VALUE;
        n = input.integer();
        ingredients = new boolean [n];
        sour = new int[n];
        bitter = new int[n];

        for(int i=0; i<n; i++){
            sour[i] = input.integer();
            bitter[i] = input.integer();
        }

        dfs(0,0,1);
        System.out.println(answer);
    }

    static void dfs(int count, int b, int s){
        if(count>n){
            return;
        }
        if (count > 0) {
            int minus = isMin(b, s);
            answer = Math.min(answer, minus);
        }
        for(int i=0; i<ingredients.length; i++){
            if(!ingredients[i]){
                ingredients[i] = true;
                dfs(count+1, b+=bitter[i],s*=sour[i]);
                b-=bitter[i];
                s/=sour[i];
                ingredients[i] = false;
            }
        }
    }

    static int isMin(int bitter, int sour){
        return Math.abs(bitter-sour);
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