package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/06/25/15:00
 * @Description:
 */

import org.junit.Test;

import java.util.*;

/**
 *  *          Collection接口：单列集合：用来储存一个一个的对象
 *  *                  List :存储有序的，可重复的数据    “动态”数组,替换原有的数组
 *  *                      ArrayList : 作为List接口的主要实现类;线程不安全的，效率高，底层使用Object[] elenData存储
 *                         LinkedList : 对于频繁的插入，删除操作，使用此类效率比ArrayList高; 底层使用双向链表存储;
 *                         Vector : 作为List接口的古老实现类:线程安全的，效率低；底层使用Object[]存储
 *2 ArrayList的源码分析：
 * 2.1 jdk7
 * ArrayList list = new ArrayLIst() ： 底层创建了长度为10的Onject[]数据elementData
 * list.add(123);elementData[0] = new Interger(123);
 * list.add(11);如果此次添加导致底层数组容量不够，则扩容，
 * 默认情况下，扩容为原来的容量的1.5倍。同时需要将原有数组中的数据复制到新的数组中。
 * 结论;建议开发中使用带参的构造器，Arraylist list = new Arraylist(int capacity)
 *
 * 2.2 jdk 8中ArrayList的变化：
 *  ArrayList list = new ArrayLIst()  ;//底层Object[] element初始化为{}，并没有创建长度为
 *
 *  list.add(123);第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到element
 *  ...
 *  后续的添加和扩容操作与jdk7.0 无异
 *
 *  2.3小结：jdk 7中的ArrayList的创建类似于单例的懒汉式，而jdk8中的ArrayList
 *  的对象的创建类似于单例的懒汉式，延迟了数据的创建，节省内存
 *
 *  3.LinkedList源码分析
 *      LinkedList list = new LinkList():内部声明了Node类型的first和last属性，默认值为null
 *      list.add(12);将12封装到Node中，创建Node对象
 *
 *      其中，Node定义为：体现了LinkedList的双向链表的说法
 *          private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *     4.Vector的源码分析，jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组;
 *     在扩容方面，默认扩容为原来数组长度的2倍；
 *
 *  面试题：ArrayList,LinkedList,Vector三者的异同？
 *  同：三个接口都是实现了List接口，存储数据的特点相同：存储有序的，可重复的数据
 *  不同：见上
 */

/**
 * void add(int index, Object ele):在index位置插入ele元素
 * boolean addAll(int index, Collection eles):从index位置开始将eles中
 * 的所有元素添加进来
 * Object get(int index):获取指定index位置的元素
 * int indexOf(Object obj):返回obj在集合中首次出现的位置
 * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 * Object remove(int index):移除指定index位置的元素，并返回此元素
 * Object set(int index, Object ele):设置指定index位置的元素为ele
 * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
 * 位置的子集合
 *
 * 总结：常用方法：
 * 增：add,
 * 删:remove(int index) ,
 * 改:set
 * 查 :get
 * 插入add(int index,Object obj);
 * 长度:size()
 * 遍历:1.Iterator 迭代器方式
 *  2.增强for循环
 *  3.普通的循环
 */
public class ListTest {
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：1.Iterator 迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //方式二：增强for循环
        for (Object obj : list){
            System.out.println(obj);
        }
        //方式三：普通的for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        System.out.println(list);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println(list.indexOf(456));

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf(1));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex 左闭右开的区间
        List list1 = list.subList(2, 4);
        System.out.println(list1);

    }

    @Test
    public void test1(){

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        System.out.println(list);


        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);
        //boolean addAll(int index, Collection eles):从index位置开始将eles中       * 的所有元素添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size());//5 + 3
        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));
    }



    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
