package com.atguigu.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Leo messi
 * @Date: 2022/07/10/13:09
 * @Description:
 */
public class FileUtilsTest {

    public static void main(String[] args) {
        File srcFile = new File("day_10\\爱情与友情.jpg");
        File destFile = new File("day_10\\爱情与友情1.jpg");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
