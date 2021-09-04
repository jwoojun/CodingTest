package baek.impl.boj_14890;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Input input = new Input();
    static int n;
    static int l;
    static int[][] map;
    static int[] direction ={0,1,2,3};  // 동서남북
    static int[] dx ={1,-1,0,0};  // 동서남북
    static int[] dy ={0,0,1,-1};  // 동서남북
    static int[][] visited;
    public static void main(String args []) throws Exception {
        n = input.integer();
        l = input.integer();
        map = new int[n][n];
        visited = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                map[i][j] = input.integer();
        }


    }

    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }

    static boolean minus(int x, int y, int next_x, int next_y){
        return Math.abs(map[x][y]-map[next_x][next_y]) == 1;
    }

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
