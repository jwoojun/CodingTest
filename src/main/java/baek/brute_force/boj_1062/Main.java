package baek.brute_force.boj_1062;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, ans;
    static boolean words[][];
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        for(int mask=0; mask<1<<21; mask++){
            System.out.println(mask);
        }
//        n = input.integer();
//        k = input.integer();
//        words = new boolean[n][26];
//        visited = new boolean[26];
//        canFinish();
//        for(int i=0; i<n; i++){
//            String temp = input.br.readLine();
//            for(int j=0; j<temp.length(); j++){
//                words[i][temp.charAt(j)-'a'] = true;
//            }
//        }
//        ans = 0;
//        solve(0, 0);
//        System.out.print(ans);



    }
    private static void canFinish(){
        if(k<5) {
            System.out.println(ans);
            System.exit(0);
        }

        if(k==26){
            System.out.println(n);
            System.exit(0);
        }

    }

    private static void solve(int index, int depth){
        if(depth == k){
            check();
            return;
        }

        for(int i=index; i<26; i++){
            if(!visited[i]){
                visited[i]= true;
                solve(i, depth+1);
                visited[i] = false;
            }
        }
    }

    private static void check(){
        int count = 0;

        for(int i=0;i<n; i++){
            boolean learnAble = true;
            for(int j=0; j<26;j++){
                if(words[i][j] && !visited[j]){
                    learnAble = false;
                    break;
                }
            }
            if(learnAble){
                count++;
            }
            ans = Math.max(count, ans);
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
    }
}
