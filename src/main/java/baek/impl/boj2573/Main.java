package baek.impl.boj2573;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] ice;
    static boolean[][] visited;
    static int [] dx = {1, -1, 0,0 };
    static int [] dy = {0, 0, 1,-1 };
    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        ice = new int[n][m];
        visited = new boolean[n][m];

    }

    static void makeSea() throws Exception {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ice[i][j] = input.integer();
            }
        }
    }

    static boolean isPossible(int x, int y){
        return x>=0 && x<n || y>=0 && y<m && ice[x][y] != 0 && !visited[x][y] ;
    }
    static int isNearTheSea(int x, int y){
        int count=0;
        for(int i=0; i<4; i++){
            int next_x = x + dx[i];
            int next_y = x + dy[i];
            if(ice[next_x][next_y]==0){
                count++;
            }
        }
        return count;
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
