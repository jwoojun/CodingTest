import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12886 {
    static int a;
    static int b;
    static int c;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] visited = new boolean[1501][1501];

        public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        divideWith3(a, b, c);

        Queue<Stone> q = new LinkedList<>();
        q.add(new Stone(a, b, c));
        visited[a][b] = true;


        while (!q.isEmpty()){
            Stone stone = q.poll();
            int x = stone.a;
            int y = stone.b;
            int z = stone.c;
            isAnswer(x, y, z);

            if (x != y) {
                int next_x = x > y ? x-y : x*2;
                int next_y = x > y ? y*2 : y-x;
                if (visitable(next_x, next_y)) {
                    q.add(new Stone(next_x, next_y, z));
                    visited[next_x][next_y] = true;
                }
            }

            if (x != z) {
                int next_x = x > z ? x-z : x*2;
                int next_z = x > z ? z*2 : z-x;
                if (visitable(next_x, next_z)) {
                    q.add(new Stone(next_x, y, next_z));
                    visited[next_x][next_z] = true;
                }
            }

            if (y != z) {
                int next_y = y > z ? y-z : y*2;
                int next_z = y > z ? z*2 : z-y;
                if (visitable(next_y, next_z)) {
                    q.add(new Stone(x, next_y, next_z));
                    visited[next_y][next_z] = true;
                }
            }
        }
        System.out.println(0);
        System.exit(0);

    }

    public static void divideWith3(int x, int y, int z) {
        if ((x + y + z) % 3 != 0) {
            System.out.println(0);
            System.exit(0);
        }
    }
    public static void isAnswer(int x, int y, int z){
        if (x==y && y ==z){
            System.out.println(1);
            System.exit(0);
        }
    }
    public static boolean visitable(int a, int b){
        return !visited[a][b];
    }

}

class Stone {
    int a;
    int b;
    int c;

    public Stone(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}