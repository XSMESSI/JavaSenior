package com.atguigu.java1;

/**
 * @Author: Leo messi
 * @Date: 2022/06/25/19:02
 * @Description:
 */

import com.atguigu.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1.Set接口的框架:
 *                 Set 接口: 存储无序的，不可重复的数据   高中讲的"集合"
 *                     HashSet/ 作为Set接口的主要实现类，线程不安全的，可以存储null值
 *                          LinkedHashSet/ ： 作为HashSet子类；遍历其内部数据时，可以按照添加的顺序遍历
 *                              TreeSet ：可以按照添加的元素指定属性，进行排序。
 *
 *
 *  1.Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法；
 *  2.要求：向Set中添加的数据，其所在的类一定要重写hashCode（））和equals()
 *  要求：重写的hashCode（））和equals（））尽可能保持一致，相等的对象必须具有相等的散列码
 *  重写的两个方法的小技巧：对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值。
 *
 */
public class SetTest {

    /**
     * 一、Set:存储无序，不可重复的数据
     * 以HashSet为例说明
     * 1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加,而是根据哈希值决定的
     *
     * 2.不可重复性：保证添加的元素按照equals()方法判断时，不能返回true，即:相同的元素只能添加一个
     *
     * 二、添加元素的过程：以HashSet为例：
     * 我们向HashSet添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值
     * 此哈希值接着通过某种计算计算出在HashSet底层数组中的存放位置（即为：索引位置），判断数组
     * 此位置上是否已经有元素
     * 如果此位置上没有其他元素，此元素a添加成功   -->情况1
     * 如果此位置上有其他元素（或以链表形式存在的多个元素）,则比较元素a和元素b的hash值。
     *      如果hash值不相同，则元素a添加成功     -->情况2
     *      如果hash值相同，进而需要调用元素a所在类的equals()方法；
     *          equals()返回true，元素返回失败
     *          equals()返回false，元素添加成功     --》情况3
     * 对于添加成功的情况2和情况3而言，元素a 与已经存在指定索引位置上数据以链表的方式存储
     * jdk7 ：元素a放在数组中，指向原来的元素
     * jdk8 ： 原来的元素放在数组中，指向元素a
     *
     * 总结：七上八下
     *
     * HashSet底层：数组+链表的结构；
     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用：还是无序的
    //LinkedHashSet作为HashSet的子类，在添加数据的同事，每个数据还维护了两个引用，记录此数据
    //前数据和后一个数据。
    //优点：对于频繁的遍历操作，LinkedHashSet 效率高于HashSet

    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
