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
    public void preOrderTraverse(TreeNode node) {
        if (node != null){
            System.out.print(node.data + " ");
            preOrderTraverse(node.getLeftChild());
            preOrderTraverse(node.getRightChild());
        }
    }

    @Override
    public void inOrderTraverse(TreeNode node) {
        if (node != null){
            preOrderTraverse(node.getLeftChild());
            System.out.print(node.data + " ");
            preOrderTraverse(node.getRightChild());
        }
    }

    @Override
    public void postOrderTraverse(TreeNode node) {
        if (node != null){
            preOrderTraverse(node.getLeftChild());
            preOrderTraverse(node.getRightChild());
            System.out.print(node.data + " ");
        }
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
