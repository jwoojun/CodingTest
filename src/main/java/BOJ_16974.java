import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16974 {
      static int n;
      static long x;
      static long[] h;
      static long[] p;
      static StringTokenizer st;
      static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Long.parseLong(st.nextToken());
//        System.identityHashCode()

        h = new long[n + 1];
        p = new long[n + 1];
        h[0] = p[0] = 1;

        for (int i = 1; i <= n; i++) {
          h[i] = 1 + h[i - 1] + 1 + h[i - 1] + 1;
          p[i] = p[i - 1] + 1 + p[i - 1];
        }
        bw.write(getPatty(n, x)+"\n");
        bw.flush();
        bw.close();
        br.close();
      }

      private static long getPatty(int n, long x) {
        if (n == 0) {
         if (x == 1) {
            return 1;
          }
        }

        if (x == 1) {
          return 0;
        } else if (x <= 1 + h[n - 1]) {
          return getPatty(n - 1, x - 1);
        } else if (x == 1 + h[n - 1] + 1) {
          return p[n - 1] + 1;
        } else if (x <= 1 + h[n - 1] + 1 + h[n - 1]) {
          return p[n - 1] + 1 + getPatty(n - 1, x - (1 + h[n - 1] + 1));
        } else {
          return p[n - 1] + 1 + p[n - 1];
        }
      }
}
