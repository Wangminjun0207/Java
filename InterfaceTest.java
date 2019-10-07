// InterfaceTest.java

import java.lang.String;
import java.util.Scanner;
// output接口
interface Output
{
	public void prt();
}

class Bicycle{
	private double speed;   // 运行时速
	// 单参构造函数
	public Bicycle(double speed_) throws ArithmeticException
	{
		if(speed_>20)
		{
			ArithmeticException e = new ArithmeticException("时速"+speed_+"km/h超过了Bicycle的最大匀速速度20km/h，创建Bicycle实例失败！");
			throw e;
		}
		else
			speed = speed_;
	}
	// 重写prt方法
	public void prt()
	{
		System.out.println("自行车的时速：" + speed + "km/h");
	}
}

class Car{
	private double speed;   // 运行时速
	// 单参构造函数
	public Car(double speed_) throws ArithmeticException
	{
		if(speed_>120)
		{
			ArithmeticException e = new ArithmeticException("时速"+speed_+"km/h超过了Car最大匀速速度120km/h，创建Car实例失败！");
			throw e;
		}
		else
			speed = speed_;
	}
	// 重写prt方法
	public void prt()
	{
		System.out.println("小轿车的时速：" + speed + "km/h");
	}
}

class Bus{
	private double speed;   // 运行时速
	// 单参构造函数
	public Bus(double speed_) throws ArithmeticException
	{
		if(speed_>60)
		{
			ArithmeticException e = new ArithmeticException("时速"+speed_+"km/h超过了Bus的最大匀速速度60km/h，创建Bus实例失败！");
			throw e;
		}
		else
			speed = speed_;
	}
	// 重写prt方法
	public void prt()
	{
		System.out.println("公交车的时速：" + speed + "km/h");
	}
}

public class InterfaceTest
{
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		double speed = in.nextDouble();
		try{
			Bicycle	bicycle = new Bicycle(speed); // 创建自行车实例
			bicycle.prt();
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
		try{
			Car car = new Car(speed);     // 创建小汽车实例
			car.prt();
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
		try{
			Bus bus = new Bus(speed);     // 创建公交车实例
			bus.prt();
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
	}
}
