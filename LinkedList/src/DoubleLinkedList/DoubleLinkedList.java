package DoubleLinkedList;

/**
 * Created by cuizhe on 2019-01-04.
 */
public class DoubleLinkedList<T> {

    private Node<T> head ;//链表的头结点
    private Node<T> last ;//链表的尾结点

    public DoubleLinkedList() {
        head = null;
        last = null;
    }


    public boolean isEmpty() {
        return head == null;
    }


}
