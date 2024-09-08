package com.atguigu.java2;


import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用情境：当要传递给Lambda表达式的操作，已经有具体的方法实现，可以使用方法引用来替代Lambda表达式。
 *
 * 2.方法引用：本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例，所以方法引用，也就是函数式接口的实例
 *
 * 3.使用格式： 类（或对象） ::方法名
 *
 *
 * 4:具体分为如下的三种情况：
 *   情况1：对象::非静态方法
 *   情况2：类::静态方法
 *   情况3：类::实例方法
 *
 *
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型一致。
 * (针对于情况1 和 情况2)
 *
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 = str -> System.out.println(str);

		con1.accept("Hello World");


		System.out.println("*****************");

		PrintStream ps = System.out;
		Consumer<String> con2 = ps::println;
		con2.accept("Hello World  PrintStream");

		
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001,"Tom",23,5600);

//		Supplier<String> sup1 = () -> Employee.getName();
//		System.out.println(sup1.get());


		System.out.println("**********");

		Supplier<String> sup2 = emp::getName;
		System.out.println(sup2.get());


	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com1 = (x,y) -> Integer.compare(x,y);
		System.out.println(com1.compare(10,20));

		System.out.println("*");

		Comparator<Integer> com2 = Integer::compare;
		System.out.println(com2.compare(10,20));

		
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double,Long> func = new Function<Double, Long>() {
			@Override
			public Long apply(Double aDouble) {
				return Math.round(aDouble);
			}
		};

		System.out.println(func.apply(10.5));


		Function<Double,Long> func1 = d -> Math.round(d);
		System.out.println("func1.apply(10.5) = " + func1.apply(10.5));

		Function<Double,Long> func2 = Math::round;
		System.out.println("func2.apply(10.5) = " + func2.apply(10.5));


	}

	// 情况三：类 :: 实例方法 (有难度)
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com1 = (x,y) -> x.compareTo(y);
		System.out.println(com1.compare("abc","def"));

		System.out.println("*");

		Comparator<String> com2 = String::compareTo;
		System.out.println(com2.compare("abc","def"));


	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);

		System.out.println(bp1.test("abc", "def"));

		BiPredicate<String, String> bp2 = String::equals;

		System.out.println(bp2.test("abc", "def"));
		
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Function<Employee, String> func1 = e -> e.getName();
		System.out.println(func1.apply(new Employee(1001,"Tom",23,5600)));

		System.out.println("*");

		Function<Employee, String> func2 = Employee::getName;
		System.out.println(func2.apply(new Employee(1001,"Tom",23,5600)));


	}

}
