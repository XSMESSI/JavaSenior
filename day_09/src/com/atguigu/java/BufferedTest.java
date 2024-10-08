package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/07/05/11:37
 * @Description:
 */

import org.testng.annotations.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提高流的读取，写入的速度
 *      提高读写速度的原因:内部提供了一个缓冲区
 *
 * 3.处理流，就是套接在已有的流的基础上.
 *
 */
public class BufferedTest {


    /**
     * 实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("1.jpg");
            File destFile = new File("122.jpg");
            //2.造流
            //2.1 造结点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取，写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
                bos.flush();//刷新缓存区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //说明：关闭外层流的同事，内层流也会自动的关闭。关于内层流的关闭，我们可以省略
//        fos.close();
//        fis.close();
    }

    //实现文件复制的方法：
    public void copyFileWithBufees(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1 造结点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取，写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //说明：关闭外层流的同事，内层流也会自动的关闭。关于内层流的关闭，我们可以省略
//        fos.close();
//        fis.close();
    }


    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        //文件的路径，以及复制之后的路径信息存储
        String srcpPath = "C:\\Users\\Leo-MESSI\\Pictures\\Camera Roll\\2.jpg";
        String destpPath = "C:\\Users\\Leo-MESSI\\Pictures\\Camera Roll\\2copy1111.jpg";
//        String srcpPath = "hello.txt";
//        String destpPath = "hello3.txt";
        copyFileWithBufees(srcpPath,destpPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为" + (end - start));//35毫秒
    }

    /** *
     *
     * 使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void tetsBufferedReaderAndBofferWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作：
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//            }
            //方式二:使用数组
            String data;
            while ((data = br.readLine()) != null){
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符
                //方法二：
                bw.write(data);//data中不包含换行符
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
