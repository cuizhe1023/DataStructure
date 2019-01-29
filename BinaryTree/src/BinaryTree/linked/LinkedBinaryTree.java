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
            preOrderTraverse(root);
            System.out.println();
        }
    }

    private void preOrderTraverse(TreeNode treeNode) {
        if (treeNode != null){
            System.out.print(treeNode.getData() + " ");
            preOrderTraverse(treeNode.getLeftChild());
            preOrderTraverse(treeNode.getRightChild());
        }
    }

    @Override
    public void inOrderTraverse() {
        if (root != null){
            inOrderTraverse(root);
            System.out.println();
        }
    }

    private void inOrderTraverse(TreeNode treeNode) {
        if (treeNode != null){
            inOrderTraverse(treeNode.getLeftChild());
            System.out.print(treeNode.getData() + " ");
            inOrderTraverse(treeNode.getRightChild());
        }
    }

    @Override
    public void postOrderTraverse() {
        if (root != null){
            postOrderTraverse(root);
            System.out.println();
        }
    }

    private void postOrderTraverse(TreeNode treeNode) {
        if (treeNode != null){
            postOrderTraverse(treeNode.getLeftChild());
            postOrderTraverse(treeNode.getRightChild());
            System.out.print(treeNode.getData() + " ");
        }
    }


    /**
     * 前序非递归遍历：
     * 1.对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2.若左子树为空，栈顶节点出栈，将该节点的右子树置为current
     * 3.重复1、2步操作，直到current为空且栈内节点为空。
     */
    @Override
    public void preOrderByStack() {
        LinkStack<TreeNode> stack = new LinkStack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()){
            while (curNode != null){
                stack.push(curNode);
                System.out.print(curNode.getData()+" ");
                curNode = curNode.getLeftChild();
            }
            if (!stack.isEmpty()){
                curNode = stack.peek();
                stack.pop();
                curNode = curNode.getRightChild();
            }
        }
        System.out.println();
    }

    /**
     * 中序非递归遍历：
     * 1.对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2.若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     * 3.重复1、2步操作，直到current为空且栈内节点为空
     */
    @Override
    public void inOrderByStack() {
        LinkStack<TreeNode> stack = new LinkStack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()){
            while (curNode != null){
                stack.push(curNode);
                curNode = curNode.getLeftChild();
            }
            if (!stack.isEmpty()){
                curNode = stack.peek();
                stack.pop();
                System.out.print(curNode.getData()+" ");
                curNode = curNode.getRightChild();
            }
        }
        System.out.println();
    }

    /**
     * 后序非递归遍历：
     * 1.对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2.若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点
     * 3.重复1、2步操作，直到current为空且栈内节点为空。
     */
    @Override
    public void postOrderByStack() {
        LinkStack<TreeNode> stack = new LinkStack<>();
        TreeNode curNode = root;
        TreeNode preNode = null;
        while (curNode != null || !stack.isEmpty()){
            while (curNode != null){
                stack.push(curNode);
                curNode = curNode.getLeftChild();
            }
            if (!stack.isEmpty()){
                curNode = stack.peek().getRightChild();
                if (curNode == null || curNode == preNode){
                    curNode = stack.peek();
                    stack.pop();
                    System.out.print(curNode.getData()+" ");
                    preNode = curNode;
                    curNode = null;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void levelOrderByStack() {

    }


}
