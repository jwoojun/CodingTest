package programmers.가장먼노드;

import java.util.*;

public class Solution {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int[][] board;

    public static int solution(int n, int[][] edge) {
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] ints : edge) {
            int nodeA = ints[0] - 1;
            int nodeB = ints[1] - 1;
            map.get(nodeA).add(nodeB);
            map.get(nodeB).add(nodeA);
            board[nodeA][nodeB] = 1;
            board[nodeB][nodeA] = 1;
        }
        return bfs(0, n);
    }

    static int bfs(int start, int n) {
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        boolean[] visited = new boolean[n];
        deque.add(start);
        visited[start] = true;
        while (true) {
            Deque<Integer> temp = new LinkedList<>();
            while (!deque.isEmpty()) {
                int value = deque.poll();
                for (int node : map.get(value)) {
                    if (!visited[node]) {
                        temp.add(node);
                        visited[node] = true;
                    }
                }
            }
            if (temp.isEmpty()) break;
            result = temp.size();
            deque.addAll(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, vertex));
    }

    static class Point {
        int no;
        int x;
        int y;

        public Point(int no, int x, int y) {
            this.no = no;
            this.x = x;
            this.y = y;
        }

    }
}
