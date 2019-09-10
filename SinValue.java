// SinValue.java
import java.util.Scanner;
public class SinValue
{
	// 求阶乘函数
	static int fun(int n)
	{
		if(n==1 || n==0)
			return 1;
		else
			return n*fun(n-1);
	}
	// 求x幂函数
	static double power(int n, double x)
	{
		double sum = 1.0;
		for(int i=1;i<=n;i++)
		{
			sum *= x;
		}
		return sum;
	}
	// 函数入口
	public static void main(String args[])
	{
		System.out.print("请输入一个实数：");
		Scanner in = new Scanner(System.in);
		double value = in.nextDouble();
		int count = 1;  // 幂
		int signal = 1; // 符号
		double tempValue = 0; // 各项的值
		double sinx = 0; // sin(x)的值
		do{
			tempValue = power(count,value)/(double)fun(count);
			count += 2;
			sinx = sinx + signal * tempValue;
			signal = signal * (-1);  // 符号取反
		}while(tempValue>=10E-8);
		System.out.println("sin(x)="+sinx);
	}
}
