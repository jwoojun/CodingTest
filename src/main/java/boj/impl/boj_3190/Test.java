package boj.impl.boj_3190;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args){
        Deque<String> deque = new LinkedList<>();
        deque.add("A");
        deque.add("B");
        deque.add("C");
        deque.add("D");
        deque.add("E");
        String alph = deque.pollFirst();
        System.out.println("Alpha= "+alph);
    }
}
