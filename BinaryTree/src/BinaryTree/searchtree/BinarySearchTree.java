package BinaryTree.searchtree;

import BinaryTree.Node;

import java.util.LinkedList;

/**
 * @Author: cuizhe
 * @Date: 2019/2/9 16:28
 */
public class BinarySearchTree{

    private Node root;//根结点

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinarySearchTree() {
        root = null;
    }

    public void add(Integer data){
        Node newNode = new Node(data);
        if (root==null){
            root = newNode;
            root.setLeftChild(null);
            root.setRightChild(null);
        }else {
            Node curNode = root;
            Node parent = null;
            while (true){
                if (data<curNode.getData()){
                    parent = curNode;
                    curNode = curNode.getLeftChild();
                    if (curNode == null){
                        parent.setLeftChild(newNode);
                        break;
                    }
                }else if (data>curNode.getData()){
                    parent = curNode;
                    curNode = curNode.getRightChild();
                    if (curNode == null){
                        parent.setRightChild(newNode);
                        break;
                    }
                }else {
                    System.out.println("插入了重复的值");
                    break;
                }
            }
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size() {
        return size(root);
    }

    public int size(Node node){
        if (node==null){
            return 0;
        }else {
            int left = size(node.getLeftChild());
            int right = size(node.getRightChild());
            return left+right+1;
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(Node treeNode){
        if (treeNode == null){
            return 0;
        }
        int left = getHeight(treeNode.getLeftChild());
        int right = getHeight(treeNode.getRightChild());
        return left>right?(left+1):(right+1);
    }

    public Node findKey(Integer data) {
        return findKey(data,root);
    }

    public Node findKey(Integer data,Node node){
        if (node==null){
            return null;
        }
        while (node!=null){
            if (data<node.getData()){
                node = node.getLeftChild();
            }else if (data>node.getData()){
                node = node.getRightChild();
            }else {
                return node;
            }
        }
        return null;
    }

    public void preOrderTraverse() {
        if (root != null){
            preOrderTraverse(root);
            System.out.println();
        }
    }

    private void preOrderTraverse(Node treeNode) {
        if (treeNode != null){
            System.out.print(treeNode.getData() + " ");
            preOrderTraverse(treeNode.getLeftChild());
            preOrderTraverse(treeNode.getRightChild());
        }
    }

    public void inOrderTraverse() {
        if (root != null){
            inOrderTraverse(root);
            System.out.println();
        }
    }

    private void inOrderTraverse(Node treeNode) {
        if (treeNode != null){
            inOrderTraverse(treeNode.getLeftChild());
            System.out.print(treeNode.getData() + " ");
            inOrderTraverse(treeNode.getRightChild());
        }
    }

    public void postOrderTraverse() {
        if (root != null){
            postOrderTraverse(root);
            System.out.println();
        }
    }

    private void postOrderTraverse(Node treeNode) {
        if (treeNode != null){
            postOrderTraverse(treeNode.getLeftChild());
            postOrderTraverse(treeNode.getRightChild());
            System.out.print(treeNode.getData() + " ");
        }
    }

    public void preOrderByStack() {
        LinkedList<Node> stack = new LinkedList<Node>();
        Node curNode = root;
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

    public void inOrderByStack() {
        LinkedList<Node> stack = new LinkedList<Node>();
        Node curNode = root;
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

    public void postOrderByStack() {
        LinkedList<Node> stack = new LinkedList<Node>();
        Node curNode = root;
        Node preNode = null;
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

    public void levelOrderByStack() {
        LinkedList<Node> queue = new LinkedList<Node>();
        Node curNode = root;
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
