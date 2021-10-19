//package boj.search.boj_9663;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Practice {
//
//    static int n;
//    static int result = 0;
//    static boolean[][] board;
//    static boolean[] columns;
//    public static void main(String[] args) throws Exception {
//        init();
//        dfs(0);
//        System.out.println(result);
//    }
//
//    static void init() throws Exception {
//        n = input.integer();
//        board = new boolean[n][n];
//        columns = new boolean[n];
//    }
//
//    static void dfs(int row){
//        if(row==n){
//            result++;
//            return;
//        }
//
//        for(int i=0; i<n; i++){
//            columns[ro]
//        }
////        for(int col=0; col<n; col++){
////            if(check(row, col)){
////                columns[col] = true;
////                board[row][col] = true;
////                dfs(row+1);
////                columns[col] = false;
////                board[row][col] = false;
////            }
////        }
//    }
//
//    static boolean check(int row, int col){
//        if(columns[col]) return false;
//
//
//        return true;
//    }
//
//    static boolean moveable(int x, int y){
//        return x>=0 && x<n && y>=0 && y<n;
//    }
//
//    static void print() {
//        for(int row=0; row<n; row++){
//            System.out.println();
//            for(int col=0; col<n; col++){
//                System.out.print(board[row][col] +" ");
//            }
//        }
//        System.out.println();
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
//    }
//}
