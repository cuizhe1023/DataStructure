package BinaryTree.linked;

import BinaryTree.LinkQueue;
import BinaryTree.LinkStack;
import BinaryTree.BinaryTree;
import BinaryTree.TreeNode;

/**
 * @Author: cuizhe
 * @Date: 2019/1/24 22:43
 */
public class LinkedBinaryTree<T> implements BinaryTree{

    private TreeNode root;//根结点

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
        return size(root);
    }

    private int size(TreeNode treeNode) {
        if (treeNode==null){
            return 0;
        }else {
            int left = size(treeNode.getLeftChild());
            int right = size(treeNode.getRightChild());
            return left+right+1;
        }
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int left = getHeight(treeNode.getLeftChild());
        int right = getHeight(treeNode.getRightChild());
        return left>right?(left+1):(right+1);
    }

    @Override
    public TreeNode findKey(Object data) {
        return findKey(data,root);
    }

    private TreeNode findKey(Object o,TreeNode treeNode){
        if (treeNode==null){
            return null;
        }
        if (treeNode!=null && treeNode.getData()==o){
            return treeNode;
        }else {
            TreeNode left = findKey(o,treeNode.getLeftChild());
            TreeNode right = findKey(o,treeNode.getRightChild());
            if (left!=null&&left.getData()==o){
                return left;
            }
            if (right!=null&&right.getData()==o){
                return right;
            }
            return null;
        }
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
     * 1.对于任意结点 curNode，若该结点不为空则访问该结点后再将结点压栈，并将左子树结点置为 curNode，重复此操作，直到 curNode 为空。
     * 2.若左子树为空，栈顶结点出栈，将该结点的右子树置为 curNode
     * 3.重复1、2步操作，直到 curNode 为空且栈内结点为空。
     */
    @Override
    public void preOrderByStack() {
        LinkStack<TreeNode> stack = new LinkStack<TreeNode>();
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
     * 1.对于任意结点 curNode，若该结点不为空则将该结点压栈，并将左子树结点置为 curNode，重复此操作，直到 curNode 为空。
     * 2.若左子树为空，栈顶结点出栈，访问结点后将该结点的右子树置为 curNode
     * 3.重复1、2步操作，直到 curNode 为空且栈内结点为空
     */
    @Override
    public void inOrderByStack() {
        LinkStack<TreeNode> stack = new LinkStack<TreeNode>();
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
     * 1.对于任意结点curNode，若该结点不为空则访问该结点后再将结点压栈，并将左子树结点置为 curNode，重复此操作，直到 curNode 为空。
     * 2.若左子树为空，取栈顶结点的右子树，如果右子树为空或右子树刚访问过，则访问该结点，并将preNode置为该结点
     * 3.重复1、2步操作，直到 curNode 为空且栈内结点为空。
     */
    @Override
    public void postOrderByStack() {
        LinkStack<TreeNode> stack = new LinkStack<TreeNode>();
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

    /**
     * 层次遍历：
     * 1.对于任意结点 curNode，先把该结点放入队列中
     * 2.从队中拿出结点，如果该结点的左右结点不为空，就把左右结点加入到队列中
     * 3.重复1、2步操作，直到 curNode 为空且队列内节结点为空。
     */
    @Override
    public void levelOrderByStack() {
        LinkQueue<TreeNode> queue = new LinkQueue<TreeNode>();
        TreeNode curNode;
        queue.add(root);
        while(!queue.isEmpty()){
            curNode = queue.peek();
            queue.poll();
            System.out.print(curNode.getData() + " ");
            if (curNode.getLeftChild()!=null){
                queue.add(curNode.getLeftChild());
            }
            if (curNode.getRightChild()!=null){
                queue.add(curNode.getRightChild());
            }
        }
        System.out.println();
    }
}
