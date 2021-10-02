package baek.graph.boj_13418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int m;
    static List<Building> buildings = new ArrayList<>();
    static int [] parent;
    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<m+1; i++){
            int a = input.integer();
            int b = input.integer();
            int c = input.integer();
            buildings.add(new Building(a, b, c));
        }

        int direct = 0;
        buildings.sort(Building::compareTo);
        for (Building building : buildings) {
            int start = findParent(building.start);
            int end = findParent(building.end);
            if (start != end) {
                unionParent(building.start, building.end);
                if (building.direction == 0) {
                    direct++;
                }
            }
        }
        for(int i=0; i<n+1; i++){
            parent[i] = i;
        }
        int reverse = 0;
        List<Building> lst = buildings.stream()
                .sorted(Comparator.comparing(Building::getDirection).reversed())
                .collect(Collectors.toUnmodifiableList());
        for(int i=lst.size()-1;i>=0; i--){
            Building building = buildings.get(i);
            int start = findParent(building.start);
            int end = findParent(building.end);
            if(start != end){
                unionParent(building.start, building.end);
                if(building.direction==0){
                    reverse ++;
                }
            }
        }
        System.out.println(direct*direct - reverse*reverse);
    }

    static int findParent(int x){
        if(parent[x] != x){
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    static void unionParent(int x, int y){
        int a = findParent(x);
        int b = findParent(y);
        if(a<b){
            parent[b]=a;
        }else {
            parent[a] = b;
        }
    }

    static Input input = new Main.Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }

    static class Building implements Comparable<Building> {
        int start;
        int end;
        int direction;

        public Building(int start, int end, int direction) {
            this.start = start;
            this.end = end;
            this.direction = direction;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getDirection() {
            return direction;
        }

        @Override
        public String toString() {
            return "Building{" +
                    "start=" + start +
                    ", end=" + end +
                    ", direction=" + direction +
                    '}';
        }

        @Override
        public int compareTo(Building building) {
            return this.direction-building.direction;
        }
    }
}
