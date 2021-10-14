package boj.dp.boj_9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Map<Integer, Integer> repository = new HashMap<>();
    public static void main(String[] args) throws Exception {
        init();
        while (n-- > 0) {
            int number = input.integer();
            System.out.println(calculate(number - 1));
        }
    }

    static void init() throws Exception {
        n = input.integer();
        repository.put(0, 1);
        repository.put(1, 2);
        repository.put(2, 4);
    }

    static int calculate(int number){
        if(repository.containsKey(number)){
            return repository.get(number);
        }
        for(int i=3; i<number+1; i++){
            repository.putIfAbsent(i, repository.get(i-3)+repository.get(i-2)+repository.get(i-1));
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
