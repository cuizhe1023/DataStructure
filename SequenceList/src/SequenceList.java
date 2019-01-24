import java.util.Arrays;

/**
 * @Author: cuizhe
 * @Date: 2019/1/24 12:16
 */
public class SequenceList<T> {
    private T[] elem= null;//通过数组来构建一个顺序表
    private int maxSize;//数组的长度
    private int curSize;//数组中有效元素的长度

    public SequenceList() {
        this(10);
    }

    public SequenceList(int maxSize) {
        if (maxSize >= 0){
            this.maxSize = maxSize;
            this.elem = (T[]) new Object[maxSize];
            this.curSize = 0;
        }else {
            throw new RuntimeException("初始化数组失败，数组大小不能小于0");
        }
    }

    /**
     * 获取数组的大小
     * @return 数组大小
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * 获取顺序表的大小
     * @return 顺序表的大小
     */
    public int getCurSize() {
        return curSize;
    }

    /**
     * 向顺序表中添加数据，首先判断是否为空，再看顺序表扩容，之后对其进行添加操作。
     * @param data
     */
    public void add(T data){
        if (elem==null){
            throw new RuntimeException("顺序表为空");
        }
        ensureCapacity();
        elem[curSize] = data;
        curSize++;
    }

    /**
     * 扩容操作，如果顺序表的大小和数组大小相等，便将其扩容2倍
     */
    public void ensureCapacity(){
        if (curSize >= maxSize){
            maxSize = maxSize * 2;
            elem = Arrays.copyOf(elem,maxSize);
        }
    }

    /**
     * 对指定位置的元素进行删除
     * 先判断是否有效，接着通过循环让目标位置之后的元素覆盖前一个元素，在将最后一个有效的元素置为null，长度-1
     *
     * @param index 指定位置
     */
    public void remove(int index){
        if (elem==null || curSize==0){
            throw new RuntimeException("顺序表为空");
        }
        if (index>curSize||index<0){
            throw new RuntimeException("输入不合法");
        }
        for (int i = index; i < curSize; i++) {
            elem[i] = elem[i+1];
        }
        elem[curSize]=null;
        curSize--;
    }

    /**
     * 对指定位置的元素进行替换
     * 判断输入是否合法，然后直接替换
     *
     * @param index 指定的位置
     * @param data 替换的元素
     */
    public void set(int index,T data){
        if (elem==null || curSize==0){
            throw new RuntimeException("顺序表为空");
        }
        if (index>curSize||index<0){
            throw new RuntimeException("输入不合法");
        }
        elem[index] = data;
    }

    /**
     * 获取指定元素的数据
     *
     * @param index 指定位置
     * @return 指定位置的数据
     */
    public T get(int index){
        if (elem==null || curSize==0){
            throw new RuntimeException("顺序表为空");
        }
        if (index>curSize||index<0){
            throw new RuntimeException("输入不合法");
        }
        return elem[index];
    }

    /**
     * 在指定位置添加数据
     * 判断输入是否合法，如果满了，进行扩容
     * 将指定位置后的元素向后移，对指定元素进行赋值
     * 长度+1
     *
     * @param index
     * @param data
     */
    public void addByIndex(int index,T data){
        if (isEmpty()){
            throw new RuntimeException("顺序表为空");
        }
        if (index>curSize||index<0){
            throw new RuntimeException("输入不合法");
        }
        if (isFull()){
            ensureCapacity();
        }
        for (int i = curSize-1; i >= index ; i--) {
            elem[i+1] = elem[i];
        }
        elem[index] = data;
        curSize++;
    }

    /**
     * 判断顺序表是否为空
     * @return ture/false
     */
    public boolean isEmpty(){
        return curSize == 0 || elem==null;
    }

    /**
     * 判断顺序表是否满了
     * @return true/false
     */
    public boolean isFull(){
        return curSize==maxSize;
    }

    /**
     * 打印顺序表
     */
    public void print(){
        if (isEmpty()){
            throw new RuntimeException("表为空");
        }else {
            System.out.print("[");
            int i = 0;
            for (T t :
                    elem) {
                if (i == curSize-1){
                    System.out.println(t+"]");
                    break;
                }else {
                    System.out.print(t+",");
                }
                i++;
            }
        }
    }
}
