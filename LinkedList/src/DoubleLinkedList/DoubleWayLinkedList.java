package DoubleLinkedList;

/**
 * @Author: cuizhe
 * @Date: 2019/1/18 21:14
 */
public class DoubleWayLinkedList<T> {

    private Node<T> head;//链表头
    private Node<T> end;//链表尾

    //双向链表的节点信息
    private class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public DoubleWayLinkedList() {
        head = null;
        end = null;
    }

    //在链表头插入数据
    public void insertHead(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            end = newNode;
        }else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    //在链表尾插入数据
    public void insertEnd(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            end = newNode;
        }else {
            newNode.prev = end;
            end.next = newNode;
            end = newNode;
        }
    }

    //获取链表长度
    public int length() {
        int length = 0;
        Node<T> temp = head;
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    public void printList() {
        if (head == null) {
            System.out.println("链表中没有数据");
        } else {
            Node curNode = head;
            System.out.print("[");
            while (curNode != null) {
                if (curNode.getNext() != null) {
                    System.out.print(curNode.getData() + "->");
                } else {
                    System.out.println(curNode.getData() + "]");
                }
                curNode = curNode.getNext();
            }
        }
    }
}
