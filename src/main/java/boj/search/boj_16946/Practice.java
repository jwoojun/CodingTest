package boj.search.boj_16946;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Practice {
    static int n;
    static int m;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static int groupNo = 2;
    static HashMap<Integer, Integer> groupMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        init();
        makeGroup();
        plusValue();
        System.out.println(sb);
    }

    private static void init() throws Exception {
        n = input.integer();
        m = input.integer();
        board = new int[n][m];

        for (int row = 0; row < n; row++) {
            char[] temp = input.next().toCharArray();
            for (int col = 0; col < m; col++) {
                board[row][col] = temp[col] - '0';
            }
        }
    }

    static void plusValue() {
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(isWall(row, col)){
                    int result = 1;
                    Set<Integer> set = new HashSet<>();
                    for(int dir=0; dir<4; dir++){
                        int next_x = row + dx[dir];
                        int next_y = col + dy[dir];
                        if(moveable(next_x, next_y) && hasGroup(next_x, next_y)
                                && !containsGroupNo(set, next_x, next_y)){
                            set.add(board[next_x][next_y]);
                            result+=groupMap.get(board[next_x][next_y]);
                        }
                    }
                    sb.append(result%10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
    }

    static void makeGroup(){
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(isBlank(row, col)){
                    bfs(row, col);
                }
            }
        }
    }

    static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        board[x][y] = groupNo;
        int groupCount = 1;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int dir=0; dir<4; dir++){
                int next_x = point.x + dx[dir];
                int next_y = point.y + dy[dir];
                if(moveable(next_x, next_y) && isBlank(next_x, next_y)){
                    board[next_x][next_y] = groupNo;
                    groupCount++;
                    queue.add(new Point(next_x, next_y));
                }
            }
        }
        groupMap.put(groupNo, groupCount);
        groupNo++;
    }

    static boolean moveable(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }

    static boolean isBlank(int x, int y){
        return board[x][y] == 0;
    }

    static boolean isWall(int x, int y){
        return board[x][y] == 1;
    }

    static boolean hasGroup(int x, int y){
        return board[x][y] > 1;
    }

    static boolean containsGroupNo(Set<Integer> set, int x, int y){
        return set.contains(board[x][y]);
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void print(){
        for(int row=0; row<n; row++){
            System.out.println();
            for(int col=0; col<m; col++){
                System.out.print(board[row][col]+" ");
            }
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

