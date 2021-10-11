package boj.impl.boj_21608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// https://velog.io/@mulgyeol/%EB%B0%B1%EC%A4%80-21608-%EC%83%81%EC%96%B4-%EC%B4%88%EB%93%B1%ED%95%99%EA%B5%90-Java
public class Main {
    static int n;
    static int[][] board;
    static int[][] seat;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static Map<Integer, Shark> list = new HashMap<>();

    public static void main(String[] args) throws Exception {
        n = input.integer();
        board = new int[n][n];
        seat = new int[n][n];
        int n2 = n*n;
        for(int i=0; i<n*n; i++){
            int number = input.integer();
            int s1 = input.integer();
            int s2 = input.integer();
            int s3 = input.integer();
            int s4 = input.integer();
            findSeat(number, new ArrayList<>(Set.of(s1, s2, s3, s4)));
        }
    }

    static void findSeat(int number, List<Integer> friends){
        int[][] nearScore = new int[n][n];
        for(Integer friend: friends){
            if(list.containsKey(friend)){
                Shark shark = list.get(friend);
                int x = shark.x;
                int y = shark.y;
                for(int i=0; i<4; i++){
                    int next_x = x+dx[i];
                    int next_y = y+dy[i];
                    if(isPossible(next_x, next_y)){
                        nearScore[next_x][next_y] += 1;
                    }
                }
            }
        }

        int emptyCountMax = -1;
        int nearScoreMax = -1;
        int select_x = -1;
        int select_y = -1;

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(seat[row][col] != 0) continue;
                if(nearScoreMax < nearScore[row][col]){
                    select_x = row;
                    select_y = col;
                    nearScoreMax = nearScore[row][col];
                    emptyCountMax = seat[row][col];
                }else if(nearScoreMax == nearScore[row][col] && emptyCountMax<seat[row][col]){
                    emptyCountMax = seat[row][col];
                    select_x = row;
                    select_y = col;
                }
            }
        }

        seat[select_x][select_y] = number;
        list.put(number, new Shark(select_x, select_y, friends));

        for(int i=0; i<4; i++){
            int next_x = select_x+dx[i];
            int next_y = select_y+dy[i];
            if(isPossible(next_x, next_y)){
                seat[next_x][next_y] --;
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
        return x>=0 && x<n && y>0 && y<n && seat[x][y]==0;
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
        List<Integer> friends = new ArrayList<>();

        public Shark(int x, int y, List<Integer> friends) {
            this.x = x;
            this.y = y;
            this.friends = friends;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "x=" + x +
                    ", y=" + y +
                    ", friends=" + friends +
                    '}';
        }
    }
}
