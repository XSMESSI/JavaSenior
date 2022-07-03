package com.atguigu.java;

import org.junit.Test;

import java.util.*;
import java.util.Map.*;

/**
 * @Author: Leo messi
 * @Date: 2022/07/03/10:28
 * @Description:
 */

/**
 * 泛型的使用：
 * 1.jdk5.0 新增的特性
 * 2.在集合中使用泛型：
 *  总结：
 *  1.集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *  2.在实例化集合类时，可以指明具体的泛型类型；
 *  3.指明完以后，在集合类或接口中凡是定义类或接口时，内部结构使用到类的泛型位置，都指定为实例化的泛型类型
 *  比如：add(E e)   --->实例化以后：add(Integer e)
 *  4.注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *  5.如果实例化时，没有指明泛型的类型，默认类型为java.lang.Object类型
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口、泛型方法 见 GenericTest1
 *
 */
public class GenericTest {

    //在集合中使用泛型之前的情况
    @Test
    public void test1(){

        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
        list.add("Tom");
//        System.out.println("list = " + list);
        for (Object score : list) {
            //问题二：强转时，可能会出现ClassCastException
            //java.lang.ClassCastException:
            int stuScore = (Integer) score;
            System.out.println("stuScore = " + stuScore);
        }
    }

    //在集合中使用泛型之前的情况
    @Test
    public void etst2(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //编译时，就会进行类型检查
//        list.add("Tom");
        //方式1：
//        for (Integer score : list) {
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println("stuScore = " + stuScore);
//        }
        //方式2：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println("stuScore = " + stuScore);
        }

    }

    //在集合中使用泛型之前的情况,以HashMap为例
    @Test
    public void etst3(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("Tom",87);
        map.put("Jerry",67);
        map.put("Jack",77);

//        map.put(1,2);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----" + value);
        }

    }
}
