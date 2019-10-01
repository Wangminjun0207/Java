// ClassTest.java

import java.util.Scanner;
import java.lang.String;

class Vehicle{
	private int wheels;  // 轮数
	private double load;    // 最大载重量

	// 构造函数
	public Vehicle(int wheels_, double load_)
	{
		wheels = wheels_;
		load = load_;
	}
	// 拷贝构造函数
	public Vehicle(Vehicle vehicle)
	{
		wheels = vehicle.wheels;
		load = vehicle.load;
	}
	// 打印实例属性的函数
	public void display()
	{
		System.out.println("wheels    :" + wheels + "轮");
		System.out.println("load      :" + load + "千克");
	}
	/* 可以试用super.fun()调用父类的同名函数
	// 获取轮数函数
	public int getWheels()
	{
		return wheels;
	}
	// 获取最大载重量的函数
	public double getLoad()
	{
		return load;
	}*/
}

class Car extends Vehicle
{
	private int passengers;   // 载客人数
	private String make;      // 车的品牌

	// 构造函数
	public Car(int wheels_, double load_, int passengers_, String make_)
	{
		super(wheels_, load_);
		passengers = passengers_;
		make = make_;
	}
	// 拷贝构造函数
	public Car(Car car)
	{
		super(car);
		passengers = car.passengers;
		make = car.make;
	}
	// 打印实例属性的函数
	public void display()
	{
		System.out.println("----------Car----------");
		//System.out.println("wheels    :" + this.getWheels() + "轮");
		//System.out.println("load      :" + this.getLoad() + "千克");
		super.display();
		System.out.println("passengers:" + passengers + "人");
		System.out.println("make      :" + make);
	}
}

class Truck extends Vehicle
{
	private int bridges;   // 卡车轴数
	private String cargo_tp;  // 货物类型
	// 构造函数
	public Truck(int wheels_, double load_, int bridges_, String cargo_tp_)
	{
		super(wheels_, load_);
		bridges = bridges_;
		cargo_tp =cargo_tp_;

	}
	// 拷贝构造函数
	public Truck(Truck truck)
	{
		super(truck);
		bridges = truck.bridges;
		cargo_tp = truck.cargo_tp;
	}
	// 打印实例属性的函数
	public void display()
	{
		System.out.println("----------Truck----------");
		//System.out.println("wheels    :" + this.getWheels() + "轮");
		//System.out.println("load      :" + this.getLoad() + "千克");
		super.display();
		System.out.println("bridges   :" + bridges + "轴");
		System.out.println("cargo_tp  :" + cargo_tp);
	}
}

public class ClassTest
{
	public static void main(String args[])
	{
		Car car = new Car(4,3630,5,"宝马");
		Truck truck = new Truck(4,12000,3,"食品");
		Vehicle vehicle1 = car;
		Vehicle vehicle2 = truck;
		vehicle1.display();
		vehicle2.display();
	}
}
