package boj.graph.boj_1062;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class False {
    static int n, k;
    static int basicWords = 5;
    static Map<Character, Character> map = new HashMap<>();
    static List<String> lst = new ArrayList<>();
    static List<Character> alpha = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        init();
        canFinish();
        dfs(0);
        System.out.println(answer);
    }

    static void init() throws Exception {
        for (char i = 'a'; i < 'z'; i++) {
            alpha.add(i);
        }
        n = input.integer();
        k = input.integer();
        map.put('a', 'a');
        map.put('n', 'n');
        map.put('t', 't');
        map.put('c', 'c');
        map.put('i', 'i');
        for (int i = 0; i < n; i++) {
            lst.add(input.next());
        }
    }

    private static void canFinish(){
        if(k<5) {
            System.out.println(0);
            System.exit(0);
        }

        if(k==26){
            System.out.println(n);
            System.exit(0);
        }
    }

    static void dfs(int count) {
        if (basicWords + count == k) {
            int temp = 0;
            for (String word : lst) {
                boolean learnable = true;
                int len = word.length();
                String w = word;
                for (int j = 0; j < len; j++) {
                    if (!map.containsKey(w.charAt(j))) {
                        learnable = false;
                        break;
                    }
                }
                if (learnable) {
                    temp++;
                }
            }
            answer = Math.max(answer, temp);
            return;
        }

        for (Character character : alpha) {
            if (!map.containsKey(character)) {
                map.put(character, character);
                dfs(count + 1);
                map.remove(character, character);
            }
        }
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public String next() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public char[] nToCharArray() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken().toCharArray();
        }
    }
}

//    static void print() {
//        for(int row=0; row<m; row++){
//            System.out.println();
//            for(int col=0; col<n; col++){
//                System.out.print(visited[row][col]+" ");
//            }
//        }
//    }

//7 9
//antarotica
//antajapwtica
//antarnlhtica
//antavfytica
//antarwtica
//antaltica
//antantica
//답 : 4
//출력 : 3