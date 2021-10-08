package boj.impl.boj_14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {
    static int n;
    static int m;
    static int r;
    static int c;
    static int d;
    static Input input = new Input();
    static int[][] map;
    static int count= 1;
    static int [] dx = {0, -1, 0, 1};
    static int [] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        r = input.integer();
        c = input.integer();
        d = input.integer();
        map = new int[n][m];
        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                map[i][j] = input.integer();
            }
        }
        dfs(r, c, d);
        System.out.println(count);
    }

    static void dfs(int x, int y, int direction){
        map[x][y] = -1;
        direction -= 1;
        if(direction==-1){
            direction = 3;
        }
        for(int i=0; i<4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if(isMoveAble(next_x, next_y)){
                if (map[next_x][next_y] == 0) {
                    count++;
                    dfs(next_x, next_y, direction);
                    return;
                }
            }
        }

        int d = (direction+2)%4;
        int back_x = x+dx[d];
        int back_y = y+dy[d];
        if(isMoveAble(back_x, back_y)){
            dfs(back_x, back_y, d);
        }
    }

    static boolean isMoveAble(int x, int y){
        return x>=0 && x<n && y>=0 && y<m && map[x][y] != -1;
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
