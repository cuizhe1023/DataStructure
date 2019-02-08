package BinaryTree.arrays;

import BinaryTree.BinaryTree;
import BinaryTree.TreeNode;

import java.util.LinkedList;

/**
 * @Author: cuizhe
 * @Date: 2019/1/24 22:40
 */
public class ArrayBinaryTree<T> implements BinaryTree {

    private TreeNode root;

    private LinkedList<TreeNode> list = null;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void createTree(T array[]) {
        list = new LinkedList<TreeNode>();
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            TreeNode treeNode = new TreeNode(array[nodeIndex]);
            list.add(treeNode);
        }
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            if (list.get(parentIndex * 2 + 1) != null) {
                list.get(parentIndex).setLeftChild(list.get(parentIndex * 2 + 1));
            }
            // 右孩子
            if (list.get(parentIndex * 2 + 2) != null) {
                list.get(parentIndex).setRightChild(list.get(parentIndex * 2 + 2));
            }
        }
        int lastParentIndex = array.length / 2 - 1;
        list.get(lastParentIndex).setLeftChild(list.get(lastParentIndex * 2 + 1));
        if (array.length % 2 == 1) {
            list.get(lastParentIndex).setRightChild(list.get(lastParentIndex * 2 + 2));
        }
        setRoot(list.get(0));
    }

    @Override
    public boolean isEmpty() {
        return list == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(TreeNode treeNode) {
        if (treeNode==null){
            return 0;
        }else {
            if (treeNode.getData()!=null) {
                int left = size(treeNode.getLeftChild());
                int right = size(treeNode.getRightChild());
                return left + right + 1;
            }
            return 0;
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
        if (root != null) {
            preOrderTraverse(root);
            System.out.println();
        }
    }

    private void preOrderTraverse(TreeNode treeNode) {
        if (treeNode != null && treeNode.getData()!=null) {
            System.out.print(treeNode.getData() + " ");
            preOrderTraverse(treeNode.getLeftChild());
            preOrderTraverse(treeNode.getRightChild());
        }
    }

    @Override
    public void inOrderTraverse() {
        if (root != null) {
            inOrderTraverse(root);
            System.out.println();
        }
    }

    private void inOrderTraverse(TreeNode treeNode) {
        if (treeNode != null && treeNode.getData()!=null) {
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

    private void postOrderTraverse(TreeNode treeNode){
        if (treeNode != null && treeNode.getData()!=null){
            postOrderTraverse(treeNode.getLeftChild());
            postOrderTraverse(treeNode.getRightChild());
            System.out.print(treeNode.getData()+" ");
        }
    }

    @Override
    public void preOrderByStack() {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        while (curNode!=null || !stack.isEmpty()){
            while (curNode!=null && curNode.getData()!=null){
                stack.push(curNode);
                System.out.print(curNode.getData()+" ");
                curNode = curNode.getLeftChild();
            }

            if (!stack.isEmpty()){
                curNode = stack.pop();
                curNode = curNode.getRightChild();
            }
        }
        System.out.println();
    }

    @Override
    public void inOrderByStack() {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()){
            while (curNode != null && curNode.getData() != null){
                stack.push(curNode);
                curNode = curNode.getLeftChild();
            }
            if (!stack.isEmpty()){
                curNode = stack.pop();
                System.out.print(curNode.getData() + " ");
                curNode = curNode.getRightChild();
            }
        }
        System.out.println();
    }

    @Override
    public void postOrderByStack() {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        TreeNode preNode = null;
        while (curNode!=null || !stack.isEmpty()){
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.getLeftChild();
            }
            if (!stack.isEmpty()){
                curNode = stack.peek().getRightChild();
                if (curNode == null || curNode == preNode){
                    curNode = stack.pop();
                    if (curNode.getData() != null)
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
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        queue.add(curNode);
        while (!queue.isEmpty()){
            curNode = queue.poll();
            if (curNode.getData() != null)
                System.out.print(curNode.getData()+" ");
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
