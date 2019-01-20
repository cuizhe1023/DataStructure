package SingleLinkdeList;

/**
 * @Author: cuizhe
 * @Date: 2019/1/1 18:24
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkdeList<Integer> list = new LinkdeList<>();
        System.out.println("链表是否为空：" + list.isEmpty());
        System.out.println("链表的长度为：" + list.length());
        list.insertEnd(3);
        list.insertHead(1);
        list.insertEnd(4);
        list.insertEnd(5);
        list.insertEnd(6);
        list.insertEnd(7);
        list.insertEnd(8);
        list.printList();
        list.insertByIndex(2,2);
        list.printList();
        list.insertByIndex(1,74);
        list.printList();
        list.insertByIndex(9,100);
        list.printList();
        System.out.println("链表是否为空：" + list.isEmpty());
        System.out.println("链表的长度为：" + list.length());

        System.out.println("删除第一个结点：");
        list.deleteFirst();
        list.printList();

        System.out.println("删除最后一个结点：");
        list.deleteEnd();
        list.printList();

        System.out.println("删除第二个结点：");
        list.deleteByIndex(2);
        list.printList();

        System.out.println("非递归反转链表：");
        list.reverseList();
        list.printList();

        System.out.println("通过递归反转链表：");
        list.setHead(list.reverseListByRecursion(list.getHead()));
        list.printList();
    }
}
