package stack.arrays;

/**
 * @Author: cuizhe
 * @Date: 2019/1/22 19:27
 */
public class ArraysStackTest {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
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
        System.out.println("栈是否满了-----"+stack.isFull());
        System.out.println("打印栈：");
        stack.printStack();
    }

}
