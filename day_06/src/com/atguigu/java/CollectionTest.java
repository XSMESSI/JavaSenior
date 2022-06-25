package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/06/19/16:05
 * @Description:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 *
 * 向Collection接口的恩实现类的对象中添加数据obj时，要求obj所在类要重写equals()
 *
 */
public class CollectionTest {

    @Test
    public void etst1(){
        Collection coll = new ArrayList();
        coll.add(12);
        coll.add(121);
        coll.add(12);
        coll.add(new String("Tom"));
        coll.add(24);
        coll.add(45);

        System.out.println(coll);
        coll.add(new Person("tom",20));

        //contains() 是否包含
        //我们在判断时会调用obj对象所在类的equals()
        boolean contains = coll.contains(12);
        System.out.println(contains);

        boolean tom = coll.contains(new Person("tom", 20));
        System.out.println(tom);

        //2.contailsAll :判断形参coll1中所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,456);

        System.out.println("containsAll使用");
        boolean b = coll.containsAll(coll1);
        System.out.println(b);


    }

    @Test
    public void etst2(){
        //3.从当前集合中移出obj元素
        Collection coll = new ArrayList();
        coll.add(12);
        coll.add(121);
        coll.add(12);
        coll.add(new String("Tom"));
        coll.add(24);
        coll.add(45);
        coll.add(new Person("tom",20));

        boolean remove = coll.remove(12311);
        System.out.println(remove);
        System.out.println(coll);

        boolean tom = coll.remove(new Person("tom", 20));
        System.out.println(coll);

        //4.removeAll():从当前集合中移除coll1中所有元素
        Collection coll1 = Arrays.asList(24, 456);
        boolean b = coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        //3.从当前集合中移出obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(121);
        coll.add(12);
        coll.add(new String("Tom"));
        coll.add(24);
        coll.add(45);
        coll.add(new Person("tom",20));

        //retainAll 获取当前集合和coll1的交集，并返回给当前集合（修改当前集合）
//        Collection coll1 = Arrays.asList(123,456,233);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //equals(obj) 比较两个对象是否是相等的:要想返回true，需要当前集合和形参集合的元素都相同
        Collection coll1 = new ArrayList();
        coll1.add(121);
        coll1.add(123);
        coll1.add(12);
        coll1.add(new String("Tom"));
        coll1.add(24);
        coll1.add(45);
        coll1.add(new Person("tom",20));
        System.out.println(coll.equals(coll1));

    }


    @Test
    public void etst4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(121);
        coll.add(12);
        coll.add(new String("Tom"));
        coll.add(24);
        coll.add(45);
        coll.add(new Person("tom",20));

        //7.hashCode()：返回当前对象的hasCode值
        System.out.println(coll.hashCode());

        //8.集合 ->数组：toArray()
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //拓展：数组-》集合
        List<String> list = Arrays.asList(new String[]{"AA", "BB"});
        System.out.println(list);
        List arr1 = Arrays.asList(new int[]{123,45});
        System.out.println(arr1.size());

        //9.iterator Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素。





        List arr2 = Arrays.asList(new Integer[]{123,45});
        System.out.println(arr2.size());
    }
}
