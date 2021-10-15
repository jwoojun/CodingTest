package data_structure.segmenttree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Segment {
    public static void main(String[] args) throws Exception {
        Tree segmentTree = new Tree();
        segmentTree.init(0, segmentTree.elements.length-1, 1);
        System.out.print("n번부터 m번 까지의 구간합\n");
        System.out.println(segmentTree.query(0, segmentTree.elements.length - 1, 1, input.integer(), input.integer()));
        System.out.println("n과 m을 입력해주세요");
        int n = input.integer();
        int m = input.integer();
        segmentTree.update(0, segmentTree.elements.length - 1, 1, 0, m - segmentTree.elements[n]);
        System.out.println("변경된 세그먼트트리 전체합= "+segmentTree.query(0, segmentTree.elements.length-1, 1, 0, 5));
    }


    private static Input input = new Input();
    private static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}

class Tree {
    int elements[];
    int tree[];

    public Tree() throws Exception {
        int elementCount = input.integer();
        elements = new int[elementCount];
        tree = new int[elements.length*4+1];
        for(int i=0; i<elements.length; i++){
            int element = input.integer();
            elements[i] = element;
        }
        print();
        System.out.println();
        for(int e : tree){
            System.out.println(e);
        }
    }

    public int init(int startNo, int endNo, int nodeNo) {
        // 리프에 도달했다면
        if(startNo == endNo){
            return tree[nodeNo] = elements[startNo];
        }
        int mid = (startNo+endNo)/2;
        return tree[nodeNo] = init(startNo, mid, nodeNo*2) + init(mid+1, endNo, nodeNo*2+1);
    }

    public int query(int start, int end, int nodeNo, int left, int right){
        if(left>end || right<start){
            return 0;
        }

        if(left<=start && end<=right){
            return tree[nodeNo];
        }

        int mid = (start+end)/2;
        return query(start, mid, nodeNo*2, left, right) + query(mid+1, end, nodeNo*2+1, left, right);
    }

    public void update(int start, int end, int node, int index, int value){
        if(index<start || index>end){
            return;
        }
        tree[node] += value;
        if(start==end){
            return;
        }
        int mid = (start+end)/2;
        update(start, mid, node*2, index, value);
        update(mid+1, end, node*2+1, index, value);
    }

    public void print() {
        for(int i=0; i<this.elements.length; i++){
            System.out.print(i+"번째 인덱스="+this.elements[i]+"\n");
        }
        System.out.println();
    }

    public void print2() {
        for(int i=0; i<this.tree.length; i++){
            System.out.print(i+"번째 인덱스="+this.tree[i]+"\n");
        }
        System.out.println();
    }



    private static Input input = new Input();
    private static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "elements=" + Arrays.toString(elements) +
                ", tree=" + Arrays.toString(tree) +
                '}';
    }
}
