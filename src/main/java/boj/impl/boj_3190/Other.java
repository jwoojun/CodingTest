package boj.impl.boj_3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Other {
    static int n;


    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
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
