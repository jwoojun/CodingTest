package boj.dp.boj_2294;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int n;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        k = input.integer();
        int [] conins = new int[n];
        int [] memoi = new int[k+1];
        for(int i=0; i<n; i++){
            int number = input.integer();
            conins[i] = number;
        }
        Arrays.fill(memoi, 100001);
        memoi[0]=0;

        for(int i=0; i<n; i++){
            for(int j=conins[i]; j<k+1; j++){
                memoi[j] = Math.min(memoi[j], memoi[j-conins[i]]+1);
            }
        }
        System.out.println(memoi[k] == 100001? -1 : memoi[k]);
    }

    static Input input = new Main.Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
