package programmers.네트워크;

class Solution2 {
    static boolean[] visited ;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited =new boolean[n];
        for(int i=0; i<n; i++){
            for (int j = 0; j < n; j++) {
                if (!visited[i] && computers[i][j]!=0) {
                    dfs(i,n, computers);
                    answer++;
                }
            }
        }
        return answer;
    }

    static void dfs(int row, int total, int[][] computers){
        visited[row] = true;
        for(int i=0; i<total; i++){
            if(!visited[i] && computers[row][i] == 1){
                dfs(i, total, computers);
            }
        }
    }
}