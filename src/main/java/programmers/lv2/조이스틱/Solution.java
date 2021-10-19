package programmers.lv2.조이스틱;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    static int answer = 987654321;
    enum Command {
        NEXT("N", 0), BEFORE("B", 1), LEFT("L",2), RIGHT("R",3);
        private final String description;
        private final int order;

        Command(String description, int order) {
            this.description = description;
            this.order = order;
        }
    }
    public static void main(String args []){
        init();
        Queue<Alpha> queue = new LinkedList<>();
        String alphabet = "JAR";
        queue.add(new Alpha(0, 0, ""));
        while (!queue.isEmpty()){
            Alpha alpha = queue.poll();
            System.out.println(alpha);
            if(alpha.count >= alphabet.length()){
                if(alpha.result.equals(alphabet)){
                    answer = Math.min(alpha.count, answer);
                }
            } else {
                for (int i = 0; i < 26; i++) {
//                    alpha.move(i);
                    queue.add(new Alpha(alpha.count+1, alpha.position, alpha.result));
                }
            }
        }
        System.out.println(answer);
    }
    static void init(){
        for(int i=97; i<123; i++){
            repository.put(i-97, String.valueOf((char)i));
        }
    }

    static Map<Integer, String> repository = new HashMap<>();

    public int solution(String name) {
        int answer = 0;
        return answer;
    }

    static class Alpha {
        int count;
        int position;
        String result;

        public Alpha(int count, int position, String result) {
            this.count = count;
            this.position = position;
            this.result = result;
        }
//
//        void move(int i) {
//            if(i==0){
//                next();
//            } else if(i==1){
//                before();
//            }else if(i==2){
//                left();
//            }else if(i==3){
//                right();
//            }
//        }

        @Override
        public String toString() {
            return "Alpha{" +
                    "count=" + count +
                    ", position=" + position +
                    ", result='" + result + '\'' +
                    '}';
        }

        void next(int move) {
            if(this.position == 25){
                return;
            }else {
                this.position += 1;
                this.result += repository.get(position);
            }


        }

        void before(int move){
            this.position-=1;
            if(this.position==0){
                this.position = 25;
            }
            this.result+= repository.get(position);
        }
        void left(int move){
            if(this.position==0){
                this.position=25;
                this.result+= repository.get(position);
            }else {
                this.position = 0;
                this.result+= repository.get(position);
            }
        }
        void right(int move){
            this.position = 25;
            this.result+= repository.get(position);
        }



    }




}
