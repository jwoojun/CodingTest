package boj.search.boj_1600;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int w;
    static int h;
    static int[][] board;
    static boolean[][][] visited;
    static int[][] moves = {{-2, -1}, {-1,-2},{-2,1}, {-1,2}, {1, 2}, {2,1}, {1, -2}, {2,-1}};
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        init();
        bfs(0,0);
    }

    static void init() throws Exception {
        k = input.integer();
        w = input.integer();
        h = input.integer();
        board = new int[h][w];
        visited = new boolean[k+1][h][w];
        for(int row=0; row<h; row++){
            for(int col=0; col<w; col++){
                int number = input.integer();
                board[row][col] = number;
            }
        }
    }

    static void bfs(int x, int y){
        Queue<Monkey> queue = new LinkedList<>();
        queue.add(new Monkey(x, y, 0 , k));
        visited[k][x][y] = true;
        while(!queue.isEmpty()){
            Monkey monkey = queue.poll();
            if(monkey.x == h-1 && monkey.y == w-1){
                System.out.println(monkey.moveCount);
                System.exit(0);
            }
            for(int i=0; i<4; i++){
                int next_x = monkey.x + dx[i];
                int next_y = monkey.y + dy[i];
                if(moveable_monkey(next_x, next_y, monkey.jumpCount)){
                    visited[monkey.jumpCount][next_x][next_y] = true;
                    queue.add(new Monkey(next_x, next_y, monkey.moveCount+1, monkey.jumpCount));
                }
            }
            if(monkey.jumpCount>0){
                for (int[] move : moves) {
                    int next_x = monkey.x + move[0];
                    int next_y = monkey.y + move[1];
                    if (moveable_horse(next_x, next_y, monkey.jumpCount)) {
                        visited[monkey.jumpCount-1][next_x][next_y] = true;
                        queue.add(new Monkey(next_x, next_y, monkey.moveCount+1, monkey.jumpCount-1));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static boolean moveable_monkey(int x, int y, int number) {
        return x>=0 && x< h && y>=0 && y<w && board[x][y] ==0 && !visited[number][x][y];
    }

    static boolean moveable_horse(int x, int y, int number) {
        return x>=0 && x< h && y>=0 && y<w && board[x][y] ==0 && !visited[number-1][x][y];
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

    static class Monkey{
        int x;
        int y;
        int moveCount;
        int jumpCount;

        public Monkey(int x, int y, int index, int jumpCount) {
            this.x = x;
            this.y = y;
            this.moveCount = index;
            this.jumpCount = jumpCount;
        }
    }

    static void print(){
        for(int i=0; i<h; i++){
            System.out.println();
            for(int j=0; j<w; j++){
                System.out.print(visited[i][j]+" ");
            }
        }
        System.out.println();
        System.out.println("=======================");
    }
}
