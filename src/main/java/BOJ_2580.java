//
//import java.util.*;
//
//class Main {
//  static StringTokenizer stringTokenizer = new StringTokenizer("");
//  static HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
//  static Node[] station = new Node[200001];
//
//  public int solve(String[] subway,int st,int ed){
//    int idx = 1;
//    for(String s : subway){
//      stringTokenizer = new StringTokenizer(s);
//      while(stringTokenizer.hasMoreElements()){
//        int a = Integer.parseInt(stringTokenizer.nextToken());
//        if(map.containsKey(a)){
//          map.get(a).add(idx);
//        }
//        else{
//          ArrayList<Integer> temp = new ArrayList<>();
//          temp.add(idx);
//          map.put(a,temp);
//        }
//      }
//      idx++;
//    }
//    for(int i=1;i<idx;i++){
//      station[i] = new Node(i);
//    }
//
//    // 환승역이 아니기때문에
//    int start = map.get(st).get(0);
//    int end = map.get(ed).get(0);
//
//    for (Map.Entry<Integer, ArrayList<Integer>> next : map.entrySet()) {
//      // 환승역이라면?
//      if (next.getValue().size() > 1) {
//        for (int i = 0; i < 1 << next.getValue().size(); i++) {
//          if (Integer.bitCount(i) == 2) {
//            ArrayList<Integer> temp = new ArrayList<>();
//            for (int j = 0; j < next.getValue().size(); j++) {
//              if ((i & (1 << j)) > 0) {
//                temp.add(j);
//              }
//            }
//            station[next.getValue().get(temp.get(0))].next.add(station[next.getValue().get(temp.get(1))]);
//            station[next.getValue().get(temp.get(1))].next.add(station[next.getValue().get(temp.get(0))]);
//          }
//        }
//      }
//    }
//
//    boolean[] ch = new boolean[200001];
//    ch[start] = true;
//    Queue<Pair> q = new LinkedList<>();
//    q.add(new Pair(start,0));
//
//    while(!q.isEmpty()){
//      Pair p = q.poll();
//
//      if(p.x == end){
//        return p.cnt;
//      }
//
//      for(Node nextStation : station[p.x].next){
//        if(!ch[nextStation.idx]){
//          q.add(new Pair(nextStation.idx,p.cnt+1));
//        }
//      }
//
//    }
//
//    return 0;
//  }
//  static class Pair{
//    int x;
//    int cnt;
//
//    public Pair(int x, int cnt) {
//      this.x = x;
//      this.cnt = cnt;
//    }
//  }
//
//  static class Node{
//    int idx;
//    ArrayList<Node> next = new ArrayList<>();
//
//    public Node(int idx) {
//      this.idx = idx;
//    }
//  }
//
//  public static void main(String[] args) {
//    Main main = new Main();
//    System.out.println(main.solve(new String[]{"1 2 3 4 5 6 7 8",
//            "2 11",
//            "0 11 10",
//            "3 17 19 12 13 9 14 15 10",
//            "20 2 21"},1,8));
//  }
//
//}
//
////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.util.ArrayList;
////
////public class BOJ_2580 {
////
////  static int matrix[][] = new int[9][9];
////  static ArrayList<int[]> empty_position = new ArrayList<>();
////  //    static ArrayList<Position> lst = new ArrayList<>();
////
////  public static void main(String args[]) throws IOException {
////      make_board();
////
////
////  }
////
////  static void make_board() throws IOException {
////    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
////    for (int i = 0; i < 9; i++) {
////      for (int j = 0; j < 9; j++) {
////        matrix[i][j] = Integer.parseInt(bf.readLine());
////        if (matrix[i][j] == 0) {
////          empty_position.add(new int[] {i, j});
////        }
////      }
////    }
////  }
////}
////
////class Position {
////  int x;
////  int y;
////
////  public Position(int x, int y) {
////    this.x = x;
////    this.y = y;
////  }
////}
