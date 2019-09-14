// IsPalindrome.java
// 判断输入的字符串是否是回文字符串，输出true或者false
import java.util.Scanner;
public class IsPalindrome
{
	public static void main(String args[])
	{
		System.out.print("请输入一个字符串：");
		Scanner in = new Scanner(System.in);
		String str = in.next();
		int len = str.length();// 求出str的长度
		int it = 0;
		boolean result = true;
		while(it<len-1)
		{
			if(str.charAt(it)!=str.charAt(len-1))
			{
				result = false;
				break;
			}
			it++;
			len--;
		}
		System.out.println(result);
	}
}
