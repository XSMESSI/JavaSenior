package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/06/18/15:04
 * @Description:
 */

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println("summer = " + summer);
        System.out.println("Season1.class.getSuperclass() = " + Season1.class.getSuperclass());

        //values()
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println(">>>>>>>>>>>>>");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }


        //valueOf(String objName) : 根据提供objName,返回枚举类中是objName的对象
        //如果没有objName的枚举类异常对像，则抛异常:Exception in thread "main" java.lang.IllegalArgumentException
        Season1 win = Season1.valueOf("WINTER");
        System.out.println("win = " + win);
        win.show();
    }
}

interface Info {
    void show();
}

//自定义枚举类
enum Season1 implements Info {
    //1.提供当前枚举类的对象，多个对象之间用,隔开,末尾对象";"结束
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里》？");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };


    //2.声明Season对象的属性 private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4.其他诉求1：获取枚举类对象的属性


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}


