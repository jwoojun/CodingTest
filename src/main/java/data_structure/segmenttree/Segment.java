package data_structure.segmenttree;

public class Segment {
    private static long init(int[] numbers, long[] tree, int node, int start, int end){
        if(start == end){
            return tree[node] = numbers[start];
        }

        int mid = (start+end)/2;
        return tree[node] = init(numbers, tree, node*2, start, mid) +
                init(numbers, tree, node*2+1, mid+1, end);
    }
}
