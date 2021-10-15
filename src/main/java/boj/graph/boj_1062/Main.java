package boj.graph.boj_1062;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean[] learnd = new boolean[26];
    static boolean[][] words;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        init();
        canFinish();
        dfs(0, 0);
        System.out.println(answer);
    }

    static void init() throws Exception {
        n = input.integer();
        k = input.integer();
        words = new boolean[n][26];

        for (int i = 0; i < n; i++) {
            String word = input.next();
            for (int j = 0; j < word.length(); j++) {
                words[i][word.charAt(j) - 'a'] = true;
            }
        }
    }

    private static void canFinish() {
        if(k<5) {
            System.out.println(0);
            System.exit(0);
        }

        if(k==26){
            System.out.println(n);
            System.exit(0);
        }
    }

    static void dfs(int index, int count) {
        if (count == k) {
            check();
            return;
        }

        for (int alpha= index; alpha<26; alpha++) {
            if (!learnd[alpha]) {
                learnd[alpha] = true;
                dfs(alpha+1, count+1);
                learnd[alpha] = false;
            }
        }
    }

    private static void check() {
        int count = 0;
        for (int i=0; i<n; i++) {
            boolean learnable = true;
            for (int j = 0; j < 26; j++) {
                if (words[i][j] && !learnd[j]) {
                    learnable = false;
                    break;
                }
            }
            if (learnable) {
                count++;
            }
        }
        answer = Math.max(answer, count);
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