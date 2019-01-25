package linkedlist.doublelinkedlist;

/**
 * @Author: cuizhe
 * @Date: 2019/1/18 21:14
 */
public class DoubleWayLinkedList<T> {

    private Node<T> head;//链表头
    private Node<T> end;//链表尾

    //双向链表的结点信息
    private class Node<T>{
        private T data;//数据域
        private Node<T> prev;//前驱域
        private Node<T> next;//后继域

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
     * 获取头结点信息
     * @return 头结点
     */
    public Node getHeadNode() {
        return head;
    }

    /**
     * 获取尾结点信息
     * @return 尾结点
     */
    public Node getEndNode() {
        return end;
    }

    /**
     * 头插法
     * 先 new 一个新结点，保存传入的数据；
     * 接着判断链表是否为空，即头结点是否为 null，如果头结点为空，则将头结点指向新结点,尾结点也指向新结点；
     * 如果不为空，新结点的后继域指向头结点的地址，头结点的前驱域指向新结点，再将头结点指向新的结点。
     * (此时新节点的前区域是 null )
     *
     * @param data 结点数据
     */
    public void insertHead(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            end = newNode;
        }else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    /**
     * 尾插法
     * 先 new 一个新结点，保存传入的数据；
     * 接着判断链表是否为空，即头结点是否为 null，如果头结点为空，则将头结点指向新结点,尾结点也指向新结点；
     * 如果不为空，新结点的前驱域指向尾结点，尾结点的后继域指向新结点，再将尾结点指向新结点。
     * (此时新节点的前区域是 null )
     *
     * @param data 结点数据
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
     * 先判断指定位置合不合法，是否大于链表长度，是否小于1，以及判断链表是否为空；
     * 在判断特殊情况，是否在头结点插入，是否在末尾插入;
     * 先 new 一个新结点，保存传入的数据；
     * 再设置一个计数器，并遍历链表，在遍历每一个结点之前，计数器+1
     * （计数器代表新结点的位置，在遍历之前+1，是为了保证在插入前能获取上一个结点的信息）;
     * 当计数器与传入的位置相同时，进行插入处理:
     * (1).新结点的后继域指向当前结点的下一个结点（当前结点的后继域赋值给新结点的后继域）;
     * (2).当前结点的后继域指向新结点;
     * (3).新结点的前驱域指向当前结点;
     * (4).新结点的后继域指向的结点的前驱域指向新结点。
     *
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
     * 删除第一个结点
     * 将头结点的下一个结点的前驱域置为 null
     * 将头结点指向头结点的下一个结点
     */
    public void deleteFirst(){
        if (head == null) {
            System.out.println("链表为空，删除失败");
            return;
        }
        head.getNext().setPrev(null);
        head = head.getNext();
    }

    /**
     * 删除最后一个结点
     * 先将尾结点的前一个结点的后继域置为 null
     * 然后将尾结点的前一个结点赋给尾结点
     */
    public void deleteEnd(){
        if (head == null) {
            System.out.println("链表为空，删除失败");
            return;
        }
        end.getPrev().setNext(null);
        end = end.getPrev();
    }

    /**
     * 删除指定位置的结点
     * 先判断指定位置合不合法，是否大于链表长度，是否小于1，以及判断链表是否为空；
     * 在判断特殊情况，是否删除的是第一个结点，是否删除的是第二个结点
     * 设置一个计数器，并遍历链表，在遍历每一个结点之前，计数器+1
     * （计数器代表新结点的位置，在遍历之前+1，是为了保证在插入前能获取上一个结点的信息）
     * 当计数器与传入的位置相同时，进行删除操作，
     * (1).当前结点的下一个结点的下一个结点的前驱域置为当前结点
     * (2).当前结点的后继域设置为当前结点的下一个结点的下一个结点
     * @param index 指定位置
     */
    public void deleteByindex(int index){
        if (index<1 || index > length()){
            System.out.println("输入错误,删除失败");
            return;
        }
        if (head == null) {
            System.out.println("链表为空，插入失败");
            return;
        }
        if (index == 1) {
            deleteFirst();
            return;
        }
        if (index == length()){
            deleteEnd();
            return;
        }
        int length = 1;
        Node curNode = head;
        while (curNode.getNext() != null){
            length++;
            if (index == length){
                curNode.getNext().getNext().setPrev(curNode);
                curNode.setNext(curNode.getNext().getNext());
                return;
            }
            curNode = curNode.getNext();
        }
    }

    /**
     * 修改指定位置的结点的数据
     *
     * @param index 指定位置
     * @param data 修改的数据
     */
    public void updateDataByIndex(int index,T data){
        if (index<1 || index > length()){
            System.out.println("输入错误,删除失败");
            return ;
        }
        if (head == null) {
            System.out.println("链表为空，插入失败");
            return ;
        }
        getNodeByIndex(index).setData(data);
    }

    /**
     * 获取指定位置的结点信息
     * 先判断指定位置合不合法，是否大于链表长度，是否小于1，以及判断链表是否为空；
     * 在判断特殊情况，是否获取的是第一个结点，是否获取的是第二个结点
     * 设置一个计数器，并遍历链表，在遍历每一个结点之前，计数器+1
     * （计数器代表新结点的位置，在遍历之前+1，是为了保证在插入前能获取上一个结点的信息）
     * 当计数器与传入的位置相同时，返回当前结点的后一个结点的信息
     *
     * @param index 指定的位置
     * @return 获取的结点信息
     */
    public Node getNodeByIndex(int index){
        if (index<1 || index > length()){
            System.out.println("输入错误,删除失败");
            return null;
        }
        if (head == null) {
            System.out.println("链表为空，插入失败");
            return null;
        }
        if (index == 1) {
            return head;
        }
        if (index == length()){
            return end;
        }
        int length = 1;
        Node curNode = head;
        while (curNode.getNext() != null){
            length++;
            if (index == length){
                return curNode.getNext();
            }
            curNode = curNode.getNext();
        }
        return null;
    }

    /**
     * 获取指定位置结点的数据域
     *
     * @param index 指定的位置
     * @return 结点的数据域
     */
    public T getDataByIndex(int index){
        if (index<1 || index > length()){
            System.out.println("输入错误,删除失败");
            return null;
        }
        if (head == null) {
            System.out.println("链表为空，插入失败");
            return null;
        }
        return (T) getNodeByIndex(index).getData();
    }

    /**
     * 获取链表结点个数
     *
     * @return 结点个数
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
     * 判断链表是否为空
     * @return true/false
     */
    public boolean isEmpty() {
        return head == null;
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
    public void reversePrintList() {
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
