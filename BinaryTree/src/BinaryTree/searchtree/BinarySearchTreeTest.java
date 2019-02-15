package BinaryTree.searchtree;

/**
 * @Author: cuizhe
 * @Date: 2019/2/9 16:28
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        System.out.println("判断二叉树是否为空：" + binarySearchTree.isEmpty());
        binarySearchTree.add(8);
        binarySearchTree.add(3);
        binarySearchTree.add(10);
        binarySearchTree.add(1);
        binarySearchTree.add(6);
        binarySearchTree.add(14);
        binarySearchTree.add(4);
        binarySearchTree.add(7);
        binarySearchTree.add(13);
        System.out.println("判断二叉树是否为空：" + binarySearchTree.isEmpty());

        System.out.println("根："+binarySearchTree.getRoot().getData());

        System.out.println("前序遍历：");//8,3,1,6,4,7,10,14,13
        binarySearchTree.preOrderTraverse();
        System.out.println("中序遍历：");//1,3,4,6,7,8,10,13,14
        binarySearchTree.inOrderTraverse();
        System.out.println("后序遍历：");//1,4,7,6,3,13,14,10,8
        binarySearchTree.postOrderTraverse();


        System.out.println("非递归前序遍历：");
        binarySearchTree.preOrderByStack();
        System.out.println("非递归中序遍历：");
        binarySearchTree.inOrderByStack();
        System.out.println("非递归后序遍历：");
        binarySearchTree.postOrderByStack();

        System.out.println("层次遍历：");//8,3,10,1,6,14,4,7,13
        binarySearchTree.levelOrderByStack();

        System.out.println("根："+binarySearchTree.getRoot().getData());

        System.out.println("树的高度为：");
        System.out.println(binarySearchTree.getHeight());

        System.out.println("树的结点数：");
        System.out.println(binarySearchTree.size());

        System.out.println("查找数据为2的结点：");
        System.out.println(binarySearchTree.findKey(2));

        System.out.println("查找数据为13的结点：");
        System.out.println(binarySearchTree.findKey(13));

        System.out.println("层次遍历：");//8,3,10,1,6,14,4,7,13
        binarySearchTree.levelOrderByStack();
        System.out.println("中序遍历：");//1,3,4,6,7,8,10,13,14
        binarySearchTree.inOrderTraverse();

        binarySearchTree.remove(3);
        binarySearchTree.levelOrderByStack();

        System.out.println("中序遍历：");//1,3,4,6,7,8,10,13,14
        binarySearchTree.inOrderTraverse();
    }

}
