package boj.dp.boj_2748;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Map<Integer, Long> repository = new HashMap<>();

    public static void main(String[] args) throws Exception {
        n = input.integer();
        init();
        System.out.println(calculateFibo(n%1000000007));
    }

    static void init() {
        repository.put(0, 0L);
        repository.put(1, 1L);
    }

    static long calculateFibo(int number) {
        if(repository.containsKey(number)){
            return repository.get(number);
        }
        for(int i=0; i<number; i++){
            repository.putIfAbsent(i+2, repository.get(i) + repository.get(i+1));
        }
        return repository.get(number);
    }

    static Input input = new Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
