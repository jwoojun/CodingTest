class Main{
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=- && y<m && !visited[n][m];
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