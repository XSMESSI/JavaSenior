package com.atguigu.java1;

import org.junit.Test;

import java.util.List;

/**
 * @Author: Leo messi
 * @Date: 2022/07/03/19:39
 * @Description:
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);


        StudentDAO dao2 = new StudentDAO();
        dao2.getIndex(1);
    }
}
