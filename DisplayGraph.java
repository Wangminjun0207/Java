// DisplayGraph.java
import java.util.Scanner;
public class DisplayGraph
{
	public static void main(String args[])
	{
		System.out.print("请输入一个整数：");
		Scanner in = new Scanner(System.in);
		int lineCount = in.nextInt();
		int colCount = lineCount;
		for(int i=1;i<=lineCount;i++)
		{

			for(int k=1;k<=(i-1)*2;k++)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=(colCount)*2-1;j++)
			{
				System.out.print(" *");
			}
			colCount--;
			System.out.println();
		}
	}
}
