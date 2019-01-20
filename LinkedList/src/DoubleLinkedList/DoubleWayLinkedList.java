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

    /**
     * 头插法
     * @param data 节点数据
     */
    public void insertHead(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            end = newNode;
        }else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
    }

    /**
     * 尾插法
     * @param data 节点数据
     */
    public void insertEnd(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            end = newNode;
        }else {
            newNode.setPrev(end);
            end.setNext(newNode);
            end = newNode;
        }
    }

    /**
     * 在指定位置插入数据
     * @param index 指定位置
     * @param data 数据
     */
    public void insertByIndex(int index, T data) {
        if (index < 1 || index > length()) {
            System.out.println("插入位置不合法，插入失败");
            return;
        }
        if (head == null) {
            System.out.println("链表为空，插入失败");
            return;
        }
        if (index == 1) {
            insertHead(data);
            return;
        }
        if (index == length()){
            insertEnd(data);
            return;
        }
        int length = 1;
        Node curNode = head;
        Node<T> newNode = new Node<>(data);
        while (curNode.getNext() != null) {
            length++;
            if (index == length) {
                System.out.println("当前结点"+curNode.getData());
                newNode.setNext(curNode.getNext());
                curNode.setNext(newNode);
                newNode.setPrev(curNode);
                newNode.getNext().setPrev(newNode);

                return;
            }
            curNode = curNode.getNext();
        }
    }

    /**
     * 获取链表节点个数
     * @return
     */
    public int length() {
        int length = 0;
        Node<T> temp = head;
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    /**
     * 正序打印链表
     */
    public void printList() {
        if (head == null) {
            System.out.println("链表中没有数据");
        } else {
            Node curNode = head;
            System.out.print("[");
            while (curNode != null) {
//                System.out.println("\n当前节点的前一个节点的前驱域为空:"+(curNode.getPrev()==null));
//                System.out.println("当前节点的前一个节点的数据域为空:"+(curNode.getData()));
//                System.out.println("当前节点的前一个节点的后继域为空:"+(curNode.getNext()==null));
                if (curNode.getNext() != null) {
                    System.out.print(curNode.getData() + "->");
                } else {
                    System.out.println(curNode.getData() + "]");
                }
                curNode = curNode.getNext();
            }
        }
    }

    /**
     * 逆序打印链表
     */
    public void reverseList() {
        if (head == null) {
            System.out.println("链表中没有数据");
        } else {
            Node curNode = end;
            System.out.print("[");
            while (curNode != null) {
                if (curNode.getPrev() != null) {
                    System.out.print(curNode.getData() + "->");
                } else {
                    System.out.println(curNode.getData() + "]");
                }
                curNode = curNode.getPrev();
            }
        }
    }
}
