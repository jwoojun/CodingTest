package baek.impl.boj_14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int r;
    static int c;
    static int d;
    static Input input = new Input();
    static int[][] map;
    static int count= 1;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String args []) throws Exception {
        n = input.nInt();
        m = input.nInt();
        r = input.nInt();
        c = input.nInt();
        d = input.nInt();
        map = new int[n][m];
        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                map[i][j] = input.nInt();
            }
        }
        dfs(r,c,d);
        System.out.println(count);
    }

    public static void dfs(int x, int y, int direction){
        map[x][y] = 2;
        for(int i=0; i<4; i++){
            direction -=1;
            if(direction ==-1 ){
                direction= 3;
            }
            int next_x = x+dx[direction];
            int next_y = y+dy[direction];
            if(isPossible(next_x, next_y)) {
                if(map[next_x][next_y] == 0) {
                    count ++;
                    dfs(next_x, next_y, direction);
                    return;
                }
            }
        }
        int d = (direction+2)%4;
        int back_x = x + dx[d];
        int back_y = y + dy[d];
        if(isPossible(back_x, back_y) ) {
            dfs(back_x, back_y, direction);
        }
    }

    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int nInt() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
