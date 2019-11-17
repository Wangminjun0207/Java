// OutputStreamDemo.java

import java.io.*;

class OutputStreamDemo{
	public static void main(String args[])throws IOException{
		FileOutputStream fos = new FileOutputStream("Text\\fos.txt");
		fos.write("abcdef".getBytes());   // 字的最小表达式，不涉及到刷新
		fos.close(); // 只关闭，不刷新
	}
}