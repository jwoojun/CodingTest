package data_structure.kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int [] parent;
    public static void main(String args []){

    }


    public static int findParent(int number){
            if(parent[number] != number){
                return findParent(parent[number]);
            }
            return parent[number];
    }

    public static void unionParent(int valueA, int valueB){
        int a = findParent(valueA);
        int b = findParent(valueB);
        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    public static void initParent(int n){
        for(int i=0; i<n+1; i++){
            parent[i] = i;
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
