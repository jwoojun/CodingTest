package baek.brute_force.boj_11502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Input input = new Input();
    static List<Integer> primeNumbers = new ArrayList<>();
    static int t;
    public static void main(String args []) throws Exception {
        findPrimeNumbers();
        t = input.integer();

        for (int i = 0; i < t; i++) {
            isPrime(input.integer());
        }
    }
    static void isPrime(int expectedNumber) {
        for(int i=0; i<primeNumbers.size(); i++){
            for(int j=0; j<primeNumbers.size(); j++){
                if(primeNumbers.get(i)+primeNumbers.get(j)>expectedNumber){
                    continue;
                }
                for (Integer primeNumber : primeNumbers) {
                    if (primeNumbers.get(i) + primeNumbers.get(j) + primeNumber <= expectedNumber) {
                        if (primeNumbers.get(i) + primeNumbers.get(j) + primeNumber == expectedNumber) {
                            System.out.println(primeNumbers.get(i) + " " + primeNumbers.get(j) + " " + primeNumber);
                            return;
                        }

                    }
                }
            }
        }
        System.out.println(0);
    }

    static void findPrimeNumbers() {
        int [] numbers = new int[ 1001];
        for(int i=2; i<1001; i++){
            numbers[i] = i;
        }

        for(int i=2; i<=(int) Math.sqrt(1001)+1; i++){
            for(int j=2; i*j<1001; j++){
                numbers[i*j] = 0;
            }
        }

        for(int i=2; i<1001; i++){
            if (numbers[i] != 0){
                primeNumbers.add(numbers[i]);
            }
        }
    }

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    };
}
