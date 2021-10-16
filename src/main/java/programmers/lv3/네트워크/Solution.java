package programmers.lv3.네트워크;

public class Solution {
    static boolean[] visited;
    static int[][] connections;
    static int total;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        total = n;
        connections = computers;
        visited =new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int node) {
        for(int row=0; row<total; row++){
            for(int col=0; col<total; col++){
                if(row!=col && !visited[col] && connections[node][col]>0){
                    visited[col] = true;
                    dfs(col);
                }
            }
        }
    }

    public static void main(String[] args){
        int n = 3;
        int[][] connections = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution(n, connections));
    }

}
