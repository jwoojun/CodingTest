package boj.dp.boj_2294;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice {
    static int n;
    static int k;
    static int[] coins;
    static int[] memoi;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        k = input.integer();
        coins = new int[n];
        memoi = new int[k+1];
        init();
        for(int i=0; i<n; i++){
            for(int j=coins[i]; j<k+1; j++){
                memoi[j] = Math.min(memoi[j], memoi[j-coins[i]]+1);
            }
        }
        System.out.println(memoi[k] == 10000001? -1 : memoi[k]);
    }

    private static void init() throws Exception {
        for(int i=0; i<n; i++){
            int number = input.integer();
            coins[i] = number;
        }
        Arrays.fill(memoi, 10000001);
        memoi[0] = 0;
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

