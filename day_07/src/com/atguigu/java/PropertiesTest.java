package com.atguigu.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: Leo messi
 * @Date: 2022/07/02/18:24
 * @Description:
 */
public class PropertiesTest {

    //Properties 类是 Hashtable 的子类，该对象用于处理属性文件
    //Properties：常用来处理配置文件，key和value都是Strign类型
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {

            Properties pros = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流对应的文件
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println("name = " + name);
            System.out.println("password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
