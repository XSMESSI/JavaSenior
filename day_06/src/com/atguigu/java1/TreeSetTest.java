package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author: Leo messi
 * @Date: 2022/06/25/22:39
 * @Description:
 */
public class TreeSetTest {

    /**
     * 向TreeSet中添加数据，要求是相同类的对象
     * 2.两种排序方式:自然排序(实现Comparable接口)和定制排序
     *
     * 3.自然排序中，比较两个对象是都相同的标准为：compareTo返回0，不再是equals()
     * 4.定制排序中，比较两个对象是否相同的标准为：compareTo返回0，不再是equals()
     */

    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("a");

        //举例一
//        set.add(34);
//        set.add(314);
//        set.add(54);

        //举例二：
        set.add(new User("TOm",12));
        set.add(new User("marry",12));
        set.add(new User("Jack",11));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
//                return 0;
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("TOm",12));
        set.add(new User("marry",12));
        set.add(new User("Jack",11));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
