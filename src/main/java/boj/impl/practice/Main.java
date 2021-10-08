package boj.impl.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row;
    static int column;
    static int time;
    static Input input = new Input();
    static int [][] map = new int[51][51];
    static Point[] cleaner = new Point[2];
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};


    public static void main(String[] args) throws Exception {

        row = input.integer();
        column = input.integer();
        time = input.integer();

        for(int i=0; i<2; i++){
            cleaner[i] = new Point(-1, -1);
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                map[i][j] = input.integer();
                if(map[i][j] == -1){
                    for(int k=0; k<2; k++){
                        if (cleaner[k].x == -1){
                            cleaner[k].x = i;
                            cleaner[k].y = j;
                        }
                    }
                }
            }
        }
        spread();
    }

    static void spread(){
        int[][] dustArray = new int[51][51];
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                int count = 0;
                for(int k=0; k<4; k++){
                    int next_x = j + dx[k];
                    int next_y = i + dy[k];
                    if(isPossible(next_x, next_y)){
                        count ++;
                        dustArray[next_x][next_y] += map[i][j]/5;
                    }
                }
                map[i][j] -= map[i][j]/5*count;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] > 0) {
                    dustArray[i][j] += map[i][j];
                }
            }
        }

        for (int i=0; i<2; i++){
            int x = cleaner[i].x;
            int y = cleaner[i].x;
            dustArray[x][y] = -1;
        }
        map = dustArray;
    }

    static boolean isPossible(int x, int y){
        return x>=0 && x < row && y>=0 && y<column && map[x][y] != -1;
    }


    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }


    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}