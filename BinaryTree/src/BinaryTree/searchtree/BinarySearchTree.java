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

    public void remove(Integer data){
        Node delNode = root;//需要删除的结点
        Node parent = null;//删除结点的父节点
        boolean isLeftChild = true;//判断是左结点还是右结点

        //确定父节点以及确定是父结点的左结点还是右结点
        while (true){
            if (data == delNode.getData()){
                break;
            }else if (data<delNode.getData()){
                isLeftChild = true;
                parent = delNode;
                delNode = delNode.getLeftChild();
            }else if (data>delNode.getData()){
                isLeftChild = false;
                parent = delNode;
                delNode = delNode.getRightChild();
            }
            if (delNode == null){
                System.out.println("结点不存在");
                return;
            }
        }

        //分情况考虑
        //1.要删除的结点是叶子结点
        if (delNode.getLeftChild()==null && delNode.getRightChild()==null){
            if (delNode==root){
                delNode = null;
            }else {
                //如果该结点是父节点的左结点,将父节点的左结点置为NULL;否则，将右结点置为NULL
                if (isLeftChild){
                    parent.setLeftChild(null);
                }else {
                    parent.setRightChild(null);
                }
            }
        }else if (delNode.getRightChild() == null){
            //2.需要删除的结点有一个子结点，且该子节点为左子结点
            if (delNode==root){
                //如果该结点为根节点，将根节点的左子结点变为根
                setRoot(delNode.getLeftChild());
            }else {
                if (isLeftChild){
                    //如果该结点是父结点的左子结点，将该结点的左子结点变为父节点的左子结点
                    parent.setLeftChild(delNode.getLeftChild());
                }else {
                    //如果该结点是父结点的右结点，将该结点的左子结点变为父节点的右子结点
                    parent.setRightChild(delNode.getLeftChild());
                }
            }
        }else if (delNode.getLeftChild() == null){
            //2.需要删除的结点有一个子结点，且该子结点为右子结点
            if (delNode==root){
                //如果该结点为根节点，将根节点的右子结点变为根
                setRoot(delNode.getRightChild());
            }else {
                if (isLeftChild){
                    //如果该结点是父结点的左子结点，将该结点的右子结点变为父节点的左子结点
                    parent.setLeftChild(delNode.getRightChild());
                }else {
                    //如果该结点是父结点的右子结点，将该结点的右子结点变为父节点的右子结点
                    parent.setRightChild(delNode.getRightChild());
                }
            }
        }else {
            //3.需要删除的节点有两个子结点，需要寻找该结点的后续结点替代删除结点
            Node next = getNext(delNode);
            //如果该结点为根节点，将后继结点变为根节点，并将根节点的左子结点变为后继结点的左子结点
            if (delNode==root){
                setRoot(next);
            }else {
                if (isLeftChild){
                    parent.setLeftChild(next);
                }else {
                    parent.setRightChild(next);
                }
            }
        }
        return ;
    }

    private Node getNext(Node delNode) {
        Node next = delNode;
        Node nextParent = null;
        Node curNode = delNode.getRightChild();

        while (curNode!=null){
            nextParent = next;
            next = curNode;
            curNode = curNode.getLeftChild();
        }
        //如果后继结点不是删除结点的右子结点时
        if (next != delNode.getRightChild()){
            //要将后继结点的右子结点指向后继结点的父节点的左子结点
            nextParent.setLeftChild(next.getRightChild());
            //并将删除结点的右子结点指向后继结点的右子结点
            next.setRightChild(delNode.getRightChild());
        }
        //任何情况下，都需要将删除结点的左子结点指向后继结点的左子结点
        next.setLeftChild(delNode.getLeftChild());
        return next;
    }

    public boolean isEmpty(){
        return root==null;
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
