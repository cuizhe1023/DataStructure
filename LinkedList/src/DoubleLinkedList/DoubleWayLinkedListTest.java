package DoubleLinkedList;

/**
 * @Author: cuizhe
 * @Date: 2019/1/18 21:27
 */
public class DoubleWayLinkedListTest {
    public static void main(String[] args) {
        DoubleWayLinkedList<Integer> list = new DoubleWayLinkedList<>();
        list.insertEnd(2);
        list.insertHead(1);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);
        list.insertEnd(6);

        list.printList();
        list.insertByIndex(4,7);
        list.printList();
        System.out.println(list.length());
        list.reverseList();
    }
}