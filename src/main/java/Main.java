import java.util.Optional;

import static java.lang.System.out;

public class Main {
    public static int[] d;

    public static int go(int n) {
        if (n == 1) {
            return 0;
        }
        d[n] = go(n - 1) + 1;

        if (n % 2 == 0) {
            int temp = go(n - 2) + 1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }
        if (n % 3 == 0) {
            int temp = go(n / 3) + 1;
            if (d[n] > temp) {
                d[n] = temp;
            }
            ;
        }
        return d[n];
    }
    public static void main(String args []){
        String a = null;
        Optional.ofNullable(a)
                .ifPresentOrElse(out::println, NullPointerException::new);

    }

}
