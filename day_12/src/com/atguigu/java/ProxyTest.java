package com.atguigu.java;

/**
 * @author leo-xushen
 * @version 1.0
 * @date 2024/9/5 19:29
 * @desc <>
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例：
 *
 *
 *
 */
interface Human{

    String getBelief();

    void eat(String food);

}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}


/**
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法；
 */
class ProxyFactory{

    //调用此方法，返回一个代理类对象,解决问题一：
    public static Object getProxyInstance(Object object){//obj：被代理类对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(object);

        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler {


    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();


        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类对象
        Object returnValue = method.invoke(obj, args);

        util.method2();
        //上述方法的返回值就作为当前类中invoke方法的返回值
        return returnValue;
    }
}

class HumanUtil{

    public void method1(){
        System.out.println("==============通用方法1======================");
    }

    public void method2(){
        System.out.println("==============通用方法2======================");
    }
}




public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        proxyInstance.eat("苹果");

        System.out.println("*****************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyClothFactory.produceCloth();
    }



}
