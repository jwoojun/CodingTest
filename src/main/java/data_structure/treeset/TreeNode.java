package data_structure.treeset;

import java.util.Set;
import java.util.TreeSet;

public class TreeNode {
    private TreeNode left;       // 왼쪽 자식노드
    private Object element;      // 객체를 저장하기 위한 참조변수
    private TreeNode right;      // 오른쪽 자식노드


    public static void main(String args []){
        Set<Integer> set = new TreeSet<Integer>();
        for (int i=0; i<6; i++){
            int num = (int) (Math.random() * 45)+1;
            set.add(num);
        }
        set.forEach(System.out::println);
    }
}






