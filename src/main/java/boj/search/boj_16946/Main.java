package boj.search.boj_16946;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static int[] dx = {1, -1,0, 0};
    static int [] dy = {0,0, 1, -1};
    static int groupNo = 2;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        board = new int[n][m];

        for(int row=0; row<n; row++){
            char[] temp = input.next().toCharArray();
            for(int col=0; col<m; col++){
                board[row][col] = temp[col] - '0';
            }
        }

        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(board[row][col] ==  0){
                    bfs(row, col);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int row=0; row<n; row++){
            for(int column=0; column<m; column++){
                if(board[row][column] == 1){
                    int result = 1;
                    Set<Integer> groupSet = new HashSet<>();
                    for(int i=0; i<4; i++){
                        int next_x = row + dx[i];
                        int next_y = column + dy[i];
                        if(isPossible(next_x, next_y) && board[next_x][next_y]>1 && !groupSet.contains(board[next_x][next_y])){
                            groupSet.add(board[next_x][next_y]);
                            result += map.get(board[next_x][next_y]);
                        }
                    }
                    sb.append(result%10);
                }
                else sb.append(0);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y){
        int groupCount = 0 ;
        board[x][y] = groupNo;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()){
            Point point = queue.poll();
            groupCount++;
            for(int i=0; i<4; i++){
                int next_x = point.x + dx[i];
                int next_y = point.y + dy[i];
                if(isPossible(next_x, next_y) && board[next_x][next_y]==0){
                    board[next_x][next_y] = groupNo;
                    queue.add(new Point(next_x, next_y));
                }

            }
        }
        map.put(groupNo, groupCount);
        groupNo++;
    }

    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Input input = new Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
