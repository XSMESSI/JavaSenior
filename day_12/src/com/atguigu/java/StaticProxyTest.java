package com.atguigu.java;

/**
 * @author leo-xushen
 * @version 1.0
 * @date 2024/9/5 19:21
 * @desc <>
 */

/**
 * 静态代理举例：
 *
 * 特点：代理类和被代理在编译期间，就确定下来了
 *
 */
interface ClothFactory{


    public void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory clothFactory){
        this.factory = clothFactory;
    }

    @Override
    public void produceCloth() {

        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();

        System.out.println("代理工厂做一些收尾工作");

    }
}

//被代理类

class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike生产一批工作服");
    }

}

public class StaticProxyTest {

    public static void main(String[] args) {

        //创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}
