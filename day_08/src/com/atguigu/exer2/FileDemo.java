package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Leo messi
 * @Date: 2022/07/04/9:02
 * @Description:
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\softInstall\\io\\io1\\wwwnew.txt");
        //创建一个与File同目录下的另外一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile){
            System.out.println("创建成功!");
        }
    }
}
