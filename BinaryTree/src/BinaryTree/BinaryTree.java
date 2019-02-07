package BinaryTree;

/**
 * 二叉树接口
 * 可以有不同的实现方式，每种实现方式可以使用不同的存储结构，比如顺序，链式等。
 * @Author: cuizhe
 * @Date: 2019/1/28 22:59
 */
public interface BinaryTree<T> {

    /**
     * 判断是否为空
     * @return true/false
     */
    public boolean isEmpty();

    /**
     * 二叉树节点数量
     * @return 二叉树节点数量
     */
    public int size();

    /**
     * 获取二叉树的高度
     * @return 二叉树高度
     */
    public int getHeight();

    /**
     * 查找指定值的结点
     * @param data 数据
     * @return 结点信息
     */
    public TreeNode findKey(T data);

    /**
     * 前序遍历--递归
     */
    public void preOrderTraverse();

    /**
     * 中序遍历--递归
     */
    public void inOrderTraverse();

    /**
     * 后序遍历--递归
     */
    public void postOrderTraverse();

    /**
     * 前序遍历--非递归
     */
    public void preOrderByStack();

    /**
     * 中序遍历--非递归
     */
    public void inOrderByStack();

    /**
     * 后序遍历--非递归
     */
    public void postOrderByStack();

    /**
     * 层次遍历
     */
    public void levelOrderByStack();
}
