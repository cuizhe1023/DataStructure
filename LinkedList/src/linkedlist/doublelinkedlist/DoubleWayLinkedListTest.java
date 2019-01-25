package linkedlist.doublelinkedlist;

/**
 * @Author: cuizhe
 * @Date: 2019/1/18 21:27
 */
public class DoubleWayLinkedListTest {
    public static void main(String[] args) {
        DoubleWayLinkedList<Integer> list = new DoubleWayLinkedList<>();
        System.out.println("插入链表前:");
        System.out.println("链表是否为空:" + list.isEmpty());
        System.out.println("链表的长度为:" + list.length());
        list.insertEnd(2);
        list.insertHead(1);
        list.insertHead(0);
        list.insertHead(23);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);
        list.insertEnd(6);
        System.out.println("插入链表后:");
        System.out.println("链表是否为空:" + list.isEmpty());
        System.out.println("链表的长度为:" + list.length());
        System.out.println("-------------------------------");

        System.out.println("打印链表:");
        list.printList();

        System.out.println("在第三个位置插入10:");
        list.insertByIndex(3,10);
        list.printList();

        System.out.println("删除第一个结点:");
        list.deleteByindex(1);
        list.printList();

        System.out.println("删除最后一个结点:");
        list.deleteEnd();
        list.printList();

        System.out.println("删除第2个结点:");
        list.deleteByindex(2);
        list.printList();

        System.out.println("修改第2个结点的数据:");
        list.updateDataByIndex(2,9);
        list.printList();

        System.out.println("查看第4个结点的数据:");
        System.out.println(list.getDataByIndex(4));

        System.out.println("逆序输出链表:");
        list.reversePrintList();
    }
}
