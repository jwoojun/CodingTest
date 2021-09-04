package baek.brute_force.boj_1038;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/** The type Main. */
public class Main {
    /** The Decrease numbers. */
    static List<Long> decreaseNumbers = new ArrayList<>();

    /** The Input. */
    static Input input = new Input();
    /**
     * Main.
     *
     * @param args the args
     * @throws Exception the exception
     */
    public static void main(String args[]) throws Exception {
        for (int i = 0; i < 10; i++) {
            findDecreaseNumber(i, 1);
        }
        Collections.sort(decreaseNumbers);
        int n = input.integer();
        System.out.println(decreaseNumbers.get(n));

//

    }

    /**
     * Find decrease number.
     *
     * @param number the number
     * @param count the count
     */
    static void findDecreaseNumber(long number, int count) {
        if (count>10){
            return;
        }
        if (!decreaseNumbers.contains(number)) {
            decreaseNumbers.add(number);
        }
        for (int i=0; i<10; i++){
            if(number%10>i){
                findDecreaseNumber(number*10+i, count+1);
            }
        }
    }

    /** The type Input. */
    static class Input {
        /** The Br. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /** The St. */
        StringTokenizer st = new StringTokenizer("");
        /**
         * Integer int.
         *
         * @return the int
         */
        public int integer() throws Exception {
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    };

}
