package ArraysQueue;

/**
 * @Author: cuizhe
 * @Date: 2019/1/23 11:18
 */
public class ArrayQueueTest {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        System.out.println("队列是否为空-----"+queue.isEmpty());
        System.out.println("队列长度---------"+queue.length());
        System.out.println("入队");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println("队列是否为空-----"+queue.isEmpty());
        System.out.println("队列长度---------"+queue.length());
        System.out.println("队首元素---------"+queue.peek());
        System.out.println("出队");
        queue.poll();
        System.out.println("队首元素---------"+queue.peek());
    }
}
