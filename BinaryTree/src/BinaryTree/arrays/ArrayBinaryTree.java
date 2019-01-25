package BinaryTree.arrays;

/**
 * @Author: cuizhe
 * @Date: 2019/1/24 22:40
 */
public class ArrayBinaryTree<T> {

    private class TreeNode<T>{
        T data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(T newData) {
            data = newData;
            leftChild = null;
            rightChild = null;
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



}
