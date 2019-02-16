package BinaryTree.AVLTree;

/**
 * @Author: cuizhe
 * @Date: 2019/2/12 21:31
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        System.out.println("判断二叉树是否为空：" + avlTree.isEmpty());
        avlTree.add(3);
        avlTree.add(2);
        avlTree.add(1);
        avlTree.add(4);
        avlTree.add(5);
        avlTree.add(6);
        avlTree.add(7);
        avlTree.add(10);
        avlTree.add(9);

        System.out.println("判断二叉树是否为空：" + avlTree.isEmpty());

        System.out.println("根："+avlTree.getRoot().getData());

        System.out.println("前序遍历：");//4,2,1,3,6,5,9,7,10
        avlTree.preOrderTraverse();
        System.out.println("中序遍历：");//1,2,3,4,5,6,7,9,10
        avlTree.inOrderTraverse();
        System.out.println("后序遍历：");//1,3,2,5,7,10,9,6,4
        avlTree.postOrderTraverse();
        System.out.println("层次遍历：");//4,2,6,1,3,5,9,7,10
        avlTree.levelOrderByQueue();

        System.out.println("删除6");
        avlTree.remove(6);

        System.out.println("非递归前序遍历：");//4,2,1,3,7,5,9,10
        avlTree.preOrderByStack();
        System.out.println("非递归中序遍历：");//1,2,3,4,5,7,9,10
        avlTree.inOrderByStack();
        System.out.println("非递归后序遍历：");//1,3,2,5,10,9,7,4
        avlTree.postOrderByStack();

        System.out.println("层次遍历：");//4,2,7,1,3,5,9,10
        avlTree.levelOrderByQueue();
    }
}
