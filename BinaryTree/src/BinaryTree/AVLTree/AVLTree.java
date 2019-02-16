package BinaryTree.AVLTree;

import java.util.LinkedList;

/**
 * @Author: cuizhe
 * @Date: 2019/2/12 21:31
 */
public class AVLTree {

    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    public void setRoot(AVLNode root) {
        this.root = root;
    }

    public AVLTree() {
        root = null;
    }

    public class AVLNode {
        private Integer data;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;

        public AVLNode(int data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public AVLNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(AVLNode leftChild) {
            this.leftChild = leftChild;
        }

        public AVLNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(AVLNode rightChild) {
            this.rightChild = rightChild;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    //计算节点高度
    public int height(AVLNode avlNode) {
        return avlNode == null ? -1 : avlNode.getHeight();
    }

    //左-左型
    public AVLNode L_Rotate(AVLNode avlNode) {
        //旋转
        AVLNode curNode = avlNode.getLeftChild();
        avlNode.setLeftChild(curNode.getRightChild());
        curNode.setRightChild(avlNode);

        //重新计算高
        curNode.setHeight(Math.max(height(curNode.getLeftChild()), height(curNode.getRightChild())) + 1);
        avlNode.setHeight(Math.max(height(avlNode.getLeftChild()), height(avlNode.getRightChild())) + 1);

        return curNode;
    }

    //右-右型
    public AVLNode R_Rotate(AVLNode avlNode) {
        //旋转
        AVLNode curNode = avlNode.getRightChild();
        avlNode.setRightChild(curNode.getLeftChild());
        curNode.setLeftChild(avlNode);
        //重新计算高
        curNode.setHeight(Math.max(height(curNode.getLeftChild()), height(curNode.getRightChild())) + 1);
        avlNode.setHeight(Math.max(height(avlNode.getLeftChild()), height(avlNode.getRightChild())) + 1);

        return curNode;
    }

    //左-右型，先右旋，再左旋
    public AVLNode L_R_Rotate(AVLNode avlNode) {
        //旋转
        avlNode.setLeftChild(R_Rotate(avlNode.getLeftChild()));
        return L_Rotate(avlNode);
    }

    //右-左型，先左旋，再右旋
    public AVLNode R_L_Rotate(AVLNode avlNode) {
        //旋转
        avlNode.setRightChild(L_Rotate(avlNode.getRightChild()));
        return R_Rotate(avlNode);
    }

    public void add(Integer data) {
        if (data == null) {
            throw new RuntimeException("data can\'t not be null ");
        } else {
            this.root = add(data, root);
        }
    }

    private AVLNode add(Integer data,AVLNode avlNode){
        if (avlNode==null){
            avlNode = new AVLNode(data);
        }else if (data<avlNode.getData()){
            avlNode.setLeftChild(add(data,avlNode.getLeftChild()));
            if (height(avlNode.getLeftChild())-height(avlNode.getRightChild())==2){
                if (data < avlNode.getLeftChild().getData()){
                    avlNode = L_Rotate(avlNode);
                }else {
                    avlNode = L_R_Rotate(avlNode);
                }
            }
        }else if (data > avlNode.getData()){
            avlNode.setRightChild(add(data,avlNode.getRightChild()));
            if (height(avlNode.getRightChild())-height(avlNode.getLeftChild())==2){
                if (data < avlNode.getRightChild().getData()){
                    avlNode = R_L_Rotate(avlNode);
                }else {
                    avlNode = R_Rotate(avlNode);
                }
            }
        }
        avlNode.setHeight(Math.max(height(avlNode.getLeftChild()),height(avlNode.getRightChild()))+1);
        return avlNode;
    }

    public void remove(Integer data){
        if (data==null){
            throw new RuntimeException("data can\'t not be null ");
        }else {
            remove(data,root);
        }
    }

    private AVLNode remove(Integer data,AVLNode avlNode){
        if (avlNode==null){
            return null;
        }
        //从左子树查找要进行删除的元素
        if (data<avlNode.getData()){
            avlNode.setLeftChild(remove(data,avlNode.getLeftChild()));
            if (height(avlNode.getRightChild())-height(avlNode.getLeftChild())==2){
                AVLNode curNode = avlNode.getRightChild();
                //判断需要进行那种旋转
                if (height(curNode.getLeftChild())>height(curNode.getRightChild())){
                    //RL
                    avlNode=R_L_Rotate(avlNode);
                }else {
                    //RR
                    avlNode=R_Rotate(avlNode);
                }
            }
        }else if (data> avlNode.getData()){
            //从右子树查找要进行删除的元素
            avlNode.setRightChild(remove(data,avlNode.getRightChild()));
            if (height(avlNode.getLeftChild())-height(avlNode.getRightChild())==2){
                AVLNode curNode = avlNode.getLeftChild();
                //判断需要进行那种旋转
                if (height(curNode.getRightChild())>height(curNode.getLeftChild())){
                    //LR
                    avlNode=L_R_Rotate(avlNode);
                }else {
                    //LL
                    avlNode=L_Rotate(avlNode);
                }
            }
        }else if (avlNode.getRightChild()!=null && avlNode.getLeftChild()!=null){
            //有两个子结点，需要寻找替换的结点
            avlNode.setData(findMin(avlNode.getRightChild()).getData());
            //移除被替换的节点
            avlNode.setRightChild(remove(avlNode.getData(),avlNode.getRightChild()));
        }else {
            //只有一个孩子，或者是叶子结点的情况
            avlNode = (avlNode.getLeftChild()!=null)?avlNode.getLeftChild():avlNode.getRightChild();
        }
        if (avlNode!=null){
            //更新高度
            avlNode.setHeight(Math.max(height(avlNode.getLeftChild()),height(avlNode.getRightChild()))+1);
        }
        return avlNode;
    }

    /**
     * 查找最小值结点
     * @param avlNode 查找以 avlNode 为根下的最小值的结点
     * @return
     */
    private AVLNode findMin(AVLNode avlNode) {
        if (avlNode==null)//结束条件
            return null;
        else if (avlNode.getLeftChild()==null)//如果没有左结点,那么t就是最小的
            return avlNode;
        return findMin(avlNode.getLeftChild());
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void preOrderTraverse() {
        if (root != null){
            preOrderTraverse(root);
            System.out.println();
        }
    }

    private void preOrderTraverse(AVLNode treeNode) {
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

    private void inOrderTraverse(AVLNode treeNode) {
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

    private void postOrderTraverse(AVLNode treeNode) {
        if (treeNode != null){
            postOrderTraverse(treeNode.getLeftChild());
            postOrderTraverse(treeNode.getRightChild());
            System.out.print(treeNode.getData() + " ");
        }
    }
    //非递归前中后，
    public void preOrderByStack(){
        AVLNode curNode = root;
        LinkedList<AVLNode> stack = new LinkedList<>();
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

    public void inOrderByStack(){
        AVLNode curNode = root;
        LinkedList<AVLNode> stack = new LinkedList<>();
        while (curNode!=null || !stack.isEmpty()){
            while (curNode!=null && curNode.getData()!=null){
                stack.push(curNode);
                curNode = curNode.getLeftChild();
            }
            if (!stack.isEmpty()){
                curNode = stack.pop();
                System.out.print(curNode.getData()+" ");
                curNode = curNode.getRightChild();
            }
        }
        System.out.println();
    }

    public void postOrderByStack(){
        AVLNode curNode = root;
        AVLNode preNode = null;
        LinkedList<AVLNode> stack = new LinkedList<>();
        while (curNode!=null || !stack.isEmpty()){
            while (curNode!=null && curNode.getData()!=null){
                stack.push(curNode);
                curNode = curNode.getLeftChild();
            }
            if (!stack.isEmpty()){
                curNode = stack.peek().getRightChild();
                if (curNode==null || curNode==preNode){
                    curNode = stack.pop();
                    if (curNode.getData()!=null){
                        System.out.print(curNode.getData()+" ");
                    }
                    preNode = curNode;
                    curNode = null;
                }
            }
        }
        System.out.println();
    }
    //层次遍历
    public void levelOrderByQueue(){
        AVLNode curNode = root;
        LinkedList<AVLNode> queue = new LinkedList<>();
        queue.add(curNode);
        while (!queue.isEmpty()){
            curNode = queue.poll();
            if (curNode.getData()!=null){
                System.out.print(curNode.getData()+" ");
            }
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
