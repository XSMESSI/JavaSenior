package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Leo messi
 * @Date: 2022/07/03/15:41
 * @Description:
 */
public class SubOrder extends Order<Integer>{//SubOrder 不再是泛型类

    public static <E> List<E> copyFromArrayList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
