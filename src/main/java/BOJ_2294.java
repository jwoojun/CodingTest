import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2294 {
    static int n;
    static int k;
    static int [] coins;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args []) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n+1; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void overValue(){

    }


}
