package boj.string.boj_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Input intput = new Input();
    static String words;
    static String word;
    static int start = 0;
    static int answer = 0;
    static int end = 0;
    public static void main(String args []) throws IOException {
        words = intput.br.readLine();
        word = intput.br.readLine();
        end = words.length()-word.length();

        while(start<=end){
            if(words.substring(start, start+word.length()).equals(word)){
                answer++;
                start+=word.length();
            }
            start++;
        }
        System.out.println(answer);
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
