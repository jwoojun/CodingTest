package boj.impl.boj_15662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Input input = new Input();
    static int t;
    static int k;
    static int [][] wheel;
    public static void main(String[] args) throws Exception {
        t=4;
        wheel = new int[t+1][8];

        for(int i=1; i<t+1;i++){
            for(int j=0; j<8; j++){
                wheel[i][j] = input.integer();
            }
        }

        for(int i=1; i<t+1;i++){
            for(int j=0; j<8; j++){
                System.out.print(wheel[i][j]);
            }
            System.out.println();
        }
//        k = input.integer();

    }
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }

    static class Command{
        int wheelNumber;
        int direction;

        public Command(int wheelNumber, int direction) {
            this.wheelNumber = wheelNumber;
            this.direction = direction;
        }
    }
}
