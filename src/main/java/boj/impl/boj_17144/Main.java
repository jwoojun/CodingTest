package boj.impl.boj_17144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Stream;




public class Main {
    static Input input = new Input();
    static int row;
    static int column;
    static int time;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Point[] cleaner = new Point[2];  // 청소기 위치

    static int [][] map = new int[51][51];

    public static void main(String[] args) throws Exception {
        for(int i=0; i<2; i++){
            cleaner[i] = new Point(-1,-1);
        }
        row = input.nInt();
        column = input.nInt();
        time = input.nInt();

        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                map[i][j] = input.nInt();
                if (map[i][j] == -1) {

                    // 청소기 위치 저장
                    for(int k=0; k<2; k++){
                        if (cleaner[k].x == -1){
                            cleaner[k].x = i;
                            cleaner[k].y = j;
                            break;
                        }
                    }
                }
            }
        }
        while(time-->0){
            spread();
            moveDust();
        }
        int answer = 0;
        for(int i=0;i<row;i++){
            for(int j=0; j<column;j++){
                if(map[i][j]>0){
                    answer+= map[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    static void moveDust(){
        int[][] moveArray = new int[51][51];
        for (int i=0; i<row; i++){
            if (column >= 0) {
                System.arraycopy(map[i], 0, moveArray[i], 0, column);
            }
        }
        int upperCleaner = cleaner[0].x;
        int lowerCleaner = cleaner[1].x;

        // 각 청소기의 아래, 윗변
        for(int i=1; i<column; i++){
            moveArray[0][i-1] = map[0][i];
            moveArray[upperCleaner][i] = map[upperCleaner][i-1];
            moveArray[row-1][i-1] = map[row-1][i];
            moveArray[lowerCleaner][i] = map[lowerCleaner][i-1];
        }
        // 위 청소기(왼쪽)
        for (int i= 1; i<=upperCleaner; i++){
            moveArray[i][0] = map[i-1][0];
        }

        // 위 청소기(오른쪽)
        for (int i= upperCleaner-1; i>=0; i--){
            moveArray[i][column-1] = map[i+1][column-1];
        }

        // 아래 청소기(왼쪽)
        for (int i=row-2; i>=lowerCleaner; i--){
            moveArray[i][0] = map[i+1][0];
        }

        // 아래 청소기(오른쪽)
        for (int i= lowerCleaner+1; i<row; i++){
            moveArray[i][column-1] = map[i-1][column-1];
        }
        map = moveArray;

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(map[i][j] == -1)
                    map[i][j] = 0;
            }
        }
        map[cleaner[0].x][0] = -1;
        map[cleaner[1].x][0] = -1;
    }

    static void spread(){
        int[][] spreadArray = new int[51][51];
        for(int i=0; i<row; i++){
            for(int j=0; j<column;j++){
                if(map[i][j]>0){
                    int count=0;
                    for(int k=0; k<4; k++){
                        int next_x = dx[k]+i;
                        int next_y = dy[k]+j;
                        if(isPossible(next_x, next_y)){
                            count++;
                            spreadArray[next_x][next_y] += map[i][j]/5;
                        }
                    }
                    map[i][j] -= map[i][j]/5*count;
                }
            }
        }
        for (int i=0; i<row;i++){
            for(int j=0; j<column; j++){
                if(map[i][j]>0){
                    spreadArray[i][j] += map[i][j];
                }
            }
        }
        spreadArray[cleaner[0].x][0] = -1;
        spreadArray[cleaner[1].x][0] = -1;
        map = spreadArray;
    }

    public static boolean isPossible(int x, int y){
        return x>=0 && x<row && y>=0 && y<column && map[x][y] != -1;
    }

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int nInt() throws Exception{
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
