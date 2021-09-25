package baek.impl.boj_21609;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int black = -1;
    static int answer = 0;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Point> area = new PriorityQueue<>();

    static void print(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        n=input.integer();
        m=input.integer();
        map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = input.integer();
            }
        }

        while(true) {
            area.clear();
            visited = new boolean[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j] && map[i][j] >=0 ){
                        bfs(i, j, map[i][j]);
                    }
                }
            }
            if(area.isEmpty()){
                break;
            }
            System.out.println("--");
            Point point = area.poll();
            answer += Math.pow(point.blockCount, 2);
            erase(point.x, point.y, map[point.x][point.y]);
            gravity();
            rotate();
            gravity();
        }
        System.out.println(answer);
    }

    static void rotate(){
        int [][] copy = new int[n][n];
        for(int i=0; i<n; i++){
            copy[i]= map[i].clone();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = copy[j][n-1-i];
            }
        }
    }

    static void gravity(){
        for(int i=0; i<n; i++){
            int bottom = n-1;
            for(int j= n-1; j>=0; j--){
                if(map[j][i] == -2){
                    continue;
                } else if(map[j][i] == black){
                    bottom = j-1;
                }else {
                    int block = map[j][i];
                    map[j][i] = -2;
                    map[bottom--][i] = block;
                }
            }
        }

    }
    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>= 0 && y<n;
    }

    static void erase(int x, int y, int color){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0, 0));
        boolean [][] visit = new boolean[n][n];
        visit[x][y] = true;
        // 빈칸 -> -2
        map[x][y] = -2;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            color = point.rainbowBlockCount;
            for(int i=0; i<4; i++){
                int next_x = point.x + dx[i];
                int next_y = point.y + dy[i];
                if(isPossible(next_x, next_y)){
                    if (!visit[next_x][next_y]
                            && (map[next_x][next_y] == color || map[next_x][next_y] == 0)) {
                        queue.add(new Point(next_x, next_y, 0, 0));
                        map[next_x][next_y] = -2;
                        visit[next_x][next_y] = true;
                    }
                }
            }
        }

    }


    static void bfs(int x, int y, int color){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0, 0));
        visited[x][y] = true;
        int blockCount = 0;
        int rainbowBlock = 0;
        while(!queue.isEmpty()){
            blockCount ++ ;
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int next_x = point.x + dx[i];
                int next_y = point.y + dy[i];
                if(isPossible(next_x, next_y)){
                    if(!visited[next_x][next_y]
                            && (map[next_x][next_y] == color || map[next_x][next_y] ==0)){
                        if(map[next_x][next_y] == 0){
                            rainbowBlock++;
                            queue.add(new Point(next_x, next_y, point.blockCount +1, rainbowBlock));
                            visited[next_x][next_y] = true;
                        }
                    }
                }
            }
        }
        if(blockCount>=2){
            area.add(new Point(x, y, blockCount, rainbowBlock));
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int blockCount;
        int rainbowBlockCount;

        public Point(int x, int y, int blockCount, int rainbowBlockCount) {
            this.x = x;
            this.y = y;
            this.blockCount = blockCount;
            this.rainbowBlockCount = rainbowBlockCount;
        }


        @Override
        public int compareTo(Point point) {
            if (this.blockCount > point.blockCount)
                return -1;
            else if(this.blockCount == point.blockCount){
                if(this.rainbowBlockCount > point.rainbowBlockCount){
                    return -1;
                }else if(this.rainbowBlockCount == point.rainbowBlockCount){
                    if(this.x > point.x){
                        return -1;
                    }else if(this.x == point.x){
                        return -1;
                    }else {
                        return 1;
                    }
                }else {
                    return 1;
                }
            }else {
                return 1;
            }
        }
    }





    static boolean checkValue(int x, int y, int x2, int y2){
        return (Math.abs(x-x2) + Math.abs(y-y2)) == 1;
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

// 아... ㅜㅜ

}


