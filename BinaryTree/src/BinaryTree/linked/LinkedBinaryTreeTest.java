package BinaryTree.linked;

import BinaryTree.TreeNode;

/**
 * @Author: cuizhe
 * @Date: 2019/1/24 22:45
 */
public class LinkedBinaryTreeTest {

    public static void main(String[] args) {
        /**
         * 创建二叉树,从叶子结点开始
         *           1
         *       /     \
         *      4       2
         *       \    /  \
         *        5  3    6
         *                 \
         *                  7
         */
        TreeNode<Integer> node5 = new TreeNode<Integer>(5,null,null);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4,null,node5);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7,null,null);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6,null,node7);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3,null,null);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2,node3,node6);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1,node4,node2);

        LinkedBinaryTree<Integer> binaryTree = new LinkedBinaryTree<>();
        System.out.println("判断二叉树是否为空：" + binaryTree.isEmpty());
        binaryTree.setRoot(node1);
        System.out.println("判断二叉树是否为空：" + binaryTree.isEmpty());

        System.out.println("前序遍历：");//1452367
        binaryTree.preOrderTraverse();
        System.out.println("中序遍历：");//4513267
        binaryTree.inOrderTraverse();
        System.out.println("后序遍历：");//5437621
        binaryTree.postOrderTraverse();

        System.out.println("非递归前序遍历：");
        binaryTree.preOrderByStack();
        System.out.println("非递归中序遍历：");
        binaryTree.inOrderByStack();
        System.out.println("非递归后序遍历：");
        binaryTree.postOrderByStack();

        System.out.println("层次遍历：");//1425367
        binaryTree.levelOrderByStack();

        System.out.println("树的高度为：");
        System.out.println(binaryTree.getHeight());

        System.out.println("树的结点数：");
        System.out.println(binaryTree.size());

        System.out.println("查找数据为2的结点");
        System.out.println(binaryTree.findKey(2));

        System.out.println("查找数据为13的结点");
        System.out.println(binaryTree.findKey(13));
    }
}
