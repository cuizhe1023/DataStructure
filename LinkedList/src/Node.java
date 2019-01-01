/**
 * @Author: cuizhe
 * @Date: 2019/1/1 18:24
 */
public class Node<T> {
    private T data;
    private Node next;
    private Node head;

    public Node(){

    }

    public Node(T data) {
        this.data = data;
    }

    /**
     * 头插法：
     * 先 new 一个新的结点，
     * 接着判断链表是否为空，即头结点是否为null，如果头结点为空，则将头结点指向新的结点；
     * 如果不为空，新的结点的指针域指向头结点的地址，再将头结点指向新的结点。
     * @param data 数据域，插入的数据
     */
    public void insertHead(T data){
        Node<T> newNode = new Node<>(data);
        if (head==null){
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 尾插法：
     * 先 new 一个新的结点，
     * 接着判断链表是否为空，即头结点是否为null，如果头结点为空，则将头结点指向新的结点；
     * 如果不为空，最后一个结点的指针域指向新的结点。
     * @param data 结点的数据
     */
    public void insertEnd(T data){
        Node<T> newNode = new Node<>(data);
        Node<T> temp = head;
        if (head == null){
            head = newNode;
        }else {
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     * 在指定位置插入数据
     * 先判断指定位置合不合法，是否大于链表长度，是否小于0，以及判断链表是否为空；
     *
     * 先 new 一个新的结点，
     * @param data
     */
    public void insertByindex(int index,T data){
        if (index < 0 || index > length()){
            System.out.println("插入位置不合法，插入失败");
            return;
        }
        if (head == null){
            System.out.println("链表为空，插入失败");
            return;
        }
        Node<T> newNode = new Node<>(data);
        int length = 1;
        Node temp = head;
        while (temp.next != null){
            if (index == length){
                if (index == 1){
                    newNode.next = head;
                    head = newNode;
                }
                newNode.next = temp.next;
                temp.next = newNode;
                return ;
            }
            temp = temp.next;
            length++;
        }
    }

    /**
     * 获取链表长度，设定一个计数器，每遍历一个点，计数器加一
     * @return 链表长度，
     */
    public int length(){
        int length = 0;
        Node temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 打印链表，遍历链表并打印结点数据。
     */
    public void printList(){
        if (head==null){
            System.out.println("链表中没有数据");
        }else {
            Node temp = head;
            System.out.print("[");
            while (temp != null){
                if (temp.next != null){
                    System.out.print(temp.data + "->");
                }else {
                    System.out.println(temp.data + "]");
                }
                temp = temp.next;
            }
        }
    }

}
