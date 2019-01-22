package LinkedStack;

/**
 * @Author: cuizhe
 * @Date: 2019/1/22 19:07
 */
public class LinkStack<T> {

    private Node top;//栈顶元素

    //链栈的结点信息
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

    public LinkStack() {
        top = null;
    }

    /**
     * 进栈，链表的头插法
     */
    public void push(T data){
        Node<T> newNode = new Node<>(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
    }

    /**
     * 出栈，删除链表的第一个结点
     */
    public void pop(){
        if (top == null) {
            throw new RuntimeException("空栈！");
        }
        top = top.getNext();
    }

    /**
     * 查看栈顶元素
     *
     * @return 栈顶元素
     */
    public T peek(){
        return (T) top.getData();
    }

    /**
     * 栈的长度
     *
     * @return 栈的长度
     */
    public int length() {
        int length = 0;
        Node temp = top;
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    /**
     * 判断栈是否为空
     * @return true/false
     */
    public boolean isEmpty(){
        return top==null;
    }

    /**
     * 打印栈
     */
    public void printStack(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }else {
            Node curNode = top;
            System.out.print("[");
            while (curNode != null){
                if (curNode.getNext() != null){
                    System.out.print(curNode.getData()+"<-");
                }else {
                    System.out.print(curNode.getData()+"]");
                }
                curNode = curNode.getNext();
            }
        }
    }
}
