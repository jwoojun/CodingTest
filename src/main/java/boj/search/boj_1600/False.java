package boj.search.boj_1600;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class False {
    static int k;
    static int w;
    static int h;
    static int[][] board;
    static boolean[][] visited;
    static int[][] move = {{-2, -1}, {-1,-2},{-2,1}, {-1,2}, {1, 2}, {2,1}, {1, -2}, {2,-1},    {1,0}, {-1,0}, {0,1}, {0,-1}};
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        k = input.integer();
        w = input.integer();
        h = input.integer();
        board = new int[h][w];
        visited = new boolean[h][w];
        for(int row=0; row<h; row++){
            for(int col=0; col<w; col++){
                int number = input.integer();
                board[row][col] = number;
            }
        }
        Queue<Monkey> queue = new LinkedList<>();
        visited[h-1][w-1] = true;
        queue.add(new Monkey(h-1,w-1, 0, k));
        while(!queue.isEmpty()){
            Monkey monkey = queue.poll();
            int x = monkey.x;
            int y = monkey.y;
            if(x==0 && y==0){
                System.out.println(monkey.index);
                System.exit(0);
            }
            if(monkey.jumpCount==0){
                for(int i=0; i<4; i++){
                    int next_x = x +dx[i];
                    int next_y = y +dy[i];
                    if(moveable(next_x, next_y)){
                        visited[next_x][next_y] = true;
                        queue.add(new Monkey(next_x, next_y, monkey.index+1, 0));
                    }
                }
            }else {
                for (int i = 0; i < move.length; i++) {
                    if (i > 7) {
                        int next_x = x + move[i][0];
                        int next_y = y + move[i][1];
                        if (moveable(next_x, next_y)) {
                            visited[next_x][next_y] = true;
                            queue.add(new Monkey(next_x, next_y, monkey.index + 1, monkey.jumpCount));
                        }
                    } else {
                        int next_x = x + move[i][0];
                        int next_y = y + move[i][1];
                        if (moveable(next_x, next_y)) {
                            visited[next_x][next_y] = true;
                            queue.add(new Monkey(next_x, next_y, monkey.index + 1, monkey.jumpCount - 1));
                        }
                    }
                }
            }

        }
        System.out.println(-1);
    }

    static boolean moveable(int x, int y){
        return x>=0 && x< h && y>=0 && y<w && board[x][y] != 1 && !visited[x][y];
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
        int index;
        int jumpCount;

        public Monkey(int x, int y, int index, int jumpCount) {
            this.x = x;
            this.y = y;
            this.index = index;
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

//3
//4 5
//0 1 1 1
//1 1 0 1
//1 1 1 1
//1 1 1 0
//1 1 1 0
// 정답 3


//1
//4 4
//0 0 0 0
//1 0 0 0
//0 0 1 0
//0 1 0 0
// 정답 6

//1
//4 4
//0 1 1 1
//0 0 1 1
//1 0 1 1
//1 1 1 0
//정답 4


//4
//6 10
//0 0 1 1 1 1
//0 1 1 0 1 1
//0 1 1 1 1 0
//0 1 1 1 1 0
//0 1 1 1 1 0
//0 1 1 1 1 0
//0 1 1 0 1 1
//0 1 1 1 1 1
//1 1 1 1 0 0
//1 0 0 1 1 0
// 정답 10


//1
//4 4
//0 1 1 1
//0 0 1 1
//1 0 1 1
//1 1 1 0
// 정답4