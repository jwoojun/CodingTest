//package programmers.lv3.가장먼노드;

//import java.util.Arrays;
//class Solution2 {
//    static Edges[] e;
//    public int solution(int n, int[][] edge) {
//        e= new Edges[n+1];
//        boolean[] visited = new boolean[n+1];
//        int[] dist = new int[n+1];
//        int distMax = Integer.MIN_VALUE;
//
//        Arrays.fill(dist,Integer.MAX_VALUE-1);
//        dist[1] = 0;
//        for(int i=1;i<=n;i++)
//            e[i] = new Edges();
//
//        for(int[] ed : edge){
////            e[ed[0]].set.add(ed[1]);
////            e[ed[1]].set.add(ed[0]);
//        }
//
//
//        for(int i=1;i<=n;i++){
//
//            int min = Integer.MAX_VALUE;
//            int idx = -1;
//
//            for(int j=1;j<=n;j++){
//
//                if(min > dist[j] && !visited[j]){
//                    min = dist[j];
//                    idx = j;
//                }
//            }
//
//            visited[idx] = true;
//
//            Iterator<Integer> it  = e[idx].set.iterator();
//            while(it.hasNext()){
//                int next = it.next();
//
//                if(!visited[next] && dist[next] > dist[idx]+1){
//                    dist[next] = dist[idx] + 1;
//                    if(distMax < dist[next]){
//                        distMax = dist[next];
//                    }
//                }
//
//            }
//        }
//
//        int answer = 0;
//        for(int i=1;i<=n;i++){
//            if(dist[i]==distMax) answer++;
//        }
//        return answer;
//    }
//
//
//    static class Edges{
//        HashSet<Integer> set = new HashSet<>();
//    }
//}
