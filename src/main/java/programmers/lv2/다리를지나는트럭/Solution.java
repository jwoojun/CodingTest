package programmers.lv2.다리를지나는트럭;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    static int answer = 0;
    static int current_bridge_weight = 0;
    static Deque<Truck> waitingTrucks = new LinkedList<>();
    static Deque<Truck> bridge = new LinkedList<>();

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        init(bridge_length, weight, truck_weights);

        while(!bridge.isEmpty()){
            answer+=1;
            current_bridge_weight -= bridge.pollFirst().weight;
            if(!waitingTrucks.isEmpty()){
                if(!overThanBridge(weight)){
                    current_bridge_weight += waitingTrucks.peekFirst().weight;
                    bridge.add(waitingTrucks.pollFirst());
                }else {
                    bridge.add(new Truck(0));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int [] array= {7, 4, 5, 6};
        System.out.println(solution(2, 10, array));
    }

    static void init(int bridge_length, int weight, int[] truck_weights){
        for(int i=0; i<bridge_length; i++){
            bridge.add(new Truck(0));
        }

        for(int truck : truck_weights){
            waitingTrucks.add(new Truck(truck));
        }
    }
    static boolean overThanBridge(int weight) {
        return current_bridge_weight + waitingTrucks.peekFirst().weight > weight;
    }
    static class Truck {
        int weight;

        public Truck(int weight) {
            this.weight = weight;
        }
    }
}
