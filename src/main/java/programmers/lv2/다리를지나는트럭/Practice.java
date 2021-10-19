package programmers.lv2.다리를지나는트럭;


import java.util.Deque;
import java.util.LinkedList;

public class Practice {
    static int answer = 0;
    static int current_sum = 0;
    static Deque<Truck> movingTrucks = new LinkedList<>();
    static Deque<Truck> waitingTrucks = new LinkedList<>();
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        init(truck_weights);

        while(!waitingTrucks.isEmpty() || !movingTrucks.isEmpty()){
            answer+=1;
            if(movingTrucks.isEmpty()){
                current_sum += waitingTrucks.peek().weight;
                movingTrucks.add(waitingTrucks.poll());
                continue;
            }

            for(Truck t : movingTrucks){
                t.move();
            }

            if(movingTrucks.peek().time > bridge_length){
                Truck truck = movingTrucks.poll();
                current_sum -= truck.weight;
            }

            if(!waitingTrucks.isEmpty() && current_sum + waitingTrucks.peek().weight<= weight){
                current_sum += waitingTrucks.peek().weight;
                movingTrucks.add(waitingTrucks.poll());
            }
        }
        return answer;
    }

    private static void init(int[] truck_weights) {
        for(int truck : truck_weights){
            waitingTrucks.add(new Truck(truck, 1));
        }
    }

    public static void main(String[] args){
        int [] array= {7, 4, 5, 6};
        solution(2, 10, array);
        System.out.println(solution(2, 10, array));
    }

    static class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }

        public void move() {
            time+=1;
        }
    }
}
