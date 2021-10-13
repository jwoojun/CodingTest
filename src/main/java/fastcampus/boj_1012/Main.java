package fastcampus.boj_1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int k;
    static int t;
    static int[][] board;
    static boolean[][] visited;
    static int result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        t = input.integer();
        while (t--> 0) {
            init();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col] == 1 && !visited[row][col]) {
                        result++;
                        visited[row][col] = true;
                        bfs(row, col);
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void init() throws Exception {
        m = input.integer();
        n = input.integer();
        k = input.integer();
        board = new int[m][n];
        visited = new boolean[m][n];
        result = 0;
        for (int j = 0; j < k; j++) {
            int x = input.integer();
            int y = input.integer();
            board[x][y] = 1;
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int next_x = point.x + dx[i];
                int next_y = point.y + dy[i];
                if (moveable(next_x, next_y)) {
                    visited[next_x][next_y] = true;
                    queue.add(new Point(next_x, next_y));
                }
            }
        }
    }

    static boolean moveable(int x, int y){
        return x>=0 && x<m && y>=0 && y<n && board[x][y] == 1 && !visited[x][y];
    }

    static class Point {
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
    }
}
