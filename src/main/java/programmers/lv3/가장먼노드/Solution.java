package programmers.lv3.가장먼노드;

import jnr.ffi.annotations.In;

import java.util.*;

public class Solution {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<edge.length; i++){
            int nodeA = edge[i][0]-1;
            int nodeB = edge[i][1]-1;
            map.get(nodeA).add(nodeB);
            map.get(nodeB).add(nodeA);
        }
        answer = bfs(0, n);
        return  answer;
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

}
