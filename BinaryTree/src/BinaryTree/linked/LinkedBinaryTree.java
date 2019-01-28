package BinaryTree.linked;

import BinaryTree.BinaryTree;

/**
 * @Author: cuizhe
 * @Date: 2019/1/24 22:43
 */
public class LinkedBinaryTree<T> implements BinaryTree {

    private TreeNode root;//根节点

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public LinkedBinaryTree() {
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public TreeNode findKey(Object data) {
        return null;
    }

    @Override
    public void preOrderTraverse() {
        if (root != null){
            System.out.print(root.data + " ");
            LinkedBinaryTree leftTree = new LinkedBinaryTree();
            leftTree.root = root.getLeftChild();
            leftTree.preOrderTraverse();
            LinkedBinaryTree rightTree = new LinkedBinaryTree();
            rightTree.root = root.getRightChild();
            rightTree.preOrderTraverse();
        }
        System.out.println();
    }

    @Override
    public void inOrderTraverse() {

    }

    @Override
    public void postOrderTraverse() {

    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void inOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void levelOrderByStack() {

    }


}
