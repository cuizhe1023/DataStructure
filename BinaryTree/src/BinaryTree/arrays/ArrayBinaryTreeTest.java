package BinaryTree.arrays;

/**
 * @Author: cuizhe
 * @Date: 2019/1/24 22:44
 */
public class ArrayBinaryTreeTest {

    public static void main(String[] args) {
        /**
         * 创建二叉树,从叶子结点开始
         *           1                                                       1
         *       /     \                                   /                                     \
         *      4       2                                 4                                       2
         *       \    /  \         ->            /                 \                     /                 \
         *        5  3    6                    null                 5                   3                   6
         *                 \               /        \          /        \          /        \          /        \
         *                  7            null      null      null      null      null      null      null        7
         */

        Integer array[] = {1,4,2,null,5,3,6,null,null,null,null,null,null,null,7};
        ArrayBinaryTree arrayTree = new ArrayBinaryTree();
        System.out.println("判断二叉树是否为空：" + arrayTree.isEmpty());
        arrayTree.createTree(array);
        System.out.println("判断二叉树是否为空：" + arrayTree.isEmpty());

        System.out.println("前序遍历：");//1452367
        arrayTree.preOrderTraverse();
        System.out.println("中序遍历：");//4513267
        arrayTree.inOrderTraverse();
        System.out.println("后序遍历：");//5437621
        arrayTree.postOrderTraverse();

        System.out.println("非递归前序遍历：");
        arrayTree.preOrderByStack();
        System.out.println("非递归中序遍历：");
        arrayTree.inOrderByStack();
        System.out.println("非递归后序遍历：");
        arrayTree.postOrderByStack();

        System.out.println("层次遍历：");//1425367
        arrayTree.levelOrderByStack();

        System.out.println("树的高度为：");
        System.out.println(arrayTree.getHeight());

        System.out.println("树的结点数：");
        System.out.println(arrayTree.size());

        System.out.println("查找数据为2的结点：");
        System.out.println(arrayTree.findKey(2));

        System.out.println("查找数据为13的结点：");
        System.out.println(arrayTree.findKey(13));
    }

}
