package baek.brute_force.boj_12851;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static int minTime = Integer.MAX_VALUE;
    static int count=0;
    static Queue<Integer> queue;
    static int[] time = new int[100001];
    public static void main(String[] args) throws Exception {
        n = input.integer();
        k = input.integer();
        if (n >= k) {
            System.out.println((n-k) + "\n1");
            return;
        }
        bfs();
        System.out.println(minTime + "\n" + count);
    }

    static void bfs(){
        queue  = new LinkedList<>();
        queue.add(n);
        time[n]=1;
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(minTime<time[current]){
                return;
            }
            for(int i=0; i<3; i++){
                int next;
                if(i == 0){
                    next = current +1;
                } else if(i==1){
                    next = current-1;
                }
                else {
                    next = current*2;
                }

                if(!isPossible(next)){
                    continue;
                }

                if(next == k){
                    minTime = time[current];
                    count++;
                }

                if(time[next] == 0 || time[next]==time[current]+1){
                    queue.add(next);
                    time[next] = time[current]+1;
                }
            }
        }
    }

    static boolean isPossible(int x){
        if(x<0 || x>100000){
            return false;
        }
        return true;
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
