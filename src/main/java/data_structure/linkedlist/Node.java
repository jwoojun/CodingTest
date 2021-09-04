package data_structure.linkedlist;

public class Node {
    private Node next;      // 다음 노드의 주소를 저장
    private Node previous;  // 이전 노드의 주소를 저장
    private Object data;  // 데이터 저장

    public Node(Node next, Node previous, Object object) {
        this.next = next;
        this.previous = previous;
        this.data = object;
    }

    public Node nextNode() {
        return next;
    }

    public void setNextNode(Node next) {
        this.next = next;
    }

    public Node previous() {
        return previous;
    }

    public void setPreviousNode(Node previous) {
        this.previous = previous;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "next=" + next + ", previous=" + previous + ", object=" + data + '}';
    }
}

class LinkedList_impl {
    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirstNode(Object data){
        Node newNode = new Node(null, null, data);
        head = newNode;
        size++;
        if(head.nextNode()==null){
            tail = head;
        }
    }

    public void addLastNode(Object data){
        Node newNode = new Node(null, null, data);
        if(size == 0){
            addFirstNode(data);
        }else{
            tail.setNextNode(newNode);
            size++;
        }
    }

    public Node searchNode(int index){
        int i=0;
        Node target = head;
        while(i < size){
            target = head.nextNode();

        }
        return target;
    }
}







