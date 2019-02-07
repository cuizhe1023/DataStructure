package BinaryTree;

/**
 * @Author: cuizhe
 * @Date: 2019/1/28 22:10
 */
public class TreeNode<T> {

    private T data;//二叉链表的值
    private TreeNode leftChild;//左子树
    private TreeNode rightChild;//右子树

    public TreeNode(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode(T data, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
