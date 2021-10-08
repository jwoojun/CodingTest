package boj.impl.boj_16935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int r;
    static int[][] map;
    static Input input = new Input();
    static int[][] case1;
    static int[][] case3;
    public static void main(String args []) throws Exception {
        n = input.integer();
        m = input.integer();
        r = input.integer();
        case1 = new int[n][m];
        map = new int [n][m];
        case3 = new int [m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = input.integer();
            }
        }
        int k = input.integer();
        if(k==1){
            isCase1();
        }
        else if(k==2){
            isCase2();
        }
        else if(k==3){
            isCase3();
        }
        else if(k==4){
            isCase4();
        }
        else if(k==5){
            isCase5();
        }
        else if(k==6){
            isCase6();
        }
        System.exit(0);

    }

    static void isCase1() throws Exception {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                case1[i][j] = map[n-1-i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(case1[i][j]+" ");
            }
            if (i != n - 1) {
                System.out.println();
            }
        }
    }

    static void isCase2() throws Exception {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                case1[i][j] = map[i][m-1-j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(case1[i][j]+" ");
            }
            if (i != n - 1) {
                System.out.println();
            }
        }
    }

    static void isCase3() throws Exception {
        for(int i=0; i<m; i++){
            for(int j=0; j<=n-1; j++){
                case3[i][j] = map[n-1-j][i];
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(case3[i][j]+" ");
            }
            if (i != m - 1) {
                System.out.println();
            }
        }
    }

    static void isCase4() throws Exception {
        for(int i=0; i<case3.length; i++){
            for(int j=0; j<case3[0].length; j++){
                case3[i][j] = map[j][i];
            }
        }

        for(int i=case3.length-1; i>=0; i--){
            for(int j=0; j<case3[0].length; j++){
                if(j != case3[0].length-1)
                    System.out.print(case3[i][j]+" ");
            }
            if (i != m - 1) {
                System.out.println();
            }
        }
    }

    static void isCase5() throws Exception {
        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                case1[i][j+m/2] = map[i][j];
            }
        }

        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                case1[i+n/2][j+m/2] = map[i][j+m/2];
            }
        }


        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                case1[i+n/2][j] = map[i+n/2][j+m/2];
            }
        }

        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                case1[i][j] = map[i+n/2][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(case1[i][j]+" ");
            }
            if (i != n - 1) {
                System.out.println();
            }
        }

    }

    static void isCase6() throws Exception {
        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                case1[i+n/2][j] = map[i][j];
            }
        }

        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                case1[i+n/2][j+m/2] = map[i+n/2][j];
            }
        }


        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                case1[i][j+m/2] = map[i+n/2][j+m/2];
            }
        }

        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                case1[i][j] = map[i][j+m/2];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(case1[i][j]+" ");
            }
            if (i != n - 1) {
                System.out.println();
            }
        }

    }

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
    }

}
