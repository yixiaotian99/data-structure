package com.xiao.data.list;

import lombok.Data;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2019-08-28 10:10
 * @Description 使用java一维数组模拟顺序存储链表
 **/
@Data
public class SeqList {

    /**
     * 数组的长度，一般不变
     */
    private int MAX_SIZE = 10;

    /**
     * 定义存储数据的一维数组
     */
    private int[] data;

    /**
     * 定义线性表长度，会存着插入与删除长度变化
     */
    private int length;


    /**
     * 顺序链表的插入操作，因为顺序链表在物理上也是连续的空间存储，因此，插入必将导致后面的元素全体后移
     * 可以想像成火车站排队买票的场景，突然一个大姐插队，后面的人只能一个一个后向退
     * 那假如插入 i 的位置，那其实元素是插入到了下标为 i-1 与 i 元素之间
     * <p>
     * 一些基本的逻辑判断
     * 1. 当 i 的位置不合法(小于1或大于当前线性表长度)，抛出异常
     * 2. 当插入后超过顺序链表最大长度，抛出异常
     * 3. 插入的元素是 i 位置，下标为 i-1，则将 i-1 之后所有元素后移一位
     * 4. 插入元素
     * 5. 顺序链表长度加1
     *
     * @param index 位置信息，与下标 i-1 相对应
     * @param node  插入的元素
     */
    public void insertList(SeqList list, int index, int node) {

        //1. 位置判断
        if (index < 1 || index > list.length + 1) {
            System.out.println("postion error");
            return;
        }

        //2. 最大长度
        if (list.length >= list.MAX_SIZE) {
            System.out.println("overflow");
            return;
        }

        //3. 插入的元素不在队尾则直接插入，否则由下标 i-1 开始，所有后面元素后移一位
        if (index <= list.length) {
            //必须先对数组扩容，否则会报下标越界
            list.data = Arrays.copyOf(list.data, list.length + 1);

            for (int j = list.length - 1; j >= index - 1; j--) {
                //位置 j 的元素，变成 j+1 下标
                list.data[j + 1] = list.data[j];
            }
        }


        //4. 插入元素
        list.data[index - 1] = node;

        //5. 增加长度
        list.length++;

        System.out.println(Arrays.asList(list));
    }


    /**
     * 顺序表的删除操作，同插入操作相反，删除操作会将后面的元素全部前移
     * 假如删除 i 位置元素，其实是删除下标为 i-1 的元素，那后面的所有元素都将前移
     * <p>
     * 1. 当 i 位置不合法，抛出异常
     * 2. 取出删除的元素
     * 3. 从删除元素开始遍历到最后一个元素，将所有元素前移
     * 4. 表长减1
     */
    public int deleteList(SeqList list, int index) {
        //1. 位置判断
        if (index < 1 || index > list.length) {
            System.out.println("position error");
        }

        //2. 取出待删除元素
        int deleteNode = list.data[index - 1];

        //3. 元素前移
        for (int j = index; j < list.length; j++) {
            list.data[j - 1] = list.data[j];
        }

        //4. 表长减1
        list.length--;

        //SeqList(MAX_SIZE=10, data=[20, 30, 30], length=2)] 数组最后一个元素没有被清空
        System.out.println(Arrays.asList(list));
        return deleteNode;
    }
}


class TestSeqList {
    public static void main(String[] args) {

        //测试插入元素
        SeqList list = new SeqList();
        list.setData(new int[]{10, 20, 30});
        list.setLength(3);

        //list.insertList(list, 2, 50);

        System.out.println(list.deleteList(list, 1));
    }
}


















