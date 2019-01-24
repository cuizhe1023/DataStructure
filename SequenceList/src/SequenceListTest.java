/**
 * @Author: cuizhe
 * @Date: 2019/1/24 14:39
 */
public class SequenceListTest {

    public static void main(String[] args) {
        SequenceList<Integer> list = new SequenceList<>();
        System.out.println("顺序表为空："+list.isEmpty());
        System.out.println("顺序表长度："+list.getCurSize());
        System.out.println("数组长度"+list.getMaxSize());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        System.out.println("顺序表为空："+list.isEmpty());
        System.out.println("打印顺序表：");
        list.print();
        System.out.println("设置6个元素为6");
        list.set(6,7);
        System.out.println("顺序表长度："+list.getCurSize());
        System.out.println("数组长度"+list.getMaxSize());
        list.remove(2);
        System.out.println("在第三个位置插入3：");
        list.addByIndex(3,3);
        System.out.println("打印顺序表：");
        list.print();
        System.out.println("顺序表长度："+list.getCurSize());
        System.out.println("顺序表第三个元素是："+list.get(6));
    }

}
