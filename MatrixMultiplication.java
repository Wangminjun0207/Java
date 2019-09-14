// MatrixMultiplication.java
// 实现矩阵乘法

import java.util.Scanner;
public class MatrixMultiplication
{
	// 求矩阵乘法的函数
	public static void fun(int A[][], int B[][], int C[][])
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				for(int k=0;k<5;k++)
				{
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		}
	}
	// 输出矩阵函数
	static void displayC(int C[][])
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(C[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		int A[][] = new int[4][5]; // 4*5
		int B[][] = new int[5][4]; // 5*4
		int C[][] = new int[4][4]; // 4*4
		Scanner in = new Scanner(System.in);
		System.out.print("输入矩阵A(4*5):");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				A[i][j] = in.nextInt();
			}
		}

		System.out.print("输入矩阵B(5*4:)");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				B[i][j] = in.nextInt();
			}
		}
		
		fun(A,B,C);
		displayC(C);
	}

}
