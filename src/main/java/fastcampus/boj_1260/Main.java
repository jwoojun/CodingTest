package fastcampus.boj_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][];
    static boolean[] visit;
    static int n, m, v;

    static void dfs(int i) {
        visit[i] = true;
        System.out.print(i + " ");
        for (int j = 1; j < n + 1; j++) {
            if (map[i][j] == 1 && !visit[j]) {
                dfs(j);
            }
        }
    }

    static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i);
        visit[i] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");
            for (int k = 1; k < n+1; k++) {
                if (map[temp][k] == 1 && !visit[k]) {
                    queue.offer(k);
                    visit[k] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        for (int j = 0; j < n + 1; j++) {
            Arrays.fill(map[j], 0);
        }

        Arrays.fill(visit, false);
        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        dfs(v);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(v);
    }
}
