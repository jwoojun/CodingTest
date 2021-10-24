//package boj.impl.boj_12904;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    enum Direction {
//        NORTH, EAST, SOUTH, WEST;
//    }
//    static  int n;
//    static int[] dx = {0, 1, 0, -1};
//    static int[] dy = {-1, 0, 1, 0};
//    static int answer = Integer.MIN_VALUE;
//    static Block[][] board;
//    static boolean[][] visited;
//    static Map<Integer, Integer> maxRepository = new HashMap<>();
//    public static void main(String[] args) throws Exception {
//        n = input.integer();
//        board = new Block[n][n];
//        visited = new boolean[n][n];
//        for(int i=0; i<11; i++){
//            maxRepository.put(i, (int)Math.pow(2, i));
//        }
//
//        for(int row=0; row<n; row++){
//            for(int col=0; col<n; col++){
//                int value = input.integer();
//                board[row][col] = new Block(row, col, value, false);
//                if(board[row][col].value != 0) {
//                    visited[row][col] = true;
//                }
//            }
//        }
//    }
//
//    static boolean checkPrevious(Block[][] current, int[][] previous){
//        for(int row=0; row<n; row++){
//            for(int col=0;col<n; col++){
//                if(previous[row][col] != current[row][col].value){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    static void backTracking(int k, Block[][] board){
//        int currentMax = getMax();
//        if(currentMax <= maxRepository.get(k)){
//            return;
//        }
//
//        if(k==10){
//            answer = Math.max(answer, currentMax);
//            int value = answer;
//            while(k-->0){
//                maxRepository.put(k, value);
//                value/=2;
//            }
//        }else{
//            for(int direction=0; direction<4; direction++){
//
//            }
//        }
//    }
//    static int[][] pushLeft(int[][] board) {
//        Queue<Integer> queue = new LinkedList<>();
//        int[][] newMap = new int[n][n];
//
//        for(int row=0; row<n; row++){
//            for(int col=0; col<n; col++){
//
//            }
//            int index = 0;
//            while(!queue.isEmpty()){
//                int value = queue.poll();
//                if(newMap[row][index] == 0){
//                    newMap[row][index] = value;
//                }
//            }
//        }
//        return null;
//    }
//
//    static int[][] move(Block[][]board, int direction){
//        int [][] afterMove = copy(board);
//        switch (direction) {
//            case 0:
//                afterMove = pushLeft(afterMove);
//                break;
//            case 1:
//                afterMove = pushRight(afterMove);
//                break;
//            case 2 :
//                afterMove = rotateClockwise(afterMove);
//                afterMove = pushRight(afterMove);
//                afterMove = rotateCounterClockwise(afterMove);
//                break;
//            case 3 :
//                afterMove = rotateClockwise(afterMove);
//                afterMove = pushLeft(afterMove);
//                afterMove = rotateCounterClockwise(afterMove);
//                break;
//        }
//        return afterMove;
//    }
//
//    private static int[][] rotateCounterClockwise(int[][] afterMove) {
//        int[][] temp = new int[n][n];
//        for(int row=0; row<n; row++){
//            for(int col=0; col<n; col++){
//                temp[row][col] = afterMove[n-1-col][]
//            }
//        }
//        return new int[0][];
//    }
//
//    private static int[][] rotateClockwise(int[][] afterMove) {
//        return new int[0][];
//    }
//
//    private static int[][] pushRight(int[][] afterMove) {
//        return new int[0][];
//    }
//
//
//    private static void dfs(int count) {
//        if(count == 10){
//            findMaxBlock();
//            return;
//        }else {
//            for (int direction = 0; direction < 4; direction++) {
//                for(int row=0; row<n; row++){
//                    for(int col=0; col<n; col++){
//                        if(direction==0 && visited[row][col]){
//                            Block block = board[row][col];
//                            block.pushNorth(row, col, 0);
//
//                        }else if(direction==1 && visited[row][col]){
//                            Block block = board[row][col];
//                            block.pushRight(row, col, 1);
//                        }else if(direction==2 && visited[row][col]){
//                            Block block = board[row][col];
//                            block.pushSouth(row, col, 2);
//                        }else if(direction==3 && visited[row][col]){
//                            Block block = board[row][col];
//                            block.pushLeft(row, col, 3);
//                        }
//                    }}
//            }
//        }}
//
//    public static void start(int count) {
//        if(count == 10) {
//            findMaxBlock();
//            return;
//        }
//        int[][] copy = copy();
//
//        for(int direction=0; direction<4; direction++){
//            move(direction);
//            start(count+1);
//        }
//    }
//
//
//
//    static int[][] copy(int[][] board) {
//        int[][] copy = new int[n][n];
//        for(int row=0; row<n; row++){
//            for(int col=0; col<n; col++){
//                copy[row][col] = board[row][col];
//            }
//        }
//        return copy;
//    }
//
//    static void findMaxBlock(){
//        for(int row=0; row<n; row++){
//            for(int col=0; col<n; col++){
//                if(board[row][col]!=null){
//                    answer = Math.max(answer, board[row][col].value);
//                }
//            }
//        }
//    }
//
//    static boolean moveable(int x, int y){
//        return  x>=0 && x<n && y>=0 && y<n;
//    }
//
//    static class Block {
//        int x, y;
//        int value;
//        boolean merge;
//
//        public Block(int x, int y, int value, boolean merge) {
//            this.x = x;
//            this.y = y;
//            this.value = value;
//            this.merge = merge;
//        }
//
//        @Override
//        public String toString() {
//            return value +"";
//        }
//
//        void pushNorth(int x, int y, int direction) {
//            if(x==0) return;
//            int next_x = x + dy[direction];
//            int next_y = y + dx[direction];
//            if (moveable(next_x, next_y) && !visited[x][y] ) {
//                board[next_x][next_y] = board[x][y];
//                board[x][y] = null;
//                visited[x][y] = false;
//                visited[next_x][next_y] = true;
//            } else {
//                if (moveable(next_x, next_y) && visited[x][y] && board[next_x][next_y] != null && !board[next_x][next_y].merge) {
//                    board[next_x][next_y].value += board[x][y].value;
//                    board[x][y] = null;
//                    board[next_x][next_y].merge = true;
//                    visited[x][y] = false;
//                }
//            }
//        }
//
//        void pushRight(int x, int y,  int direction) {
//            if(y==n-1) return;
//            int next_x = x + dy[direction];
//            int next_y = y + dx[direction];
//            if (moveable(next_x, next_y)  && !visited[x][y]) {
//                board[next_x][next_y] = board[x][y];
//                board[x][y] = null;
//                visited[x][y] = false;
//                visited[next_x][next_y] = true;
//            } else {
//                if (moveable(next_x, next_y) && visited[x][y] && board[next_x][next_y] != null && !board[next_x][next_y].merge) {
//                    board[next_x][next_y].value += board[x][y].value;
//                    board[x][y] = null;
//                    board[next_x][next_y].merge = true;
//                    visited[x][y] = false;
//                }
//            }
//        }
//
//        void pushSouth(int x, int y,  int direction) {
//            if(x==n-1) return;
//            int next_x = x + dy[direction];
//            int next_y = y + dx[direction];
//            if (moveable(next_x, next_y)  && !visited[x][y]) {
//                board[next_x][next_y] = board[x][y];
//                board[x][y] = null;
//                visited[x][y] = false;
//                visited[next_x][next_y] = true;
//            } else {
//                if (moveable(next_x, next_y) && visited[x][y] && board[next_x][next_y] != null && !board[next_x][next_y].merge) {
//                    board[next_x][next_y].value += board[x][y].value;
//                    board[x][y] = null;
//                    board[next_x][next_y].merge = true;
//                    visited[x][y] = false;
//
//                }
//            }
//        }
//
//        void pushLeft(int x, int y,  int direction) {
//            if(y==0) return;
//            int next_x = x + dy[direction];
//            int next_y = y + dx[direction];
//            if (moveable(next_x, next_y)  && !visited[x][y]) {
//                board[next_x][next_y] = board[x][y];
//                board[x][y] = null;
//                visited[x][y] = false;
//                visited[next_x][next_y] = true;
//            } else {
//                if (moveable(next_x, next_y) && visited[x][y] && board[next_x][next_y] != null && !board[next_x][next_y].merge) {
//                    board[next_x][next_y].value += board[x][y].value;
//                    board[x][y] = null;
//                    board[next_x][next_y].merge = true;
//                    visited[x][y] = false;
//                }
//            }
//        }
//    }
//
//    static Input input = new Input();
//    static class Input {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer("");
//        public int integer() throws Exception{
//            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
//            return Integer.parseInt(st.nextToken());
//        }
//        public String next() throws Exception{
//            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
//            return st.nextToken();
//        }
//        public char[] nToCharArray() throws Exception{
//            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
//            return st.nextToken().toCharArray();
//        }
//
//    }
//
//    static void print() {
//        for(int row=0; row<n; row++){
//            System.out.println();
//            for(int col=0; col<n; col++){
//                System.out.print(board[row][col]+" ");
//            }
//        }
//    }
//
//}
