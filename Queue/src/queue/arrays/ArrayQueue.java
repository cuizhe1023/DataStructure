package queue.arrays;

/**
 * @Author: cuizhe
 * @Date: 2019/1/23 11:18
 */
public class ArrayQueue<T> {
    private int front;//队头
    private int rear;//队尾
    private int maxSize = 0;//队列容量
    private Object[] elem;//通过数组实现队列

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int size) {
        if (size >= 0){
            this.maxSize = size;
            elem = new Object[maxSize];
            front = rear = 0;
        }else {
            throw new RuntimeException("初始化大小不能小于0：" + size);
        }
    }

    /**
     * 入队
     */
    public void add(T data){
        if (rear==maxSize){
            throw new RuntimeException("队列已满");
        }
        elem[rear] = data;
        rear++;
    }

    /**
     * 出队
     */
    public void poll(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }else {
            elem[front] = null;
            front++;
        }
    }

    /**
     * 返回队首元素
     * @return 队首元素
     */
    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }else {
            return (T) elem[front];
        }
    }

    /**
     * 判空
     */
    public boolean isEmpty(){
        return front==rear;
    }

    /**
     * 队列长度
     * @return 队列长度
     */
    public int length(){
        return rear-front;
    }

}
