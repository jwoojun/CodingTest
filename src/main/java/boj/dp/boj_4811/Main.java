package boj.dp.boj_4811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static long[][] dp;
  // dp가 표를 그려서 해결하기. dp[n] -->
  public static void main(String[] args) throws Exception {
    dp = new long[63][63];
    while (true){
      int pill = input.integer();;
      eat(pill, 0);
      if(pill==0){
        break;
      }
    }
  }

  static long eat(int w, int h){
    if(dp[w][h] != 0){
      return dp[w][h];
    }

    if(w==0) return 1;
    if(h == 0) return dp[w][h] = eat(w-1, h+1);
    else return dp[w][h] = eat(w, h-1) + eat(w-1, h+1);
  }

  static Input input = new Input();

  static class Input {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    public int integer() throws Exception {
      if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
      return Integer.parseInt(st.nextToken());
    }

    public String next() throws Exception {
      if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
      return st.nextToken();
    }
  }
}
