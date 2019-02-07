package BinaryTree;

/**
 * @Author: cuizhe
 * @Date: 2019/1/23 11:18
 */
public class LinkQueue<T> {

    private Node front;//队列头
    private Node rear;//队列尾

    private class Node<T> {
        private T data;
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

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public LinkQueue() {
        front = null;
        rear = null;
    }

    /**
     * 入队，链表的尾插法
     */
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if (isEmpty()){
            front = newNode;
            rear = front;
        }else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    /**
     * 出队
     */
    public void poll(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }else {
            Node<T> headNode = front;
            front = front.next;
            headNode.setNext(null);
        }
    }

    /**
     * 获取队首元素
     * @return 队首元素
     */
    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }else {
            return (T) front.getData();
        }
    }

    /**
     * 获取队列长度
     * @return
     */
    public int length(){
        int length = 0;
        Node temp = front;
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    /**
     * 判空
     * @return true/false
     */
    public boolean isEmpty(){
        return front==null;
    }

}
