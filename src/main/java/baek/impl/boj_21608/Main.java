package baek.impl.boj_21608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static int[][] seat;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static Map<Integer, Shark> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        n = input.integer();
        board = new int[n][n];
        seat = new int[n][n];
        int n2 = n*n;
        for(int i=0; i<n2; i++){
            int number = input.integer();
            int s1 = input.integer();
            int s2 = input.integer();
            int s3 = input.integer();
            int s4 = input.integer();

        }


    }

    static void findSeat(int number, int[] friends){
        int [][] score = new int[n][n];
        for(int friend : friends){
            if(map.containsKey(friend)){
                Shark shark = map.get(friend);
                int x = shark.x;
                int y = shark.y;
                for(int i=0; i<4; i++){
                    int next_x = x + dx[i];
                    int next_y = y + dy[i];
                    if(isPossible(next_x, next_y)){
                        score[next_x][next_y] += 1;
                    }
                }
            }
        }

        int emptyCountMax = Integer.MIN_VALUE;
        int scoreMax = Integer.MIN_VALUE;
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(seat[i][j] !=0){
                    continue;
                }
                if(scoreMax<score[i][j]){
                    x = i;
                    y = j;
                    scoreMax = score[i][j];
                    emptyCountMax = board[i][j];
                }else if(scoreMax == score[i][j] && emptyCountMax < board[i][j]){
                    emptyCountMax = board[i][j];
                    x = i;
                    y = j;
                }


            }

        }
        seat[x][y] = number;
        map.put(number, new Shark(x, y, friends));

        for(int i=0; i<4; i++){
            int next_x = x + dx[i];
            int next_y = y+dy[i];
            if(isPossible(next_x, next_y)){

            }
        }
    }

    static void seat(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int count = 4;
                if(i==0 || i ==n-1) count--;
                if(j==0 || j== n-1) count--;
                seat[i][j] = count;
            }
        }
    }

    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>0 && y<n &&seat[x][y]==0;
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

    static class Shark {
        int x;
        int y;
        int [] friends;

        public Shark(int x, int y, int[] friends) {
            this.x = x;
            this.y = y;
            this.friends = friends;
        }
    }
}
