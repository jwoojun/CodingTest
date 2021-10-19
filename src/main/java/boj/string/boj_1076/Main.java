package boj.string.boj_1076;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static String a, b, c;
    static Map<String, Registance> repository = new HashMap<>();

    static void init() throws Exception {
        repository.put("black", new Registance("black", 0, (long) Math.pow(10,0)));
        repository.put("brown", new Registance("brown", 1, (long) Math.pow(10,1)));
        repository.put("red", new Registance("red", 2, (long) Math.pow(10,2)));
        repository.put("orange", new Registance("orange", 3, (long) Math.pow(10,3)));
        repository.put("yellow", new Registance("yellow", 4, (long) Math.pow(10,4)));
        repository.put("green", new Registance("green", 5, (long) Math.pow(10,5)));
        repository.put("blue", new Registance("blue", 6, (long) Math.pow(10,6)));
        repository.put("violet", new Registance("violet", 7, (long) Math.pow(10,7)));
        repository.put("grey", new Registance("grey", 8, (long) Math.pow(10,8)));
        repository.put("white", new Registance("white", 9, (long) Math.pow(10,9)));

        a = input.next();
        b = input.next();
        c = input.next();
    }

    public static void main(String[] args) throws Exception {
        init();
        calculate(a, b, c);
    }

    private static void calculate(String a, String b, String c) {
        long result = (Long.parseLong(String.valueOf(repository.get(a).number)+ String.valueOf(repository.get(b).number)))*repository.get(c).value;
        System.out.println(result);
    }

    static class Registance {
        String name;
        int number;
        long value;

        public Registance(String name, int number, long value) {
            this.name = name;
            this.number = number;
            this.value = value;
        }
    }

    static Input input = new Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public char[] nToCharArray() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken().toCharArray();
        }
    }
}