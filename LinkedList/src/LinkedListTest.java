/**
 * @Author: cuizhe
 * @Date: 2019/1/1 18:24
 */
public class LinkedListTest {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        System.out.println("链表是否为空："+node.isEmpty());
        node.insertEnd(1);
        node.insertEnd(2);
        node.insertEnd(3);
        node.insertEnd(4);
        node.insertEnd(5);
        node.insertEnd(6);
        node.insertByindex(4,41);
        System.out.println("链表长度为："+node.length());
        System.out.println("链表是否为空："+node.isEmpty());
        node.printList();
        node.reverseList();
        node.printList();
    }
}
