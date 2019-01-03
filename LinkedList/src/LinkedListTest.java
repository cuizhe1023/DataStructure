/**
 * @Author: cuizhe
 * @Date: 2019/1/1 18:24
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        System.out.println("链表是否为空：" + list.isEmpty());
        System.out.println("链表的长度为：" + list.length());
        list.insertEnd(2);
        list.insertHead(1);
        list.insertEnd(4);
        list.insertByindex(3,3);
        list.insertEnd(5);
        list.insertEnd(6);
        System.out.println("链表是否为空：" + list.isEmpty());
        System.out.println("链表的长度为：" + list.length());

        System.out.println("打印链表：");
        list.printList();

        System.out.println("删除第一个结点：");
        list.deleteFirst();
        list.printList();

        System.out.println("删除最后一个结点：");
        list.deleteEnd();
        list.printList();

        System.out.println("删除第二个结点：");
        list.deleteByindex(2);
        list.printList();

        System.out.println("非递归反转链表：");
        list.reverseList();
        list.printList();

        System.out.println("通过递归反转链表：");
        Node node = list.reverseListByRecursion(list.head);
        while (node != null){
            System.out.print(node.getData() +" ");
            node = node.getNext();
        }
    }
}
