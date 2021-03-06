package linkedlist.singlelinkdelist;

/**
 * Created by cuizhe on 2019-01-02.
 */
public class LinkdeList<T> {

    private Node head;//链表的头结点

    //链表的结点信息
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

    public LinkdeList() {
        head = null;
    }

    /**
     * 获取头结点信息
     * @return 头结点
     */
    public Node getHead() {
        return head;
    }

    /**
     * 将该结点设置为头结点
     * @param head 设置为头结点的结点
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * 头插法：
     * 先 new 一个新结点，保存传入的数据；
     * 接着判断链表是否为空，即头结点是否为null，如果头结点为空，则将头结点指向新的结点；
     * 如果不为空，新的结点的指针域指向头结点的地址，再将头结点指向新的结点。
     *
     * @param data 数据域，插入的数据
     */
    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    /**
     * 尾插法：
     * 先 new 一个新结点，保存传入的数据；
     * 接着判断链表是否为空，即头结点是否为null，如果头结点为空，则将头结点指向新的结点；
     * 如果不为空，最后一个结点的指针域指向新的结点。
     *
     * @param data 结点的数据
     */
    public void insertEnd(T data) {
        Node<T> newNode = new Node<>(data);
        Node temp = head;
        if (head == null) {
            head = newNode;
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    /**
     * 在指定位置插入数据
     * 先判断指定位置合不合法，是否大于链表长度，是否小于1，以及判断链表是否为空；
     * 在判断特殊情况，是否在头结点插入，是否在末尾插入
     * 先 new 一个新结点，保存传入的数据；
     * 再设置一个计数器，并遍历链表，在遍历每一个结点之前，计数器+1
     * （计数器代表新结点的位置，在遍历之前+1，是为了保证在插入前能获取上一个结点的信息）；
     * 当计数器与传入的位置相同时，进行插入处理，
     * (1).新结点的指针域指向当前结点的下一个结点（当前结点的指针域赋值给新结点的指针域）
     * (2).当前结点的指针域指向新结点（当前结点的指针域赋值给新结点）
     *
     * @param index 传入的位置
     * @param data  传入的数据
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
                break;
            }
            curNode = curNode.getNext();
        }
    }

    /**
     * 删除第一个结点
     */
    public void deleteFirst() {
        if (head == null) {
            System.out.println("链表为空，删除失败");
            return;
        }
        head = head.getNext();
    }

    /**
     * 删除最后一个结点
     */
    public void deleteEnd() {
        if (head == null) {
            System.out.println("链表为空，删除失败");
            return;
        }
        Node curNode = head;
        Node prevNode = null;
        while (curNode.getNext() != null) {
            if (curNode.getNext().getNext() == null) {
                prevNode = curNode;
            }
            curNode = curNode.getNext();
        }
        prevNode.setNext(null);
    }

    /**
     * 删除指定位置的数据
     *
     * @param index
     */
    public void deleteByIndex(int index) {
        if (index<1 || index > length()){
            System.out.println("输入错误,删除失败");
            return;
        }
        if (head == null) {
            System.out.println("链表为空，插入失败");
            return;
        }
        int length = 1;
        Node curNode = head;
        while (curNode.getNext() != null){
            length++;
            if (index == length){
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
     * 获取最后一个结点
     * @return 返回最后一个结点的结点信息
     */
    public Node getEndNode(){
        if (head == null) {
            System.out.println("链表为空，插入失败");
            return null;
        }
        Node curNode = head;
        while (curNode.getNext() != null){
            curNode = curNode.getNext();
        }
        return curNode;
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
            return getEndNode();
        }
        int length = 1;
        Node curNode = head;
        while (curNode.getNext() != null) {
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
        return (T) getNodeByIndex(index).getData();
    }

    /**
     * 获取链表长度，设定一个计数器，每遍历一个点，计数器加一
     *
     * @return 链表长度，
     */
    public int length() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    /**
     * 打印链表，遍历链表并打印结点数据。
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
     * 判断链表是否为空
     *
     * @return true/false
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 不通过递归实现链表的反转
     * 定义三个结点，用来保存当前结点的前驱，当前结点，当前结点的后继，
     * 定义的这个三个指针，目的就是防止断链之后无法继续遍历链表以后的结点，实现全部的反转。
     * 当前结点的指针域指向其前驱的时候，就已经实现了方向反转，
     * 但是当前结点此时就和其后继断链了，但是其后继结点的地址保存在 nextNode 中，
     * 因此，使用后移的方式，prevNode 保存当前结点，curNode 保存其后继结点，
     * 在下次循环中，nextNode 继续指向更新之后的当前结点的后继。
     * 从而实现了状态的保存，继续遍历全部结点，实现链表的反转。
     */
    public void reverseList() {
        Node curNode = head;//保存当前结点的地址
        Node prevNode = null;//保存当前结点前驱的地址
        Node nextNode = null;//保存当前结点后继的地址

        //开始遍历链表
        while (curNode != null) {
            //如果当前结点不是 null，那么初始化 nextNode 指针指向当前结点的下一个结点
            nextNode = curNode.getNext();
            //如果找到了尾结点，将头结点指向尾节点
            if (nextNode == null) {
                head = curNode;
            }
            //当前结点的指针域指向其前驱，实现链表的反转
            curNode.setNext(prevNode);
            //反转之后会产生断链的情况，因此用 prevNode 保存当前结点的地址，相当于将三个变量往后移动一个结点。
            prevNode = curNode;
            //当前结点往后移动一个结点。
            curNode = nextNode;
        }
    }

    /**
     * 通过递归实现链表的反转
     */
    public Node reverseListByRecursion(Node node){
        if(node==null||node.getNext()==null){
            return node;
        }
        Node reNode = reverseListByRecursion(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return reNode;
    }
}
