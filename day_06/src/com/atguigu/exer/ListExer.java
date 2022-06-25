package com.atguigu.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Leo messi
 * @Date: 2022/06/25/18:57
 * @Description:
 */
public class ListExer {

    /**
     * 区分remove(int index) 和 remove(Object obj)
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    //考察删除的点
    private static void updateList(List list) {
//        list.remove(2);
        list.remove(new Integer(2));
    }
}
