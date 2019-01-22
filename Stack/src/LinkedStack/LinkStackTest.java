package LinkedStack;

/**
 * @Author: cuizhe
 * @Date: 2019/1/22 19:28
 */
public class LinkStackTest {

    public static void main(String[] args) {
        LinkStack<Integer> stack = new LinkStack<>();
        System.out.println("栈是否为空-----"+stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        System.out.println("栈是否为空-----"+stack.isEmpty());
        System.out.println("栈顶数据为-----"+stack.peek());
        System.out.println("栈的长度为-----"+stack.length());
        System.out.println("打印栈：");
        stack.printStack();
    }

}
