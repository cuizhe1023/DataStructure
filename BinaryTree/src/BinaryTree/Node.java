package BinaryTree;

/**
 * @Author: cuizhe
 * @Date: 2019/2/9 21:58
 */
public class Node {

    private Integer data;//二叉链表的值
    private Node leftChild;//左子树
    private Node rightChild;//右子树

    public Node(Integer data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node(int data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
