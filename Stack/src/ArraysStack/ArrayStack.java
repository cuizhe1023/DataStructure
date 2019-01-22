package ArraysStack;

/**
 * @Author: cuizhe
 * @Date: 2019/1/22 19:07
 */
public class ArrayStack<T> {
    private int top;//栈顶指针
    private int maxSize = 0;//栈容量
    private Object[] elem;//通过数组实现栈

    public ArrayStack(){
        this(10);
    }

    public ArrayStack(int size){
        if (size >= 0){
            this.maxSize = size;
            elem = new Object[maxSize];
            top = -1;
        }else {
            throw new RuntimeException("初始化大小不能小于0：" + size);
        }
    }

    /**
     * 判断是否为空
     * @return true/false
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 判断栈是否满了
     * @return true/false
     */
    public boolean isFull(){
        return top == elem.length-1;
    }

    /**
     * 进栈，第一个元素top=0
     */
    public void push(T data){
        if (isFull()){
            throw new RuntimeException("栈已满，无法将元素入栈！");
        }else {
            elem[top+1] = data;
            top++;
        }
    }

    /**
     * 出栈
     */
    public void pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空！");
        }else {
            top--;
        }
    }

    /**
     * 查看栈顶数据
     * @return 栈顶数据
     */
    public T peek(){
        return (T) elem[top];
    }

    public void printStack(){
        System.out.print("[");
        for (int i = elem.length-1; i > -1; i--) {
            if (i > 0){
                System.out.print(elem[i]+"<-");
            }else{
                System.out.print(elem[i]+"]");
            }
        }
    }
}
