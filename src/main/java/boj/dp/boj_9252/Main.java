package boj.dp.boj_9252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
//https://gre-eny.tistory.com/98 참조
public class Main {
    static String alphabetA;
    static String alphabetB;
    static int [][] dp;
    public static void main(String[] args) throws Exception {
        alphabetA = input.next();
        alphabetB = input.next();
        dp = new int[alphabetA.length()+1][alphabetB.length()+1];
        for(int row=0; row<alphabetA.length(); row++){
            for(int col=0; col<alphabetB.length(); col++){
                if(alphabetA.charAt(row)==(alphabetB.charAt(col))){
                    dp[row+1][col+1] = dp[row][col]+1;
                }else {
                    dp[row+1][col+1] = Math.max(dp[row+1][col], dp[row][col+1]);
                }
            }
        }
        System.out.println(dp[alphabetA.length()][alphabetB.length()]);

        Stack<Character> stack = new Stack<>();
        int alphaAlength = alphabetA.length();
        int alphaBlength = alphabetB.length();
        while(alphaAlength>=1 && alphaBlength>=1){
            if(dp[alphaAlength][alphaBlength] == dp[alphaAlength-1][alphaBlength]){
                alphaAlength--;
            }else if(dp[alphaAlength][alphaBlength] == dp[alphaAlength][alphaBlength-1]){
                alphaBlength--;
            }else {
                stack.push(alphabetA.charAt(alphaAlength-1));
                alphaAlength--;
                alphaBlength--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }

    static void print() {
        for(int row=0; row<alphabetA.length()+1; row++){
            System.out.println();
            for(int col=0; col<alphabetB.length()+1; col++){
                System.out.print(dp[row][col] + " ");
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
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
