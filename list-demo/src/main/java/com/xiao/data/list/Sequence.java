package com.xiao.data.list;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2019-08-28 11:09
 * @Description
 **/
public class Sequence<E> {
    //存储元素的数组
    private Object[] elem;
    //数组的容量
    private int capacity;
    //顺序表的实际大小
    private int size;

    public Sequence(int capacity){
        if (capacity<0){
            throw new RuntimeException("初始容量不能小于0");
        }
        this.capacity=capacity;
        elem=new Object[capacity];
        size =0;
    }

    public Sequence(){
        this(10);
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        checkIndexBounds(index);
        return (E) elem[index];
    }

    /**
     * 查找某元素在顺序表中是否存在
     * @param e
     * @return 存在则返回下标，否则返回-1
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (elem[i]==e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 向指定位置添加元素
     * @param e
     * @param index
     * @return
     */
    public boolean add(E e,int index) {
        if (index<0 || index>size){
            return false;
        }
        checkCapacity();
        for (int i = size -1; i>=index; i--){
            elem[i+1]=elem[i];
        }
        elem[index]=e;
        size++;
        System.out.println(elem);
        return true;
    }

    /**
     * 向顺序表尾巴添加元素
     * @param e
     */
    public void add(E e){
        checkCapacity();
        elem[size++]=e;
    }

    /**
     * 移除指定位置的元素
     * @param index
     */
    public void remove(int index){
        checkIndexBounds(index);
        for (int i = index; i< size -1; i++){
            elem[i]=elem[i+1];
        }
        elem[--size]=null;
    }

    /**
     * 移除顺序表中最后一个元素
     */
    public void remove(){
        elem[--size]=null;
    }

    /**
     * 修改指定位置上的元素
     * @param e
     * @param index
     */
    public void set(E e,int index){
        checkIndexBounds(index);
        elem[index]=e;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    /**
     * 若顺序表大小超过数组容量，则根据下面的增长策略增加数组容量，并拷贝原来的数组
     */
    private void checkCapacity(){
        if (size>=capacity){
            capacity=capacity+(int) (capacity*0.5f);
            elem= Arrays.copyOf(elem,capacity);
        }
    }

    /**
     * 检查数组下标是否越界
     * @param index
     */
    private void checkIndexBounds(int index){
        if (index<0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}


class TestSequence{
    public static void main(String[] args) {
        Sequence seq = new Sequence();
        seq.add(10, 2);


    }
}