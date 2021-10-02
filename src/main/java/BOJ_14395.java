
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14395 {
      static long s;
      static long t;
      static String[] operator = {"*", "+", "-"};
      private static final Queue<Number> queue = new LinkedList<Number>();
      private static final HashSet<Long> set = new HashSet<>();

      public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        if (isEqual(s, t)) {
          System.out.println(0);
          return;
        }


        queue.add(new Number(s, ""));
        set.add(s);

        while (!queue.isEmpty()) {
                Number number = queue.poll();


                if (number.number == t) {
                  System.out.println(number.operation);
                  return;
                }

              if (over(number.number)) {
                  for (int i = 0; i < 3; i++) {
                      long next = valid(number.number, i);
                      if (next > t){
                          continue;
                      }
                        set.add(next);
                        queue.offer(new Number(next, number.operation + operator[i]));
                      }
                }
            }

            System.out.println(-1);
            br.close();
      }

          public static boolean over(long number){
            return number<=t;
          }
          public static boolean visitable(long number) {
            return number != -1 || !(set.contains(number));
          }

          public static boolean isEqual(long s, long t) {
            return s == t;
          }

          public static boolean isZero(long t) {
            return t == 0;
          }

          public static boolean isFirst(long t) {
            return t == 1;
          }

          public static long valid(long number, int i) {
            if (i == 0) {
              if (number * number > t) {
                return -1;
              }
              return number * number;
            } else {
              if (number * 2 > t) {
                return -1;
              }
              return number * 2;
            }
          }
}

class Number {
  long number;
  String operation;

  public Number(long number, String operation) {
    this.number = number;
    this.operation = operation;
  }
}