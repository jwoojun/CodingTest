package boj.string.boj_9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<String> brackets = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        init();
        check_bracket();
        System.out.println(sb);
    }

    private static void check_bracket() {
        for (String bracket : brackets) {
            if(hasEvenBracketCount(bracket) && hasSameBracketCount(bracket) &&
                    !hasInvalidStartAndEnd(bracket)){
                sb.append("YES").append("\n");
            }else {
                sb.append("NO").append("\n");
            }
        }
    }

    private static void init() throws Exception {
        n = input.integer();
        for (int i = 0; i < n; i++) {
            brackets.add(input.next());
        }
    }

    static boolean hasEvenBracketCount(String str){
        return str.length()%2 == 0;
    }

    static boolean hasSameBracketCount(String str){
        int bracketA = 0;
        int bracketB = 0;
        for(int i=0; i<str.length(); i++){
            if (str.charAt(i)=='(') bracketA+=1;
            else if(str.charAt(i)==')') bracketB+=1;
            if(bracketA<bracketB) return false;
        }
        return bracketA == bracketB;
    }

    static boolean hasInvalidStartAndEnd(String str){
        return str.charAt(0)==')' || str.charAt(str.length()-1)=='(';
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
        public char[] toCharArray() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken().toCharArray();
        }
    }
}
