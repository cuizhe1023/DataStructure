package BinaryTree.AVLTree;

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
        private int data;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;

        public AVLNode(int data) {
            this.data = data;
        }

        public int getData() {
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
        }else;
        avlNode.setHeight(Math.max(height(avlNode.getLeftChild()),height(avlNode.getRightChild()))+1);
        return avlNode;
    }

    public void remove(Integer data){
        if (data==null){
            throw new RuntimeException("data can\'t not be null ");
        }else {

        }
    }

    public AVLNode remove(Integer data,AVLNode avlNode){

        return avlNode;
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
}
