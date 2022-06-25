package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: Leo messi
 * @Date: 2022/06/19/16:58
 * @Description:
 */

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 内部的方法:hasNext() 和  next()
 */
public class IteratorTest {

    @Test
    public void etst1(){
        //iterator Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素。

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(121);
        coll.add(12);
        coll.add(new String("Tom"));
        coll.add(24);
        coll.add(45);
        coll.add(new Person("tom",20));


        Iterator iterator = coll.iterator();
        //方式一：
//        System.out.println(iterator.next());

        //方式二:
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void etst2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(121);
        coll.add(12);
        coll.add(new String("Tom"));
        coll.add(24);
        coll.add(45);
        coll.add(new Person("tom",20));

        //错误方式一
//        Iterator iterator = coll.iterator();
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合
        //的第一个元素之前。

        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }

    // 如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
    //再调用remove都会报IllegalStateException。
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(121);
        coll.add(12);
        coll.add(new String("Tom"));
        coll.add(24);
        coll.add(45);
        coll.add(new Person("tom",20));

        //删除集合中“Tom”
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();
            }
        }


        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
