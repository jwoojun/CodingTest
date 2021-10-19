class Main{
    /**
     * Input
     * 원준님 Version. Great!
     * */
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
        public char[] nToCharArray() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken().toCharArray();
        }
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static boolean isPossible(int x, int y){
        return x>=0 && x<n && y>=- && y<m && !visited[n][m];
    }

    /**
     * 2차워 배열에서 최댓값 찾기_V1
     * 행, 열을 복사해서 사용했기 때문에 일반화된 상태
     * */
    static int getArrayMaxValue(int[][] array) {
        int value = 0;
        int row_last = array.length;
        int col_last = array[0].length;
        for(int row=0; row<row_last; row++){
            for(int col; col<col_last; col++){
                if(array[row][col]>value){
                    value = array[row][col];
                }
            }
        }
        return value;
    }

    /**
     * 2차워 배열에서 최댓값 찾기_V2
     * */
    static int getArrayMaxValue(int[] array) {
        return Arrays.stream(array).max().orElseThrow();
    }


    static void print() {
        for(int row=0; row<m; row++){
            System.out.println();
            for(int col=0; col<n; col++){
                System.out.print(visited[row][col]+" ");
            }
        }
    }

    /**
     * 문자열 초기화 Map<Integer, String>
     * 시작점을 0으로 했기 때문에 get으로 원소를 찾을 때는 0부터 넣으면 된다.
     * */
    static Map<Integer, String> repository = new HashMap<>();
    static void init(){
        for(int i=97; i<123; i++){
            repository.put(i-97, String.valueOf((char)i));
        }
    }
}